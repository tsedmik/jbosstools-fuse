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
package org.jboss.tools.fuse.reddeer.preference;

import org.eclipse.reddeer.core.reference.ReferencedComposite;
import org.eclipse.reddeer.jface.preference.PreferencePage;
import org.eclipse.reddeer.swt.impl.button.CheckBox;

/**
 * Represents <i>Console</i> preference page
 * 
 * @author tsedmik
 */
public class ConsolePreferencePage extends PreferencePage {
	
	public ConsolePreferencePage(ReferencedComposite ref) {
		super(ref, "Run/Debug", "Console");
	}

	public void toggleShowConsoleStandardWrite(boolean checked) {
		new CheckBox(2).toggle(checked);
	}

	public void toggleShowConsoleErrorWrite(boolean checked) {
		new CheckBox(3).toggle(checked);
	}
}
