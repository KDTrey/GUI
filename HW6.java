/**********************
* Purpose: Prompts user for a string and returns the string printed backwards
* using a Stack
*
**********************/
import java.util.Scanner;
public class printBackwards{

	public static void main(String[] args) {
		Stack<Character> inStack = new Stack<>();
		Stack<Character> outStack = new Stack<>();
		StringBuilder result = new StringBuilder();
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter a sentence: ");
		String str = scan.nextLine();
		scan.close();

		for(int i = str.length() - 1; i >= 0; i--){
			inStack.push(str.charAt(i));
		}
		while(!inStack.isEmpty()){
			if(inStack.peek() == ' '){
				while(!outStack.isEmpty()){
					result.append(outStack.pop());
				}
				result.append(inStack.pop());
			}
			else
				outStack.push(inStack.pop());
		}
		while(!outStack.isEmpty()){
			result.append(outStack.pop());
		}

		System.out.println(result);

	}



}
