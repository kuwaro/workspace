package a;
import java.util.Random;
public class Main {
public static void main(String[] args) {
	int one=0,two=0,three=0,four=0,five=0,six=0;
	Random random = new Random();
	for(int i=0;i<600;i++) {
		int n=random.nextInt(6)+1;
		switch(n) {
		case 1:
			one++;
			break;
		case 2:
			two++;
			break;
		case 3:
			three++;
			break;
		case 4:
			four++;
			break;
		case 5:
			five++;
			break;
		case 6:
			six++;
			break;

		}
	}
System.out.print(one+" "+two+" "+three+" "+four+" "+five+" "+six);
}
}
