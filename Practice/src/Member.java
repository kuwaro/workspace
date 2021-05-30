import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Member implements Serializable{
	private int id;
		int id(){
			return id;
		}
	private String name;
		String name(){
			return name;
		}
	private String m_address;
		String m_address(){
			return m_address;
		}
	private String password;
		String password(){
			return password;
		}
	private ArrayList<Costume> costumes;
		ArrayList<Costume> costumes(){
			return costumes;
		}
	private static ArrayList<Member> member_list = new ArrayList<Member>();
		static ArrayList<Member> member_list(){
			return member_list;
		}
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	public Member(){
		costumes = new ArrayList<Costume>();
	}

	public void setID(){
		id = member_list.size();
	}
	public void setName(String n){
		name = n;
	}
	public void setM_add(String m){
		m_address = m;
	}
	public void setPasswd(String p){
		password = p;
	}
	public void addMember(Member m){
		member_list.add(m);
	}


	static void serialize(){
		try{
			ObjectOutputStream objOutStream =
			new ObjectOutputStream(
				new FileOutputStream("./bin/member.bin")
			);

			objOutStream.writeObject(member_list);
			objOutStream.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	static void deserialize(){
        try {
            ObjectInputStream objInStream
              = new ObjectInputStream(
                new FileInputStream("./bin/member.bin"));

            member_list = (ArrayList<Member>) objInStream.readObject();

            objInStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

	void registration(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("please input your name");
		scan = new Scanner(System.in);
		name = scan.nextLine();
		System.out.println("please input your e-mail address");
		m_address = scan.nextLine();
		System.out.println("Setting your password");
		password = scan.nextLine();
		id = member_list.size();
		member_list.add(this);
		System.out.println("Your ID is "+id);
	}

	void costume_get(Costume c){
		//System.out.println("You rent "+c.name());
		costumes.add(c);
	}

	void costume_return(Costume c){
	/*
		System.out.println("You rent "+c.name());
		for(Costume cos : costumes){
			System.out.println(cos.name());
		}
		System.out.println(costumes.indexOf(c));
		*/
		for(Costume cos : costumes){
			if(cos.id()==c.id()){
				costumes.remove(cos);
				break;
			}
		}

	}

	boolean has_this_costume(Costume c){
		for(Costume cos : costumes){
			if(cos.id()==c.id()){
				return true;
			}
		}
		return false;
	}
}

