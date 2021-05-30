
public class Prob25 {
public static void main(String[] args) {
	Turtle t;
	t = new Turtle();
	t.move(100, 200);
	t.penDown();
	for(int i=0;i<4;i++) {
		t.go(60);
		if(i==3) {
			break;
		}
		t.rotate(90);
		}
	t.rotate(30);
	for(int i=0;i<4;i++) {
	t.go(60);
	t.rotate(120);
	t.go(60);
	t.rotate(-30);
	}




}
}
