public class Prob74 {
  public static void main(String[] args) {
    int a[] = new int[]{0, 1, 2};
    try{for(int i = 0; i < 4; i++){
      System.out.println("a[" + i +"]=" + a[i]);
    }
    }catch (Exception e) {
    	System.out.println("Index is out of bounds!");
	}
  }
}
