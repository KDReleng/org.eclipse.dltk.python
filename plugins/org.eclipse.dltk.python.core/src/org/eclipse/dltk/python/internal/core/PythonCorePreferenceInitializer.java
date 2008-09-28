package org.eclipse.dltk.python.internal.core;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.dltk.compiler.task.TodoTaskPreferences;
import org.eclipse.dltk.python.core.PythonPlugin;


public class PythonCorePreferenceInitializer extends
		AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		Preferences store = PythonPlugin.getDefault().getPluginPreferences();
		
		TodoTaskPreferences.initializeDefaultValues(store);
	}

}
