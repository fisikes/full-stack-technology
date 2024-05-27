package fisikes.calc;

import fisikes.antlr4.LabeledExprLexer;
import fisikes.antlr4.LabeledExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calc {


    public static Integer calc(String in) {

        ANTLRInputStream input = new ANTLRInputStream(in);
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.prog(); // parse

        EvalVisitor eval = new EvalVisitor();
        final Integer result = eval.visit(tree);
        return result;
    }
}
