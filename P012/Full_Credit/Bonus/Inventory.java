package store;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.JFrame;



public class Inventory{
	private static final Component txtfield1 = null;
	public int num_donuts;
	public int num_filling;
	public boolean num_frosting;
	public int num_frosting_unfrosted;
	public int num_frosting_glazed;
	public int num_frosting_choclate;
	public int num_frosting_vanilla;
	public int num_frosting_strawberry;
	public int num_frosting_creme;
	public int num_frosting_cherry;
	
	public Inventory()
	{
		num_filling = 50;
		num_frosting=false;
		num_frosting_unfrosted=10;
		num_frosting_glazed=10;
		num_frosting_choclate=15;
		num_frosting_vanilla=10;
		num_frosting_strawberry=10;
		num_frosting_creme=10;
		num_frosting_cherry=10;
		
	}
	
	public int consumeFrostingUnfrosted()
	{
		this.num_frosting_unfrosted -= 1;
		return this.num_frosting_unfrosted;
	}
	public int consumeFrostingGlazed()
	{
		this.num_frosting_glazed -=1;
		return this.num_frosting_glazed;
	}
	public int consumeFrostingchoclate()
	{
		this.num_frosting_choclate -=1;
		return this.num_frosting_choclate;
	}
	public int consumeFrostingvanilla()
	{
		this.num_frosting_vanilla -= 1;
		return this.num_frosting_vanilla;
	}
	public int consumeFrostingstrawberry()
	{
		this.num_frosting_strawberry -= 1;
		return this.num_frosting_strawberry;
	}
	public int consumeFrostingcreme()
	{
		this.num_frosting_creme -= 1;
		return this.num_frosting_creme;
	}
	public int consumeFrostingcherry()
	{
		this.num_frosting_cherry -= 1;
		return this.num_frosting_cherry;
	}
	
	
	//
	public void displayInventory()
	{
		
		JFrame frame=new JFrame("Inventory");
		JLabel label1=new JLabel("Unfrosted");
		JLabel label2=new JLabel("Glazed");
		JLabel label3=new JLabel("Choclate");
		JLabel label4=new JLabel("Vanilla");
		JLabel label5=new JLabel("Strawberry");
		JLabel label6=new JLabel("Cherry");
		
		label1.setBounds(50,50,100,30);
		label2.setBounds(50,90,110,30);
		label3.setBounds(50,130,120,30);
		label4.setBounds(50,170,130,30);
		label5.setBounds(50,210,140,30);
		label6.setBounds(50,250,150,30);
		
		JTextField textfield1=new JTextField();
		textfield1.setBounds(150,55,100,20);
		JTextField textfield2=new JTextField();
		textfield2.setBounds(150,95,100,20);
		JTextField textfield3=new JTextField();
		textfield3.setBounds(150,135,100,20);
		JTextField textfield4=new JTextField();
		textfield4.setBounds(150,175,100,20);
		JTextField textfield5=new JTextField();
		textfield5.setBounds(150,215,100,20);
		JTextField textfield6=new JTextField();
		textfield6.setBounds(150,255,100,20);
		
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label6);
		frame.add(textfield1);
		frame.add(textfield2);
		frame.add(textfield3);
		frame.add(textfield4);
		frame.add(textfield5);
		frame.add(textfield6);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(500,500);
		frame.setVisible(true);
		
		
		
		
	}
}
