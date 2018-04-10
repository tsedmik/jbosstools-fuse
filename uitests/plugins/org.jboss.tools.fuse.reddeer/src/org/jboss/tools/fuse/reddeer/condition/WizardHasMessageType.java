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
package org.jboss.tools.fuse.reddeer.condition;

import org.eclipse.reddeer.common.condition.AbstractWaitCondition;
import org.eclipse.reddeer.jface.dialogs.MessageTypeEnum;
import org.eclipse.reddeer.jface.wizard.WizardDialog;

/**
 * @author tsedmik
 */
public class WizardHasMessageType extends AbstractWaitCondition {

	private WizardDialog wizard;
	private MessageTypeEnum type;

	public WizardHasMessageType(WizardDialog wizard, MessageTypeEnum type) {
		this.wizard = wizard;
		this.type = type;
	}

	@Override
	public boolean test() {
		return wizard.getMessageType() == type;
	}

	@Override
	public String description() {
		return "Expected '" + type + "' but was '" + wizard.getMessageType() + "'";
	}
}
