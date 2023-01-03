package compiler.lexer;

// Our keywords will be defined using this class
public class Keyword extends Token {
    public final String lexeme;

    public Keyword(String lexeme, int tag) {
        super(tag);
        this.lexeme = lexeme;
    }

    public final static Keyword AND = new Keyword("&&", Tag.AND);
    public final static Keyword OR = new Keyword("||", Tag.OR);
    public final static Keyword PLUS = new Keyword("+", Tag.PLUS);
    public final static Keyword MINUS = new Keyword("-", Tag.MINUS);
    public final static Keyword DIVIDE = new Keyword("/", Tag.DIVIDE);
    public final static Keyword MULTIPLY = new Keyword("*", Tag.MULTIPLY);
    public final static Keyword INCREMENT = new Keyword("++", Tag.INCREMENT);
    public final static Keyword DECREMENT = new Keyword("--", Tag.DECREMENT);
    public final static Keyword MODULO = new Keyword("%", Tag.MODULO);
    public final static Keyword BR_OP = new Keyword("(", Tag.BR_OP);
    public final static Keyword BR_CL = new Keyword(")", Tag.BR_CL);
    public final static Keyword EQ = new Keyword("=", Tag.EQ);
}
