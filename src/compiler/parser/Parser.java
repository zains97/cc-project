package compiler.parser;

import compiler.lexer.Lexer;
import compiler.lexer.Tag;
import compiler.lexer.Token;

import java.io.IOException;

public class Parser {
    private final Lexer lexer;
    private Token look;

    public Parser(Lexer lexer) throws IOException {
        this.lexer = lexer;
        move();
    }

    private void move() throws IOException {
        look = lexer.scan();
    }

    //Matches the cureent token tag with tag number we need
    private void match(int t) throws IOException {
        if (look.tag == t) {
            move();
        } else {
            error("Syntax Error");
        }
    }

    private void error(String s) {
        throw new Error("near line " + lexer.line + " : " + s);
    }

    public void start() throws IOException {
        program();
    }

    private void program() throws IOException { // PROG → EXPR
        expr();
    }
//    private Env top = null; // top symbol table

    private void expr(){

    }

    private void decl() throws IOException {
        while (look.tag == Tag.TYPE){
            type();
            match(Tag.ID);
            match(';');
        }
    }

    private void type() throws IOException {
        match(Tag.TYPE);
    }

    private void stmts() throws IOException {
        if (look.tag == '}'){

        }
        else {
            stmt();
            stmts();
        }
    }

    private void stmt() throws IOException {
        switch (look.tag){
            case ';':
                move();
                return;

        }
    }
}
