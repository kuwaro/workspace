import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
public class Main extends JFrame implements ActionListener{
	ArrayList<book> finishedList=new ArrayList<book>();
	ArrayList<book> toReadList=new ArrayList<book>();
	List<book> saveList=new ArrayList<book>();
	static JPanel cardPanel;
	CardLayout layout;
	static int info_show=0;
	static int finito=0;
	static int flag=0;
	static JTextField[] field=new JTextField[10];
	private DefaultListModel<String> listModel;
	private JList<String> list;

public static void main(String[] args) {
	Main frame=new Main();
	frame.setLayout(new BorderLayout());
	frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Book management system");
	frame.setBounds(100,100,400,300);
	frame.setVisible(true);
}

Main() {
	for(int i=0;i<field.length;i++) {
		field[i]=new JTextField();
	}
	JLabel[] labelnull=new JLabel[100];
	for(int i=0;i<labelnull.length;i++)
		labelnull[i]=new JLabel(" ");

	JButton[] back= new JButton[10];
	for(int i=0;i<back.length;i++) {
	back[i]= new JButton("Back");
	back[i].addActionListener(this);
	back[i].setActionCommand("back");
	}
	JPanel mainpanel=new JPanel();//firstpanel
	JButton btn1=new JButton("1:Add book data");
	JButton btn2=new JButton("2:show list");
	JButton btn3=new JButton("3:exit");
	mainpanel.add(btn1);
	mainpanel.add(btn2);
	mainpanel.add(btn3);
	btn1.addActionListener(this);
	btn2.addActionListener(this);
	btn3.addActionListener(this);
	btn1.setActionCommand("panel12_1");
	btn2.setActionCommand("panel12_2");
	btn3.setActionCommand("exit");
	//panel2
	JPanel panel12=new JPanel();
	panel12.setLayout(new GridLayout(6,2));
	JLabel label=new JLabel("Which list do you select?");
	JButton btn4=new JButton("1:Finished");
	JButton btn5=new JButton("2:ToRead");
	panel12.add(label,0);
	panel12.add(labelnull[6],1);
	panel12.add(btn4,2);
	panel12.add(btn5,3);
	for(int i=7;i<12;i++) {
	panel12.add(labelnull[i],i-3);
	}
	panel12.add(back[0],9);
	btn4.addActionListener(this);
	btn5.addActionListener(this);
	btn4.setActionCommand("finished");
	btn5.setActionCommand("Toread");

	//panel3
	JPanel panel1_12=new JPanel();
	panel1_12.setLayout(new GridLayout(13,2));
	JLabel label1=new JLabel("Please enter information.");
	JLabel label2=new JLabel("subject:");
	JLabel label3=new JLabel("ISBN num:");
	JLabel label4=new JLabel("author:");
	JLabel label5=new JLabel("publisher:");
	JLabel label6=new JLabel("year:");
	JButton btn6=new JButton("add");
	panel1_12.add(label1,0);
	panel1_12.add(labelnull[0],1);
	panel1_12.add(labelnull[1],2);
	panel1_12.add(labelnull[2],3);
	panel1_12.add(label2,4);
	panel1_12.add(field[0],5);
	panel1_12.add(label3,6);
	panel1_12.add(field[1],7);
	panel1_12.add(label4,8);
	panel1_12.add(field[2],9);
	panel1_12.add(label5,10);
	panel1_12.add(field[3],11);
	panel1_12.add(label6,12);
	panel1_12.add(field[4],13);
	panel1_12.add(labelnull[3],14);
	panel1_12.add(labelnull[4],15);
	panel1_12.add(labelnull[5],16);
	panel1_12.add(btn6,17);
	for(int i=12;i<16;i++){
		panel1_12.add(labelnull[i],i+6);
	}
	panel1_12.add(back[1]);
	btn6.addActionListener(this);
	btn6.setActionCommand("add");

	//panel4
	JPanel panel2_2=new JPanel();
	panel2_2.setLayout(new GridLayout(11,3));
	JLabel label8=new JLabel("How do you want to look?");
	JButton btn8=new JButton("1:nomal order");
	JButton btn10=new JButton("2:interest order");
	JButton btn11=new JButton("3:popular order");
	panel2_2.add(label8,0);
	for(int i=1;i<2;i++) {
		panel2_2.add(labelnull[i+15],i);
	}
	panel2_2.add(btn8,2);
	panel2_2.add(btn10,3);
	panel2_2.add(btn11,4);
	for(int i=5;i<10;i++) {
		panel2_2.add(labelnull[i+18],i);
	}
	panel2_2.add(back[2],10);
	btn8.addActionListener(this);
	btn10.addActionListener(this);
	btn11.addActionListener(this);
	btn8.setActionCommand("nomal");
	btn10.setActionCommand("interest");
	btn11.setActionCommand("popular");
	back[2].setActionCommand("backto_panel12");

	//showpanel
	JPanel showpanel=new JPanel();
	listModel = new DefaultListModel<String>();
	list = new JList<String>(listModel);
	list.setVisibleRowCount(10);
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	JScrollPane scrollPane = new JScrollPane(list);
	scrollPane.createVerticalScrollBar();
	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	showpanel.setLayout(new BorderLayout());
	showpanel.add(list,BorderLayout.CENTER);
	showpanel.add(back[3],BorderLayout.PAGE_END);
	back[3].addActionListener(this);
	back[3].setActionCommand("gotoHowshow");

	//panel5
	JPanel kanryopanel=new JPanel();
	JLabel label7 =new JLabel("Completion of registration");
	JButton btn7=new JButton("OK");
	kanryopanel.add(label7);
	kanryopanel.add(btn7);
	btn7.addActionListener(this);
	btn7.setActionCommand("OK");

	//panel6
	JPanel errorpanel=new JPanel();
	JLabel label9 =new JLabel("ERROR! Please enter all information");
	JButton btn9=new JButton("OK");
	errorpanel.add(label9);
	errorpanel.add(btn9);
	btn9.addActionListener(this);
	btn9.setActionCommand("back");

	cardPanel=new JPanel();
	layout=new CardLayout();
	cardPanel.setLayout(layout);
	cardPanel.add(mainpanel,"main");
	cardPanel.add(panel12,"panel12");
	cardPanel.add(panel1_12,"information");
	cardPanel.add(errorpanel,"error");
	cardPanel.add(panel2_2,"Howshow");
	cardPanel.add(kanryopanel,"kanryo");
	cardPanel.add(showpanel,"show");
}

@Override
public void actionPerformed(ActionEvent e) {
	String cmd=e.getActionCommand();
	switch(cmd) {
	case "exit":
		System.exit(0);
	case "panel12_1":
		info_show=1;
		layout.show(cardPanel,"panel12");
		break;
	case "panel12_2":
		info_show=2;
		layout.show(cardPanel,"panel12");
		break;
	case "finished":
		finito=1;
		if(info_show==1) {
			layout.show(cardPanel, "information");
		}else {
			layout.show(cardPanel, "Howshow");
		}
		break;
	case "Toread":
		finito=2;
		if(info_show==1) {
			layout.show(cardPanel, "information");
		}else {
			layout.show(cardPanel, "Howshow");
		}
		break;
	case "back":
		System.out.println("b");
		layout.previous(cardPanel);
			break;
	case "backto_panel12":
		layout.show(cardPanel,"panel12");
		break;
	case "add":{
		for(int i=0;i<5;i++) {
			if(field[i].getText().equals("")) {
				layout.show(cardPanel, "error");
				break;
			}
			if(i==4)
				flag=1;
			}
			if(flag==1) {
	book book1 =new book(field[0].getText(),field[1].getText(),field[2].getText()
			,field[3].getText(),field[4].getText());
	if(finito==1) {
		finishedList.add(book1);
	}else {
		toReadList.add(book1);
	}
	for(int i=0;i<5;i++) {
		field[i].setText("");
	}
	layout.show(cardPanel,"kanryo");
	}
		break;
		}
	case "OK":
		layout.first(cardPanel);
		break;
	case "gotoHowshow":
		listModel.removeAllElements();
		layout.show(cardPanel, "Howshow");
		break;
	case "nomal":
		layout.show(cardPanel,"show");
		if(finito==1) {
		for(int i=0;i<finishedList.size();i++) {
		listModel.addElement(finishedList.get(i).getsubject()
				+"(isbnNum:"+finishedList.get(i).getisbnNum()
				+" author:"+finishedList.get(i).getauthor()
				+" publisher:"+finishedList.get(i).getpublisher()
				+" year:"+finishedList.get(i).getyear()+")");
		}
		}else{
			for(int i=0;i<toReadList.size();i++) {
				listModel.addElement(toReadList.get(i).getsubject()
						+"(isbnNum:"+toReadList.get(i).getisbnNum()
						+" author:"+toReadList.get(i).getauthor()
						+" publisher:"+toReadList.get(i).getpublisher()
						+" year:"+toReadList.get(i).getyear()+")");
		}
		}
		break;
	case "interest":
		layout.show(cardPanel,"show");
		if(finito==1) {
			saveList=Recommend.interest(finishedList);
		for(int i=0;i<saveList.size();i++) {
			listModel.addElement(saveList.get(i).getsubject()
					+"(isbnNum:"+saveList.get(i).getisbnNum()
					+" author:"+saveList.get(i).getauthor()
					+" publisher:"+saveList.get(i).getpublisher()
					+" year:"+saveList.get(i).getyear()+")");
			}
		}else {
			saveList=Recommend.interest(toReadList);
			for(int i=0;i<toReadList.size();i++) {
				listModel.addElement(saveList.get(i).getsubject()
						+"(isbnNum:"+saveList.get(i).getisbnNum()
						+" author:"+saveList.get(i).getauthor()
						+" publisher:"+saveList.get(i).getpublisher()
						+" year:"+saveList.get(i).getyear()+")");
		}
		}
		break;

	case "popular":
		layout.show(cardPanel,"show");
		if(finito==1) {
			saveList=Recommend.popularity(finishedList);
			for(int i=0;i<saveList.size();i++) {
				listModel.addElement(saveList.get(i).getsubject()
						+"(isbnNum:"+saveList.get(i).getisbnNum()
						+" author:"+saveList.get(i).getauthor()
						+" publisher:"+saveList.get(i).getpublisher()
						+" year:"+saveList.get(i).getyear()+")");
				}
			}else {
				saveList=Recommend.popularity(toReadList);
				for(int i=0;i<toReadList.size();i++) {
					listModel.addElement(saveList.get(i).getsubject()
							+"(isbnNum:"+saveList.get(i).getisbnNum()
							+" author:"+saveList.get(i).getauthor()
							+" publisher:"+saveList.get(i).getpublisher()
							+" year:"+saveList.get(i).getyear()+")");
			}
			}
		break;
	}
	}}