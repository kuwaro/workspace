import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Prob93 {
  private static String labelPrefix = "New String:";
  private JLabel label;
  private JTextField field;

  class ButtonAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
    	String templeText=field.getText();
      label.setText(labelPrefix + templeText);
    }
  }

  public Component createComponents() {
	field =new JTextField("Initial");
    label = new JLabel(labelPrefix + "XXX");
    JButton button = new JButton("Move!");

    ButtonAction buttonListener = new ButtonAction();
    button.addActionListener( buttonListener );
    JPanel pane = new JPanel();
    pane.setBorder(BorderFactory.createEmptyBorder( 30, 30, 10, 30 ));
    pane.setLayout(new GridLayout(0, 1));
    pane.add(field);
    pane.add(button);
    pane.add(label);
    return pane;
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("TestButton");
    Prob93 app = new Prob93();
    Component contents = app.createComponents();
    frame.getContentPane().add(contents, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
