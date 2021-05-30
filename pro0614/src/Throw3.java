public class Throw3 {
  
	public static void methodA(String fruit) throws Exception {
		try {
			if (fruit.equals("apple"))
				throw new Exception("APPLE!");
		}
		finally {
			System.out.println("The finally fruit is " + fruit);
		}			
		System.out.println("Fruit = " + fruit);
	}
  
	public static void main(String[] args) {
		try {
			methodA("orange");
			System.out.println("Let's eat!");
			methodA("apple");
			System.out.println("The end");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("The actual end");
	}
}
