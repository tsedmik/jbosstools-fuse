/*******************************************************************************
 * Copyright (c) 2018 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.fuse.ui.bot.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.reddeer.common.wait.WaitUntil;
import org.eclipse.reddeer.eclipse.ui.views.log.LogView;
import org.eclipse.reddeer.jface.dialogs.MessageTypeEnum;
import org.eclipse.reddeer.junit.runner.RedDeerSuite;
import org.eclipse.reddeer.requirements.openperspective.OpenPerspectiveRequirement.OpenPerspective;
import org.eclipse.reddeer.swt.condition.ControlIsEnabled;
import org.eclipse.reddeer.swt.impl.button.FinishButton;
import org.eclipse.reddeer.workbench.ui.dialogs.WorkbenchPreferenceDialog;
import org.jboss.tools.fuse.reddeer.LogGrapper;
import org.jboss.tools.fuse.reddeer.perspectives.FuseIntegrationPerspective;
import org.jboss.tools.fuse.reddeer.preference.StagingRepositoriesPreferencePage;
import org.jboss.tools.fuse.reddeer.wizard.NewFuseIgniteExtensionProjectFirstPage;
import org.jboss.tools.fuse.reddeer.wizard.NewFuseIgniteExtensionProjectSecondPage;
import org.jboss.tools.fuse.reddeer.wizard.NewFuseIgniteExtensionProjectWizard;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests "New Fuse Ignite Extension Project Wizard"<br/>
 * <i>Quick</i> - tests only the wizard, does not finish it
 * 
 * @author tsedmik
 */
@OpenPerspective(FuseIntegrationPerspective.class)
@RunWith(RedDeerSuite.class)
public class NewFuseIgniteExtWizardTest {

	private NewFuseIgniteExtensionProjectWizard wizard;

	@BeforeClass
	public static void useStagingRepos() {
		WorkbenchPreferenceDialog dialog = new WorkbenchPreferenceDialog();
		StagingRepositoriesPreferencePage page = new StagingRepositoriesPreferencePage(dialog);
		dialog.open();
		dialog.select(page);
		page.toggleStagingRepositories(true);
		dialog.ok();
	}

	@Before
	public void openWizard() {
		wizard = new NewFuseIgniteExtensionProjectWizard();
		wizard.open();
	}

	@After
	public void closeWizard() {
		if (wizard.isOpen()) {
			wizard.cancel();
		}

		LogView errorLog = new LogView();
		errorLog.open();
		errorLog.deleteLog();
	}

	/**
	 * <p>
	 * Tests the first page of <i>New Fuse Ignite Extension Project</i> wizard
	 * </p>
	 * <b>Steps:</b>
	 * <ol>
	 * <li>Open <i>New Fuse Ignite Extension Project</i> wizard</li>
	 * <li>Deselect "Use default Workspace location" option</li>
	 * <li>Check whether "Path" and "Browse" button became enabled</li>
	 * <li>Set a project name</li>
	 * <li>Check whether a user can go to next page (which should be unaccessible)</li>
	 * <li>Select "Use default Workspace location" option/li>
	 * <li>Check whether a user can go to next page (which should be accessible)</li>
	 * </ol>
	 */
	@Test
	public void testLocation() {
		NewFuseIgniteExtensionProjectFirstPage firstPage = new NewFuseIgniteExtensionProjectFirstPage(wizard);
		assertFalse(firstPage.getPathTXT().isEnabled());
		assertFalse(firstPage.getBrowseBTN().isEnabled());
		assertTrue(firstPage.getUseDefaultWorkspaceLocationCHBgroup().isChecked());
		firstPage.toggleUseDefaultWorkspaceLocationGroup(false);
		assertTrue(firstPage.getBrowseBTN().isEnabled());
		assertTrue(firstPage.getPathTXT().isEnabled());
		checkFailToFinish();
		firstPage.setTextProjectName("MyNewIgniteExt");
		checkFailToFinish();
		firstPage.toggleUseDefaultWorkspaceLocationGroup(true);
		checkClearToProceed();
		assertTrue("There are some errors in Error Log", LogGrapper.getPluginErrors("fuse").size() == 0);
	}

	/**
	 * <p>
	 * Tests Ignite version verify button on the second page of <i>New Fuse Ignite Extension Project</i> wizard
	 * </p>
	 * <b>Steps:</b>
	 * <ol>
	 * <li>Open <i>New Fuse Ignite Extension Project</i> wizard</li>
	 * <li>Set a project name</li>
	 * <li>Set an invalid Ignite version and verify it</li>
	 * <li>Check wizard message</li>
	 * <li>Check whether a user can finish the wizard (FAIL)</li>
	 * <li>Set a valid Ignite version and verify it</li>
	 * <li>Check wizard message</li>
	 * <li>Check whether a user can finish the wizard (SUCCESS)</li>
	 * </ol>
	 */
	@Test
	public void testIgnitelVersionVerify() {
		NewFuseIgniteExtensionProjectFirstPage firstPage = new NewFuseIgniteExtensionProjectFirstPage(wizard);
		firstPage.setTextProjectName("MyNewIgniteExt");
		wizard.next();
		NewFuseIgniteExtensionProjectSecondPage secondPage = new NewFuseIgniteExtensionProjectSecondPage(wizard);
		secondPage.setIgniteVersion("100.100.100");
		secondPage.clickVerifyIgniteVersion();
		checkFailToFinish();
		assertTrue("There are some errors in Error Log", LogGrapper.getPluginErrors("fuse").size() == 0);
	}

