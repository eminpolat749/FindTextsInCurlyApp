package csd;

import java.util.Scanner;

public class App {
	
	public static void main(String [] args)
	{
		FindTextsInCurlyApp.run();
		
	}

}

class FindTextsInCurlyApp {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		
		for (;;) {
			
			System.out.print("Bir yazı giriniz:");
			String s = kb.nextLine();
			
			if ("quit".equals(s))
				break;
			
			FindTextsInCurly findTextsInCurly = new FindTextsInCurly(s);
			findTextsInCurly.parse();
			
			
			System.out.println(findTextsInCurly.isValid ? findTextsInCurly.result : "Yanlış giriş");
		}
		System.out.println("Program sonu!...");
	}
}

class FindTextsInCurly {
	
	public String text;
	public String result;
	public boolean isValid;
	
	public FindTextsInCurly(String txt)
	{
		text = txt;
		result = text;
		isValid = true;
	}
	
	public void parse()
	{
		for (;;) {
			int open = result.indexOf('{');
			int close = result.lastIndexOf('}');
			
			if (open == -1 && close != -1 || open > close) {
				isValid = false;
				break;
			}
			
			if (close == -1)
				break;
			
			result = result.substring(open + 1, close);
		}
	}
	
}
