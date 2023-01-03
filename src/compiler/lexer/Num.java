package compiler.lexer;

public class Num extends Token {
    public final int value;

    Num(int value){
        //Tag will be tag for number for each Num
        super(Tag.NUM);
        this.value = value;
    }
}
