import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;


import static org.example.Factorial.factorial;

public class FactorialTest {

    @Test
    public void negativeNullPointerExceptionTest(){
        Long n = null;
        Assertions.assertThrows(NullPointerException.class, () -> factorial(n));
    }

    @Test
    public void negativeIllegalArgumentExceptionTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> factorial(-1));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "3, 6",
            "300, 306057512216440636035370461297268629388588804173576999416776741259476533176716867465515291422" +
                    "477573349939147888701726368864263907759003154226842927906974559841225476930271954604008012" +
                    "215776252176854255965356903506788725264321896264299365204576448830388909753943489625436053" +
                    "225980776521270822437639449120128678675368305712293681943649956460498166450227716500185176" +
                    "546469340112226034729724066333258583506870150169794168850353752137554910289126407157154830" +
                    "2822849379526365801452352331569364822334367992545940952768206080622328123873838808170496000" +
                    "00000000000000000000000000000000000000000000000000000000000000000000000"
    })
    public void testFactorial(long n, BigInteger expected) {
        Assertions.assertEquals(expected, factorial(n));
    }
}
