import java.io.IOException;
import java.util.Scanner;
public class Main{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int q=sc.nextInt();
		char moji[]=new char[n+1];//ENTERを含めて考える！！
		int count[]=new int[q];
		int ask[][]=new int [q][2];
		for(int i=0;i<n;i++) {
			moji[i]=(char)System.in.read();
			if(moji[i]=='\n')
				break;
		}
		for(int i=0;i<q;i++) {
			ask[i][0]=sc.nextInt();
			ask[i][1]=sc.nextInt();
		}

		int z=0;
		for(int j=0;j<q;j++,z++)
		for(int i=ask[z][0]-1;i<ask[z][1]-1;i++) {
			if(moji[i]=='A') {
				if(moji[i+1]=='C') {
				count[j]++;
				}
			}
		}
		System.out.println();
		for(int i=0;i<q;i++) {
			System.out.println(count[i]);
		}

	}
	}
