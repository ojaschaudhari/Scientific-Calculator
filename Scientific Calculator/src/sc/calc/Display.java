package sc.calc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;


public class Display extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	static double num1,num2,ans,E,P;
	static int inum;
	static String op="",op1="a",exp,flag="0",flag1="0";
	String pattern = "#,##,##,##,##,##,##,###.######";
	
	static JButton[] btn = new JButton[35];
	static JTextArea input = new JTextArea();
	String btnStr[] = {"Red","Deg","x!","(",")","%","AC","Inv","sin","ln","7","8","9","÷","π","cos","log","4","5","6","*","e","tan","√","1","2","3","-","Ans","Exp","x^y","0",".","=","+"}; 
	int x[] = {100,100,100,100,100}, y[] = {350,420,490,560,630};

	Font font = new Font("", Font.PLAIN, 40);
	@SuppressWarnings("rawtypes")
	static DefaultListModel record;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	Display() {
		Display.num1 = 0;
		Display.num2 = 0;
		Display.ans = 0;
		Display.op = "";
		Display.op1 = "";
		Display.exp = "";
		Display.P = 3.14159265359;
		Display.E = 2.71828182846;
		Display.flag1 = "";
		Display.inum = 0;
		record = new DefaultListModel();

//		DATA		
		final JList data = new JList(record);
		data.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		data.setVisibleRowCount(3);
		JScrollPane dataScroll = new JScrollPane(data);
		dataScroll.setBounds(100, 50, 820, 150);
		data.setFont(new Font("", Font.PLAIN, 25));
		add(dataScroll);
		data.setBackground(new Color(117,117,117));
		data.setForeground(Color.WHITE);
		data.setBorder(BorderFactory.createEmptyBorder());

//		INPUT
		input.setFont(font);
		input.setBounds(100, 250, 820, 50);
		input.setBackground(new Color(97,97,97));
		input.setForeground(Color.WHITE);
		add(input);

//		BUTTONS
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(btnStr[i]);
			
			if(i <= 6) {
				btn[i].setBounds(x[0], y[0], 100, 50);
				x[0] = x[0] + 120;
			}
			
			else if (i > 6 && i <= 13) {
				btn[i].setBounds(x[1], y[1], 100, 50);
				x[1] = x[1] + 120;
			}

			else if (i > 13 && i <= 20) {
				btn[i].setBounds(x[2], y[2], 100, 50);
				x[2] = x[2] + 120;
			}
			
			else if (i > 20 && i <= 27) {
				btn[i].setBounds(x[3], y[3], 100, 50);
				x[3] = x[3] + 120;
			}
			
			else if (i > 27) {
				btn[i].setBounds(x[4], y[4], 100, 50);
				x[4] = x[4] + 120;
			}
			
			
			btn[i].setFont(new Font("Times New Roman",Font.PLAIN,23));
			btn[i].setBorder(BorderFactory.createLineBorder(new Color(33,33,33), 1));
			btn[i].setBackground(Color.BLACK);
			btn[i].setForeground(new Color(255, 109, 0));
			add(btn[i]);
			if (i==33) {
				btn[33].addActionListener(new Arithmatic());
				btn[33].addActionListener(new Trigo());
				btn[33].addActionListener(new Log());
				btn[33].addActionListener(new FactExpSqr());
			}
			btn[i].addActionListener(this);
		}
		
		btn[28].setFont(new Font("Times New Roman",Font.BOLD,23));
		btn[28].setBackground(new Color(1,87,155));
		btn[28].setForeground(Color.WHITE);
		
		btn[33].setBackground(new Color(1,87,155));
		btn[33].setForeground(Color.WHITE);
		
		btn[0].setForeground(new Color(13,71,161));
		btn[1].setForeground(new Color(13,71,161));
		btn[2].setForeground(new Color(13,71,161));
		btn[7].setForeground(new Color(13,71,161));
		btn[8].setForeground(new Color(13,71,161));
		btn[9].setForeground(new Color(13,71,161));
		btn[14].setForeground(new Color(13,71,161));
		btn[15].setForeground(new Color(13,71,161));
		btn[16].setForeground(new Color(13,71,161));
		btn[20].setForeground(new Color(13,71,161));
		btn[21].setForeground(new Color(13,71,161));
		btn[22].setForeground(new Color(13,71,161));
		btn[23].setForeground(new Color(13,71,161));
		btn[29].setForeground(new Color(13,71,161));
		btn[30].setForeground(new Color(13,71,161));
		
		btn[3].setForeground(Color.RED);
		btn[4].setForeground(Color.RED);
		btn[5].setForeground(Color.RED);
		btn[6].setForeground(Color.RED);
		btn[13].setForeground(Color.RED);
		btn[20].setForeground(Color.RED);
		btn[27].setForeground(Color.RED);
		btn[34].setForeground(Color.RED);
		btn[32].setFont(new Font("Times New Roman",Font.BOLD,23));
		
		setSize(1020,780);
		setLayout(null);
		setVisible(true);
		setTitle("Scientific Calculator");
		getContentPane().setBackground(new Color(33,33,33));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed (ActionEvent e) {
//		EQUAL
		if(e.getSource() == btn[33] || e.getSource() == btn[28]) {
			if(flag.equals("ar")) {
				try {
					num2 = Double.parseDouble(input.getText());
				}
				catch (NumberFormatException ne) {
					num2 = 1;
				}
			}
			else if(flag.equals("tr")) {
				exp = input.getText();
			}
			else if (flag.equals("ln") || flag.equals("log") || op.equals("√") || op.equals("raiseTo")) {
				exp = input.getText();
				System.out.println("Dis -> " + exp);
			}
			else if(flag.equals("e")) {
				num1 = E;
			}
			else if(flag.equals("p")) {
				num1 = P;
			}
		}
		
//		FACTORIAL
		if(e.getSource() == btn[2]) {
			inum = Integer.parseInt(input.getText());
			input.append("!");
			op = "!";
		}
		
//		SQUARE ROOT
		if(e.getSource() == btn[23]) {
			op = "√";
			input.append("√");
		}
		
//		EXPONENT
		if(e.getSource() == btn[30]) {
			op = "raiseTo";
			num1 = Double.parseDouble(input.getText());
			input.append("raiseTo");
		}
		
//		LOG
		if(e.getSource() == btn[9]) {
			input.append("ln");
			op="ln";
			flag="ln";
			flag1="ln";
		}
		if(e.getSource() == btn[16]) {
			input.append("log");
			op="log";
			flag="log";
			flag1="log";
		}	
		
//		TRIGONOMETRY
		if(e.getSource() == btn[8]) {
			btn[0].setBackground(new Color(255,255,255,70));
			input.append("sin ");
			op = "sin";
			flag = "tr";
		}
		if(e.getSource() == btn[15]) {
			btn[0].setBackground(new Color(255,255,255,70));
			input.append("cos ");
			op = "cos";
			flag = "tr";
		}
		if(e.getSource() == btn[22]) {
			btn[0].setBackground(new Color(255,255,255,70));
			input.append("tan ");
			op = "tan";
			flag = "tr";
		}
		if(e.getSource() == btn[7]) {
			btn[0].setBackground(new Color(255,255,255,70));
			input.append("inv of ");
			op1 = "inv";
			flag = "tr";
		}
		
//		ARITHMATIC
		try {
			if(e.getSource() == btn[13]) {
				setEP();
				input.setText("");
				op = "/";
				flag = "ar";
			}
			if(e.getSource() == btn[20]) {
				setEP();
				input.setText("");
				op = "*";
				flag = "ar";
			}
			if(e.getSource() == btn[27]) {
				setEP();
				input.setText("");
				op = "-";
				flag = "ar";
			}
			if(e.getSource() == btn[34]) {
				setEP();
				input.setText("");
				op = "+";
				flag = "ar";
			}
			if(e.getSource() == btn[5]) {
				setEP();
				input.setText("");
				op = "%";
				flag = "ar";
			}
		}
		catch (NumberFormatException a) {
			System.out.println("Malformed Expression");
		}
		
//		NUMBERS
		
		if(e.getSource() == btn[10]) {
			input.append("7");
		}
		if(e.getSource() == btn[11]) {
			input.append("8");
		}
		if(e.getSource() == btn[12]) {
			input.append("9");
		}
		if(e.getSource() == btn[17]) {
			input.append("4"); 
		}
		if(e.getSource() == btn[18]) {
			input.append("5");
		}
		if(e.getSource() == btn[19]) {
			input.append("6");
		}
		if(e.getSource() == btn[24]) {
			input.append("1");
		}
		if(e.getSource() == btn[25]) {
			input.append("2");
		}
		if(e.getSource() == btn[26]) {
			input.append("3");
		}
		if(e.getSource() == btn[31]) {
			input.append("0");
		}
		if(e.getSource() == btn[32]) {
			input.append(".");
		}
		
		if(e.getSource() == btn[6]) {
			input.setText("");
		}
		
		if(e.getSource() == btn[21]) {
			input.setText(input.getText() + "e");
			op ="e";
			flag ="e";
		}
		
		if(e.getSource() == btn[14]) {
			input.setText(input.getText() + "π");
			op = "p";
			flag = "p";
		}
	}
	
	public void setEP() {
		if(flag.equals("e")) {
			num1 = E;
		}
		else if (flag.equals("p")) {
			num1 = P;
		}
		else {
			num1 = Double.parseDouble(input.getText());
		}
	}
}