
public abstract class Goods {
	private String Type;
	private int Num;
	private int UnitPrice;
	private String Destination;

	public Goods(String Type,int Num,int UnitPrice,String Destination){
		this.Type=Type;
		this.Num=Num;
		this.UnitPrice=UnitPrice;
		this.Destination=Destination;
	}
	String getType() {
		return this.Type;
	}
	int getNum() {
		return this.Num;
	}
	int getUnitPrice() {
		return this.UnitPrice;
	}
	String getDestination() {
		return this.Destination;
	}
	void setDistination(String Destination) {
		this.Destination=Destination;
	}
	void setNum(int Num) {
		this.Num=Num;
	}
	int getTotalPrice() {
		return UnitPrice*Num;
	}
	void print() {
		System.out.println("Type:"+Type);
		System.out.println("Num:"+Num);
		System.out.println("UnitPrice:"+UnitPrice);
		System.out.println("Destination:"+Destination);
	}
	abstract int getCharge();
}
