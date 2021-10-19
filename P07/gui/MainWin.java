
import java.awt.event.ActionListner;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.util.concurrent.ThreadLoccalRandom;

public class MainWin extends JFrame
{
    private JLabel data=new JFrame;
    GridBagConstraints constraints=new GridBagConstraints();

    private boolean boole;

    public MainWin (String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setSize(400, 200);
        boole=true;
        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem quit=new JmenuItem("Quit");

        JMenu create = (JMenu) new JMenuItem("Create");
        JMenuItem jav = new JMenuItem("Java");
        JMenuItem donu = new JMenuItem("Donut");
        JMenu help = (JMenu) new JMenuItem("Help");
        JMenuItem about=new JMenuItem("About");

        jav.addActionListiner(event -> onJavaclick());
        donu.addActionListiner(event -> onDonutclick());
        quit.addActionListener(event -> onQuitClick);
        about.addActionListener(event -> onAboutClick);

        help.add(about);
        file.add(quit);
        create.add(jav);
        create.add(donu);

        menubar.add(file);
        menubar.add(create);
        menubar.add(help);

        setJMenuBar(menubar);
        setVisible(true);
        constraints.gridx=0;
        constraints.gridy=0;
    }

    protected void onAboutClick()
    {
        JDialog about=new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Java and Donut Express");

        JLabel title =new JLabel(
                "<html>"
                        +"<p><font size=+4>Nim</font></p>"
                        +"</html>");
        about.add(title);

        JLabel artists =new JLabel("<html>"
                        +"<p>Version 1.3J</p>"
                        +"<p>Copyright 2017-2020 by George F. Rice</p>"
                        +"<p>Licensed under Gnu GPL 3.0</p>"
                        +"<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
                +"<p><font size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
                +"<p>Robot by FreePik.com, licensed for personal</p>”+ “<p>and commercial purposes with attribution</p>"
                +"<p><font size=-2>”+ “https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
                +"</html>");
        about.add(artists);
        JButton okay =new JButton("OK");
        okay.addActionListener(new ActionListener()
        {publicvoidactionPerformed( ActionEvent e){
            about.setVisible(false);
        }});
        about.add(okay,BorderLayout.EAST);
        about.setSize(380,480);
        about.setVisible(true);
    }
     protected void onQuitClick()
     {
         System.exit(0);
     }

     protected void onCreateJavaClick()
     {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         GridBagConstraints constraintsLe=(GridBagConstraints) constraints.clone();

         constraintsLe.gridx=0;
         constraintsLe.gridy=0;
         constraintsLe.weightx=0;

         JButton bt1=new JButton("Java Name Dialog");
         bt1.setLayout(new BoxLayout(bt1,BoxLayout,PAGE_AXIS));

         bt1.addActionListener(
                 event -> {
                     String strName = JOptionPane.showInputDialog(this,"Java Name?");
                     if(strname !=null);
                     data.setText(strname);
                     else
                     data.setText("Nothoing Found");
                 }
                 constraints.gridy++;
                 add(bt1, constraints)
                 );

         JButton bt2=newJButton("Java Name Dialog");
         bt2.setLayout(new BoxLayout(bt2, BoxLayout.PAGE_AXIS));

         bt2.addActionListener(
                 event ->
                 {
                     String strprice = JOptionPane.showInputDialog(this,"Price?");
                     double price=Double.parseDouble(strprice);
                     if(price !=0);
                         data.setText(price);
                     else
                         data.setText("0");
                 });
         constraints.gridy++;
         add(bt2, constraints);

         JButton bt3=new JButton("Cost Dialog");
         bt3.setLayout(new BoxLayout(bt3, BoxLayout.PAGE_AXIS));

         bt3.addActionListiner(
             event ->
             {
                 String strcost=JOptionPane.showInputDialog(this,"Cost?");
                 double cost=Double.parseDouble(cost);

                 if(cost !=0)
                 data.setText(cost);
                 else
                     data.setText("0");
             }

         );
         constraits.griddy++;
         add(bt3,constraints);


         JLabel darkness=new JLabel("Darkness?");
         darkness.setHorizontalAlignment(JLabel.CENTER);
         darkness.setVerticalAlignment(JLabel.CENTER);

         add(darkness,constraintsLe);

         Darkness[] choices ={Darkness.BLOND,Darkness.MEDIUM,Darkness.DARK,Darkness.EXTREME}

         JComboBox darkne= new JComboBox<Darkness>(choices);
         darkne.setEditable(true);

         constraints.gridx=1;
         constraints.gridy=0;
         constraints.weighty=0;

         add(darkne,constraints);


         JLabel shot=new JLabel("Shot?");
         shot.setHorizontalAlignment(JLabel.CENTER);
         shot.setVerticalAlignment(JLabel,CENTER);

         constraintsLe.gridx=3;
         constraintsLe.gridy=0;
         constraintsLe.weightx=1;
         add(shot,constraintsLe);

         Shot[] choice={Shot.NONE,Shot.CHOCOLATE,Shot.VANILLA,Shot.HAZELNUT};
         JComboBox shotz=new JComboBox<Shot>(choice);
         shotz.setEditable(true);
         wellconstraints.gridx=1;

         constraints.gridy=0;
         constraints.weighty=0;
         add(shotz, constraintsLe);

         data=new JLabel();
         constraints.gridy++;
         add(data,constraints);

         JPanel panel =new JPanel();
         JButton oky =new JButton("OK");
         JButton cancel =new JButton("Cancel");
         oky.addActionListener(
                 event -> {
                     boole = false;
                     setVisible(false);
           System.out.println("Darkness = " + darkne.getSelectedItem() + "\nshots=" + shots.getSelectedItem()+\n);
                 });

         panel.add(cancel);
         constraints.gridx=0;
         constraints.gridy=4;
         constraints.gridwidth=2;
         constraints.anchor= GridBagConstraints.CENTER;
         add(panel, constraints);
         pack();

         setSize(480,450);
         setVisible(true);

     }
      protected void onCreateDonutClick()
      {
          JButton bt1=new JButton("Donut Name Dialog");
          bt1.addActionListner(
          event -> {
              String stName = JOptionPane.showInputDialog(this,"Donut Name?");
              if(stname !=null);
              data.setText(stname);
                     else
              data.setText("Nothoing Found");
          });
          constraints.gridy++;
          add(bt1, constraints);

          JButton bt2=newJButton("Price Dialog");

          bt2.addActionListener(
                  event ->
                  {
                      String tprice = JOptionPane.showInputDialog(this,"Price?");
                      double priced=Double.parseDouble(tprice);
                      if(priced !=0);
                      data.setText(tprice);
                     else
                      data.setText("0");
                  });
          constraints.gridy++;
          add(bt2, constraints);

          JButton bt3=new JButton("Cost Dialog");

          bt3.addActionListiner(
                  event ->
                  {
                      String docost=JOptionPane.showInputDialog(this,"Cost?");
                      double cost=Double.parseDouble(docost);

                      if(cost !=0)
                          data.setText(docost);
                      else
                          data.setText("0");
                  }

          );
          constraits.griddy++;
          add(bt3,constraints);


          JLabel shot=new JLabel("Fillings?");
          shot.setHorizontalAlignment(JLabel.CENTER);
          shot.setVerticalAlignment(JLabel,CENTER);

          constraintsLe.gridx=3;
          constraintsLe.gridy=0;
          constraintsLe.weightx=1;
          add(shot,constraintsLe);




      }

    public static void main(String[] args){
      MainWin jade1 = new MainWin("JADE");
      jade1.setVisible(true);
    }
    }
