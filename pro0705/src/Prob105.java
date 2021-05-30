public class Prob105{
	public static void main(String[] args) {
		try {
		String ans="";
		String[] check=args[0].split("");
		if(check[0].equals("0")&&check.length!=1) {
			throw new Exception();
		}
		long num=Long.parseLong(args[0]);
		String[] num1= {"","one","two","three","four","five","six",
				"seven","eight","nine","ten","eleven","twelve","thirteen",
				"fourteen","fifteen","sixteen","seventeen","eighteen",
				"nineteen"};
		String[] num2= {"","","twenty","thirty","forty","fifty","sixty",
				"seventy","eighty","ninety"};
		String[] tanni= {"thousand","million","billion","trillion"};
		for(int count=0;;count++) {
			if(num==0) {
				ans="zero";
				break;
			}
		long kari=num%100;
		if(kari>=0&&kari<20) {
			ans=num1[(int) kari]+ans;
		}else {
			ans=num1[(int) (kari%10)]+ans;
			if(kari%10!=0) {
				ans="-"+ans;
			}
			ans=num2[(int) ((kari/10)%10)]+ans;
		}
		num/=100;
		if(num==0) {
			break;
		}else {
			if(num%10!=0) {
				ans=" "+ans;
				ans=num1[(int) (num%10)]+" "+"hundred"+ans;
			}
		}
		num/=10;
		if(num==0) {
			break;
		}else {
			ans=" "+tanni[count]+" "+ans;
		}
		}
		String ans2=ans.substring(0,1).toUpperCase()+ans.substring(1);
System.out.println(ans2);
}catch(Exception e){
	System.out.println("ERROR!");
}
		};
	}
