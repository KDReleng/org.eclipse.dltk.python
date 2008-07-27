package org.eclipse.dltk.python.internal.debug.ui;

import org.eclipse.dltk.debug.ui.DLTKDebugUIPluginPreferenceInitializer;
import org.eclipse.dltk.python.core.PythonNature;

public class PythonDebugUIPreferenceInitializer extends
		DLTKDebugUIPluginPreferenceInitializer {

	protected String getNatureId() {
		return PythonNature.NATURE_ID;
	}
}
