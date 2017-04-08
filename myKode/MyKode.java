package myKode;
/****************************************
 * Purpose: check whether a Java source-code file
 * has correct pairs of grouping symbols
 * Also display the frequency of each keyword used in the program
 * Author: Tony Adkins
 * Course: 1302 B
 * Date: 11/2/16
 *
 *****************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;



public class MyKode {
	public static void main(String [] args) throws Exception{
		String filename = args[0];

		File file = new File(filename);
		if(file.exists())
		{
			System.out.println(checkSymbol(file));
			kountOccurence(file);
		}
	}




	public static boolean checkSymbol(File file) throws Exception{


		Scanner scan = new Scanner(file);

		Stack<Character> symbol = new Stack<>();



		while(scan.hasNext())
		{
			String tokens = scan.next();


			for(int i = 0; i < tokens.length(); i++)
			{

				if(tokens.charAt(i) == '(' || tokens.charAt(i) == '{' ||
						tokens.charAt(i) == '[' )
				{
					symbol.push(tokens.charAt(i));

				}


				else if(tokens.charAt(i) == ')')
				{
					if(symbol.isEmpty() || !(symbol.peek() == '('))
					{

						return false;
					}
					symbol.pop();
					continue;
				}
				else if(tokens.charAt(i) == '}')
				{
					if(symbol.isEmpty() || !(symbol.peek() == '{'))
					{
						return false;
					}
					symbol.pop();
					continue;
				}
				else if(tokens.charAt(i) == ']')
				{
					if(symbol.isEmpty() || !(symbol.peek() == '['))
					{
						return false;
					}
					symbol.pop();
					continue;
				}

			}
		}
		if(!symbol.isEmpty()){
			return false;
		}

		return true;
	}


	public static void kountOccurence(File file){

		Scanner scan;
		try
		{
			scan = new Scanner(file);
			String[] keywordString = {"abstract", "assert", "boolean",
			        "break", "byte", "case", "catch", "char", "class", "const",
			        "continue", "default", "do", "double", "else", "enum",
			        "extends", "for", "final", "finally", "float", "goto",
			        "if", "implements", "import", "instanceof", "int",
			        "interface", "long", "native", "new", "package", "private",
			        "protected", "public", "return", "short", "static",
			        "strictfp", "super", "switch", "synchronized", "this",
			        "throw", "throws", "transient", "try", "void", "volatile",
			        "while", "true", "false", "null"};

			// Create a HashMap
			Map<String, Integer> map = new TreeMap<>();
		    String key;
		    while(scan.hasNext())
		    {
		    	key = scan.next();
		    	if(!map.containsKey(key))
				{
					map.put(key, 1);
				}
				else
				{
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
		    }
		    for(String s : keywordString)
		    {
		    	if(map.containsKey(s)) {
		    		System.out.println(s + " " + map.get(s));
		    	}
		    }
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
