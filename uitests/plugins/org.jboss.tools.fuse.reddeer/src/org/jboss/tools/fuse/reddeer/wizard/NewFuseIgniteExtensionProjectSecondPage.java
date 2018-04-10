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
package org.jboss.tools.fuse.reddeer.wizard;

import java.util.List;

import org.eclipse.reddeer.common.wait.TimePeriod;
import org.eclipse.reddeer.common.wait.WaitUntil;
import org.eclipse.reddeer.core.exception.CoreLayerException;
import org.eclipse.reddeer.core.reference.ReferencedComposite;
import org.eclipse.reddeer.jface.wizard.WizardPage;
import org.eclipse.reddeer.swt.condition.ControlIsEnabled;
import org.eclipse.reddeer.swt.impl.button.PushButton;
import org.eclipse.reddeer.swt.impl.button.RadioButton;
import org.eclipse.reddeer.swt.impl.combo.DefaultCombo;
import org.eclipse.reddeer.swt.impl.text.LabeledText;

/**
 * Represents the second page of "New Fuse Ignite Extension Project" wizard
 * 
 * @author tsedmik
 */
public class NewFuseIgniteExtensionProjectSecondPage extends WizardPage {

	public NewFuseIgniteExtensionProjectSecondPage(ReferencedComposite referencedComposite) {
		super(referencedComposite);
	}

	public DefaultCombo getIgniteVersionCombo() {
		return new DefaultCombo(this, 0);
	}

	public String getIgniteVersion() {
		return new DefaultCombo(this, 0).getSelection();
	}

	public List<String> getAllAvailableIgniteVersions() {
		return new DefaultCombo(this, 0).getItems();
	}

	public void setIgniteVersion(String version) {
		new DefaultCombo(this, 0).setText(version);
	}

	public void clickVerifyIgniteVersion() {
		PushButton verify = new PushButton(this, "Verify");
		verify.click();
		new WaitUntil(new ControlIsEnabled(verify), TimePeriod.LONG);
	}

	public PushButton getVerifyBTN() {
		return new PushButton(this, "Verify");
	}

	public String getTextVersion() {
		return new LabeledText(this, "Version").getText();
	}

	public String getTextDescription() {
		return new LabeledText(this, "Description").getText();
	}

	public String getTextName() {
		return new LabeledText(this, "Name").getText();
	}

	public String getTextID() {
		return new LabeledText(this, "ID").getText();
	}

	public void setTextVersion(String str) {
		new LabeledText(this, "Version").setText(str);
	}

	public void setTextDescription(String str) {
		new LabeledText(this, "Description").setText(str);
	}

	public void setTextName(String str) {
		new LabeledText(this, "Name").setText(str);
	}

	public void setTextID(String str) {
		new LabeledText(this, "ID").setText(str);
	}

	public boolean isSelectedJavaBeanRDB() {
		return new RadioButton(this, "Java bean").isSelected();
	}

	public boolean isSelectedCamelRouteRDB() {
		return new RadioButton(this, "Camel route").isSelected();
	}

	public boolean isSelectedCustomConnectorRDB() {
		return new RadioButton(this, "Custom Connector").isSelected();
	}

	public boolean isSelectedCustomStepRDB() {
		return new RadioButton(this, "Custom Step").isSelected();
	}

	public void toggleJavaBeanRDB(boolean choice) {
		new RadioButton(this, "Java bean").toggle(choice);
	}

	public void toggleCamelRouteRDB(boolean choice) {
		new RadioButton(this, "Camel route").toggle(choice);
	}

	public void toggleCustomConnectorRDB(boolean choice) {
		new RadioButton(this, "Custom Connector").toggle(choice);
	}

	public void toggleCustomStepRDB(boolean choice) {
		new RadioButton(this, "Custom Step").toggle(choice);
	}

	public boolean isTemplateSelectionAvailable() {
		try {
			new RadioButton(this, "Camel route");
			new RadioButton(this, "Java bean");
		} catch (CoreLayerException e) {
			return false;
		}
		return true;
	}
}
