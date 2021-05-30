import java.util.Scanner;

public class Prob84 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer=0;
		boolean judge=false;
		int score=0;//何枚抜いたか
		Card lastCard = null; //最後に選択されたカード
		Card[] fieldCard=new Card[5];
		for(int i=0;i<5;i++) {
			fieldCard[i]=new Card();}
		//ゲーム開始！
		for(;;score++,judge=false) {
			if(score==52) {
				System.out.println("GAME CLEAR!");
				System.out.println("Congratulation!!");
				System.out.println("Rusult:Your score is "+score+".");
				System.exit(0);}
		Card.listDisp();
		System.out.println("                         score:"+score);
		Card.lastDisp(lastCard);
		Card.cardDisp(fieldCard);
		for(int i=0;i<fieldCard.length;i++) {
			judge=judge||fieldCard[i].cardCheck(lastCard);}
		//選択できるカードがなければ終わらす
		if(!judge) {
			System.out.println("GAME OVER");
			System.out.println("Result:Your score is "+score+".");
			System.exit(0);}
		System.out.print("selectable cardNumber:");
		for(int i=0;i<fieldCard.length;i++) {
			if(fieldCard[i].cardCheck(lastCard)) {
			System.out.print((i+1)+" ");}}
		System.out.println();
		while(true) {
		//カードを選ばせる
		System.out.print("Select CardNumber:");
		answer=sc.nextInt();
		if(answer<1||answer>5) {
			System.out.println("CardNumber is from 1 to 5.");
			System.out.println();
		}else if(answer>=1&&answer<=5) {
			if(fieldCard[answer-1].cardCheck(lastCard)) {
			lastCard=fieldCard[answer-1];
			if(score>=47) {
					fieldCard[answer-1].cardType=0;
					fieldCard[answer-1].cardNumber=0;
					break;}else {
			fieldCard[answer-1] =new Card();
			break;}}else {
				System.out.println("The cardNumber is not selectable.");
				System.out.println();}}}
		//選択されたカードを墓地に送る
		Card.selected(lastCard);
		System.out.println();
		System.out.println();}}}