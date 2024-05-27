package fisikes.calc;

import fisikes.antlr4.XMLLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

public class XmlTests {


    @Test
    void test() {

        var text = """
                <tools>
                    <tool name="ANTLR">A parser generator</tool>
                </tools>
                """;

        ANTLRInputStream input = new ANTLRInputStream(text); // create a lexer that feeds off of input CharStream
        XMLLexer lexer = new XMLLexer(input); // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer); // create a parser that feeds off the tokens buffer


        System.out.println(tokens);

    }
}
