package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		String delimiters = ",|\n";

		if (text.startsWith("//")) {
			delimiters = text.substring(2, 3);
			text = text.substring(4);
			return sum(splitNumbers(text, delimiters));
		} else if(text.equals("")) {
			return 0;
		} else if(text.contains(",") || text.contains("\n")) {
			return sum(splitNumbers(text, delimiters)); 
		} else {
			return 1;
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimiters){
	    return numbers.split(delimiters);
	}

    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

}