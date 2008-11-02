package org.eclipse.dltk.python.internal.ui.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.dltk.python.core.PythonNature;
import org.eclipse.dltk.python.core.PythonPlugin;
import org.eclipse.dltk.ui.PreferencesAdapter;
import org.eclipse.dltk.ui.preferences.AbstractConfigurationBlockPropertyAndPreferencePage;
import org.eclipse.dltk.ui.preferences.AbstractOptionsBlock;
import org.eclipse.dltk.ui.preferences.AbstractTodoTaskOptionsBlock;
import org.eclipse.dltk.ui.preferences.PreferenceKey;
import org.eclipse.dltk.ui.util.IStatusChangeListener;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;

public class PythonTodoTaskPreferencePage extends
		AbstractConfigurationBlockPropertyAndPreferencePage {

	static final PreferenceKey CASE_SENSITIVE = AbstractTodoTaskOptionsBlock
			.createCaseSensitiveKey(PythonPlugin.PLUGIN_ID);

	static final PreferenceKey ENABLED = AbstractTodoTaskOptionsBlock
			.createEnabledKey(PythonPlugin.PLUGIN_ID);

	static final PreferenceKey TAGS = AbstractTodoTaskOptionsBlock
			.createTagKey(PythonPlugin.PLUGIN_ID);

	protected String getHelpId() {
		return null;
	}

	protected void setDescription() {
		setDescription(PythonPreferencesMessages.TodoTaskDescription);
	}

	protected Preferences getPluginPreferences() {
		return PythonPlugin.getDefault().getPluginPreferences();
	}

	protected AbstractOptionsBlock createOptionsBlock(
			IStatusChangeListener newStatusChangedListener, IProject project,
			IWorkbenchPreferenceContainer container) {
		return new AbstractTodoTaskOptionsBlock(newStatusChangedListener,
				project, getPreferenceKeys(), container) {
			protected PreferenceKey getTags() {
				return TAGS;
			}

			protected PreferenceKey getEnabledKey() {
				return ENABLED;
			}

			protected PreferenceKey getCaseSensitiveKey() {
				return CASE_SENSITIVE;
			}
		};
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
		return "org.eclipse.dltk.python.preferences.todo";
	}

	protected String getPropertyPageId() {
		return "org.eclipse.dltk.python.propertyPage.todo";
	}

	protected PreferenceKey[] getPreferenceKeys() {
		return new PreferenceKey[] { TAGS, ENABLED, CASE_SENSITIVE };
	}
}
