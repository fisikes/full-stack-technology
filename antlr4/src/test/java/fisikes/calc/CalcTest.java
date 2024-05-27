package fisikes.calc;

import org.junit.jupiter.api.Test;

class CalcTest {


    @Test
    void test() {

        var in = """
                193
                a = 5
                b = 6
                a + b * 2
                (1+2)*3
                """;
        Calc.calc(in);
    }

}