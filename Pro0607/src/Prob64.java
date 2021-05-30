
public class Prob64 {
	public static void main(String[] args) {

		if(args.length==0) {
			System.out.println("No numbers!");
			System.exit(0);
		}
		for(int k=0;k<args.length;k++) {
			int buf[]=new int[100];
		int s1 = 0,s2=0, ans=0,pre[]=new int[2];
		int count=0;
		if(args[k].length()>10) {
			pre[0]=Integer.parseInt(args[k].substring(0,10));
			pre[1]=Integer.parseInt(args[k].substring(10,args[k].length()));
			System.out.print(pre[0]+""+pre[1]);
			for(int a=0;a<2;a++) {
			for(int i=0;pre[a]>0;i++,count++) {
				buf[i]=(pre[a]%10);
				pre[a]/=10;
			}
			for(int i=0;i<count;i+=2) {
			s1+=buf[i];
			}
			for(int i=1;i<count;i+=2) {
				if(buf[i]*2>=10) {
					s2+=(buf[i]*2)%10;
					s2+=((buf[i]*2)/10)%10;
				}else {
				s2+=buf[i]*2;
				}
			}
			count=0;
			}
		}else {
		ans=Integer.valueOf(args[k]);
		System.out.print(ans);
		for(int i=0;ans>0;i++,count++) {
			buf[i]=(ans%10);
			ans/=10;
		}
		for(int i=0;i<count;i+=2) {
		s1+=buf[i];
		}
		for(int i=1;i<count;i+=2) {
			if(buf[i]*2>=10) {
				s2+=(buf[i]*2)%10;
				s2+=((buf[i]*2)/10)%10;
			}else {
			s2+=buf[i]*2;
			}
		}}
		System.out.print(" "+(s1+s2));
		if((s1+s2)%10==0) {
			System.out.println(" Good");
		}else {
			System.out.println(" Bad");
		}
	}
}
}
