import java.awt.Color;

public class Prob24 {
	public static void main(String[] args) {
		Turtle t;
		t = new Turtle();
		t.move(100, 200);
		t.penDown();
		for(int i=0;i<3;i++) {
		t.setColor(Color.blue);
		t.go(60);
		t.rotate(40);
		t.setColor(Color.red);
		t.go(60);
		t.rotate(40);
		t.setColor(Color.yellow);
		t.go(60);
		t.rotate(40);
		}
}
	}
