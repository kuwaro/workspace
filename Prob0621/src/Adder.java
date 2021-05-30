import java.util.Scanner;

public class Adder {
	private void processInput(String inString) {
		String[] inputs = inString.split("\\s+");
		int result = 0;
		for (int i=0; i<inputs.length; i++) {
			if (inputs[i].compareTo("quit") == 0) {
				System.exit(0);
			}
			result += Integer.valueOf(inputs[i]);
		}
		System.out.println(result);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Adder app = new Adder();

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Please input numbers: ");
			String str = scan.nextLine();
			app.processInput(str);
		}
	}
}
