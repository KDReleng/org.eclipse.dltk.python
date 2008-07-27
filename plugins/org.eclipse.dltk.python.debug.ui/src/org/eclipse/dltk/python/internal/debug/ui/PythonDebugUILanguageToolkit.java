package org.eclipse.dltk.python.internal.debug.ui;

import org.eclipse.dltk.debug.ui.AbstractDebugUILanguageToolkit;
import org.eclipse.dltk.python.internal.debug.PythonDebugConstants;
import org.eclipse.jface.preference.IPreferenceStore;

public class PythonDebugUILanguageToolkit extends
		AbstractDebugUILanguageToolkit {

	/*
	 * @see org.eclipse.dltk.debug.ui.IDLTKDebugUILanguageToolkit#getDebugModelId()
	 */
	public String getDebugModelId() {
		return PythonDebugConstants.DEBUG_MODEL_ID;
	}
	
	/*
	 * @see org.eclipse.dltk.debug.ui.IDLTKDebugUILanguageToolkit#getPreferenceStore()
	 */
	public IPreferenceStore getPreferenceStore() {
		return PythonDebugUIPlugin.getDefault().getPreferenceStore();
	}

	/*
	 * @see org.eclipse.dltk.debug.ui.AbstractDebugUILanguageToolkit#getVariablesViewPreferencePages()
	 */
	public String[] getVariablesViewPreferencePages() {
		return new String[] {"org.eclipse.dltk.python.preferences.debug.detailFormatters"};
	}
}
