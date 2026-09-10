// Generated from C:/Users/CMD/IdeaProjects/compilador_minilang_java/src/antlr4/lexeri.g4 by ANTLR 4.13.2
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
		"\u0004\u0000\u0007v\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002F\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003K\b\u0003\n\u0003"+
		"\f\u0003N\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0003\u0004S\b\u0004"+
		"\u0001\u0004\u0004\u0004V\b\u0004\u000b\u0004\f\u0004W\u0001\u0005\u0003"+
		"\u0005[\b\u0005\u0001\u0005\u0004\u0005^\b\u0005\u000b\u0005\f\u0005_"+
		"\u0001\u0005\u0001\u0005\u0004\u0005d\b\u0005\u000b\u0005\f\u0005e\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006o\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0000\u0000\t\u0001\u0000\u0003\u0000\u0005\u0001\u0007\u0002"+
		"\t\u0003\u000b\u0004\r\u0005\u000f\u0006\u0011\u0007\u0001\u0000\u0004"+
		"\u0002\u0000AZaz\u0002\u0000++--\u0003\u0000*+--//\u0003\u0000\t\n\r\r"+
		"  \u0088\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0001\u0013\u0001\u0000\u0000\u0000\u0003"+
		"\u0015\u0001\u0000\u0000\u0000\u0005E\u0001\u0000\u0000\u0000\u0007G\u0001"+
		"\u0000\u0000\u0000\tR\u0001\u0000\u0000\u0000\u000bZ\u0001\u0000\u0000"+
		"\u0000\rn\u0001\u0000\u0000\u0000\u000fp\u0001\u0000\u0000\u0000\u0011"+
		"r\u0001\u0000\u0000\u0000\u0013\u0014\u0007\u0000\u0000\u0000\u0014\u0002"+
		"\u0001\u0000\u0000\u0000\u0015\u0016\u000209\u0000\u0016\u0004\u0001\u0000"+
		"\u0000\u0000\u0017\u0018\u0005i\u0000\u0000\u0018\u0019\u0005n\u0000\u0000"+
		"\u0019F\u0005t\u0000\u0000\u001a\u001b\u0005i\u0000\u0000\u001bF\u0005"+
		"f\u0000\u0000\u001c\u001d\u0005w\u0000\u0000\u001d\u001e\u0005r\u0000"+
		"\u0000\u001e\u001f\u0005i\u0000\u0000\u001f \u0005t\u0000\u0000 F\u0005"+
		"e\u0000\u0000!\"\u0005r\u0000\u0000\"#\u0005e\u0000\u0000#$\u0005a\u0000"+
		"\u0000$F\u0005d\u0000\u0000%&\u0005t\u0000\u0000&\'\u0005h\u0000\u0000"+
		"\'(\u0005e\u0000\u0000(F\u0005n\u0000\u0000)*\u0005e\u0000\u0000*+\u0005"+
		"l\u0000\u0000+,\u0005s\u0000\u0000,F\u0005e\u0000\u0000-.\u0005b\u0000"+
		"\u0000./\u0005e\u0000\u0000/0\u0005g\u0000\u000001\u0005i\u0000\u0000"+
		"1F\u0005n\u0000\u000023\u0005w\u0000\u000034\u0005h\u0000\u000045\u0005"+
		"i\u0000\u000056\u0005l\u0000\u00006F\u0005e\u0000\u000078\u0005d\u0000"+
		"\u00008F\u0005o\u0000\u00009:\u0005p\u0000\u0000:;\u0005r\u0000\u0000"+
		";<\u0005o\u0000\u0000<=\u0005g\u0000\u0000=>\u0005r\u0000\u0000>?\u0005"+
		"a\u0000\u0000?F\u0005m\u0000\u0000@A\u0005f\u0000\u0000AB\u0005l\u0000"+
		"\u0000BC\u0005o\u0000\u0000CD\u0005a\u0000\u0000DF\u0005t\u0000\u0000"+
		"E\u0017\u0001\u0000\u0000\u0000E\u001a\u0001\u0000\u0000\u0000E\u001c"+
		"\u0001\u0000\u0000\u0000E!\u0001\u0000\u0000\u0000E%\u0001\u0000\u0000"+
		"\u0000E)\u0001\u0000\u0000\u0000E-\u0001\u0000\u0000\u0000E2\u0001\u0000"+
		"\u0000\u0000E7\u0001\u0000\u0000\u0000E9\u0001\u0000\u0000\u0000E@\u0001"+
		"\u0000\u0000\u0000F\u0006\u0001\u0000\u0000\u0000GL\u0003\u0001\u0000"+
		"\u0000HK\u0003\u0001\u0000\u0000IK\u0003\u0003\u0001\u0000JH\u0001\u0000"+
		"\u0000\u0000JI\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000\u0000LJ\u0001"+
		"\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0001\u0000\u0000\u0000"+
		"NL\u0001\u0000\u0000\u0000OP\u0006\u0003\u0000\u0000P\b\u0001\u0000\u0000"+
		"\u0000QS\u0007\u0001\u0000\u0000RQ\u0001\u0000\u0000\u0000RS\u0001\u0000"+
		"\u0000\u0000SU\u0001\u0000\u0000\u0000TV\u0003\u0003\u0001\u0000UT\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000X\n\u0001\u0000\u0000\u0000Y[\u0007\u0001\u0000"+
		"\u0000ZY\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[]\u0001\u0000"+
		"\u0000\u0000\\^\u0003\u0003\u0001\u0000]\\\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000ac\u0005.\u0000\u0000bd\u0003\u0003\u0001\u0000"+
		"cb\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000"+
		"\u0000ef\u0001\u0000\u0000\u0000f\f\u0001\u0000\u0000\u0000go\u0005>\u0000"+
		"\u0000hi\u0005>\u0000\u0000io\u0005=\u0000\u0000jo\u0005<\u0000\u0000"+
		"kl\u0005<\u0000\u0000lo\u0005=\u0000\u0000mo\u0005=\u0000\u0000ng\u0001"+
		"\u0000\u0000\u0000nh\u0001\u0000\u0000\u0000nj\u0001\u0000\u0000\u0000"+
		"nk\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000o\u000e\u0001\u0000"+
		"\u0000\u0000pq\u0007\u0002\u0000\u0000q\u0010\u0001\u0000\u0000\u0000"+
		"rs\u0007\u0003\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0006\b\u0001\u0000"+
		"u\u0012\u0001\u0000\u0000\u0000\n\u0000EJLRWZ_en\u0002\u0001\u0003\u0000"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}