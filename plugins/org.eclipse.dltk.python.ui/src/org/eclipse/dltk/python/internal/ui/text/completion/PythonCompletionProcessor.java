package org.eclipse.dltk.python.internal.ui.text.completion;

import org.eclipse.dltk.python.core.PythonNature;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProcessor;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.ui.IEditorPart;

/**
 * Python completion processor
 */
public class PythonCompletionProcessor extends ScriptCompletionProcessor {

	public PythonCompletionProcessor(IEditorPart editor,
			ContentAssistant assistant, String partition) {
		super(editor, assistant, partition);
	}

	@Override
	protected String getNatureId() {
		return PythonNature.NATURE_ID;
	}

}
