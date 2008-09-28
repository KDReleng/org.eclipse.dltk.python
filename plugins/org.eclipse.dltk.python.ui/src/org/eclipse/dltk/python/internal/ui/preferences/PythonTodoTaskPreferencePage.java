package org.eclipse.dltk.python.internal.ui.preferences;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.dltk.python.core.PythonPlugin;
import org.eclipse.dltk.ui.preferences.TodoTaskAbstractPreferencePage;

public class PythonTodoTaskPreferencePage extends
		TodoTaskAbstractPreferencePage {

	protected Preferences getPluginPreferences() {
		return PythonPlugin.getDefault().getPluginPreferences();
	}

	protected String getHelpId() {
		return null;
	}

	protected void setDescription() {
		setDescription("FIXME: python");
	}

}
