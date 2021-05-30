
public class TruckUser {
	public static void main(String[] args){
	     Truck truck1 = new Truck(10);
	     Truck truck2 = new Truck(10);
	     truck1.setCar(123, 8.0);
	     truck1.addGas(30);
	     truck2.setCar(789, 7.5);
	     truck2.addGas(40);
	     Goods goods1 = new BigGoods("grape", 200, 400, "Yokohama");
	     Goods goods2 = new SmallGoods("apple", 250, 350, "Ueno");
	     Goods goods3 = new MediumGoods("banana", 1000, 100, "Shinjuku");
	     Goods goods4 = new SmallGoods("apple", 100, 350, "Ueno");
	     Goods goods5 = new BigGoods("banana", 200, 200, "Osaka");
	     Goods goods6 = new MediumGoods("orange", 200, 100, "Kyoto");
	     Goods goods7 = new MediumGoods("orange", 200, 150, "Kyoto");
	     truck1.addGoods(goods1);
	     truck1.addGoods(goods2);
	     truck1.addGoods(goods3);
	     truck1.addGoods(goods4);
	     truck2.addGoods(goods5);
	     truck2.addGoods(goods6);
	     truck2.addGoods(goods7);

	     System.out.println();
	     System.out.println("Truck1's current status");
	     truck1.showStatus();

	     System.out.println();
	     System.out.println("Truck2's current status");
	     truck2.showStatus();

	     System.out.println("THE END");
	  }
}
