package testing;

import java.util.ArrayList;

public class StringCalculator {
	public static String add(String num) {
		double sum = 0;
		String delimiter = "";
		int i = 0;
		
		if(num == "") {
			return "0";
		}
		
		if(num.startsWith("\\")) {
			int j = 0;
			num = num.substring(1);
			for(char c:num.toCharArray()) {
				if(c != '\\') {
					delimiter += c;
				}
				else {
					num = num.substring(j);
					add(num, delimiter);
				}
				j++;	
			}
		}
		String [] separate = num.split("[\n,]");
		
		for(String s : separate) {
			if(s.equals("")) {
				return "Invalid number expected";
			}
			if(i == separate.length && s.matches(",") || i == separate.length && s.matches("\n")) {
				return "Number expected but EOF found.";
			}
			sum += Double.parseDouble(s);
			i++;
		}
		return Double.toString(sum);
	}
	
	public static String add(String num, String delimiter) {
		int i = 0;
		double sum = 0.0;
		
		String []separate = num.split(delimiter);
		
		for(String s : separate) {
			if(s.equals("")) {
				return "Invalid number expected";
			}
			if(i == separate.length && s.matches(",") || i == separate.length && s.matches("\n")) {
				return "Number expected but EOF found.";
			}

			sum += Double.parseDouble(s);
			i++;
		}
		return Double.toString(sum);
	}
}
