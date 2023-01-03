package compiler.lexer;

public class Real extends Token {
    public final float value;

    Real(float value) {
        super(Tag.REAL);
        this.value = value;
    }
}
