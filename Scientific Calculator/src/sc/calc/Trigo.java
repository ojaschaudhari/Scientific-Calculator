package sc.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trigo implements ActionListener{

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent t) {
		if(t.getSource() == Display.btn[33]) {
			String[] a = {"sin", "cos", "tan"};
			for (int i = 0; i < a.length; i++) {
				if(Display.op.equals(a[i])) {
					String[] n = Display.exp.split(a[i]);
					Display.num1 = Double.parseDouble(n[1]);
				}
			}
			if(Display.op1.equals("inv")) {
				if(Display.op.equals("sin")) {
					Display.ans = Math.toDegrees(Math.asin(Display.num1));
				}
				else if(Display.op.equals("cos")) {
					Display.ans = Math.toDegrees(Math.acos(Display.num1));
				}
				else if(Display.op.equals("tan")) {
					Display.ans = Math.toDegrees(Math.atan(Display.num1));
				}
				Display.record.addElement("Inverse of " + Display.op + " " + Display.num1 + " = " + Display.ans);
			}
			else {
				if(Display.op.equals("sin")) {
					Display.ans = Math.sin(Math.toRadians(Display.num1));
					Display.record.addElement(Display.op + " " + Display.num1 + " = " + Display.ans);
				}
				else if(Display.op.equals("cos")) {
					Display.ans = Math.cos(Math.toRadians(Display.num1));
					Display.record.addElement(Display.op + " " + Display.num1 + " = " + Display.ans);
				}
				else if(Display.op.equals("tan")) {
					Display.ans = Math.tan(Math.toRadians(Display.num1));
					Display.record.addElement(Display.op + " " + Display.num1 + " = " + Display.ans);
				}
			}
		}
	}
}