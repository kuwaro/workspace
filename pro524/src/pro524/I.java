package pro524;

public interface I {
	public void showMessage();

	default void show() {
		System.out.println("I is shown");
	}
}
