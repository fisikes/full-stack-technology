package fisikes;

import fisikes.antlr4.RowsLexer;
import fisikes.antlr4.RowsParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Col {

    /**
     *
     * @param in
     * @param col 要打印的列
     */
    public static void col(String in, int col) {
        ANTLRInputStream input = new ANTLRInputStream(in);
        RowsLexer lexer = new RowsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RowsParser parser = new RowsParser(tokens, col); // pass column number!
        parser.setBuildParseTree(false); // don't waste time bulding a tree
        parser.file(); // parse
    }
}
