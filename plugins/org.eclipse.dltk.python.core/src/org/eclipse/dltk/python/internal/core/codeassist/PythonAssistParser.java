/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.python.internal.core.codeassist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.codeassist.AbstractAssistParser;
import org.eclipse.dltk.compiler.env.ISourceModule;

public abstract class PythonAssistParser extends AbstractAssistParser {

	protected void findElementsTo(List statements, ASTNode node, List elements) {
		if (statements == null) {
			return;
		}
		Iterator i = statements.iterator();
		while (i.hasNext()) {
			ASTNode n = (ASTNode) i.next();
			if (n.equals(node)) {
				elements.add(n);
				return;
			}
			if (n.sourceStart() <= node.sourceStart()
					&& node.sourceEnd() <= n.sourceEnd()) {
				elements.add(n);
				findElementsTo(PythonASTUtil.getStatements(n), node, elements);
				return;
			}
		}

	}

	protected List findLevelsTo(ASTNode astNodeParent) {
		ModuleDeclaration module = getModule();
		
		List elements = new ArrayList();
		if (module != null || astNodeParent instanceof ModuleDeclaration) {
			if (module == null) {
				module = (ModuleDeclaration) astNodeParent;
			}
			elements.add(module);
			findElementsTo(PythonASTUtil.getStatements(module),
					astNodeParent, elements);
		}
		return elements;
	}

	protected ModuleDeclaration postProcess(ModuleDeclaration module,
			ISourceModule sourceUnit) {
		module.rebuild();
		PythonASTUtil.extendStatements(module, sourceUnit.getSourceContents());
		
		return module;
	}
}
