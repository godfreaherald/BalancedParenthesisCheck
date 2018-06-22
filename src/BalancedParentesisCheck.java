import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class BalancedParentesisCheck {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter String : ");
	        String rows = scanner.nextLine();
	       
	       if(isValid(rows))
	    	   System.out.println("The string is balanced");  
	       else{
	    	   System.out.println("The string is unbalanced");   
	       }
	       		scanner.close();
	    }
	
	
	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		
	/* pass the expected string characters as key value in a hashmap */
		map.put('(', ')');  
		map.put('[', ']');
		map.put('{', '}');
		
		/* create a stack for storing and comparing the string characters 
		 * during string traversal
		 * */
		Stack<Character> stack = new Stack<Character>();
		
		/*traverse the string given*/
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);    /* get the current character */
	 
			if (map.keySet().contains(curr)) {  /*check if the current character is opening parenthesis and push it to the stack*/
				stack.push(curr);
				
				/*check if the current character is closing parenthesis*/
			} else if (map.values().contains(curr)) { 
				
				/*check if the stack is empty and the top object 
				 * in the stack is equal to the current element of the 
				 * string passed and the is contained it the map
				 * and  remove the element from the stack 
				 * */
				if (!stack.empty() && map.get(stack.peek()) == curr) { 
					stack.pop();   
				} else {
					return false;
				}
			}
		}
	 
		return stack.empty();    
	}
}
