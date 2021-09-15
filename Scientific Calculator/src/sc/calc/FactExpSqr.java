package sc.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactExpSqr implements ActionListener{
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent f) {
		if(f.getSource() == Display.btn[33]) {
			if(Display.op.equals("!")) {
				Display.ans = 1;
				for (int i = 1; i <= Display.inum; i++) {
					Display.ans = Display.ans * i;
				}
				Display.record.addElement(Display.inum + Display.op + " = " +Display.ans);
			}
			else if (Display.op.equals("√")) {
				String[] n = Display.exp.split("√");
				Display.num1 = Double.parseDouble(n[1]);
				Display.ans = Math.sqrt(Display.num1);
				Display.record.addElement("√" + Display.num1 + " = " + Display.ans);
			}
			else if (Display.op.equals("raiseTo")) {
				String[] n = Display.exp.split("raiseTo");
				Display.num2 = Double.parseDouble(n[1]);
				Display.ans = Math.pow(Display.num1, Display.num2);
				Display.record.addElement(Display.num1 + " ^ " + Display.num2 + " = " +Display.ans);
			}
		}
	}
}