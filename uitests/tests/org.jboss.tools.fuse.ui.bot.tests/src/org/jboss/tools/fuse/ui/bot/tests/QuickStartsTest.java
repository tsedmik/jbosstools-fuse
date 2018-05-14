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

import static org.eclipse.reddeer.requirements.server.ServerRequirementState.RUNNING;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.eclipse.reddeer.common.exception.WaitTimeoutExpiredException;
import org.eclipse.reddeer.common.wait.AbstractWait;
import org.eclipse.reddeer.common.wait.TimePeriod;
import org.eclipse.reddeer.common.wait.WaitUntil;
import org.eclipse.reddeer.eclipse.m2e.core.ui.wizard.MavenImportWizard;
import org.eclipse.reddeer.eclipse.ui.problems.Problem;
import org.eclipse.reddeer.eclipse.ui.views.log.LogView;
import org.eclipse.reddeer.eclipse.ui.views.markers.ProblemsView;
import org.eclipse.reddeer.eclipse.ui.views.markers.ProblemsView.ProblemType;
import org.eclipse.reddeer.junit.annotation.RequirementRestriction;
import org.eclipse.reddeer.junit.requirement.inject.InjectRequirement;
import org.eclipse.reddeer.junit.requirement.matcher.RequirementMatcher;
import org.eclipse.reddeer.junit.runner.RedDeerSuite;
import org.eclipse.reddeer.workbench.impl.shell.WorkbenchShell;
import org.eclipse.reddeer.workbench.ui.dialogs.WorkbenchPreferenceDialog;
import org.jboss.tools.fuse.reddeer.JiraIssue;
import org.jboss.tools.fuse.reddeer.LogGrapper;
import org.jboss.tools.fuse.reddeer.condition.FuseLogContainsText;
import org.jboss.tools.fuse.reddeer.preference.ConsolePreferencePage;
import org.jboss.tools.fuse.reddeer.requirement.FuseRequirement;
import org.jboss.tools.fuse.reddeer.requirement.FuseRequirement.Fuse;
import org.jboss.tools.fuse.reddeer.runtime.ServerTypeMatcher;
import org.jboss.tools.fuse.reddeer.runtime.impl.ServerFuse;
import org.jboss.tools.fuse.reddeer.utils.FuseServerManipulator;
import org.jboss.tools.fuse.reddeer.utils.ProjectFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests quickstarts which contains Red Hat Fuse Runtime
 * 
 * @author tsedmik
 */
@Fuse(state = RUNNING)
@RunWith(RedDeerSuite.class)
public class QuickStartsTest {

	@InjectRequirement
	private FuseRequirement serverRequirement;
	
	@RequirementRestriction
	public static RequirementMatcher getRestrictionMatcher() {
		return new RequirementMatcher(Fuse.class, "server", new ServerTypeMatcher(ServerFuse.class));
	}

	/**
	 * Prepares test environment
	 */
	@BeforeClass
	public static void setupEnv() {

		new WorkbenchShell().maximize();

		WorkbenchPreferenceDialog dialog = new WorkbenchPreferenceDialog();
		ConsolePreferencePage consolePref = new ConsolePreferencePage(dialog);
		dialog.open();
		dialog.select(consolePref);
		consolePref.toggleShowConsoleErrorWrite(false);
		consolePref.toggleShowConsoleStandardWrite(false);
		dialog.ok();

		new ProblemsView().open();
	}

	/**
	 * Prepares test environment
	 */
	@Before
	public void setupDefault() {

		new WorkbenchShell();
		new LogView().open();
		new LogView().deleteLog();
	}

	/**
	 * Removes all deployed projects
	 */
	@After
	public void setupUndeployProjects() {

		AbstractWait.sleep(TimePeriod.DEFAULT);
		new WorkbenchShell();
		FuseServerManipulator.removeAllModules(serverRequirement.getConfiguration().getServer().getName());
	}

	/**
	 * Deletes all created projects
	 */
	@After
	public void setupDeleteProjects() {
		ProjectFactory.deleteAllProjects();
	}

	/**
	 * <p>
	 * Test tries to deploy 'beginner-camel-cbr' quickstart to Red Hat Fuse Runtime.
	 * </p>
	 * <b>Steps:</b>
	 * <ol>
	 * <li>import 'beginner-camel-cbr' project from Red Hat Fuse quickstarts</li>
	 * <li>check that project is ok (no errors, unresolved dependencies, ...)</li>
	 * <li>deploy the project to Red Hat Fuse</li>
	 * <li>check whether the project is successfully deployed (check whether Red Hat Fuse log contains '(CamelContext:
	 * cbr-example-context) started')</li>
	 * </ol>
	 */
	@Test
	public void testBeginnerCamelCBR() {

		String quickstart = serverRequirement.getConfiguration().getServer().getHome() + "/quickstarts/beginner/camel-cbr";
		MavenImportWizard.importProject(quickstart);
		assertTrue("There are some errors in Error Log", LogGrapper.getPluginErrors("fuse").size() == 0);
		FuseServerManipulator.addModule(serverRequirement.getConfiguration().getServer().getName(), "beginner-camel-cbr");
		try {
			new WaitUntil(new FuseLogContainsText("(CamelContext: cbr-example-context) started"), TimePeriod.getCustom(600));
		} catch (WaitTimeoutExpiredException e) {
			fail("Project 'beginner-camel-cbr' was not sucessfully deployed!");
		}
		checkProblemsView();
	}

