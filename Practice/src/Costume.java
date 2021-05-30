import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Costume implements Serializable{
	private int id;
		int id(){
			return id;
		}
	private String name;
		String name(){
			return name;
		}
	private String size;
		String size(){
			return size;
		}
	private int fee;
		int fee(){
			return fee;
		}
	private int lending_period;
		int lending_period(){
			return lending_period;
		}
	private Calendar back_date;
		Calendar back_date(){
			return back_date;
		}
	private boolean stock;
		boolean has_stock(){
				return stock;
		}
	private ArrayList<Member> reservation_list = new ArrayList<Member>();
		ArrayList<Member> reservation_list(){
			return reservation_list;
		}
	private static ArrayList<Costume> costume_list = new ArrayList<Costume>();
		static ArrayList<Costume> costume_list(){
			return costume_list;
		}
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	public int NumOfCos(){
		return costume_list.size();
	}

	public Costume getaCostume(int i){
		return costume_list.get(i);
	}

	public void setback_date(int i){
		costume_list.get(i).back_date = Calendar.getInstance();
		costume_list.get(i).back_date.add(Calendar.DAY_OF_MONTH, costume_list.get(i).lending_period);
	}

	public void changeStock(int i){
		if(stock == true){costume_list.get(i).stock = false;}
		else {costume_list.get(i).stock = true;}		
	}
	
	static void add_costume(){
		Costume costume = new Costume();
		System.out.println("please input this costume's name");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		costume.name = str;
		System.out.println("please input this costume's fee");
		scan = new Scanner(System.in);
		str = scan.next();
		costume.fee = Integer.parseInt(str);
		costume.id = costume_list.size();
		costume.stock = true;
		costume.lending_period = 7;
		costume_list.add(costume);
	}

	static void serialize(){
		try{
			ObjectOutputStream objOutStream =
			new ObjectOutputStream(
				new FileOutputStream("./bin/costume.bin")
			);

			objOutStream.writeObject(costume_list);
			objOutStream.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	static void deserialize(){
        try {
            ObjectInputStream objInStream 
              = new ObjectInputStream(
                new FileInputStream("./bin/costume.bin"));
            
            costume_list = (ArrayList<Costume>) objInStream.readObject();
            
            objInStream.close();
          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

	static void rental(int id,Member m){
		Costume costume;
		costume = search(id);
		if(costume==null){
			System.out.println("There is no such costume");
			return;
		}
		System.out.println(costume.name);
		if(costume.stock){
			System.out.println("You must pay \\ "+costume.fee());
			costume.back_date = Calendar.getInstance();
			costume.back_date.add(Calendar.DAY_OF_MONTH, costume.lending_period);
			//costume.back_date.add(Calendar.DAY_OF_MONTH, 0);

			System.out.println("You have to return this costume by "+sdf.format(costume.back_date.getTime()));
			costume.stock = false;
			m.costume_get(costume);
		}else{
			if(m.has_this_costume(costume)){
				System.out.println("You have already rented this costume");
			}else{
				System.out.println("This costume has already rented");
				System.out.println("Do you want to reserve this costume?");
				System.out.println("["+costume.reservation_list.size()+" people reserve now]");
				Scanner scan =new Scanner (System.in);
				while(true){
					String s = scan.next();
					if(s.equals("y")){
						costume.reservation_list.add(m);
						break;
					}else if(s.equals("n")){
						break;
					}
				}
			}
		}
	}

	static void return_costume(int id,Member m){
		Costume costume;
		costume = search(id);
		if(costume==null){
			System.out.println("There is no such costume");
			return;
		}
		if(m.has_this_costume(costume)){
			Calendar now = Calendar.getInstance();
			if(compare_date(costume.back_date,now) < 0){
				System.out.println("You mast pay late fees : \\100");
			}
			costume.stock = true;
			m.costume_return(costume);
			System.out.println("Thank you !");

		}else{
			System.out.println("You didn't rent such costume");
		}
	}

	static Costume search(int id){
		for(Costume c : costume_list){
			if(c.id == id){
				return c;
			}
		}
		return null;
	}

	static int compare_date(Calendar cal1,Calendar cal2){
		cal1.set(Calendar.HOUR_OF_DAY,0);
		cal1.set(Calendar.MINUTE,0);
		cal1.set(Calendar.SECOND,0);
		cal1.set(Calendar.MILLISECOND,0);
		cal2.set(Calendar.HOUR_OF_DAY,0);
		cal2.set(Calendar.MINUTE,0);
		cal2.set(Calendar.SECOND,0);
		cal2.set(Calendar.MILLISECOND,0);
		return cal1.compareTo(cal2);

	}
}
