import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Prob92 extends JFrame {
	private static final long serialVersionUID = 1L;

	JPanel contentPane = new JPanel();
	BorderLayout borderLayout1 = new BorderLayout();
	JTextField result = new JTextField(""); //計算結果を表示するテキストフィールド

	public static void main(String[] args) {
		Prob92 app=new Prob92();
	}
	//フレームのビルド
	public Prob92() {
		contentPane.setLayout(borderLayout1);
		this.setSize(new Dimension(250, 300));
		this.setTitle("電子式卓上計算機");
		this.setContentPane(contentPane);

		contentPane.add(result, BorderLayout.NORTH); //テキストフィールドを配置

		JPanel keyPanel = new JPanel(); //ボタンを配置するパネルを用意
		keyPanel.setLayout(new GridLayout(4, 4)); //4行4列のGridLayoutにする
		contentPane.add(keyPanel, BorderLayout.CENTER);

		keyPanel.add(new NumberButton("7"), 0); //ボタンをレイアウトにはめこんでいく
		keyPanel.add(new NumberButton("8"), 1);
		keyPanel.add(new NumberButton("9"), 2);
		keyPanel.add(new JButton("÷"), 3);
		keyPanel.add(new NumberButton("4"), 4);
		keyPanel.add(new NumberButton("5"), 5);
		keyPanel.add(new NumberButton("6"), 6);
		keyPanel.add(new JButton("×"), 7);
		keyPanel.add(new NumberButton("1"), 8);
		keyPanel.add(new NumberButton("2"), 9);
		keyPanel.add(new NumberButton("3"), 10);
		keyPanel.add(new JButton("－"), 11);
		keyPanel.add(new NumberButton("0"), 12);
		keyPanel.add(new JButton("."), 13);
		keyPanel.add(new JButton("＋"), 14);
		keyPanel.add(new JButton("＝"), 15);

		contentPane.add(new JButton("C"), BorderLayout.SOUTH);//Cボタンを配置する
		this.setVisible(true);
	}
	/* テキストフィールドに引数の文字列をつなげる */
	public void appendResult(String c) {
		result.setText(result.getText() + c);
	}

	/* 数字を入力するボタンの定義 */
	public class NumberButton extends JButton implements ActionListener {
		private static final long serialVersionUID = 1L;

		public NumberButton(String keyTop) {
			super(keyTop); //JButtonクラスのコンストラクタを呼び出す
			this.addActionListener(this); //このボタンにアクションイベントのリスナを設定
		}

		public void actionPerformed(ActionEvent evt) {
			String keyNumber = this.getText(); //ボタンの名前を取り出す
			appendResult(keyNumber); //ボタンの名前をテキストフィールドにつなげる
		}
	}

}