import java.util.InputMismatchException;
import java.util.Scanner;

public class Judge {
public static void main(String[] args) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	int n;
	n =-1;
	while(true) {
	System.out.print("もう一度やりますか？(1=Yes; 0=No):");

	try {
		n = scanner.nextInt();
	} catch (InputMismatchException ex) {
	n = -1;
	// ex.printStackTrace( );
	}
	System.out.println();
	if(n==0) {
	break;
	}else if(n==1) {
	continue;
	}else {
	System.out.println("不正な入力です。");
	System.out.println("対応する文字を入力してください。");
	continue;
	}
	}
	System.out.println("終了です。");
}
}
