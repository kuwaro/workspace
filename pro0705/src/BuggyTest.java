import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuggyTest {
	private Buggy bu=new Buggy();
	@Test
	void test() {
		int a=1;
		assertEquals(bu.isPrime(a),false);
	}
	void test2() {
		int a=2;
		assertEquals(bu.isPrime(a), true);
	}

}
