package example;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


class Prob94 extends JFrame {

JTextField result = new JTextField("",15);
int stackedValue = 0;
boolean isStacked = false;
boolean afterCalc = false;
String currentOp = "";


public static void main(String args[]){
Prob94 frame = new Prob94("電卓");
frame.setVisible(true);
}


Prob94(String title){
setTitle(title);
setBounds(100, 100, 200, 240);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


JPanel p = new JPanel();

JPanel key = new JPanel();
key.setLayout(new GridLayout(5,1));

JPanel keisan = new JPanel();


p.add(result);

key.add(new NumberButton("7"),0);
key.add(new NumberButton("8"),1);
key.add(new NumberButton("9"),2);
key.add(new NumberButton("4"),3);
key.add(new NumberButton("5"),4);
key.add(new NumberButton("6"),5);
key.add(new NumberButton("1"),6);
key.add(new NumberButton("2"),7);
key.add(new NumberButton("3"),8);
key.add(new NumberButton("0"),9);
key.add(new CalcButton("+"),10);
key.add(new CalcButton("-"),11);
key.add(new CalcButton("*"),12);
key.add(new CalcButton("/"),13);
key.add(new CalcButton("="),14);

keisan.add(new ClearButton());

Container content = getContentPane();

content.add(p, BorderLayout.NORTH);
content.add(key, BorderLayout.CENTER);
content.add(keisan, BorderLayout.SOUTH);
}

public class NumberButton extends JButton implements ActionListener {

public NumberButton(String keyTop){
super(keyTop);
this.addActionListener(this);
}
public void actionPerformed(ActionEvent evt) {
String keyNumber = this.getText();
appendResult(keyNumber);
}
}

public void appendResult(String c) {
if( ! afterCalc ) {
result.setText(result.getText() + c);//数字ボタンを押した時表示
	}
else {
result.setText(c);
afterCalc =false;
}
}



public class ClearButton extends JButton implements ActionListener {

public ClearButton() {
super("C");
this.addActionListener(this);
}

public void actionPerformed(ActionEvent evt) {
result.setText("");
stackedValue = 0;
isStacked = false;
currentOp = "";
}
}

public class CalcButton extends JButton implements ActionListener{

public CalcButton(String op){
super(op);
this.addActionListener(this);
}

public void actionPerformed(ActionEvent e){
if(isStacked){
int resultValue = (Integer.valueOf(result.getText())).intValue();
if ( currentOp.equals("+"))
stackedValue += resultValue;
else if( currentOp.equals("-"))
stackedValue -= resultValue;
else if( currentOp.equals("*"))
stackedValue *= resultValue;
else if( currentOp.equals("/"))
stackedValue /= resultValue;
result.setText(String.valueOf(stackedValue));//=を押した時に、計算結果を表示する
}

currentOp = this.getText();
stackedValue = (Integer.valueOf(result.getText())).intValue();

afterCalc =true;

if( currentOp.equals("計算")){
isStacked = false;}
else
isStacked = true;
}
}
}
