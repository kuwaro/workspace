
public class MediumGoods extends Goods{

	public MediumGoods(String Type,int Num,int UnitPrice,String Destination) {
		super(Type, Num, UnitPrice, Destination);
	}

	@Override
	int getCharge() {
		return 2000;
	}
}
