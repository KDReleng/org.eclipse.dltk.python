package org.eclipse.dltk.python.internal.core.search;

import org.eclipse.dltk.core.search.AbstractSearchFactory;
import org.eclipse.dltk.core.search.IMatchLocatorParser;
import org.eclipse.dltk.core.search.matching.MatchLocator;

/**
 * Python search factory
 */
public class PythonSearchFactory extends AbstractSearchFactory {

	public IMatchLocatorParser createMatchParser(MatchLocator locator) {
		return new PythonMatchLocationParser(locator);
	}
}
