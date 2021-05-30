//身体検査データ配列からの探索
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class PhysExamSearch {
static class PhyscData{
	private String name;//氏名
	private int height;//身長
	private double vision;//視力

	//コンストラクタ
	public PhyscData(String name,int height,double vision) {
		this.name=name;
		this.height=height;
		this.vision=vision;
	}

	//文字列化
	public String toString() {
		return name+" "+height+" "+vision;
	}
	//身長昇順用コンパレータ
	public static final Comparator<PhyscData> HEIGFT_ORDER
	=new HeightOrderComparator();

	private static class HeightOrderComparator
	implements Comparator<PhyscData>{
		public int compare(PhyscData d1,PhyscData d2) {
			return (d1.height>d2.height)?1:
				(d1.height<d2.height)?-1:0;
		}
	}
}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		PhyscData[] x= { //配列の要素は身長順でなければならない
				new PhyscData("赤坂", 162, 0.3),
				new PhyscData("長浜", 168, 0.4),
				new PhyscData("松富", 169, 0.8),
				new PhyscData("武田", 171, 1.5),
				new PhyscData("加藤", 173, 0.7),
				new PhyscData("浜田", 174, 1.2),
				new PhyscData("斎藤", 175, 2.0),
		};
		System.out.print("何cmの人を探しますか:");
		int height=sc.nextInt(); //キー値の読み込み
		int idx=Arrays.binarySearch(x,//配列xから
				new PhyscData("", height,0.0),//身長がheightの要素を
				PhyscData.HEIGFT_ORDER);//HEIGHT_ORDERによって探索
		if(idx<0)
			System.out.println("その値の要素は存在しません。");
		else {
			System.out.println("その値はx["+idx+"]にあります。");
			System.out.println("データ:"+x[idx]);
		}

	}

}
