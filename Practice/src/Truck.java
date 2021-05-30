
public class Truck extends Car{

	private Goods cargo[];
    int count=0;

	Truck(int NumMax) {
		this.cargo=new Goods[NumMax];
	}
	public void addGas(double added) {
		gas = gas + added;
		System.out.println(added + " liters of gas was added");
		System.out.println("Truck now has " + gas + " liters of gas");
	}

	void addGoods(Goods goods) {
		if(count==0) {
			this.cargo[count]=goods;
			count++;
		}else{
		for(int i=0;i<count;i++) {
			if(this.cargo[i].getType()==goods.getType()&&
					this.cargo[i].getUnitPrice()==goods.getUnitPrice()&&
					this.cargo[i].getDestination()==goods.getDestination()) {
				int count=this.cargo[i].getNum()+goods.getNum();
				this.cargo[i].setNum(count);
				break;
			}
			if(i==count-1) {
				this.cargo[count]=goods;
				count++;
				break;
			}
		}
		}

	}
	int totalCargoValue() {
		int total=0;
		for(int i=0;i<this.count;i++)
			total+=this.cargo[i].getTotalPrice();

		return total;
	}
	int getTotalCharge() {
		int total=0;
		for(int i=0;i<this.count;i++)
			total+=this.cargo[i].getCharge();

		return total;
		}
	void showStatus() {
		System.out.println("【荷物の情報】");
		for(int i=0;i<this.count;i++) {
			System.out.println(i+1);
			System.out.print("種類:");
			System.out.println(this.cargo[i].getType());
			System.out.print("数:");
			System.out.println(this.cargo[i].getNum());
			System.out.print("単価:");
			System.out.println(this.cargo[i].getUnitPrice());
			System.out.print("送り先:");
			System.out.println(this.cargo[i].getDestination());
		}
		System.out.println();
		System.out.print("全荷物の総金額:");
		System.out.println(this.totalCargoValue());
		System.out.print("総運送料:");
		System.out.println(this.getTotalCharge());

	}

}
