// Generated from expr.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link exprParser}.
 */
public interface exprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link exprParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(exprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(exprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(exprParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(exprParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#expressao2}.
	 * @param ctx the parse tree
	 */
	void enterExpressao2(exprParser.Expressao2Context ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#expressao2}.
	 * @param ctx the parse tree
	 */
	void exitExpressao2(exprParser.Expressao2Context ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(exprParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(exprParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#termo2}.
	 * @param ctx the parse tree
	 */
	void enterTermo2(exprParser.Termo2Context ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#termo2}.
	 * @param ctx the parse tree
	 */
	void exitTermo2(exprParser.Termo2Context ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(exprParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(exprParser.FatorContext ctx);
}