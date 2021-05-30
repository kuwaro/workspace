
public class Constructor extends Parent{
	public Constructor() {
		super();
	}
	public Constructor(int x) {
	}
	public Constructor(int x, int y) {
		super();
	}
	public Constructor(int x, int y, int z) {
		super(x);
	}
	public static void main(String[] args) {
		Constructor c1 = new Constructor();
		Constructor c2 = new Constructor(1);
		Constructor c3 = new Constructor(1, 2);
		Constructor c4 = new Constructor(1, 2, 3);
	}
}
