import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.*;

	class pracone {
    public static void main(String[] args) {
    	JFrame f1=new JFrame("First Frame");// to create and name the frame 
    	JLabel label=new JLabel();
    	label.setText("Class Add shots");//set text in label
    	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ImageIcon image=new ImageIcon("img1.jpg");
    	f1.setIconImage(image.getImage());
    	f1.getContentPane().setBackground(new Color(32,132,232));
    	f1.setSize(400,500);
    	f1.add(label);

    	
    	JMenuBar menu=new JMenuBar();
    	JMenu m1=new JMenu("File");
    	JMenu m2=new JMenu("About");
    	JMenuItem i1=new JMenuItem("Cofee");
    	JMenuItem i2=new JMenuItem("Extra shots");
    	JMenuItem i3=new JMenuItem("Appetisers");
    	m1.add(i1);
    	m1.add(i2);
    	m1.add(i3);
      	menu.add(m1);
    	menu.add(m2);
    	JButton b1=new JButton("Click");
    	JLabel l1 = new JLabel("");
    	l1.setSize(350, 100);
    	b1.setBounds(130,100,100,40);
    	f1.setJMenuBar(menu);
    	f1.add(b1);
    	f1.add(l1);
    	f1.setLayout(null);
    	//JLabel can be said as a display area for a string text or image
    	
    	b1.addActionListener( new ActionListener() {
    		public void actionPerformed(ActionEvent e ) {
    			l1.setText("L1 label is on.\n");
    			String s1="The Message box is on";
    			JOptionPane.showMessageDialog(b1,s1);
    		}
    	});
    	i1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e)
    		{
    			JFrame coffeeFrame = new JFrame("Coffee");
    			coffeeFrame.setSize(400,400);
    			
    			JPanel coffeePanel = new JPanel();
    			ButtonGroup g1=new ButtonGroup();
    			JRadioButton j1=new JRadioButton();
    			JRadioButton j2=new JRadioButton();
    			JRadioButton j3=new JRadioButton();
    			j1.setBounds(120,30,120,50);
    			j2.setBounds(130,30,120,50);
    			j3.setBounds(140,30,120,50);
    			j1.setText("Small");
    			j2.setText("Medium");
    			j3.setText("Large");
    			g1.add(j1);
    			g1.add(j2);
    			g1.add(j3);

    			coffeePanel.add(j1);
    			coffeePanel.add(j2);
    			coffeePanel.add(j3);    			
    			coffeeFrame.add(coffeePanel);
    			coffeeFrame.show();
    			
    			coffeeFrame.setLayout(null);
    			coffeeFrame.setVisible(true);
    			
    			
    		}		
    	});
    
    	
    	f1.setVisible(true);
    	System.out.println("Hello World");

    	
		}
	    	
}
