import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public static void main(String[] args){

		Member.deserialize();
		Costume.deserialize();
		//Costume.deserialize();
		MainFrame main = new MainFrame();
		Contents c = new Contents(main);
		Component now = c.now_contents;
		main.getContentPane().add(now,BorderLayout.CENTER);

		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		main.setSize(500,300);
		main.setVisible(true);
	}

	//close MainFrame
	public void closeMainFrame(){
		this.setVisible(false);
		System.exit(1);
		}
}
