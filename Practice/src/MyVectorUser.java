
public class MyVectorUser {
	public static void main(String[] args) {
		MyVector v1 = new MyVector(20, 19);
		MyVector v2 = new MyVector(5, 10);
		System.out.println("There are " + MyVector.getNumVec() + " vectors.");
		System.out.print("v1: ");
		v1.print();
		System.out.print("v2: ");
		v2.print();
		System.out.println("v1 and v2 are same? " + v1.isEqual(v2));
		System.out.println("Double size of v1.");
		v1.constMult(2);
		System.out.println("v1 and v2 are same? " + v1.isEqual(v2));
		System.out.println("Length is " + v1.getLength());
	}

}
