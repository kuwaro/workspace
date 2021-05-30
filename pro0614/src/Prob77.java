
public class Prob77 {
	public static void main(String[] args) {
		int count=1;
		int[] first=new int[1024];
		int[] second=new int[1024];
		int[] check=new int[1024];
		try{first[0]=Integer.valueOf(args[0]);
		second[0]=Integer.valueOf(args[1]);

		if(first[0]%2==0) {
			check[0]=1;
		}
		for(int i=0;;i++,count++){
			if(first[i]<=1&&first[i]>=-1) {
				if(first[0]==0) {
					check[0]=1;
				}
				break;
			}
			first[i+1]=first[i]/2;
			if(first[i+1]%2==0) {
				check[i+1]=1;
			}
		}

		for(int i=0;i<count;i++) {
			second[i+1]=second[i]*2;
			if(check[i]==1) {
				second[i]=0;
			}
		}
		int sum=0;
		for(int i=0;i<count;i++) {
			sum+=second[i];
		}
		if(Integer.valueOf(args[0])<0) {
			sum*=(-1);
		}
		System.out.println(args[0]+"*"+args[1]+"="+sum);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please enter two numbers!");
		}catch (NumberFormatException e) {
			System.out.println("Please Input number!");
		}
	}
}
