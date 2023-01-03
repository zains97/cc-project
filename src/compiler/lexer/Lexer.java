package compiler.lexer;

import lexer.Type;

import java.io.IOException;
import java.util.HashMap;

public class Lexer {
    private HashMap<String, Keyword> words = new HashMap<>();
    private char peek = ' ';
    public static int line = 1;

    private void reserve(Keyword kword) {
        words.put(kword.lexeme, kword);
    }

    private void reserveKeywords() {
        reserve(Keyword.AND);
        reserve(Keyword.OR);
        reserve(Keyword.BR_OP);
        reserve(Keyword.BR_CL);
        reserve(Keyword.PLUS);
        reserve(Keyword.MINUS);
        reserve(Keyword.MULTIPLY);
        reserve(Keyword.DIVIDE);
        reserve(Keyword.MODULO);
        reserve(Keyword.INCREMENT);
        reserve(Keyword.DECREMENT);

        reserve(Type.INT);
        reserve(Type.FLOAT);
    }

    public Lexer() {
        reserveKeywords();
    }

    //Scans every char, peek is essentially a pointer.
    private void read() throws IOException {
        peek = (char) System.in.read();
        System.out.println(peek);
    }

    //Scans the next peek and compare it with the next char.
    private boolean read(char c) throws IOException {
        read();
        System.out.println(peek);
        if (peek != c) {
            return false;
        }
        peek = ' ';
        return true;
    }

    public Token scan() throws IOException {
        for (; ; read()) {
            if (peek == ' ' || peek == '\t' || (peek == '/' && read('/'))) {
                continue;
            } else if (peek == '\n') {
                line += 1;
            } else {
                break;
            }
        }
        switch (peek) {
            case '&':
                if (read('&')) {
                    return Keyword.AND;
                } else {
                    return new Token('&');
                }
            case '|':
                if (read('|')) {
                    return Keyword.OR;
                } else {
                    return new Token('|');
                }
            case '+':
                if (read('+')) {
                    return Keyword.INCREMENT;
                } else {
                    return Keyword.PLUS;
                }
            case '-':
                if (read('-')) {
                    return Keyword.DECREMENT;
                } else {
                    return Keyword.MINUS;
                }
            case '*':
                return Keyword.MULTIPLY;
            case '/':
                return Keyword.DIVIDE;
            case '%':
                return Keyword.MODULO;
            case '(':
                return Keyword.BR_OP;
            case ')':
                return Keyword.BR_CL;
            case '=':
                return Keyword.EQ;
        }

        if (Character.isDigit(peek)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(v, 10);
            }
            while (Character.isDigit(peek));

            if (peek != '.') {
                return new Num(v);
            }

            float x = v, d = 10;
            for (; ; ) {
                read();
                if (!Character.isDigit(peek)) {
                    break;
                }
                x = x + Character.digit(peek, 10) / d;
                d = d * 10;
            }
            return new Real(x);
        }

        if (Character.isLetter(peek)) {
            StringBuilder sb = new StringBuilder();

            do {
                sb.append(peek);

            } while (Character.isLetterOrDigit((int) peek));
            String str = sb.toString();
            Keyword kw = words.get(str);
            if (kw != null) {
                return kw;
            } else return new Keyword(str, Tag.ID);
        }
        System.out.println("Out");

        Token t = new Token(peek);
        peek = ' ';
        return t;
    }
}
