package a;
import java.util.Random;
import java.util.Scanner;
public class highcard {

	public static void game() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	int myMoney=100;
	int bet=0,cardNum=0,count=1;
	int before,after,bai=1,ans;
	System.out.println("最初に１枚カードが出ますから掛け金を決めてください。\n" +
			"次に出るカードが前のカードと同じか大きければ、あなたの勝ちです。\n" +
			"掛け金が戻りますから、続けるかどうかを決めてください。続けて勝てば掛け金は２倍になります。以降、４倍、８倍と戻るお金が増えます。ただし、負けるとそれまでの勝ちは なくなります。\n" +
			"試行回数が30回に到達して回数オーバーになるか、所持金が無くなって破産するか、1000$を超えるとゲーム終了です。\n" +
			"----------------------------------------------");
	System.out.println("ゲームを開始します。所持金は"+myMoney+"$です。");
	while(true) {
		if(count==31) {
			System.out.println((count-1)+"回に到達しました。時間切れです。かわいそうに。");
			break;
		}
		System.out.println(count+"回目,最初のカードです。");
		cardNum=random.nextInt(13)+1;
		before=cardNum;
		if(before==1) {
		System.out.println("|A|");
		}else if(before==11) {
			System.out.println("|J|");
		}else if(before==12) {
			System.out.println("|Q|");
		}else if(before==13) {
			System.out.println("|K|");
		}else {
			System.out.println("|"+before+"|");
		}
		while(true) {
		System.out.print("いくら賭けますか？"+"(1$~"+myMoney+"$):");
		bet=scanner.nextInt();
		if(bet<=0) {
			System.out.println("最低1$は賭けてください。");
		}else if(bet>myMoney) {
			System.out.println("掛け金が所持金を超えています。");
		}else {
			break;
		}
		}
		count++;
		myMoney-=bet;
		while(true) {
		cardNum=random.nextInt(13)+1;
		after=cardNum;
		if(after==1) {
			System.out.println("|A|");
			}else if(after==11) {
				System.out.println("|J|");
			}else if(after==12) {
				System.out.println("|Q|");
			}else if(after==13) {
				System.out.println("|K|");
			}else {
				System.out.println("|"+after+"|");
			}
		if(before>after) {
			System.out.println("あなたの負け。所持金は "+myMoney+"$です。");
			bai=1;
			break;
		}else {
			System.out.println("あなたの勝ち。"+bet+"$の勝ちです。");
			bai*=2;
			System.out.print("倍率は"+bai+"倍。続けますか？(1=Yes;0=No):");
			ans=scanner.nextInt();
			if(ans==1) {
				before=after;
				bet*=2;
				continue;
			}else {
				bai=1;
				myMoney+=bet;
				System.out.println("所持金は "+myMoney+"$です。");
				break;
			}
		}
		}
		if(myMoney==0) {
			System.out.println("破産しました。かわいそうに。");
			break;
		}else if(myMoney>1000) {
			System.out.println("所持金が1000$を超えました。ゲーム終了です。おめでとう！！");
			break;
		}else {
			System.out.println();
			continue;
		}

	}


	}

}
