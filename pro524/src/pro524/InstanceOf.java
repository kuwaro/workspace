package pro524;

class A {
}

class B extends A {
}

public class InstanceOf {
	public static void main(String[] args) {
		System.out.println("a) " + ((new A()) instanceof A));
		System.out.println("b) " + ((new A()) instanceof B));
		System.out.println("c) " + ((new B()) instanceof A));
		System.out.println("d) " + ((new B()) instanceof B));
		System.out.println("e) " + ((new A()) instanceof Object));
		System.out.println("f) " + ((new B()) instanceof Object));
	}
}

