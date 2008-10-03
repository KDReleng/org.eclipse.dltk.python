package org.eclipse.dltk.python.internal.core.parser;

import org.eclipse.dltk.compiler.task.ITodoTaskPreferences;
import org.eclipse.dltk.compiler.task.TodoTaskPreferences;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.builder.AbstractTodoTaskBuildParticipantType;
import org.eclipse.dltk.python.core.PythonPlugin;

public class PythonTodoParserType extends AbstractTodoTaskBuildParticipantType {

	protected ITodoTaskPreferences getPreferences(IScriptProject project) {
		return new TodoTaskPreferences(PythonPlugin.getDefault()
				.getPluginPreferences());
	}
}
