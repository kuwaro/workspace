class Prob82{
	public static void main(String[] args) {
		int[] num=new int[3];
		for(int i=0;i<args.length;i++) {
		num[i]=Integer.parseInt(args[i]);
		}
		int sum=0;
		for(int i=0;i<num[2];i++,num[0]+=num[1]) {
			System.out.print(num[0]+" ");
			sum+=num[0];
		}
		System.out.println();
		System.out.println(sum);
	}
}