public class Buggy {
	public boolean isPrime(int x){
		int max=1;
		for (int i=2; i<x/2; i++) {
			if (x%i == 0)
				max = i;
		}
		if (x==2 || max==1)
			return true;
		else
			return false;
	}
}