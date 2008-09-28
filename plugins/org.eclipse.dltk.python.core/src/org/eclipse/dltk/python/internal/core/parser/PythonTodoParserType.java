package org.eclipse.dltk.python.internal.core.parser;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.dltk.python.core.PythonPlugin;
import org.eclipse.dltk.validators.core.AbstractTodoTaskBuildParticipantType;

public class PythonTodoParserType extends
		AbstractTodoTaskBuildParticipantType {

	private static final String ID = "org.eclipse.dltk.python.todo"; //$NON-NLS-1$
	private static final String NAME = "Python TODO task parser"; //$NON-NLS-1$
	
	public PythonTodoParserType() {
		super(ID, NAME);
	}
	
	protected Preferences getPreferences() {
		return PythonPlugin.getDefault().getPluginPreferences();
	}
}
