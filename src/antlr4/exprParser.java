// Generated from expr.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class exprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NUM=6, WS=7;
	public static final int
		RULE_program = 0, RULE_expressao = 1, RULE_expressao2 = 2, RULE_termo = 3, 
		RULE_termo2 = 4, RULE_fator = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expressao", "expressao2", "termo", "termo2", "fator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "NUM", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public exprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public int val;
		public ExpressaoContext expressao;
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode EOF() { return getToken(exprParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			((ProgramContext)_localctx).expressao = expressao();
			setState(13);
			match(EOF);
			((ProgramContext)_localctx).val =  ((ProgramContext)_localctx).expressao.val;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoContext extends ParserRuleContext {
		public int val;
		public TermoContext termo;
		public Expressao2Context expressao2;
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public Expressao2Context expressao2() {
			return getRuleContext(Expressao2Context.class,0);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitExpressao(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expressao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			((ExpressaoContext)_localctx).termo = termo();
			setState(17);
			((ExpressaoContext)_localctx).expressao2 = expressao2(((ExpressaoContext)_localctx).termo.val);
			((ExpressaoContext)_localctx).val =  ((ExpressaoContext)_localctx).expressao2.sint;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expressao2Context extends ParserRuleContext {
		public int her;
		public int sint;
		public TermoContext termo;
		public Expressao2Context expressao2;
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public Expressao2Context expressao2() {
			return getRuleContext(Expressao2Context.class,0);
		}
		public Expressao2Context(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expressao2Context(ParserRuleContext parent, int invokingState, int her) {
			super(parent, invokingState);
			this.her = her;
		}
		@Override public int getRuleIndex() { return RULE_expressao2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterExpressao2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitExpressao2(this);
		}
	}

	public final Expressao2Context expressao2(int her) throws RecognitionException {
		Expressao2Context _localctx = new Expressao2Context(_ctx, getState(), her);
		enterRule(_localctx, 4, RULE_expressao2);
		try {
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				match(T__0);
				setState(21);
				((Expressao2Context)_localctx).termo = termo();
				setState(22);
				((Expressao2Context)_localctx).expressao2 = expressao2(((Expressao2Context)_localctx).termo.val + _localctx.her);
				((Expressao2Context)_localctx).sint =  ((Expressao2Context)_localctx).expressao2.sint;
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(T__1);
				setState(26);
				((Expressao2Context)_localctx).termo = termo();
				setState(27);
				((Expressao2Context)_localctx).expressao2 = expressao2(_localctx.her-((Expressao2Context)_localctx).termo.val);
				((Expressao2Context)_localctx).sint =  ((Expressao2Context)_localctx).expressao2.sint;
				}
				break;
			case EOF:
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				((Expressao2Context)_localctx).sint =  _localctx.her;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public int val;
		public FatorContext fator;
		public Termo2Context termo2;
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public Termo2Context termo2() {
			return getRuleContext(Termo2Context.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_termo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			((TermoContext)_localctx).fator = fator();
			setState(34);
			((TermoContext)_localctx).termo2 = termo2(((TermoContext)_localctx).fator.val);
			((TermoContext)_localctx).val =  ((TermoContext)_localctx).termo2.sint;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Termo2Context extends ParserRuleContext {
		public int her;
		public int sint;
		public FatorContext fator;
		public Termo2Context termo2;
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public Termo2Context termo2() {
			return getRuleContext(Termo2Context.class,0);
		}
		public Termo2Context(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Termo2Context(ParserRuleContext parent, int invokingState, int her) {
			super(parent, invokingState);
			this.her = her;
		}
		@Override public int getRuleIndex() { return RULE_termo2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterTermo2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitTermo2(this);
		}
	}

	public final Termo2Context termo2(int her) throws RecognitionException {
		Termo2Context _localctx = new Termo2Context(_ctx, getState(), her);
		enterRule(_localctx, 8, RULE_termo2);
		try {
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(T__2);
				setState(38);
				((Termo2Context)_localctx).fator = fator();
				setState(39);
				((Termo2Context)_localctx).termo2 = termo2(((Termo2Context)_localctx).fator.val * _localctx.her);
				((Termo2Context)_localctx).sint =  ((Termo2Context)_localctx).termo2.sint;
				}
				break;
			case EOF:
			case T__0:
			case T__1:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				((Termo2Context)_localctx).sint =  _localctx.her;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public int val;
		public ExpressaoContext expressao;
		public Token NUM;
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode NUM() { return getToken(exprParser.NUM, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fator);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(T__3);
				setState(46);
				((FatorContext)_localctx).expressao = expressao();
				setState(47);
				match(T__4);
				((FatorContext)_localctx).val =  ((FatorContext)_localctx).expressao.val;
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				((FatorContext)_localctx).NUM = match(NUM);
				((FatorContext)_localctx).val =  Interger.parseInt((((FatorContext)_localctx).NUM!=null?((FatorContext)_localctx).NUM.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u00077\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002 \b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004,\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u00055\b\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002\u0004\u0006"+
		"\b\n\u0000\u00004\u0000\f\u0001\u0000\u0000\u0000\u0002\u0010\u0001\u0000"+
		"\u0000\u0000\u0004\u001f\u0001\u0000\u0000\u0000\u0006!\u0001\u0000\u0000"+
		"\u0000\b+\u0001\u0000\u0000\u0000\n4\u0001\u0000\u0000\u0000\f\r\u0003"+
		"\u0002\u0001\u0000\r\u000e\u0005\u0000\u0000\u0001\u000e\u000f\u0006\u0000"+
		"\uffff\uffff\u0000\u000f\u0001\u0001\u0000\u0000\u0000\u0010\u0011\u0003"+
		"\u0006\u0003\u0000\u0011\u0012\u0003\u0004\u0002\u0000\u0012\u0013\u0006"+
		"\u0001\uffff\uffff\u0000\u0013\u0003\u0001\u0000\u0000\u0000\u0014\u0015"+
		"\u0005\u0001\u0000\u0000\u0015\u0016\u0003\u0006\u0003\u0000\u0016\u0017"+
		"\u0003\u0004\u0002\u0000\u0017\u0018\u0006\u0002\uffff\uffff\u0000\u0018"+
		" \u0001\u0000\u0000\u0000\u0019\u001a\u0005\u0002\u0000\u0000\u001a\u001b"+
		"\u0003\u0006\u0003\u0000\u001b\u001c\u0003\u0004\u0002\u0000\u001c\u001d"+
		"\u0006\u0002\uffff\uffff\u0000\u001d \u0001\u0000\u0000\u0000\u001e \u0006"+
		"\u0002\uffff\uffff\u0000\u001f\u0014\u0001\u0000\u0000\u0000\u001f\u0019"+
		"\u0001\u0000\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000 \u0005\u0001"+
		"\u0000\u0000\u0000!\"\u0003\n\u0005\u0000\"#\u0003\b\u0004\u0000#$\u0006"+
		"\u0003\uffff\uffff\u0000$\u0007\u0001\u0000\u0000\u0000%&\u0005\u0003"+
		"\u0000\u0000&\'\u0003\n\u0005\u0000\'(\u0003\b\u0004\u0000()\u0006\u0004"+
		"\uffff\uffff\u0000),\u0001\u0000\u0000\u0000*,\u0006\u0004\uffff\uffff"+
		"\u0000+%\u0001\u0000\u0000\u0000+*\u0001\u0000\u0000\u0000,\t\u0001\u0000"+
		"\u0000\u0000-.\u0005\u0004\u0000\u0000./\u0003\u0002\u0001\u0000/0\u0005"+
		"\u0005\u0000\u000001\u0006\u0005\uffff\uffff\u000015\u0001\u0000\u0000"+
		"\u000023\u0005\u0006\u0000\u000035\u0006\u0005\uffff\uffff\u00004-\u0001"+
		"\u0000\u0000\u000042\u0001\u0000\u0000\u00005\u000b\u0001\u0000\u0000"+
		"\u0000\u0003\u001f+4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}