	/**
	 * <p>
	 * Test tries to deploy 'beginner-camel-eips' quickstart to Red Hat Fuse Runtime.
	 * </p>
	 * <b>Steps:</b>
	 * <ol>
	 * <li>import 'beginner-camel-eips' project from Red Hat Fuse quickstarts</li>
	 * <li>check that project is ok (no errors, unresolved dependencies, ...)</li>
	 * <li>deploy the project to Red Hat Fuse</li>
	 * <li>check whether the project is successfully deployed (check whether Red Hat Fuse log contains '(CamelContext:
	 * eip-example-context) started')</li>
	 * </ol>
	 */
	@Test
	public void testBeginnerCamelEIPs() {

		String quickstart = serverRequirement.getConfiguration().getServer().getHome()
				+ "/quickstarts/beginner/camel-eips";
		MavenImportWizard.importProject(quickstart);
		assertTrue("There are some errors in Error Log", LogGrapper.getPluginErrors("fuse").size() == 0);
		FuseServerManipulator.addModule(serverRequirement.getConfiguration().getServer().getName(), "beginner-camel-eips");
		try {
			new WaitUntil(new FuseLogContainsText("(CamelContext: eip-example-context) started"), TimePeriod.getCustom(600));
		} catch (WaitTimeoutExpiredException e) {
			fail("Project 'beginner-camel-eips' was not sucessfully deployed!");
		}
		checkProblemsView();
	}

	/**
	 * <p>
	 * Test tries to deploy 'beginner-camel-errorhandler' quickstart to Red Hat Fuse Runtime.
	 * </p>
	 * <b>Steps:</b>
	 * <ol>
	 * <li>import 'beginner-camel-errorhandler' project from Red Hat Fuse quickstarts</li>
	 * <li>check that project is ok (no errors, unresolved dependencies, ...)</li>
	 * <li>deploy the project to Red Hat Fuse</li>
	 * <li>check whether the project is successfully deployed (check whether Red Hat Fuse log contains '(CamelContext:
	 * errors-example-context) started')</li>
	 * </ol>
	 */
	@Test
	public void testBeginnerCamelErrorHandler() {

		String quickstart = serverRequirement.getConfiguration().getServer().getHome()
				+ "/quickstarts/beginner/camel-errorhandler";
		MavenImportWizard.importProject(quickstart);
		assertTrue("There are some errors in Error Log", LogGrapper.getPluginErrors("fuse").size() == 0);
		FuseServerManipulator.addModule(serverRequirement.getConfiguration().getServer().getName(), "beginner-camel-errorhandler");
		try {
			new WaitUntil(new FuseLogContainsText("(CamelContext: errors-example-context) started"), TimePeriod.getCustom(600));
		} catch (WaitTimeoutExpiredException e) {
			fail("Project 'beginner-camel-errorhandler' was not sucessfully deployed!");
		}
		checkProblemsView();
	}

	/**
	 * <p>
	 * Test tries to deploy 'beginner-camel-log' quickstart to Red Hat Fuse Runtime.
	 * </p>
	 * <b>Steps:</b>
	 * <ol>
	 * <li>import 'beginner-camel-log' project from Red Hat Fuse quickstarts</li>
	 * <li>check that project is ok (no errors, unresolved dependencies, ...)</li>
	 * <li>deploy the project to Red Hat Fuse</li>
	 * <li>check whether the project is successfully deployed (check whether Red Hat Fuse log contains '(CamelContext:
	 * log-example-context) started')</li>
	 * </ol>
	 */
	@Test
	public void testBeginnerCamelLog() {

		String quickstart = serverRequirement.getConfiguration().getServer().getHome() + "/quickstarts/beginner/camel-log";
		MavenImportWizard.importProject(quickstart);
		assertTrue("There are some errors in Error Log", LogGrapper.getPluginErrors("fuse").size() == 0);
		FuseServerManipulator.addModule(serverRequirement.getConfiguration().getServer().getName(), "beginner-camel-log");
		try {
			new WaitUntil(new FuseLogContainsText("(CamelContext: log-example-context) started"), TimePeriod.getCustom(600));
		} catch (WaitTimeoutExpiredException e) {
			fail("Project 'beginner-camel-log' was not sucessfully deployed!");
		}
		checkProblemsView();
	}

	private void checkProblemsView() {
		
		List<Problem> problems = new ProblemsView().getProblems(ProblemType.ERROR);
		if (problems.size() == 0) {
			return;
		}
		if (problems.size() == 1 && problems.get(0).getDescription().startsWith("Referenced file contains errors (http://www.osgi.org/xmlns/blueprint/v1.0.0/blueprint.xsd).")) {
			throw new JiraIssue("ENTESB-6115");
		}
		fail("There are some errors in Problems view");
	}
}
