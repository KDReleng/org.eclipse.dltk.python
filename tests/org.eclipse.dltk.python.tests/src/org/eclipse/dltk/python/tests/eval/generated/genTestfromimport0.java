
package org.eclipse.dltk.python.tests.eval.generated;

import java.util.List;

import junit.framework.Test;

import org.eclipse.core.runtime.Path;

import org.eclipse.core.runtime.Path;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.declarations.MethodDeclaration;
import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.tests.model.AbstractModelTests;
import org.eclipse.dltk.python.internal.core.evaluation.PythonASTFindVisitor;
import org.eclipse.dltk.python.internal.core.evaluation.PythonASTTypeEvaluator;
import org.eclipse.dltk.python.internal.core.evaluation.PythonTypeEvaluatorUtils;
import org.eclipse.dltk.python.tests.PythonTestsPlugin;
import org.eclipse.dltk.ti.types.IEvaluatedType;
import org.eclipse.dltk.utils.CorePrinter;
public class genTestfromimport0 extends AbstractModelTests
{
	public genTestfromimport0(String name) {
		super( PythonTestsPlugin.PLUGIN_NAME, name);
	}
		    
	public static Test suite() {
	    return new Suite( genTestfromimport0.class);
	}
	private String prj = "eval0_fromimport0.py";    			    
	public void setUpSuite() throws Exception {
	    super.setUpSuite();
	    setUpScriptProjectTo( prj, "eval0" );
	}
	public void tearDownSuite() throws Exception {
	    super.tearDownSuite();
	    deleteProject( prj );
	}
	private void testType( String moduleName, String name, String type ) throws Exception {
		
		IScriptProject project = getScriptProject( prj );
		ISourceModule module = this.getSourceModule( prj, "src", new Path( moduleName ) );
		
		CorePrinter printer = new CorePrinter( System.out );
		
		assertNotNull( module );
		
		ModuleDeclaration astModule = PythonTypeEvaluatorUtils.parseModuleForElement(module);
		PythonASTFindVisitor findVisitor = new PythonASTFindVisitor( name );
		List nodes = findVisitor.getNodes( );

		astModule.traverse( findVisitor );
		int index = 0;
		assertNotNull( nodes );
		assertEquals( "Element name should be unical", 1, nodes.size() );		
		ASTNode nde = (ASTNode)nodes.get( 0 );
		if( ! ( nde instanceof MethodDeclaration ) ) {			
			PythonASTTypeEvaluator evaluator = new PythonASTTypeEvaluator( module, astModule, findVisitor.getParents() );
			IEvaluatedType evaluatedType = evaluator.evaluateASTNode( nde, null );
			assertEquals( "Types not equal in module " + moduleName + " for variable: " + name, type, evaluatedType.getTypeName() );
		}
	}
	

	public void REM_testEval0() throws Exception {
		testType( "fromimport0.py", "i1", "number" );
	}

	public void REM_testEval1() throws Exception {
		testType( "fromimport0.py", "i2", "string" );
	}

	public void REM_testEval2() throws Exception {
		testType( "fromimport0.py", "i3", "number" );
	}

	public void REM_testEval3() throws Exception {
		testType( "fromimport0.py", "i4", "number" );
	}

	public void REM_testEval4() throws Exception {
		testType( "fromimport0.py", "i5", "number" );
	}

	public void testEval5() throws Exception {
		testType( "fromimport0.py", "i5a", "class:A instance" );
	}

	public void REM_testEval6() throws Exception {
		testType( "fromimport0.py", "i6", "number" );
	}

	public void REM_testEval7() throws Exception {
		testType( "fromimport0.py", "i7", "string" );
	}

	public void testEval8() throws Exception {
		testType( "fromimport0.py", "i8", "unknown" );
	}

	public void REM_testEval9() throws Exception {
		testType( "fromimport0.py", "i9", "number" );
	}

	public void testEval10() throws Exception {
		testType( "fromimport0.py", "i10", "unknown" );
	}

	public void REM_testEval11() throws Exception {
		testType( "fromimport0.py", "i11", "number" );
	}

	public void REM_testEval12() throws Exception {
		testType( "fromimport0.py", "i12", "string" );
	}

	public void testEval13() throws Exception {
		testType( "fromimport0.py", "i13", "unknown" );
	}

	public void testEval14() throws Exception {
		testType( "fromimport0.py", "i14", "unknown" );
	}

	public void REM_testEval15() throws Exception {
		testType( "fromimport0.py", "i15", "number" );
	}

	public void REM_testEval16() throws Exception {
		testType( "fromimport0.py", "i16", "number" );
	}

}