	/**
	 * <p>
	 * Tests Camel the second page (details) of <i>New Fuse Ignite Extension Project</i> wizard
	 * </p>
	 * <b>Steps:</b>
	 * <ol>
	 * <li>Open <i>New Fuse Ignite Extension Project</i> wizard</li>
	 * <li>Set a project name</li>
	 * <li>Go to the second page</li>
	 * <li>Delete values for <i>ID</i>, <i>Name</i>, <i>Version</i></li>
	 * <li>Check wizard message - ERROR</li>
	 * <li>Check whether a user can finish the wizard (FAIL)</li>
	 * <li>Set an "ID"</li>
	 * <li>Check wizard message - ERROR</li>
	 * <li>Check whether a user can finish the wizard (FAIL)</li>
	 * <li>Set an "Name"</li>
	 * <li>Check wizard message - ERROR</li>
	 * <li>Check whether a user can finish the wizard (FAIL)</li>
	 * <li>Set an invalid "Version"</li>
	 * <li>Check wizard message - ERROR</li>
	 * <li>Check whether a user can finish the wizard (FAIL)</li>
	 * <li>Set a valid "Version"</li>
	 * <li>Check whether a user can finish the wizard (SUCCESS)</li>
	 * </ol>
	 */
	@Test
	public void testDetails() {
		NewFuseIgniteExtensionProjectFirstPage firstPage = new NewFuseIgniteExtensionProjectFirstPage(wizard);
		firstPage.setTextProjectName("MyNewIgniteExt");
		wizard.next();
		NewFuseIgniteExtensionProjectSecondPage secondPage = new NewFuseIgniteExtensionProjectSecondPage(wizard);
		secondPage.setTextName("");
		secondPage.setTextID("");
		secondPage.setTextVersion("");
		checkFailToFinish();
		secondPage.setTextID("ignite.extension.example");
		checkFailToFinish();
		secondPage.setTextName("Example Ignite Extension");
		checkFailToFinish();
		secondPage.setTextVersion("a.b.c");
		checkFailToFinish();
		secondPage.setTextVersion("1.1.1a");
		checkFailToFinish();
		secondPage.setTextVersion("1.1.1-SNAPSHOT");
		checkFailToFinish();
		secondPage.setTextVersion("1.1");
		checkClearToFinish();
		assertTrue("There are some errors in Error Log", LogGrapper.getPluginErrors("fuse").size() == 0);
	}

	/**
	 * <p>
	 * Tests combo boxes on the second page of <i>New Fuse Ignite Extension Project</i> wizard
	 * </p>
	 * <b>Steps:</b>
	 * <ol>
	 * <li>Open <i>New Fuse Ignite Extension Project</i> wizard</li>
	 * <li>Set a project name</li>
	 * <li>Go to the next page of the wizard</li>
	 * <li>Toggle <i>Custom Step</i> combo box</li>
	 * <li>Check whether <i>Camel route</i> and <i>Java bean</i> are available</li>
	 * <li>Toggle <i>Custom Connector</i> combo box</li>
	 * <li>Check whether <i>Camel route</i> and <i>Java bean</i> are unavailable</li>
	 * </ol>
	 */
	@Test
	public void testComboBoxes() {
		NewFuseIgniteExtensionProjectFirstPage firstPage = new NewFuseIgniteExtensionProjectFirstPage(wizard);
		firstPage.setTextProjectName("MyNewIgniteExt");
		wizard.next();
		NewFuseIgniteExtensionProjectSecondPage secondPage = new NewFuseIgniteExtensionProjectSecondPage(wizard);
		secondPage.toggleCustomStepRDB(true);
		assertTrue(secondPage.isTemplateSelectionAvailable());
		secondPage.toggleCustomConnectorRDB(true);;
		assertFalse(secondPage.isTemplateSelectionAvailable());
	}

	private void checkFailToFinish() {
		assertFalse(wizard.isNextEnabled());
		assertFalse(wizard.isFinishEnabled());
		assertTrue(wizard.isBackEnabled());
		assertEquals(MessageTypeEnum.ERROR, wizard.getMessageType());
	}

	private void checkClearToFinish() {
		assertFalse(wizard.isNextEnabled());
		new WaitUntil(new ControlIsEnabled(new FinishButton(wizard)), false);
		assertTrue(wizard.isFinishEnabled());
		assertTrue(wizard.isBackEnabled());
		assertNotEquals(MessageTypeEnum.ERROR, wizard.getMessageType());
	}

	private void checkClearToProceed() {
		assertTrue(wizard.isNextEnabled());
		assertTrue(wizard.isFinishEnabled());
		assertTrue(wizard.isBackEnabled());
		assertNotEquals(MessageTypeEnum.ERROR, wizard.getMessageType());
	}
}