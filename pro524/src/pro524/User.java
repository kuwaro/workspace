package pro524;

public class User {
	public static void testClass(W w) {
		w.showMessage();
	}

	public static void testInterface(I i) {
		i.showMessage();
		i.show();
	}

	public static void main(String[] args) {
		W w = new W();
		X x = new X();
		Y y = new Y();
		Z z = new Z();

		testClass(w);
		testClass(y);
		testClass(z);
		testInterface(x);
		testInterface(z);
	}
}
