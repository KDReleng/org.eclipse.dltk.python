package org.eclipse.dltk.python.activestatedebugger;

import org.eclipse.dltk.core.PreferencesLookupDelegate;
import org.eclipse.dltk.core.environment.IFileHandle;
import org.eclipse.dltk.launching.ExternalDebuggingEngineRunner;
import org.eclipse.dltk.launching.IInterpreterInstall;
import org.eclipse.dltk.launching.InterpreterConfig;
import org.eclipse.dltk.launching.debug.DbgpConnectionConfig;
import org.eclipse.dltk.python.internal.debug.PythonDebugPlugin;

/**
 * Debugging engine implementation for ActiveState's python debugging engine.
 * 
 * <p>
 * This implementation does not require you to install the python debugging
 * engine as described in the install documentation. Instead, the path to the
 * debugging engine will be passed to the python interpreter.
 * </p>
 * 
 * <p>
 * see: <a href=
 * "http://aspn.activestate.com/ASPN/docs/Komodo/komodo-doc-debugpython.html">
 * http://aspn.activestate.com/ASPN/docs/Komodo/komodo-doc-debugpython.html</a>
 * </p>
 */
public class PythonActiveStateDebuggerRunner extends
		ExternalDebuggingEngineRunner {

	public static final String ENGINE_ID = "org.eclipse.dltk.python.activestatedebugger"; //$NON-NLS-1$

	public PythonActiveStateDebuggerRunner(IInterpreterInstall install) {
		super(install);
	}

	/*
	 * @see ExternalDebugginEngineRunner#alterConfig(String, InterpreterConfig,
	 * String)
	 */
	protected InterpreterConfig alterConfig(InterpreterConfig config,
			PreferencesLookupDelegate delegate) {

		IFileHandle debugEnginePath = getDebuggingEnginePath(delegate);
		DbgpConnectionConfig dbgpConfig = DbgpConnectionConfig.load(config);
		// python -S path/to/pydbgp.py -d host:port -k ide_key your-script.py
		config.addInterpreterArg("-S"); //$NON-NLS-1$
		config.addInterpreterArg(debugEnginePath.toString());
		config.addInterpreterArg("-d"); //$NON-NLS-1$
		config.addInterpreterArg(dbgpConfig.getHost()
				+ ":" + dbgpConfig.getPort()); //$NON-NLS-1$
		config.addInterpreterArg("-k"); //$NON-NLS-1$
		config.addInterpreterArg(dbgpConfig.getSessionId());

		return config;
	}

	/*
	 * @see DebuggingEngineRunner#getDebuggingEngineId()
	 */
	protected String getDebuggingEngineId() {
		return ENGINE_ID;
	}

	/*
	 * @see ExternalDebuggingEngineRunner#getDebuggingEnginePreferenceKey()
	 */
	protected String getDebuggingEnginePreferenceKey() {
		return PythonActiveStateDebuggerConstants.DEBUGGING_ENGINE_PATH_KEY;
	}

	/*
	 * @see
	 * ExternalDebuggingEngineRunner#getDebuggingEnginePreferenceQualifier()
	 */
	protected String getDebuggingEnginePreferenceQualifier() {
		return PythonActiveStateDebuggerPlugin.PLUGIN_ID;
	}

	/*
	 * @see DebuggingEngineRunner#getDebugPreferenceQualifier()
	 */
	protected String getDebugPreferenceQualifier() {
		return PythonDebugPlugin.PLUGIN_ID;
	}

	/*
	 * @see DebuggingEngineRunner#getLoggingEnabledPreferenceKey()
	 */
	protected String getLoggingEnabledPreferenceKey() {
		return PythonActiveStateDebuggerConstants.ENABLE_LOGGING;
	}

	/*
	 * @see DebuggingEngineRunner#getLogFileNamePreferenceKey()
	 */
	protected String getLogFileNamePreferenceKey() {
		return PythonActiveStateDebuggerConstants.LOG_FILE_NAME;
	}

	/*
	 * @see DebuggingEngineRunner#getLogFilePathPreferenceKey ()
	 */
	protected String getLogFilePathPreferenceKey() {
		return PythonActiveStateDebuggerConstants.LOG_FILE_PATH;
	}
}
