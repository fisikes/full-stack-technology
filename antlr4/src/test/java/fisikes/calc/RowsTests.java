package fisikes.calc;

import fisikes.Col;
import org.junit.jupiter.api.Test;

public class RowsTests {

    @Test
    void test2() {
        System.out.println("\"avc\\\"\"");
    }

    @Test
    void test() {

        String rows = """
                parrt	Terence Parr	101
                tombu	Tom Burns	020
                bke	Kevin Edgar	008
                                
                """;


        Col.col(rows, 2);
    }
}
