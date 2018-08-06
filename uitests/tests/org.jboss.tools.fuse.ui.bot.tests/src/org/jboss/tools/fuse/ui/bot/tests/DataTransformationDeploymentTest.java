/*******************************************************************************
 * Copyright (c) 2017 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.fuse.ui.bot.tests;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.eclipse.reddeer.requirements.server.ServerRequirementState.RUNNING;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.reddeer.common.exception.WaitTimeoutExpiredException;
import org.eclipse.reddeer.common.matcher.RegexMatcher;
import org.eclipse.reddeer.common.wait.WaitUntil;
import org.eclipse.reddeer.eclipse.condition.ConsoleHasText;
import org.eclipse.reddeer.eclipse.ui.console.ConsoleView;
import org.eclipse.reddeer.junit.requirement.inject.InjectRequirement;
import org.eclipse.reddeer.junit.runner.RedDeerSuite;
import org.jboss.tools.fuse.reddeer.ResourceHelper;
import org.jboss.tools.fuse.reddeer.condition.FuseLogContainsText;
import org.jboss.tools.fuse.reddeer.projectexplorer.CamelProject;
import org.jboss.tools.fuse.reddeer.requirement.FuseRequirement;
import org.jboss.tools.fuse.reddeer.requirement.FuseRequirement.Fuse;
import org.jboss.tools.fuse.reddeer.utils.FuseServerManipulator;
import org.jboss.tools.fuse.reddeer.utils.FuseShellSSH;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test covers Data Transformation Tooling and deployment to Fuse Runtime
 * <p>
 * Use the following arguments to specify Fuse Integration Project:
 * <ul>
 * <li>-DfuseDeploymentType=... --- Standalone</li>
 * <li>-DfuseRuntimeType=... --- Karaf / EAP</li>
 * <li>-DfuseCamelVersion=... --- e.g. 2.18.1.redhat-000012</li>
 * <li>-DfuseDSL=... --- Blueprint / Spring</li>
 * </ul>
 * </p>
 * 
 * @author tsedmik
 */
@RunWith(RedDeerSuite.class)
@Fuse(state = RUNNING)
public class DataTransformationDeploymentTest extends DataTransformationDefaultTest {

	public static final String TRANSFORMATION_LOG_MSG = "{\"custId\":\"ACME-123\",\"priority\":\"GOLD\",\"orderId\":\"ORDER1\",\"origin\":\"ORIGIN\",\"approvalCode\":\"AUTO_OK\",\"lineItems\":[{\"itemId\":\"PICKLE\",\"amount\":1000,\"cost\":2.25},{\"itemId\":\"BANANA\",\"amount\":400,\"cost\":1.25}]}";
	public static final String EXAMPLE_KARAF_RUNTIME_PATH = "/src/data/abc-order.xml";
	public static final String EXAMPLE_EAP_RUNTIME_PATH = "/bin/src/data/abc-order.xml";
	public static final String EXAMPLE_XML_PATH = "resources/datatransformation/data/abc-order.xml";
	public static final String EAP_CONSOLE_NAME = "Fuse on EAP";

	@InjectRequirement
	private static FuseRequirement serverRequirement;

	@BeforeClass
	public static void setupConfiguration() {
		DEPLOYMENT_TYPE = "Standalone";
		RUNTIME_TYPE = serverRequirement.getConfiguration().getServer().getName().contains("EAP") ? "EAP" : "Karaf";
		CAMEL_VERSION = serverRequirement.getConfiguration().getCamelVersion();
	}

	/**
	 * Cleans up test environment
	 */
	@AfterClass
	public static void setupStopServer() {
		FuseServerManipulator.removeAllModules(serverRequirement.getConfiguration().getServer().getName());
	}

	@Before
	public void setupEnvironment() throws IOException, CoreException {
		createProject(PROJECT_NAME);
		copyResources(PROJECT_NAME);
		configureRoute();
		addDataTransformation();
		createMapping();
		new CamelProject(PROJECT_NAME).update();
	}

	/**
	 * <p>
	 * Test tries to deploy a Fuse project with defined Data Transformation to Red Hat Fuse runtime (Karaf or EAP)
	 * </p>
	 * <b>Steps</b>
	 * <ol>
	 * <li>start Red Hat Fuse</li>
	 * <li>create a new Fuse Integration Project</li>
	 * <li>add a data transformation into the project</li>
	 * <li>deploy the project</li>
	 * <li>invoke the route with copying a file</li>
	 * <li>check log of Red Hat Fuse (deployed project should log transformed XML file in JSON format)</li>
	 * </ol>
	 */
	@Test
	public void testDeployment() {

		FuseServerManipulator.addModule(serverRequirement.getConfiguration().getServer().getName(), PROJECT_NAME);
		assertTrue("The project was not successfuly deployed!", new FuseShellSSH().containsLog("started and consuming from"));
		copyExample();
		checkTransformation();
	}

	private void checkTransformation() {
		if (serverRequirement.getConfiguration().getServer().getClass().getName().contains("EAP")) {
			try {
				new ConsoleView().switchConsole(new RegexMatcher(".*" + EAP_CONSOLE_NAME + ".*"));
				new WaitUntil(new ConsoleHasText(TRANSFORMATION_LOG_MSG));
			} catch (WaitTimeoutExpiredException e) {
				fail("Transformation is broken! \n\n" + new ConsoleView().getConsoleText());
			}
		} else {
			try {
				new WaitUntil(new FuseLogContainsText(TRANSFORMATION_LOG_MSG));
			} catch (WaitTimeoutExpiredException e) {
				fail("Transformation is broken! \n\n" + new FuseShellSSH().execute("log:display"));
			}
		}
	}

	private void copyExample() {
		String from = ResourceHelper.getResourceAbsolutePath(Activator.PLUGIN_ID, EXAMPLE_XML_PATH);
		String to = serverRequirement.getConfiguration().getServer().getHome() + EXAMPLE_KARAF_RUNTIME_PATH;
		if (serverRequirement.getConfiguration().getServer().getClass().getName().contains("EAP")) {
			to = serverRequirement.getConfiguration().getServer().getHome() + EXAMPLE_EAP_RUNTIME_PATH;
		}
		try {
			Files.copy(new File(from).toPath(), new File(to).toPath(), REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Tests cannot copy XML file to home folder of Red Hat Fuse Runtime!");
		}
	}
}
