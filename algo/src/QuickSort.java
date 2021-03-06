//クイックソート
import java.util.Scanner;
public class QuickSort {
	//配列の要素a[idx1]とa[idx2]を交換
	static void swap(int[] a,int idx1,int idx2) {
		int tmp=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=tmp;
	}
	//クイックソート関数
	static void quickSort(int[] a,int left,int right) {
		int pl=left;//左カーソル
		int pr=right;//右カーソル
		int pivot=a[(pl+pr)/2];//ピボット
		do {
			while(a[pl]<pivot) pl++;
			while(a[pr]>pivot) pr--;
			if(pl<=pr)
				swap(a,pl++,pr--);
		}while(pl<=pr);

		if(left<pr) quickSort(a, left, pr);
		if(pl<right) quickSort(a, pl, right);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner stdIn=new Scanner(System.in);
		System.out.println("クイックソート");
		System.out.print("要素数:");
		int nx=stdIn.nextInt();
		int[] x=new int[nx];

		for(int i=0;i<nx;i++) {
			System.out.print("x["+i+"]:");
			x[i]=stdIn.nextInt();
		}

		quickSort(x, 0, nx-1);

		System.out.println("昇順にソートしました。");
		for(int i=0;i<nx;i++)
			System.out.println("x["+i+"]="+x[i]);
	}
}
