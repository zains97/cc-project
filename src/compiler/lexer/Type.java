package lexer;

import compiler.lexer.Keyword;
import compiler.lexer.Tag;

public class Type extends Keyword {
    public final int width;

    Type(String lexeme, int tag, int width) {
        super(lexeme, tag);
        this.width = width;
    }

    public static Type INT = new Type("int", Tag.TYPE, 4);
    public static Type FLOAT = new Type("float", Tag.TYPE, 8);

    public static boolean isNumeric(Type p) {
        return p == Type.INT || p == Type.FLOAT;
    }

    public static Type maxNumericType(Type t1, Type t2) {
        if (!isNumeric(t1) || !isNumeric(t2)) {
            return null;
        }
        if (t1 == Type.FLOAT || t2 == Type.FLOAT) {
            return Type.FLOAT;
        }

        return Type.INT;
    }

}
