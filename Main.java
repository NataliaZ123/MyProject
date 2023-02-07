import java.util.Scanner;

public class Main{
	
	public static void main(String[] args){
	    Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(calc(input));
	}
	
	public static String calc(String input) {
		try{
			String str = "", str1 = "", str2 = "", str3 = "";
			if(input.charAt(0) != '"' || input.charAt(input.length()-1) == ' '){
				throw new MyException();
			}
			int i = 1;
			while(input.charAt(i) != '"' && i < 11){
				str1 += String.valueOf(input.charAt(i));
				i++;
			}
			if(input.charAt(i) != '"'){
				throw new MyException();
			}
			i++;
			if(input.charAt(i) != ' '){
				throw new MyException();
			}
			i++;
			str2 = String.valueOf(input.charAt(i));
			i++;
			if(input.charAt(i) != ' '){
				throw new MyException();
			}
			i++;
			int j = i, a = 0;
			if(input.charAt(i) == '"'){
				if(input.charAt(input.length()-1) != '"'){
					throw new MyException();
				}
				if(!str2.equals("+") && !str2.equals("-")){
					throw new MyException();
				}
				str3 = input.substring(i+1, input.length()-1);
				if(str3.length() > 10){
					throw new MyException();
				}
			}
			else{
				try {a = Integer.parseInt(input.substring(i, input.length()));}
				catch(NumberFormatException e){
					return ("throws Exception");
				}
				if(!str2.equals("*") && !str2.equals("/")){
					throw new MyException();
				}
				if(a < 1 || a > 10){
					throw new MyException();
				}
				
			}
			switch (str2){
				case "+":
						str = str1 + str3;
						return str;
						
						
				case "-"://неверно тщтщ
					if(str3.length() > str1.length()){
						return str1;
					}
					for(int k = 0; k <= str1.length()-str3.length(); k++){
						if(str1.substring(k, str3.length()+k).equals(str3)){
							return (str1.substring(0, k) + str1.substring(str3.length()+k, str1.length()));
						}
					}// проверять подстрочки длиной с str3 в str1 на равенство str3 если равно str это сумма двух подстрок
					return str1;
					
					
				case "*":
					for(int k = 0; k < a; k++){
						str += str1;
					}
					if(str.length() > 40){
						str = str.substring(0, 40) + "...";
					}
					return str;
				case "/":
					if(a <= str1.length()){
						str = str1.substring(0, a);
						return str;
					}
					else{
						throw new MyException();
					}
				default:
					throw new MyException();
			}
			
		}
		catch(MyException e){
			return ("throws Exception");
		}
		
	}	
}