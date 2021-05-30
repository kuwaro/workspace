package a;
import java.util.Random;
import java.util.Scanner;
public class sugoroku {
	@SuppressWarnings("resource")
	public static void saikoro() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
	int position=0;
	int sai=0;
	int saitotal=0,kaisu=1;
	int n=0;
	System.out.println("▲すごろく▼\n" +
			"30マス先にゴールがあります。\n" +
			"1,2,3の３つの目を持つ特別なサイコロ10個を、好きな数だけ振って駒を進めます。\n" +
			"ぴったり上がりに止まれば終わりです。目の数が多ければ、余った目の数だけ戻ります。\n" +
			"----------------------------------------------");
	while(true) {
		while(true) {
		for(int i=0;i<30;i++) {
			if(i==position) {
				System.out.print("▲");
			}else {
				System.out.print("_ ");
			}
		}
		System.out.println("|上がり！");
		System.out.print("残り"+(30-position)+"マスです。サイコロの数は？:");
		sai = scanner.nextInt();
		for(int i=0;i<sai;i++) {
			n=random.nextInt(6)+1;
			saitotal+=n;
		}
		System.out.println("出た目の合計:"+saitotal);
		if(saitotal==(30-position)) {
			break;
		}else if(saitotal>(30-position)) {
			position=30-saitotal+(30-position);
		}else {
			position+=saitotal;
		}
		kaisu++;
		saitotal=0;
		}
		System.out.println("おめでとう！！ "+kaisu+"回目で上がりです");
		System.out.print("もう一度やりますか？(1=Yes; 0=No):");
		n=scanner.nextInt();
		if(n==0)
			break;
	else
		kaisu=1;
		position=0;
		continue;
	}
	}
	}
