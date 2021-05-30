
public class ArithmeticProgression {
	int start, current, diff, num;

	public ArithmeticProgression(int s, int d, int n) {
		start = s;
		current = s;
		diff = d;
		num = n;
	}

	public void printNums(Printer p) {
		for (int i = 0; i < num; i++) {
			p.print(current);
			next();
		}
	}

	public void next() {
		current = current + diff;
	}

	public void reset() {
		current = start;
	}

	public static void main(String[] args) {
		ArithmeticProgression ap = new ArithmeticProgression(2, 4, 10);
		ap.printNums(new SimplePrinter());
		ap.reset();
		ap.printNums(new PrettyPrinter()) ;
	}
}
