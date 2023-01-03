import compiler.lexer.Lexer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Compiler {
    public static void main(String[] args) throws IOException {
        File file = new File("src/code.txt");
        System.setIn(new FileInputStream(file));
//        Lexer lexer = new Lexer();
//        lexer.scan();
    }
}
