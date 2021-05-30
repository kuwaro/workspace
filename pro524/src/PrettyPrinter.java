
public class PrettyPrinter implements Printer{

protected String line = "";
	protected int counter = 0;
	public void print(int i) {
		if (++counter < 5) {
			line = line + i + ", ";
		} else {
			line = line + i;
			System.out.println(line);
			line = "";
			counter = 0;
		}
	}
}
