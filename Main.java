import java.util.Scanner;

public class Main{
	public static void main(String[] args){
	    Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(calc(input));
	}
	public static String calc(String input){
		int a, b, c;
		if(input.length() != 5){
			return("throws Exception");
		} 
		if((input.charAt(1)!= ' ') ||(input.charAt(3)!= ' ')){
			return("throws Exception");
		} 
		try{
            a = Integer.parseInt(String.valueOf(input.charAt(0)));
			b = Integer.parseInt(String.valueOf(input.charAt(4)));
			System.out.println(input);
				return("throws Exception");
			}
			switch (input.charAt(2)){
				case '+':
			    	c = a + b;
			    	return String.valueOf(c);
				case '-':
				    c = a - b;
					return String.valueOf(c);
				case '*':
					c = a * b;
					return String.valueOf(c);
				case '/':
					c = a/b;
					return String.valueOf(c);
				default:
					return("throws Exception");
			}
		}
		catch(NumberFormatException e){
			return("throws Exception");
		}
	}
}