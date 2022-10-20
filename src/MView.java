import java.awt.*;

import javax.swing.*;
import javax.swing.JTextField;

public class MView extends JFrame {

private JTextField fileName = new JTextField(8);
protected 	JButton clear = new JButton("Clear");
protected 	JButton open = new JButton("Open");
protected 	JButton save = new JButton("Save");
protected JPanel grid;
private JTextField[] jtf;
private JPanel bottombar = new JPanel(new FlowLayout());
private int r,c;
private double[][] ar;
protected Point cp ;

public static void main(String[] args) {
	new MView(9,6);
}

	MView(int row, int column){
		super("Matrix");
		r=row;
		c=column;
		ar = new double[r][c];
		grid = new JPanel(new GridLayout(r,c,2,2));
		setLayout(new BorderLayout());
		
		jtf = new JTextField[(r*c)] ;
		
		for (int i=0;i<jtf.length;i++) {
			jtf[i] = new JTextField("0.0");
			grid.add(jtf[i]);	
		}
		
		add(grid, BorderLayout.CENTER);
		bottombar.add(clear);
		bottombar.add(open);
		bottombar.add(save);
		bottombar.add(fileName);
		
		cp = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		add(bottombar, BorderLayout.SOUTH);
		
			setSize(400,r*50+100);
			if (c>6 ) {
				if(c*50<cp.x*2 && r*50+100<cp.y*2)
					setSize(c*50,r*50+100);
				setSize(cp.x*2, cp.y*2);
			}
	}
	MView(int row, int column, double[][] rm){
		super("Matrix");
		r=row;
		c=column;
		ar = new double[r][c];
		grid = new JPanel(new GridLayout(r,c,4,4));
		setBackground(new Color(45, 188, 80));
		setLayout(new BorderLayout());
		
		jtf = new JTextField[(r*c)] ;
		
		for (int i=0;i<jtf.length;i++) {
			jtf[i] = new JTextField(Double.toString(rm[i/(rm[0].length)][i%(rm[0].length)]));
			grid.add(jtf[i]);	
		}
		
		add(grid, BorderLayout.CENTER);
		bottombar.add(clear);
		bottombar.add(open);
		bottombar.add(save);
		bottombar.add(fileName);
		cp = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		add(bottombar, BorderLayout.SOUTH);
		
		setSize(400,r*50+100);
		if (c>6) {
			if(c*50<cp.x*2 && r*50+100<cp.y*2)
				setSize(c*50,r*50+100);
			setSize(cp.x*2, cp.y*2);
		}
	}

	double[][] getArray(){
		int y=0;
		for(int i=0 ;i<r ;i++ ) {
			for (int j=0; j<c;j++) {
				ar[i][j]=Double.parseDouble((jtf[y].getText()));
			
				y++;
			}
		}
		return ar;
	}
	
	void setArray(double[][] db) {
		for (int i=0;i<jtf.length;i++) {
			jtf[i].setText(Double.toString(db[i/(db[0].length)][i%(db[0].length)]));
		}
		
	}
	void redoMatrix(double[][] ndb) {
		setVisible(false);
		grid.removeAll();
		jtf = new JTextField[(ndb.length*ndb[0].length)];
		for (int i=0;i<jtf.length;i++) {
			jtf[i] = new JTextField(Double.toString(ndb[i/(ndb[0].length)][i%(ndb[0].length)]));
			grid.add(jtf[i]);	
		}
			add(grid, BorderLayout.CENTER);		
			repaint();
			setSize(400,r*50+100);
			if (c>6)
			setSize(c*50,r*50+100);
			setVisible(true);
	}
	
	void clear() {
		for (int i=0;i<jtf.length;i++) {
			jtf[i].setText("0.0");
		}
	}
	public String getFileName() {
		return fileName.getText();
	}
}
