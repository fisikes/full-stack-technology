package fisikes;

import fisikes.antlr4.ArrayInitLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {

    /**
     * 使用idea启动main方法, 输入{1,2,3}, 按command + d
     */
    public static void main(String[] args) throws IOException {
        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream(System.in); // create a lexer that feeds off of input CharStream
        fisikes.antlr4.ArrayInitLexer lexer = new ArrayInitLexer(input); // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer); // create a parser that feeds off the tokens buffer
        fisikes.antlr4.ArrayInitParser parser = new fisikes.antlr4.ArrayInitParser(tokens);
        ParseTree tree = parser.init(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree

        // Create a generic parse tree walker that can trigger callbacks
        ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        walker.walk(new ShortToUnicodeString(), tree);
        System.out.println(); // print a \n after translation
    }
}