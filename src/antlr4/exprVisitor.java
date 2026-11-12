// Generated from src/antlr4/expr.g4 by ANTLR 4.13.2
 package antlr4; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link exprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface exprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link exprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(exprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(exprParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#expressao2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao2(exprParser.Expressao2Context ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(exprParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#termo2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo2(exprParser.Termo2Context ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(exprParser.FatorContext ctx);
}