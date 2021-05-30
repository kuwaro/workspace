
public class TestVar {
	static int cnt1 = 1;
	int cnt2 = 1;
	static void incr1() {
		cnt1++;
	}
	void incr2() {
		cnt2++;
	}
	void show() {
		System.out.println("cnt1 = " + cnt1 + ", cnt2 = " + cnt2);
	}
	public static void main(String[] args) {
		TestVar v1 = new TestVar();
		TestVar v2 = new TestVar();
		System.out.println("(a)");
		v1.show();
		v2.show();
		incr1();
		System.out.println("(b)");
		v1.show();
		v2.show();
		v1.incr2();
		System.out.println("(c)");
		v1.show();
		v2.show();
	}
}
