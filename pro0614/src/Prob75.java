
public class Prob75 {
public static void main(String[] args) {
	try{int syo=Integer.valueOf(args[0])/Integer.valueOf(args[1]);
	System.out.println(syo);
	}catch (ArithmeticException e) {
		System.out.println("Denominator must not be zero!");
	}catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("Please enter two numbers!");
	}catch (NumberFormatException e) {
		System.out.println("Please Input number!");
	}
}
}
