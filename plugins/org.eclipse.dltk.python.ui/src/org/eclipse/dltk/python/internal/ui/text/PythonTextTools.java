/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.python.internal.ui.text;

import org.eclipse.dltk.python.ui.text.IPythonPartitions;
import org.eclipse.dltk.ui.editor.highlighting.ISemanticHighlighter;
import org.eclipse.dltk.ui.editor.highlighting.SemanticHighlighting;
import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.ui.texteditor.ITextEditor;

public class PythonTextTools extends ScriptTextTools {

	private final static String[] LEGAL_CONTENT_TYPES = new String[] {
			IPythonPartitions.PYTHON_STRING, IPythonPartitions.PYTHON_COMMENT };

	public PythonTextTools(boolean autoDisposeOnDisplayDispose) {
		super(IPythonPartitions.PYTHON_PARTITIONING, LEGAL_CONTENT_TYPES,
				autoDisposeOnDisplayDispose);
	}

	public ScriptSourceViewerConfiguration createSourceViewerConfiguraton(
			IPreferenceStore preferenceStore, ITextEditor editor,
			String partitioning) {
		return new PythonSourceViewerConfiguration(getColorManager(),
				preferenceStore, editor, partitioning);
	}

	public IPartitionTokenScanner getPartitionScanner() {
		return new PythonPartitionScanner();
	}

	public SemanticHighlighting[] getSemanticHighlightings() {
		return new SemanticHighlighting[0];
	}

	public ISemanticHighlighter getSemanticPositionUpdater() {
		return null;
	}
}
