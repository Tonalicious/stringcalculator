package is.ru.stringcalculator;

import java.util.ArrayList;

public class Calculator {

	public static int add(String text) {
		if (text.startsWith("//")) return sum(splitDelimiter(text));
		else if(text.equals("")) return 0;
		else if(text.contains(",") || text.contains("\n")) return sum(splitNumbers(text));
		else return toInt(text);
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers) {
	    return numbers.split(",|\n");
	}

	private static String[] splitDelimiter(String numbers){
		String tmp = "";
		int newLine = numbers.indexOf('\n');
		String regex = "[\\D]+";
		String replace = ",";

		numbers = numbers.substring(newLine + 1, numbers.length());
		tmp = numbers.replaceAll(regex, replace);
		return tmp.split(",");
	}

    private static int sum(String[] numbers) {
 	    ArrayList<Integer> al = new ArrayList<Integer>();
 	    int total = 0;

        for(String number : numbers) {
        	int nbrToInt = toInt(number);
        	
        	if (nbrToInt < 0) al.add(nbrToInt);
        	else if (nbrToInt <= 1000) total += nbrToInt;
        	else continue;
		}
		
		if (al.size() != 0) throw new IllegalArgumentException("Negatives not allowed: " + al.toString());
		return total;
    }
}