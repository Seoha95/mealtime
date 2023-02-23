package si;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class des extends JFrame implements ActionListener{
	
	JLabel lab1 = new JLabel("¹æ¼Û±¹ÁÖ°ü");
	JLabel lab2 = new JLabel("ÅÅ·±Æ®¼±¹ß´ëÈ¸");
	JLabel lab3 = new JLabel("ÀßÇÑ ÄÚ³ÊµéÀº");
	JButton jbt1 = new JButton("³ë·¡ 10Á¡");
	JButton jbt2 = new JButton("´í½º 20Á¡");
	JButton jbt3 = new JButton("¿µ¾î¿õº¯ 30Á¡");
	JButton jbt4 = new JButton("Ã¶ÀÎ»ïÁ¾°æ±â100Á¡");
	JButton jbt5 = new JButton("¹Ì·ÎÅ»Ãâ 90Á¡");
	JButton jbt6 = new JButton("°³±× 80Á¡");
	JButton jbt7 = new JButton("ÃÑÁ¡¼ö´Â?");
	JButton jbt8 = new JButton("Ãë¼Ò");
	String[] combo = {"³ª´Â 10´ë", "³ª´Â 20´ë", "³ª´Â 30´ëÀÌ»ó"};
	JComboBox co = new JComboBox(combo);
	
	String jumsoo = "";
	int hap = 0;
	
	
	public des() {
		
		setLayout(new GridLayout(0,3,50,50));
		
		lab1.setFont(new Font("±¼¸²",Font.BOLD , 50));
		lab2.setFont(new Font("±¼¸²",Font.BOLD , 50));
		lab3.setFont(new Font("±¼¸²",Font.BOLD , 50));
		jbt1.setFont(new Font("±¼¸²",Font.BOLD , 20));
		jbt2.setFont(new Font("±¼¸²",Font.BOLD , 20));
		jbt3.setFont(new Font("±¼¸²",Font.BOLD , 20));
		jbt4.setFont(new Font("±¼¸²",Font.BOLD , 20));
		jbt5.setFont(new Font("±¼¸²",Font.BOLD , 20));
		jbt6.setFont(new Font("±¼¸²",Font.BOLD , 20));
		jbt7.setFont(new Font("±¼¸²",Font.BOLD , 20));
		jbt8.setFont(new Font("±¼¸²",Font.BOLD , 20));
		co.setFont(new Font("±¼¸²",Font.BOLD , 20));
		
		jbt7.setBackground(Color.orange);
		jbt8.setBackground(Color.yellow);
		
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		jbt3.addActionListener(this);
		jbt4.addActionListener(this);
		jbt5.addActionListener(this);
		jbt6.addActionListener(this);
		jbt7.addActionListener(this);
		jbt8.addActionListener(this);
		
		add(lab1);
		add(lab2);
		add(lab3);
		add(jbt1);
		add(jbt2);
		add(jbt3);
		add(jbt4);
		add(jbt5);
		add(jbt6);
		add(co);
		add(jbt7);
		add(jbt8);
		
		
		
		
		setSize(1250,800);
		this.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jbt1) {
			jumsoo += jbt1.getText()+"\n";
			hap = hap+ 10;
			
		}
		
		if(e.getSource() == jbt2) {
			jumsoo += jbt2.getText()+"\n";
			hap = hap+ 20;
			
		}
		if(e.getSource() == jbt3) {
			jumsoo += jbt3.getText()+"\n";
			hap = hap+ 30;
			
		}
		
		if(e.getSource() == jbt4) {
			jumsoo += jbt4.getText()+"\n";
			hap = hap+ 100;
			
		}
		
		if(e.getSource() == jbt5) {
			jumsoo += jbt5.getText()+"\n";
			hap = hap+ 90;
			
		}
		
		if(e.getSource() == jbt6) {
			jumsoo += jbt6.getText()+"\n";
			hap = hap+ 80;
			
		}
		
		if(e.getSource() == jbt7) {
			String msg = jumsoo+"ÃÑÁ¡¼ö´Â"+String.valueOf(hap)+"Á¡";
			
			JOptionPane.showConfirmDialog(jbt7,msg, "message",JOptionPane.YES_OPTION );
			
			
			jumsoo = "";
			hap = 0;
			JOptionPane.showMessageDialog(jbt8, "Ãë¼ÒÇÕ´Ï´Ù.");
		}
		
	}




	
}




public class Test {

	public static void main(String[] args) {
		
		new des();

	}

}
