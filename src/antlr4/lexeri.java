// Generated from lexeri.g4 by ANTLR 4.13.2

package antlr4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class lexeri extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RESERVADA=1, VAR=2, NUMINT=3, NUMFLOAT=4, OP_RELACIONAL=5, OP_ARITMETICO=6, 
		WHITESPACE=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LETTER", "DIGIT", "RESERVADA", "VAR", "NUMINT", "NUMFLOAT", "OP_RELACIONAL", 
			"OP_ARITMETICO", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RESERVADA", "VAR", "NUMINT", "NUMFLOAT", "OP_RELACIONAL", "OP_ARITMETICO", 
			"WHITESPACE"
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


	public lexeri(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lexeri.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 3:
			VAR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void VAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			    System.out.print("[Var," + getText() + "]");

			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u0007q\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002A\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003F\b\u0003"+
		"\n\u0003\f\u0003I\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0003\u0004"+
		"N\b\u0004\u0001\u0004\u0004\u0004Q\b\u0004\u000b\u0004\f\u0004R\u0001"+
		"\u0005\u0003\u0005V\b\u0005\u0001\u0005\u0004\u0005Y\b\u0005\u000b\u0005"+
		"\f\u0005Z\u0001\u0005\u0001\u0005\u0004\u0005_\b\u0005\u000b\u0005\f\u0005"+
		"`\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006j\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0000\u0000\t\u0001\u0000\u0003\u0000\u0005\u0001\u0007"+
		"\u0002\t\u0003\u000b\u0004\r\u0005\u000f\u0006\u0011\u0007\u0001\u0000"+
		"\u0004\u0002\u0000AZaz\u0002\u0000++--\u0003\u0000*+--//\u0003\u0000\t"+
		"\n\r\r  \u0082\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0001\u0013\u0001\u0000\u0000\u0000"+
		"\u0003\u0015\u0001\u0000\u0000\u0000\u0005@\u0001\u0000\u0000\u0000\u0007"+
		"B\u0001\u0000\u0000\u0000\tM\u0001\u0000\u0000\u0000\u000bU\u0001\u0000"+
		"\u0000\u0000\ri\u0001\u0000\u0000\u0000\u000fk\u0001\u0000\u0000\u0000"+
		"\u0011m\u0001\u0000\u0000\u0000\u0013\u0014\u0007\u0000\u0000\u0000\u0014"+
		"\u0002\u0001\u0000\u0000\u0000\u0015\u0016\u000209\u0000\u0016\u0004\u0001"+
		"\u0000\u0000\u0000\u0017\u0018\u0005i\u0000\u0000\u0018\u0019\u0005n\u0000"+
		"\u0000\u0019A\u0005t\u0000\u0000\u001a\u001b\u0005i\u0000\u0000\u001b"+
		"A\u0005f\u0000\u0000\u001c\u001d\u0005w\u0000\u0000\u001d\u001e\u0005"+
		"r\u0000\u0000\u001e\u001f\u0005i\u0000\u0000\u001f \u0005t\u0000\u0000"+
		" A\u0005e\u0000\u0000!\"\u0005r\u0000\u0000\"#\u0005e\u0000\u0000#$\u0005"+
		"a\u0000\u0000$A\u0005d\u0000\u0000%&\u0005t\u0000\u0000&\'\u0005h\u0000"+
		"\u0000\'(\u0005e\u0000\u0000(A\u0005n\u0000\u0000)*\u0005e\u0000\u0000"+
		"*+\u0005l\u0000\u0000+,\u0005s\u0000\u0000,A\u0005e\u0000\u0000-.\u0005"+
		"b\u0000\u0000./\u0005e\u0000\u0000/0\u0005g\u0000\u000001\u0005i\u0000"+
		"\u00001A\u0005n\u0000\u000023\u0005w\u0000\u000034\u0005h\u0000\u0000"+
		"45\u0005i\u0000\u000056\u0005l\u0000\u00006A\u0005e\u0000\u000078\u0005"+
		"d\u0000\u00008A\u0005o\u0000\u00009:\u0005p\u0000\u0000:;\u0005r\u0000"+
		"\u0000;<\u0005o\u0000\u0000<=\u0005g\u0000\u0000=>\u0005r\u0000\u0000"+
		">?\u0005a\u0000\u0000?A\u0005m\u0000\u0000@\u0017\u0001\u0000\u0000\u0000"+
		"@\u001a\u0001\u0000\u0000\u0000@\u001c\u0001\u0000\u0000\u0000@!\u0001"+
		"\u0000\u0000\u0000@%\u0001\u0000\u0000\u0000@)\u0001\u0000\u0000\u0000"+
		"@-\u0001\u0000\u0000\u0000@2\u0001\u0000\u0000\u0000@7\u0001\u0000\u0000"+
		"\u0000@9\u0001\u0000\u0000\u0000A\u0006\u0001\u0000\u0000\u0000BG\u0003"+
		"\u0001\u0000\u0000CF\u0003\u0001\u0000\u0000DF\u0003\u0003\u0001\u0000"+
		"EC\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000JK\u0006\u0003\u0000\u0000K\b\u0001"+
		"\u0000\u0000\u0000LN\u0007\u0001\u0000\u0000ML\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OQ\u0003\u0003\u0001"+
		"\u0000PO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RP\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000S\n\u0001\u0000\u0000\u0000TV\u0007"+
		"\u0001\u0000\u0000UT\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VX\u0001\u0000\u0000\u0000WY\u0003\u0003\u0001\u0000XW\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\^\u0005.\u0000\u0000]_\u0003"+
		"\u0003\u0001\u0000^]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a\f\u0001\u0000\u0000"+
		"\u0000bj\u0005>\u0000\u0000cd\u0005>\u0000\u0000dj\u0005=\u0000\u0000"+
		"ej\u0005<\u0000\u0000fg\u0005<\u0000\u0000gj\u0005=\u0000\u0000hj\u0005"+
		"=\u0000\u0000ib\u0001\u0000\u0000\u0000ic\u0001\u0000\u0000\u0000ie\u0001"+
		"\u0000\u0000\u0000if\u0001\u0000\u0000\u0000ih\u0001\u0000\u0000\u0000"+
		"j\u000e\u0001\u0000\u0000\u0000kl\u0007\u0002\u0000\u0000l\u0010\u0001"+
		"\u0000\u0000\u0000mn\u0007\u0003\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"op\u0006\b\u0001\u0000p\u0012\u0001\u0000\u0000\u0000\n\u0000@EGMRUZ`"+
		"i\u0002\u0001\u0003\u0000\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}