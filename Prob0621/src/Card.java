import java.util.Random;
public class Card {
	public int cardType,cardNumber;
	static int cardList[][]=new int[4][13];//使用済みのカードを登録する
	static int selectedList[][]=new int[4][13];//選択済みのカードを登録する
	Card(){
		Random rd = new Random();
		for(;;) {
		cardType=rd.nextInt(4)+1;
		cardNumber=rd.nextInt(13)+1;
		if(cardList[cardType-1][cardNumber-1]==0)
			break;}
		cardList[cardType-1][cardNumber-1]=1;}
	//選択できるカードを表示
		public static void cardDisp(Card card[]){
			int marks[]=new int[5];
			int numbers[]=new int[5];
			//カードのマークを登録
			for(int i=0;i<card.length;i++)
			marks[i]=card[i].cardType;
			//カードの番号を登録
			for(int i=0;i<card.length;i++)
			numbers[i]=card[i].cardNumber;
			System.out.print("   ");
			//マークを表示
			for(int i=0;i<(marks.length);i++) {
				//1:スペード 2:ハート 3:クローバー 4:ダイヤ
				if(marks[i]==1) {
					System.out.print("| ♠︎ | ");
				}else if(marks[i]==2) {
					System.out.print("| ❤ | ");
				}else if(marks[i]==3) {
					System.out.print("| ♣︎️︎️ | ");
				}else if(marks[i]==4){
					System.out.print("| ♦︎️️ | ");
				}else {
					System.out.print("      ");}}
			System.out.println();
			System.out.print("   ");
			for(int i=0;i<(numbers.length);i++) {
				if(numbers[i]==1) {
					System.out.print("| A | ");
				}else if(numbers[i]==11) {
					System.out.print("| J | ");
				}else if(numbers[i]==12) {
					System.out.print("| Q | ");
				}else if(numbers[i]==13) {
					System.out.print("| K | ");
				}else if(numbers[i]==10){
					System.out.print("| 10| ");
				}else if(numbers[i]==0){
					System.out.print("      ");
				}else{
					System.out.print("| "+numbers[i]+" | ");}}
			System.out.println();
			System.out.println();
			System.out.print("   ");
			for(int i=1;i<=5;i++) {
				System.out.print("  "+i+"   ");}
System.out.println();
System.out.println();}
		//残りのカードのリストを表示
		public static void listDisp() {
			int typeCount=0;
			for(int j=0;j<4;j++,typeCount++) {
				switch(typeCount) {
				case 0:System.out.print("♠︎ ︎");
				break;
				case 1:System.out.print("❤ ︎");
				break;
				case 2:System.out.print("♣ ︎");
				break;
				default:System.out.print("♦︎ ︎");
				break;}
			for(int i=0;i<13;i++) {
			if(selectedList[j][i]==1) {
				if(i==9){
				System.out.print("  ");//使い終わったやつは表示されない
				}else {
					System.out.print(" ");}}else {
				if(i+1==1) {
					System.out.print("A");
				}else if(i+1==11) {
					System.out.print("J");
				}else if(i+1==12) {
					System.out.print("Q");
				}else if(i+1==13) {
					System.out.print("K");
				}else{
					System.out.print(i+1);}}}
			switch(typeCount) {
			case 0:System.out.print(" ♠︎");
			break;
			case 1:System.out.print(" ❤");
			break;
			case 2:System.out.print(" ♣︎");
			break;
			default:System.out.print(" ♦︎︎");
			break;}
			System.out.println();}
			System.out.println();}
		//選択されたカードを表示
		public static void lastDisp(Card card) {
			System.out.print("               ");
			if(card==null){
				System.out.print("      ");
			}else if(card.cardType==1) {
				System.out.print("| ♠︎︎︎️ | ");
			}else if(card.cardType==2) {
				System.out.print("| ❤︎️ | ");
			}else if(card.cardType==3) {
				System.out.print("| ♣︎️ | ");
			}else {
				System.out.print("| ♦︎️️ | ");}
			System.out.println();
			System.out.print("               ");
			if(card==null){
				System.out.print("      ");
			}else if(card.cardNumber==1) {
				System.out.print("| A | ");
			}else if(card.cardNumber==11) {
				System.out.print("| J | ");
			}else if(card.cardNumber==12) {
				System.out.print("| Q | ");
			}else if(card.cardNumber==13) {
				System.out.print("| K | ");
			}else if(card.cardNumber==10){
				System.out.print("| 10|");
			}else if(card.cardNumber==0){
				System.out.print("      ");
			}else{
				System.out.print("| "+card.cardNumber+" | ");}
			System.out.println();
			System.out.println();}
		//カードが繋げられるかチェック
		public boolean cardCheck(Card lastCard) {
			if(lastCard==null) {
				return true;
			}else if(lastCard.cardType==this.cardType
				||lastCard.cardNumber==this.cardNumber){
				return true;
			}else {return false;}}
		//選択されたカードをリストに登録
		public static void selected(Card selected) {
			selectedList[selected.cardType-1][selected.cardNumber-1]=1;}}
