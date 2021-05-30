import java.util.ArrayList;

public class Throw4 {

	static ArrayList<String> list;

	public static void main(String[] args) {
		list = new ArrayList<String>();
		try {
			System.out.println("Before a");
			list.add("apple");
			a();
			System.out.println("After a");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("main: " + e);
		}
		finally {
			System.out.println("main: finally");
		}
	}
	
	public static void a() {
		try {
			System.out.println("Before b");
			list.add("grape");
			b();
			System.out.println("After b");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("a: " + e);
		}
		finally {
			System.out.println("a: finally");
		}
	}

	public static void b() {
		try {
			System.out.println("Before c");
			list.add("banana");
			c();
			System.out.println("After c");
		}
		catch (NullPointerException e) {
			System.out.println("b: " + e);
		}
		finally {
			System.out.println("b: finally");
		}
	}
	
	public static void c() {
		try {
			System.out.println(list.get(3));
		}
		catch (IndexOutOfBoundsException e) {
			throw e;
		}
		finally {
			System.out.println("c: finally");
		}
	}

}
