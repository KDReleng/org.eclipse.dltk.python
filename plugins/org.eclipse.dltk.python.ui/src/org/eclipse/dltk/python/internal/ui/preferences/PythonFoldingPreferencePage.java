/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/

package org.eclipse.dltk.python.internal.ui.preferences;

import org.eclipse.dltk.python.internal.ui.PythonUI;
import org.eclipse.dltk.python.internal.ui.text.folding.PythonFoldingPreferenceBlock;
import org.eclipse.dltk.ui.preferences.AbstractConfigurationBlockPreferencePage;
import org.eclipse.dltk.ui.preferences.IPreferenceConfigurationBlock;
import org.eclipse.dltk.ui.preferences.OverlayPreferenceStore;
import org.eclipse.dltk.ui.text.folding.DefaultFoldingPreferenceConfigurationBlock;
import org.eclipse.dltk.ui.text.folding.IFoldingPreferenceBlock;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Python folding preference page
 */
public final class PythonFoldingPreferencePage extends
		AbstractConfigurationBlockPreferencePage {

	protected String getHelpId() {
		return null;
	}

	protected void setDescription() {
		// setDescription(PreferencesMessages.EditorPreferencePage_folding_title);
	}

	protected void setPreferenceStore() {
		setPreferenceStore(PythonUI.getDefault().getPreferenceStore());
	}

	protected Label createDescriptionLabel(Composite parent) {
		return null; // no description for new look.
	}

	protected IPreferenceConfigurationBlock createConfigurationBlock(
			OverlayPreferenceStore overlayPreferenceStore) {
		return new DefaultFoldingPreferenceConfigurationBlock(
				overlayPreferenceStore, this) {
			protected IFoldingPreferenceBlock createSourceCodeBlock(
					OverlayPreferenceStore store, PreferencePage page) {
				return new PythonFoldingPreferenceBlock(store, page);
			}
		};
	}
}
