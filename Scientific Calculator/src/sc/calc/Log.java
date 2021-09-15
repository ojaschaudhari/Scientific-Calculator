package sc.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Log implements ActionListener{
	
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent l) {
		if (l.getSource() == Display.btn[33]) {
			
			if(Display.op.equals("ln")) {
				String[] n = Display.exp.split("ln");
				Display.num1 = Double.parseDouble(n[1]);
				Display.ans = Math.log(Display.num1);
				Display.record.addElement("ln(" + Display.num1 + ")" + " = " + Display.ans);
			}
			else if (Display.op.equals("log")) {
				String[] n = Display.exp.split("log");
				Display.num1 = Double.parseDouble(n[1]);
				Display.ans = Math.log10(Display.num1);
				Display.record.addElement("ln(" + Display.num1 + ")" + " = " + Display.ans);
			}
			else {
				String[] b = {"e","p"};
				for (int j = 0; j < b.length; j++) {
					if(Display.flag1.equals("ln")) {
						if(Display.op.equals(b[j])) {
							Display.ans = Math.log(Display.num1);
							Display.record.addElement("ln(" + Display.num1 + ")" + " = " + Display.ans);
						}
					}
					else if(Display.flag1.equals("log")) {
						if(Display.op.equals(b[j])) {
							Display.ans = Math.log10(Display.num1);
							Display.record.addElement("ln(" + Display.num1 + ")" + " = " + Display.ans);
						}
					}
				}
			}
		}
	}
}