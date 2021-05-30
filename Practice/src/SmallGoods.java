
public class SmallGoods extends Goods{
	public SmallGoods(String Type,int Num,int UnitPrice,String Destination) {
		super(Type, Num, UnitPrice, Destination);
	}
	@Override
	int getCharge() {
		return 1000;
	}


}
