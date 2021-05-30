import java.util.Scanner;
public class Main {

@SuppressWarnings("resource")
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	System.out.print("Input Number:");
	int tmp=0;
	int num=sc.nextInt();
	int a[]=new int[num];
	for(int i=0;i<num;i++) {
		a[i]=i+1;
	}
	for(int z=0;z<num;z++) {
		System.out.print(a[z]+" ");
	}
	System.out.println();

	for(int i=0;i<num;i++) {
		for(int j=0;j<num-1;j++) {
			if(a[j]<a[j+1]) {
				tmp=a[j];
				a[j]=a[j+1];
				a[j+1]=tmp;
for(int z=0;z<num;z++) {
					System.out.print(a[z]+" ");
				}
				System.out.println();

			}

		}
	}




}
}
