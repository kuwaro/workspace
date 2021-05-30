
public class TriVertex extends Vertex{

	void draw(Turtle t) {
		t.penDown();
		t.rotate(60);
		for(int i=0;i<3;i++) {
		t.go(14);
		if(i<2) {
		t.rotate(-120);
		}else {
			t.rotate(-90);
		}
		}
	}
}
