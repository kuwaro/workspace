import java.util.ArrayList;
import java.util.Random;
public class Prob65 {
public static void main(String[] args) {
	if(args.length==0) {
		System.out.println("No numbers!");
		System.exit(0);
	}
	ArrayList<Integer> list=new ArrayList<Integer>();
	Random rn =new Random();
	int num=Integer.parseInt(args[0]);
	if(num==0) {
		System.out.println("Not valid!");
		System.exit(0);
	}
	for(int i=0;i<num;i++) {
		list.add(rn.nextInt(10));
	}

	for(int i=0;i<list.size();i++) {
		System.out.print(list.get(i));
		}
	System.out.println();
	for(int i=0,count=0;count<(num/2);count++) {
	if(list.get(i)<list.get(i+1)) {
		i+=2;
	}else {
		list.remove(i);
		list.remove(i);
	}
	}
	if(num%2==1) {
		list.remove(list.size()-1);
	}
	for(int i=0;i<list.size();i++) {
	System.out.print(list.get(i));
	}
	System.out.println();
	}
}
