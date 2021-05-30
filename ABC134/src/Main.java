import java.util.Scanner;
public class Main {
@SuppressWarnings("resource")
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int N=sc.nextInt();
	int buf[]=new int[N];
	int sum=0;
	for(int i=0;i<N;i++) {
		buf[i]=sc.nextInt();
		}

	for(int j=0;j<N;j++) {
		for(int i=j;i<N;i+=j+1) {
			if(buf[i]==1) {
				sum++;
				}
	}
	if(sum%2==buf[j]) {
		System.out.println(sum);
		if(sum==0) {
			System.exit(0);
			}
		for(int i=j;i<N;i+=j+1) {
			if(buf[i]==1) {
				System.out.print(i+1+" ");

			}}System.exit(0);
	}
	sum=0;
	}
	System.out.println(-1);

}
}
