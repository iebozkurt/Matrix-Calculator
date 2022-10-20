import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MControl extends MView implements ActionListener{
	private Model mod;
	private double[][] smatrix;
	public static void main(String[] args) {
	//	new MControl(1,2,1);
	}
	MControl(int a, int b, int num, Model model)
	{
		super(a,b);
		mod = model;
		setActionListener();
		if (num == 1) {
			setTitle("First Array");
			grid.setBackground(new Color(255, 191, 0 ));
			setLocation(0,0);
		}
		else if(num ==2) {
			setTitle("Second Array");
			grid.setBackground(new Color(64, 224, 208));			
			setLocation(cp.x*2-getSize().width,0);
		}
		else {
			setTitle("RESULT");
			grid.setBackground(new Color(142, 68, 173));
			setLocation(cp.x-getSize().width/2,cp.y*2-getSize().height);
		}
		setVisible(true);
	}
	MControl (double[][] c, int num, Model model)
	{
		super(c.length, c[0].length, c);
		setActionListener();
		mod = model;
		if (num == 1) {
			setTitle("First Array");
			grid.setBackground(new Color(255, 191, 0 ));
			setLocation(0,0);
		}
		else if(num ==2) {
			setTitle("Second Array");
			grid.setBackground(new Color(64, 224, 208));
			setLocation(cp.x*2-getSize().width,0);
		}
		else {
			setTitle("RESULT");
			grid.setBackground(new Color(142, 68, 173));			
			setLocation(cp.x-getSize().width/2,cp.y*2-getSize().height);
		}
		setVisible(true);
	}
	
	public void setActionListener()
	{
		clear.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == clear) {clear();}
		else if(o == open) { 
			smatrix = open(getFileName());
			if ( smatrix != null)
				mod.showMatrixFromMemory(smatrix, this);
		}
		else if(o == save) {
			save(getArray(),getFileName());
			
		}
		
	}
	void  save(double[][] arr, String fn) {
		/*Double[][] sr = new Double [arr.length][arr[0].length];
		for(int i=0 ; i<arr.length;i++)
			for(int j=0; j<arr.length;j++)
				sr[i][j]=arr[i][j];*/
		try {
		FileOutputStream fos = new FileOutputStream(fn);
		ObjectOutputStream ou = new ObjectOutputStream(fos);
		ou.writeObject(arr);
		ou.close();
		fos.close();
		
		}
		catch (FileNotFoundException e) {}
		catch(IOException e) {}
		
	}
	double[][]  open(String fn) {
		//Double[][] in = null;
		double [][] arr = null;
		try {
		FileInputStream fin = new FileInputStream(fn);
		ObjectInputStream oin = new ObjectInputStream(fin);
		arr = (double[][]) oin.readObject();
		oin.close();
		fin.close();
		}
		catch (FileNotFoundException e) {}
		catch(IOException e) {} 
		catch (ClassNotFoundException e) {}
		
		/*double[][] arr = new double [in.length][in[0].length];
		for(int i=0 ; i<arr.length;i++)
			for(int j=0; j<arr.length;j++)
				in[i][j]=arr[i][j];*/
		return arr;
	}

}
