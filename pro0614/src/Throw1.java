public class Throw1 {

	public static void methodA(String fruit) throws Exception {
		if (fruit.equals("apple"))
			throw new Exception("APPLE!");
		System.out.println("Fruit = " + fruit);
	}

	public static void main(String[] args) throws Exception {
		methodA("orange");
		System.out.println("Let's eat!");
		methodA("apple");
		System.out.println("The end");
	}
}
