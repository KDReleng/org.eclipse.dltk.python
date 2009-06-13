package org.eclipse.dltk.python.internal.ui.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.dltk.python.core.PythonNature;
import org.eclipse.dltk.python.core.PythonPlugin;
import org.eclipse.dltk.ui.PreferencesAdapter;
import org.eclipse.dltk.ui.preferences.AbstractConfigurationBlockPropertyAndPreferencePage;
import org.eclipse.dltk.ui.preferences.AbstractOptionsBlock;
import org.eclipse.dltk.ui.preferences.TodoTaskOptionsBlock;
import org.eclipse.dltk.ui.util.IStatusChangeListener;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;

public class PythonTodoTaskPreferencePage extends
		AbstractConfigurationBlockPropertyAndPreferencePage {

	protected String getHelpId() {
		return null;
	}

	protected void setDescription() {
		setDescription(PythonPreferencesMessages.TodoTaskDescription);
	}

	protected AbstractOptionsBlock createOptionsBlock(
			IStatusChangeListener newStatusChangedListener, IProject project,
			IWorkbenchPreferenceContainer container) {
		return new TodoTaskOptionsBlock(newStatusChangedListener, project,
				container, PythonPlugin.PLUGIN_ID);
	}

	protected String getNatureId() {
		return PythonNature.NATURE_ID;
	}

	protected String getProjectHelpId() {
		return null;
	}

	protected void setPreferenceStore() {
		setPreferenceStore(new PreferencesAdapter(PythonPlugin.getDefault()
				.getPluginPreferences()));
	}

	protected String getPreferencePageId() {
		return "org.eclipse.dltk.python.preferences.todo"; //$NON-NLS-1$
	}

	protected String getPropertyPageId() {
		return "org.eclipse.dltk.python.propertyPage.todo"; //$NON-NLS-1$
	}

}
