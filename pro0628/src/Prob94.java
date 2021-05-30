import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Prob94 extends JFrame {

	JPanel frame = new JPanel();
	BorderLayout borderLayout1 = new BorderLayout();
	JTextField result = new JTextField("");
	int stackedValue=0;
	int ans=0;
	String stackedtext="0";
	String currentOp="1";
	String prevOp="";
	boolean isStacked=false;
	public static void main(String[] args) {
		new Prob94();
	}
	//フレームのビルド
	public Prob94() {
		frame.setLayout(borderLayout1);
		this.setSize(new Dimension(250, 300));
		this.setTitle("電卓");
		this.setContentPane(frame);

		frame.add(result, BorderLayout.NORTH);

		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(4, 4));
		frame.add(keyPanel, BorderLayout.CENTER);

		keyPanel.add(new NumberButton("7"), 0);
		keyPanel.add(new NumberButton("8"), 1);
		keyPanel.add(new NumberButton("9"), 2);
		keyPanel.add(new CalcButton("÷"), 3);
		keyPanel.add(new NumberButton("4"), 4);
		keyPanel.add(new NumberButton("5"), 5);
		keyPanel.add(new NumberButton("6"), 6);
		keyPanel.add(new CalcButton("×"), 7);
		keyPanel.add(new NumberButton("1"), 8);
		keyPanel.add(new NumberButton("2"), 9);
		keyPanel.add(new NumberButton("3"), 10);
		keyPanel.add(new CalcButton("-"), 11);
		keyPanel.add(new NumberButton("0"), 12);
		keyPanel.add(new CalcButton("+"), 13);
		keyPanel.add(new ClearButton(), 14);
		keyPanel.add(new CalcButton("="),15);
		this.setVisible(true);
	}
	public void appendResult(String c) {
		result.setText(c);
	}
	class NumberButton extends JButton implements ActionListener{
		public NumberButton(String keyTop) {
			super(keyTop);
			this.addActionListener(this);
		}
		public void actionPerformed(ActionEvent evt) {
			String keyNumber =this.getText();
			appendResult(keyNumber);
			stackedtext=stackedtext+keyNumber;//表示はしないが、今まで押されてた数字を格納
			isStacked=true;
		}
	}
	class CalcButton extends JButton implements ActionListener{
		public CalcButton(String op) {
			super(op);
			this.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e) {
				int resultValue=Integer.valueOf(stackedtext);
				prevOp=currentOp;
				currentOp=this.getText();
				if(prevOp.equals("1")) {
					if(currentOp.equals("-")&&!isStacked)
						stackedValue-=resultValue;
					else
						stackedValue=resultValue;
				}else {
				if(prevOp.equals("+"))
					stackedValue+=resultValue;
				else if(prevOp.equals("-"))
					stackedValue-=resultValue;
				else if(prevOp.equals("×"))
					stackedValue*=resultValue;
				else if(prevOp.equals("÷"))
					stackedValue/=resultValue;
				}
			stackedtext="";
			if(currentOp.equals("=")) {
			 result.setText(String.valueOf(stackedValue));

			}else {
			appendResult(currentOp);
			}
		}
		}
	public class ClearButton extends JButton implements ActionListener{
		public ClearButton() {
			super("C");
			this.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e) {
			stackedValue=0;
			stackedtext="0";
			result.setText("");
			ans=0;
			prevOp="";
			currentOp="1";
			isStacked=false;
		}
	}
	}
