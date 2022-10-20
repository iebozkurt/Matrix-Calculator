import java.awt.*;
import javax.swing.*;


public class View extends JFrame{
	private JTextField m1r = new JTextField("1") ;
	private JTextField m1c = new JTextField("1") ;
	private JTextField m2r = new JTextField("1") ;
	private JTextField m2c = new JTextField("1") ;
	private JLabel m1L = new JLabel("First Matrix Dimensions");
	private JTextField msg = new JTextField() ;
	private JLabel m2L = new JLabel("Second Matrix Dimensions");
	protected JButton exe = new JButton("Execute");
	protected JButton show = new JButton("Show and Reset");
	private JComboBox<String> ops = new JComboBox<String>();
	
	
	int getm1r() {
		int ro = Integer.parseInt(m1r.getText()) ;	
		return ro;
	}
	int getm1c() {
		int ro = Integer.parseInt(m1c.getText()) ;	
		return ro;
	}
	int getm2r() {
		int ro = Integer.parseInt(m2r.getText()) ;	
		return ro;
	}
	int getm2c() {
		int ro = Integer.parseInt(m2c.getText()) ;	
		return ro;
	}
	void error() {
		msg.setText("Error");
		msg.setForeground(Color.RED);
	}
	void smsg(String hi, Color col) {
		msg.setText(hi);
		msg.setForeground(col);
	}
	//
	// 0 Sum 1 Subtract 2 Transpose 3 Multiply
	int getList() {
	return ops.getSelectedIndex();
	}
	
	View(){
		super("Matrix Calculator");
		setBackground(new Color(45, 188, 80));
		setLayout(new GridLayout(5,2,2,2));
		setVisible(true);
		ops.addItem("Sum");
		ops.addItem("Subtract");
		ops.addItem("Transpose");
		ops.addItem("Multiply");
		ops.addItem("Dot Multiply");
		add(m1L);
		add(m2L);
		add(m1r);
		add(m2r);
		add(m1c);
		add(m2c);
		add(ops);
		add(show);
		add(msg);
	
		
		msg.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,10));
		msg.setBackground(Color.YELLOW);
		msg.setEditable(false);
		add(exe);
		
		pack();
		setSize(600,200);
		
		Point cp = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		setLocation(cp.x- getSize().width/2,0);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	
	public static void main(String[] args) {
		new View();
	}

}
