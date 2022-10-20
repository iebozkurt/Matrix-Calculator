import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Control extends View implements ActionListener{

	public static void main(String[] args) {
		new Control();
	}

	private Model m =new Model();
	Control(){
		exe.addActionListener(this);
		show.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == exe) {
			
			
			switch(getList()) {
			
			case 0:			
				if(m.sumMatrix());
				else
					smsg("Dimensions of both matrices need to be same", Color.RED);							
				break;
			case 1:
				if(m.subtractMatrix());
				else 
					smsg("Dimensions of both matrices need to be same", Color.RED);	
					
				break;
			case 2:
				m.transposeMatrix();
				smsg("Only first matrix is trasposed", Color.black);
				break;
				
			case 3:
				if(m.multiplyMatrix());
				else 
					smsg("Columns of the 1st need to be same with the rows of the 2nd", Color.RED);	
				break;
		
			
			case 4:
				if(m.dotmultiplyMatrix());
				else 
				smsg("Columns of the 1st need to be same with the rows of the 2nd", Color.RED);	
				break;		
		}
			
		}
		
		else if (o== show) {
			if( 0<getm1r() && 0<getm1c() && 0<getm2r() && 0<getm2c())
				m.showInputMatrix(getm1r() ,getm1c() , getm2r(), getm2c());
			else
				smsg("Please don't try the edge cases.", Color.BLACK);
		}				
	}
	
	
}
