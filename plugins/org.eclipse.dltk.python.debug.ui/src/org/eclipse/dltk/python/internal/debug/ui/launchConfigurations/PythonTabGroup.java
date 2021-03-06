/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.python.internal.debug.ui.launchConfigurations;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.dltk.debug.ui.launchConfigurations.InterpreterTab;
import org.eclipse.dltk.debug.ui.launchConfigurations.ScriptArgumentsTab;

public class PythonTabGroup extends AbstractLaunchConfigurationTabGroup {
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {

		PythonMainLaunchConfigurationTab main = new PythonMainLaunchConfigurationTab(
				mode);
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] { main,
				new ScriptArgumentsTab(), new InterpreterTab(main),
				new EnvironmentTab(), new CommonTab() };
		setTabs(tabs);
	}
}
