import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigInteger;


import static org.example.Factorial.factorial;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {

    @Test
    public void negativeNullPointerExceptionTest(){
        Long n = null;
        assertThrows(NullPointerException.class, () -> factorial(n));
    }

    @Test
    public void negativeIllegalArgumentExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> factorial(-1));
    }

    @Test(dataProvider = "factorialTestData")
    public void testFactorial(long n, BigInteger expected) {
        assertEquals(factorial(n), expected);
    }

    @DataProvider(name = "factorialTestData")
    public Object[][] factorialTestData() {
        return new Object[][] {
                { 0, BigInteger.valueOf(1) },
                { 1, BigInteger.valueOf(1) },
                { 3, BigInteger.valueOf(6) }
        };
    }
}
