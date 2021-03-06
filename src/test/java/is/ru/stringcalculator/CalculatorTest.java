package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(2, Calculator.add("2"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

   	@Test
    public void testNewLinesTwoNumbers(){
    	assertEquals(3, Calculator.add("1\n2"));
    }

    @Test
    public void testNewLinesMultipleNumbers(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testDiffrentDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumbersThrowException(){
    	try {
    		Calculator.add("-1,2");
    	}
    	catch (IllegalArgumentException e) {
    		String message = e.getMessage();
    		assertEquals("Negatives not allowed: [-1]", message);
    	}
    }

    @Test
    public void testNumbersBiggerThan1000Ignored(){
    	assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testDelimiterOfAnyLength(){
        assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testMultipleDelimiter(){
        assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testMultipleDelimiterOfAnyLength(){
        assertEquals(6, Calculator.add("//[*****%*$$%%%][%$$****%%%]\n1**$%&&&2%$$%****3"));
    }

}