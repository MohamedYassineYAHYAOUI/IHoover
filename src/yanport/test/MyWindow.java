package yanport.test;

import javax.swing.JFrame;

public class MyWindow extends JFrame{
	
	private static final long serialVersionUID = -3497140729756956059L;

	public  MyWindow() {
		super("app");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		MyWindow window = new MyWindow();
		window.setVisible(true);
	}
}
