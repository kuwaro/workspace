
public class BigGoods extends Goods{
	public BigGoods(String Type,int Num,int UnitPrice,String Destination) {
		super(Type, Num, UnitPrice, Destination);
	}

	@Override
	int getCharge() {
		return 3000;
	}
}
