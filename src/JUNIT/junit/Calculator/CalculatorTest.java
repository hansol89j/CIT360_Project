package JUNIT.junit.Calculator;

import org.junit.*;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by hansoljeong on 2015. 11. 21..
 */
public class CalculatorTest {

    private Calculator c;

    @Before //read files
    public void setUp() throws Exception{
        c = new Calculator();
    }

    //test fails if the test takes longer than 5000
    @Test(timeout=5000)
    public void testSum(){

        double result = c.sum(10, 50);
        double result2 = c.sum(30, 30);
        assertEquals(60, result, 0);
        assertNotEquals(result2, 40);
        assertTrue(String.valueOf(60), true);
        //Is it possible to use assertTrue or assertFalse with numbers?
    }

    @Test
    public void testSubtract(){
        double result = c.subtract(50, 10);
        assertEquals(40, result, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void testSubtract1(){
        c.subtract(3, 5);
    }

    @Test(expected = ArithmeticException.class)
    public void testSubtract2(){
        double result = c.subtract(3, -5);
        //assertFalse(4, result); cannot use assertFalse, assertTrue because these are only using for strings.
    }

    @Test(expected = ArithmeticException.class)
    public void testSubtract3(){
        c.subtract(-3, -5);
    }

    @Test
    public void testMultiply(){
        double result = c.multiply(25, 25);
        assertEquals(625, result, 0);
        assertNotEquals(525, result, 100);
    }

    @Test
    public void testDivision(){
        double result = c.division(100, 10);
        assertEquals(10, result, 0);
    }

    @Test (expected = ArithmeticException.class)
    public void testDivision1(){
        c.division(100, 0);
    }

    //field() returns a Field object that reflects the specified public member field of
    // the class or interface represented by this Class object.
    @Test
    public void testUniqueId() {
        try {
            Calculator calculatorTest = new Calculator();
            Field idField = Calculator.class.getDeclaredField("uniqueId");
            idField.setAccessible(true);
            String anId = (String) idField.get(calculatorTest);
            assertEquals("123456", anId);
            assertNotEquals("93456", anId);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    @After //cleanup data
    public void afterTest(){
        c = null;
    }
}
