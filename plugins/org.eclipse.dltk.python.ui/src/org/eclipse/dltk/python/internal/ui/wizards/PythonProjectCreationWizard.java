/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.python.internal.ui.wizards;

import org.eclipse.dltk.python.core.PythonNature;
import org.eclipse.dltk.python.internal.ui.PythonImages;
import org.eclipse.dltk.python.internal.ui.preferences.PythonBuildPathsBlock;
import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.dltk.ui.util.BusyIndicatorRunnableContext;
import org.eclipse.dltk.ui.util.IStatusChangeListener;
import org.eclipse.dltk.ui.wizards.BuildpathsBlock;
import org.eclipse.dltk.ui.wizards.ProjectWizard;
import org.eclipse.dltk.ui.wizards.ProjectWizardFirstPage;
import org.eclipse.dltk.ui.wizards.ProjectWizardSecondPage;

public class PythonProjectCreationWizard extends ProjectWizard {
	private ProjectWizardFirstPage fFirstPage;
	private ProjectWizardSecondPage fSecondPage;

	public PythonProjectCreationWizard() {
		setDefaultPageImageDescriptor(PythonImages.DESC_WIZBAN_PROJECT_CREATION);
		setDialogSettings(DLTKUIPlugin.getDefault().getDialogSettings());
		setWindowTitle(PythonWizardMessages.ProjectCreationWizard_title);
	}

	public void addPages() {
		super.addPages();
		fFirstPage = new ProjectWizardFirstPage() {

			@Override
			public String getScriptNature() {
				return PythonNature.NATURE_ID;
			}

			@Override
			protected boolean interpeterRequired() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		fFirstPage
				.setTitle(PythonWizardMessages.ProjectCreationWizardFirstPage_title);
		fFirstPage
				.setDescription(PythonWizardMessages.ProjectCreationWizardFirstPage_description);
		addPage(fFirstPage);
		fSecondPage = new ProjectWizardSecondPage(fFirstPage) {
			protected BuildpathsBlock createBuildpathBlock(
					IStatusChangeListener listener) {
				return new PythonBuildPathsBlock(
						new BusyIndicatorRunnableContext(), listener, 0,
						useNewSourcePage(), null);
			}

		};
		addPage(fSecondPage);
	}

}
