import java.util.Scanner;

public class Prob81 {
	static int result = 0;
	private void processInput(String inString) {
		String[] inputs = inString.split("\\s+");

		try{
		for (int i=0; i<inputs.length; i++) {
			if (inputs[i].compareTo("quit") == 0) {
				System.exit(0);
			}
			if(inputs[i].compareTo("finish")==0) {
			System.out.println(result);
			result=0;
			}else {
			result += Integer.valueOf(inputs[i]);
			}

		}
		}catch(NumberFormatException e){
			System.out.println("This is not number!");
		}

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Prob81 app = new Prob81();

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Please input numbers: ");
			String str = scan.nextLine();
			app.processInput(str);
		}
	}
}
