package sc.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Arithmatic implements ActionListener{

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == Display.btn[33]) {
			if(Display.op.equals("/")) {
				Display.ans = Display.num1 / Display.num2;
				Display.record.addElement(Display.num1 + "  " + Display.op + "  " + Display.num2 + " = " + Display.ans);
			}
			else if (Display.op.equals("*")) {
				Display.ans = Display.num1 * Display.num2;
				Display.record.addElement(Display.num1 + "  " + Display.op + "  " + Display.num2 + " = " + Display.ans);
			}
			else if (Display.op.equals("+")) {
				Display.ans = Display.num1 + Display.num2;
				Display.record.addElement(Display.num1 + "  " + Display.op + "  " + Display.num2 + " = " + Display.ans);
			}
			else if (Display.op.equals("-")) {
				Display.ans = Display.num1 - Display.num2;
				Display.record.addElement(Display.num1 + "  " + Display.op + "  " + Display.num2 + " = " + Display.ans);
			}
			else if (Display.op.equals("%")) {
				Display.ans = (Display.num1 * Display.num2)/100;
				Display.record.addElement(Display.num1 + "  " + Display.op + "  " + Display.num2 + " = " + Display.ans);
			}
			Display.input.setText(Double.toString(Display.ans));
		}
	}
}