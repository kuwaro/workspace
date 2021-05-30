import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class Contents{
	MainFrame MF;
	Component now_contents;
	Component next_contents;
	static Member user;

	public Contents(MainFrame mf){
		MF = mf;
		now_contents = createYNComponents();
		next_contents = createYNComponents();
		user = null;
	}

	// check having your ID
	public Component createYNComponents(){
		JLabel label1= new JLabel("Welcome to Clothing Rental System!");
		JLabel label2 = new JLabel("Do you have a member ID?");
		JButton button_Yes = new JButton("Yes");
		JButton button_No = new JButton("No");

		ActionListener YesActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createLoginComponents();
						reload(next_contents);
					}
				};
		button_Yes.addActionListener(YesActionListener);
			
		ActionListener NoActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createRegisterComponents();
					    reload(next_contents);
					}
				};
		button_No.addActionListener(NoActionListener);

		JPanel main = new JPanel();
		JPanel sub = new JPanel();
			
		sub.setLayout(new GridLayout(1,0));
		sub.add(button_Yes);
		sub.add(button_No);
			
		main.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
		main.setLayout(new GridLayout(0,1));
		main.add(label1);
		main.add(label2);
		main.add(sub);

		return main;	
	}
	
	// Login Form
	public Component createLoginComponents(){
		JLabel title = new JLabel("Please input your imfomation.");
		JLabel minfo = new JLabel("Your ID:");
		JLabel pinfo = new JLabel("Password:");
		JLabel result = new JLabel("");

		JTextField ID = new JTextField("",10);
		JTextField password = new JTextField("",10);

		JButton button_Login = new JButton("login");

		ActionListener LoginActionListener = new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(searchMember(Integer.valueOf(ID.getText()),password.getText()) == true){
					/*
						System.out.println("aaaa");
						for(Costume cos : user.costumes()){
							System.out.println(cos.name());
						}
						*/
						next_contents = createMemberMenuComponents();
						reload(next_contents);
					}else{
						next_contents = createFailLoginComponents();
						reload(next_contents);
					}
				}
			};
		button_Login.addActionListener(LoginActionListener);

		JPanel main = new JPanel();
		JPanel sub_ID = new JPanel();
		JPanel sub_pw = new JPanel();
			
		sub_ID.setLayout(new BoxLayout(sub_ID,BoxLayout.X_AXIS));
		sub_ID.add(minfo);
		sub_ID.add(ID);

		sub_pw.setLayout(new BoxLayout(sub_pw,BoxLayout.X_AXIS));
		sub_pw.add(pinfo);
		sub_pw.add(password);

		main.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		main.add(title);
		main.add(sub_ID);
		main.add(sub_pw);
		main.add(button_Login);

		return main;
	}

	public Component createFailLoginComponents(){
		JLabel message1 = new JLabel("ID or Password is invalid!");
		JLabel message2 = new JLabel("Please retry Login.");
		JButton button_LF = new JButton("Login Form");

		ActionListener BackMenuActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createLoginComponents();
						reload(next_contents);
					}
				};
		button_LF.addActionListener(BackMenuActionListener);

		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
		main.setLayout(new GridLayout(0,1));
		main.add(message1);
		main.add(message2);
		main.add(button_LF);

		return main;
	}

	
	public  boolean searchMember(int id, String passwd){
		user = null;
		for(Member m: Member.member_list()){
			if(m.id() == id){
				user = m;
				break;
			}
		}
		if (user == null) return false;

		if(!passwd.equals(user.password()))	return false;
		
		return true;
	}

	//Register Form
	int new_id = 0;
	public Component createRegisterComponents(){
		Member m = new Member();
		JLabel title = new JLabel("register your imfomation");
		JLabel ninfo = new JLabel("input your Name:");
		JLabel minfo = new JLabel("input your E-mail Address");
		JLabel pinfo = new JLabel("set your Password");

		JTextField r_name = new JTextField("");
		JTextField mail = new JTextField("");
		JTextField passwd = new JTextField("");

		JButton button_Register = new JButton("Register");

		ActionListener RegisterActionListener = new ActionListener(){
				public void actionPerformed(ActionEvent e){
					m.setID();
					m.setName(r_name.getText());
					m.setM_add(mail.getText());
					m.setPasswd(passwd.getText());
					m.addMember(m);
					Member.serialize();
					new_id = m.id();
					next_contents = createCompleteRegComponents();
				    reload(next_contents);
				}
			};

		button_Register.addActionListener(RegisterActionListener);

		JPanel main = new JPanel();
		JPanel sub_name = new JPanel();
		JPanel sub_mail = new JPanel();
		JPanel sub_passwd = new JPanel();
		JPanel sub_button = new JPanel();

		sub_name.setLayout(new GridLayout(1,0));
		sub_name.add(ninfo);
		sub_name.add(r_name);

		sub_mail.setLayout(new GridLayout(1,0));
		sub_mail.add(minfo);
		sub_mail.add(mail);

		sub_passwd.setLayout(new GridLayout(1,0));
		sub_passwd.add(pinfo);
		sub_passwd.add(passwd);

		main.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
		main.setLayout(new GridLayout(0,1));
		main.add(title);
		main.add(sub_name);
		main.add(sub_mail);
		main.add(sub_passwd);
		main.add(button_Register);
		return main;
	}

	//after Registration
	public Component createCompleteRegComponents(){
		JLabel comp_reg = new JLabel("Member Registration has been completed.");
		JLabel notice_id = new JLabel("Your Member ID is " +new_id+ ". Remember Your ID!");
		JButton button_toLF = new JButton("Login Form");

		ActionListener ToLFActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createLoginComponents();
						reload(next_contents);
					}
				};
		button_toLF.addActionListener(ToLFActionListener);

		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
		main.setLayout(new GridLayout(0,1));
		main.add(comp_reg);
		main.add(notice_id);
		main.add(button_toLF);

		return main;
	}

	//Member Menu
	public Component createMemberMenuComponents(){
		JLabel label = new JLabel("Your page: "+user.name());
		JButton button_quit = new JButton("quit");
		JButton button_rental = new JButton("Rental");
		JButton button_return = new JButton("Return");
		JButton button_NRL = new JButton("show your rental list");

		ActionListener RentalActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createRentalComponents();
						reload(next_contents);
					}
				};
		button_rental.addActionListener(RentalActionListener);

		ActionListener ReturnActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createReturnComponents();
						reload(next_contents);
					}
				};
		button_return.addActionListener(ReturnActionListener);

		ActionListener NRLActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createNRLComponents();
						reload(next_contents);
					}
				};
		button_NRL.addActionListener(NRLActionListener);

		ActionListener QuitActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						MF.closeMainFrame();
					}
				};
		button_quit.addActionListener(QuitActionListener);

		JPanel main = new JPanel();
		JPanel sub = new JPanel();

	   	sub.setLayout(new GridLayout(1,0));
		sub.add(button_rental);
		sub.add(button_return);
		sub.add(button_NRL);

		main.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
		main.setLayout(new GridLayout(0,1));
		main.add(label);
		main.add(sub);
		main.add(button_quit);

		return main;	
	}

	//Rental
	public Component createRentalComponents(){
		//Costume cos = new Costume();
		//Costume.deserialize();
		//Member.deserialize();
		JLabel label = new JLabel("Please select an ID!");
		
		DefaultListModel<Integer> IDListModel = new DefaultListModel<Integer>();
		JList<Integer> IDList = new JList<Integer>(IDListModel);
		IDList.setVisibleRowCount(10);
		IDList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		DefaultListModel<String> NameListModel = new DefaultListModel<String>();
		JList<String> NameList = new JList<String>(NameListModel);
		NameList.setVisibleRowCount(10);
		
		DefaultListModel<String> SizeListModel = new DefaultListModel<String>();
		JList<String> SizeList = new JList<String>(SizeListModel);
		SizeList.setVisibleRowCount(10);
		
		DefaultListModel<Integer> FeeListModel = new DefaultListModel<Integer>();
		JList<Integer> FeeList = new JList<Integer>(FeeListModel);
		FeeList.setVisibleRowCount(10);
		
		JPanel ListPane = new JPanel();
		ListPane.setLayout(new GridLayout(1,4));
		ListPane.add(IDList);
		ListPane.add(NameList);
		ListPane.add(SizeList);
		ListPane.add(FeeList);
		

		for(Costume c : Costume.costume_list()){
			if(c.has_stock() == true){
				IDListModel.addElement(c.id());
				NameListModel.addElement(c.name());
				SizeListModel.addElement(c.size());
				FeeListModel.addElement(c.fee());
			}
		}

		JScrollPane rental_scroll = new JScrollPane(ListPane);
		rental_scroll.setPreferredSize(new Dimension(100,200));
		rental_scroll.createVerticalScrollBar();
		rental_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JButton button_rental = new JButton("Rental");
		ActionListener RentalActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						int index = IDList.getSelectedIndex();
						if(index != -1){
							for(Costume cos : Costume.costume_list()){
								if(cos.id() == IDList.getSelectedValue()){
									cos.setback_date(cos.id());
									cos.changeStock(cos.id());
									user.costume_get(cos);
									Costume.serialize();
									Member.serialize();
									next_contents = createCompleteRentalComponents();
									reload(next_contents);
									break;
								}
							}


						}else{
							JOptionPane.showMessageDialog(IDList, "None selected!", "Error", JOptionPane.ERROR_MESSAGE);
						}
				  	}
				};
		button_rental.addActionListener(RentalActionListener);

		JButton button_backMenu = new JButton("Member's Menu");

		ActionListener BackMenuActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createMemberMenuComponents();
						reload(next_contents);
					}
				};
		button_backMenu.addActionListener(BackMenuActionListener);

		JPanel main = new JPanel();
		JPanel button_sub = new JPanel();
		button_sub.setLayout(new GridLayout(1,0));
		button_sub.add(button_rental);
		button_sub.add(button_backMenu);
		
		main.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(label);
		main.add(rental_scroll);
		main.add(button_sub);
		return main;
	}

	public Component createCompleteRentalComponents(){
		JLabel comp_rent = new JLabel("Rental has been completed.");
		JButton button_backMenu = new JButton("return back to Member Menu");

		ActionListener BackMenuActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createMemberMenuComponents();
						reload(next_contents);
					}
				};
		button_backMenu.addActionListener(BackMenuActionListener);

		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
		main.setLayout(new GridLayout(0,1));
		main.add(comp_rent);
		main.add(button_backMenu);

		return main;
	}

	
	//Return
	public Component createReturnComponents(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Costume cos = new Costume();
		JLabel label = new JLabel("Please select an ID!");
		
		DefaultListModel<Integer> IDListModel = new DefaultListModel<Integer>();
		JList<Integer> IDList = new JList<Integer>(IDListModel);
		IDList.setVisibleRowCount(10);
		IDList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		DefaultListModel<String> NameListModel = new DefaultListModel<String>();
		JList<String> NameList = new JList<String>(NameListModel);
		NameList.setVisibleRowCount(10);
		
		DefaultListModel<String> SizeListModel = new DefaultListModel<String>();
		JList<String> SizeList = new JList<String>(SizeListModel);
		SizeList.setVisibleRowCount(10);

		DefaultListModel<String> Back_dateListModel = new DefaultListModel<String>();
		JList<String> Back_dateList = new JList<String>(Back_dateListModel);
		SizeList.setVisibleRowCount(10);

		JPanel ListPane = new JPanel();
		ListPane.setLayout(new GridLayout(1,4));
		ListPane.add(IDList);
		ListPane.add(NameList);
		ListPane.add(SizeList);
		ListPane.add(Back_dateList);

	    for(int i = 0; i < user.costumes().size(); i++){
			IDListModel.addElement(user.costumes().get(i).id());
   			NameListModel.addElement(user.costumes().get(i).name());
	   		SizeListModel.addElement(user.costumes().get(i).size());
		   	Back_dateListModel.addElement(sdf.format(cos.getaCostume(i).back_date().getTime()));
		}

		JScrollPane return_scroll = new JScrollPane(ListPane);
		return_scroll.setPreferredSize(new Dimension(100,200));
		return_scroll.createVerticalScrollBar();
		return_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton button_return = new JButton("Return");
		ActionListener RentalActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						int index = IDList.getSelectedIndex();
						if(index != -1){
							for(Costume cos :Costume.costume_list()){
								if(cos.id() == IDList.getSelectedValue()){
									System.out.println(cos.id());					
									user.costume_return(cos);	
									cos.changeStock(cos.id());
									//System.out.println(sdf.format(cos.back_date()));

									Costume.serialize();
									Member.serialize();

									Calendar now = Calendar.getInstance();
									if(cos.compare_date(cos.back_date(),now) >= 0){
										next_contents = createCompleteReturnComponents();
										reload(next_contents);
									}else{
										next_contents = createArrearsComponents();
										reload(next_contents);
									}	
									break;
								}
							}
						}else{
							JOptionPane.showMessageDialog(IDList, "None selected!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				};
		button_return.addActionListener(RentalActionListener);

		JButton button_backMenu = new JButton("Member's Menu");
		ActionListener BackMenuActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createMemberMenuComponents();
						reload(next_contents);
					}
				};
		button_backMenu.addActionListener(BackMenuActionListener);
		
		JPanel main = new JPanel();
		JPanel button_sub = new JPanel();
		button_sub.setLayout(new GridLayout(1,0));
		button_sub.add(button_return);
		button_sub.add(button_backMenu);
		
	    main.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(label);
		main.add(return_scroll);
		main.add(button_sub);
		return main;
	}

	public Component createCompleteReturnComponents(){
		JLabel comp_return = new JLabel("Return has been completed.");
		JButton button_backMenu = new JButton("return back to Member Menu");

		ActionListener BackMenuActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createMemberMenuComponents();
						reload(next_contents);
					}
				};
		button_backMenu.addActionListener(BackMenuActionListener);

		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
		main.setLayout(new GridLayout(0,1));
		main.add(comp_return);
		main.add(button_backMenu);

		return main;
	}

	public Component createArrearsComponents(){
		JLabel Alert = new JLabel("The return deadline has passed");
		JLabel Arrears = new JLabel("Late Payment Charge: 100 yen");
		
		JButton button_backMenu = new JButton("return back to Member Menu");
		ActionListener BackMenuActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createMemberMenuComponents();
						reload(next_contents);
					}
				};
		button_backMenu.addActionListener(BackMenuActionListener);

		JPanel main = new JPanel();
		main.setLayout(new GridLayout(0,1));
		main.add(Alert);
		main.add(Arrears);
		main.add(button_backMenu);
		return main;
	}

	// show Rental List
	public Component createNRLComponents(){
		JButton button_backMenu = new JButton("return back to Member Menu");
		Costume cos = new Costume();
		JLabel label = new JLabel("Please select an ID of costume you want to return.");
		
		DefaultListModel<Integer> IDListModel = new DefaultListModel<Integer>();
		JList<Integer> IDList = new JList<Integer>(IDListModel);
		IDList.setVisibleRowCount(10);
		IDList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		DefaultListModel<String> NameListModel = new DefaultListModel<String>();
		JList<String> NameList = new JList<String>(NameListModel);
		NameList.setVisibleRowCount(10);
		
		DefaultListModel<String> SizeListModel = new DefaultListModel<String>();
		JList<String> SizeList = new JList<String>(SizeListModel);
		SizeList.setVisibleRowCount(10);

		/*DefaultListModel<Calendar> Back_dateListModel = new DefaultListModel<Calendar>();
		JList<Calendar> Back_dateList = new JList<Calendar>(Back_dateListModel);
		SizeList.setVisibleRowCount(10);*/

		JPanel ListPane = new JPanel();
		ListPane.setLayout(new GridLayout(1,4));
		ListPane.add(IDList);
		ListPane.add(NameList);
		ListPane.add(SizeList);
		//ListPane.add(Back_dateList);

	    for(int i = 0; i < user.costumes().size(); i++){
			IDListModel.addElement(user.costumes().get(i).id());
   			NameListModel.addElement(user.costumes().get(i).name());
	   		SizeListModel.addElement(user.costumes().get(i).size());
		   	//Back_dateListModel.addElement(cos.getaCostume(i).back_date());
		}

		JScrollPane return_scroll = new JScrollPane(ListPane);
		return_scroll.setPreferredSize(new Dimension(100,200));
		return_scroll.createVerticalScrollBar();
		return_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		ActionListener BackMenuActionListener
			=new ActionListener(){
					public void actionPerformed(ActionEvent e){
						next_contents = createMemberMenuComponents();
						reload(next_contents);
					}
				};
		button_backMenu.addActionListener(BackMenuActionListener);

		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(label);
		main.add(return_scroll);
		main.add(button_backMenu);
		return main;
	}

	public void reload(Component next){
		Container contentPane = MF.getContentPane();
		contentPane.removeAll();
		contentPane.add(next_contents,BorderLayout.CENTER);
		MF.setVisible(true);
	}
}
