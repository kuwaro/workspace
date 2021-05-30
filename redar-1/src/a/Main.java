package a;
import java.util.Random;
import java.util.Scanner;
public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int position=0,range=0,target=0,count=1,n;
		Random random =new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.println("☆レーダー☆\n" +
				"ターゲットとして 0～100 のうち１つの数が設定されます。探索する位置と範囲を入力してターゲットを見つけてください。\n" +
				"ターゲットと探索位置の差が探索範囲以下であればヒットです。探索範囲より大きければ、はずれです。\n" +
				"探索位置とターゲットが一致すれば正解です。\n" +
				"----------------------------------------------\n" +
				"ゲームを開始します。");
		while(true) {
		target=random.nextInt(101);
		System.out.println("ターゲットが設定されました。");
		while(true) {
		System.out.print("位置は？:");
		position=scanner.nextInt();
		System.out.print("範囲は？:");
		range=scanner.nextInt();
		if(target==position) {
			System.out.println("おめでとう！"+" "+count+"回目で正解です！");
			break;
		}else if((target>=position-range)&&(target<=position+range)){
			System.out.println("ヒットしました。");
		}else {
			System.out.println("はずれました。");
		}
		System.out.println();
		count++;
	}
		while(true) {
		System.out.print("もう一度やりますか？(1=Yes; 0=No):");
		n =scanner.nextInt();
		if(n==1||n==0) {
			break;
		}else{
			System.out.println("不正な入力です。");
			continue;
		}
		}
		if(n==1) {
			count=1;
			continue;
		}else {
			break;
		}
		}

	}

}
