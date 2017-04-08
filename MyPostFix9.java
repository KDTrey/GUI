package myPostFix;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Scanner;
/****************************************
 * Purpose: Evaluate an expression in Postfix or Infix notation
 * Author: Dominique Adkins
 * Course: 1302 B
 * Date: 10/24/16
 *
 *****************************************/
public class MyPostFix9 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Is your expression infix or postfix.? ");
		String answer = scan.nextLine();


		if(answer.equalsIgnoreCase("postfix")){
			System.out.println("Enter postfix expression: ");
			String str = scan.nextLine();

			if(!(str.length() > 0)){
			System.out.println("Error " + str + " is not a full expression!");
			}
			else
				str = insertBlanks(str);
				System.out.println(evaluateExpression(str));
		}
		else if(answer.equalsIgnoreCase("infix")){
			System.out.println("Please enter your infix expression: ");
			String str = scan.nextLine();
			if(!(str.length() > 0)){
				System.out.println("Error " + str + " is not a full expression!");
			}
			else
				str = insertBlanks(str);
				infix(str);
		}
		else
			System.out.println("Invalid input!");

	}

	//Evaluate expression
	public static double evaluateExpression(String expression){

		//To store expression
		ArrayList<String> ex = new ArrayList<>();

		//To store operators
		Stack<Double> expressionStack = new Stack<>();


		String[] tokens = expression.split(" ");

		//Store the split expression in the expression list
		for(int i = 0; i < tokens.length; i++){
			ex.add(tokens[i]);
		}

		String item = "";
		/*loops through the expression and pushes numbers into the stack
		 * does operations when running into operators
		*/
		for(int j = 0; j < ex.size(); j++){
			item = ex.get(j);
			if(item.matches("[0-9]+")){
				expressionStack.push(Double.parseDouble(item));
			}
			else if(item.equals("+") || item.equals("-")){
				if(!expressionStack.isEmpty() &&
					   (item.equals("+") ||
						item.equals("-") ||
						item.equals("%") ||
						item.equals("*") ||
						item.equals("^") ||
						item.equals("/"))){
				processAnOperator(expressionStack, item);
				}
			}

			else if(item.equals("*") || item.equals("/") || item.equals("%")){
				if(!expressionStack.isEmpty() &&
					   (item.equals("%") ||
						item.equals("*") ||
						item.equals("^") ||
						item.equals("/"))){
				processAnOperator(expressionStack, item);
				}
			}
			else if(item.equals("^")){
				if(!expressionStack.isEmpty() && item.equals("^")){
					processAnOperator(expressionStack, item);
				}
			}
		}


		return expressionStack.pop();
	}


	public static String insertBlanks(String s) {
	    String result = "";

	    for (int i = 0; i < s.length(); i++) {
	    	result += " " + s.charAt(i) + " ";
	    }

	    return result;
	}

	  public static void processAnOperator(Stack<Double> expressionStack, String operator) {

		    double op1 = expressionStack.pop();
		    double op2 = expressionStack.pop();
		    double bob = Math.pow(op1, op2);
		    switch(operator) {
			case "+":
				expressionStack.push(op2 + op1);
				break;
			case "/":
				expressionStack.push(op2 / op1);
				break;
			case "*":
				expressionStack.push(op2 * op1);
				break;
			case "-":
				expressionStack.push(op2 - op1);
				break;
			case "^":
				expressionStack.push(bob);

			}
	  }

	  //convert from infix equation to postfix
	  public static void infix(String line){
		  ArrayList<String> postfix = new ArrayList<>();

		  Stack<String> operatorStack = new Stack<>();

		  insertBlanks(line);
		  //store expressions without the white spaces
		  String[] tokens = line.split(" ");

		  String key = " ";
		  for(int i = 0; i < tokens.length; i++){
			  key = tokens[i];
			  //if a number then add to postfix expression
			  if(key.matches("[0-9]+"))
			  {
				  postfix.add(key);
			  }
			  //inserts lowest operator in the Stack
			  else if(key.equals("+") || key.equals("-"))
			  {
				  String item = operatorStack.peek();
				  if(!(operatorStack.isEmpty()) &&
					(item.equals("+") || item.equals("-") ||
					 item.equals("*") || item.equals("/") ||
					 item.equals("%") || item.equals("^")))
				  {
					  operatorStack.pop();
					  postfix.add(item);
					  operatorStack.push(key);
					 
				  }

				  else
				  {
					  operatorStack.push(key);
				  }
			  }
			  //checks precedence of other operators already in the Stack
			  else if(key.equals("*") || key.equals("/") || key.equals("%"))
			  {
				  String item = operatorStack.peek();
				  if(((!operatorStack.isEmpty()) &&
						  item.equals("*") || item.equals("/") ||
						  item.equals("%") || item.equals("^")))
					  //if operator is same precedence then switch them
				  {	  operatorStack.pop();
					  postfix.add(operatorStack.peek());
					  operatorStack.push(key);
					  //System.out.println("**********" + item);
				  }
				  else
				  {
					operatorStack.push(key);
				  }
			  }
			  //checks precedence of other operators already in the Stack
			  else if(key.equals("^")){
				  String item = operatorStack.peek();
				  if((!operatorStack.isEmpty()) &&
					(item.equals("+") || item.equals("-") ||
					 item.equals("*") || item.equals("/") ||
					 item.equals("%")))
				  {
					  postfix.add(operatorStack.peek());
				  }
				  else
					 operatorStack.push(key);

			  }
			  else if(key.equals("(")){
				  operatorStack.push(key);
			  }
			  //Processes everything until hitting '('
			  else if(key.equals(")"))
			  {

				  String item = operatorStack.peek();
				  while(!item.equals("(") && !operatorStack.isEmpty() )
				  {
					  postfix.add(item);
					  operatorStack.pop();
					  item = operatorStack.peek();
				  }
				  operatorStack.pop();

				 /* while(!operatorStack.isEmpty())
				  {
					  String item = operatorStack.peek();
					  if(!item.equals("("))
					  operatorStack.pop();
					  postfix.add(item);
				  }*/

			  }
		  }

		  for(int j = 0; j < postfix.size(); j++){
			  System.out.print(postfix.get(j) + " ");
		  }

	  }

}

//( 1 + 2 * 3 / ( 4 - 3 ))
