[7:03 AM, 11/9/2021] Yarharth Uta: package gui;

import javax.swing.*;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.*;

import store.Store;
import store.Product;
import store.Donut;
import store.Frosting;
import store.Filling;
import store.Java;
import store.Darkness;
import store.Shot;
import store.Customer;

public class MainWin extends JFrame {

    // ///////////////////////////////////////////////////////////////////
    // Constructors

    public MainWin(String title) {
        super(title);
        store = new Store("JADE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();

        JMenu     mFile    = new JMenu("File");
        JMenuItem mnew    = new JMenuItem("New");
        JMenuItem mopen    = new JMenuItem("Open");
        JMenuItem msave    = new JMenuItem("Save");
        JMenuItem msaveAs    = new JMenuItem("Save As");
        JMenuItem Quit    = new JMenuItem("Quit");

        JMenu     mCreate  = new JMenu("Create");
        JMenuItem mJava    = new JMenuItem("Java");
        JMenuItem mDonut   = new JMenuItem("Donut");
        JMenuItem mCustomer = new JMenuItem("Customer");

        JMenu mview =new JMenu("View");
        JMenuItem mProducts = new JMenuItem("Products");
        JMenuItem mPeople = new JMenuItem("People");
        JMenu     mHelp    = new JMenu("Help");
        JMenuItem mAbout   = new JMenuItem("About");



        Quit .addActionListener(event -> onQuitClick());
        mnew.addActionListener(event -> onNewClick());
        mopen.addActionListener(event -> onOpenClick());
        msave.addActionListener(event -> onSaveClick());
        msaveAs.addActionListener(event -> onSaveAsClick());
        Quit .addActionListener(event -> onQuitClick());
        mJava .addActionListener(event -> onCreateJavaClick());
        mDonut.addActionListener(event -> onCreateDonutClick());
        mCustomer.addActionListener(event-> OnCustomerClick());
        mAbout.addActionListener(event -> onAboutClick());


        mFile.add(mnew);
        mFile.add(mopen);
        mFile.add(msave);
        mFile.add(msaveAs);
        mFile.add(Quit);


        mCreate.add(mJava);
        mCreate.add(mDonut);
        mCreate.add(mCustomer);

        mview.add(mProducts);
        mview.add(mPeople);

        mHelp  .add(mAbout);

        menubar.add(mFile);
        menubar.add(mCreate);
        menubar.add(mview);
        menubar.add(mHelp);

        setJMenuBar(menubar);

        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("JADE Controls");

        // Create the 3 buttons using the icons provided
        bJava  = new JButton(new ImageIcon("C:\\Users\\user\\IdeaProjects\\Yatharth\\src\\gui/new_java.png"));
        bJava.setActionCommand("Create new Java");
        bJava.setToolTipText("Create a new coffee selection");
        toolbar.add(bJava);
        bJava.addActionListener(event -> onCreateJavaClick());

        bDonut = new JButton(new ImageIcon("C:\\Users\\user\\IdeaProjects\\Yatharth\\src\\gui/new_donut.png"));
        bDonut.setActionCommand("Create new donut");
        bDonut.setToolTipText("Create a new donut selection");
        toolbar.add(bDonut);
        bDonut.addActionListener(event -> onCreateDonutClick());

        JButton bAbout = new JButton(new ImageIcon("C:\\Users\\user\\IdeaProjects\\Yatharth\\src\\gui/about.png"));
        bAbout.setActionCommand("About JADE Manager");
        bAbout.setToolTipText("About JADE Manager");
        toolbar.add(bAbout);
        bAbout.addActionListener(event -> onAboutClick());

        getContentPane().add(toolbar, BorderLayout.PAGE_START);


        // /////////////////////////// ////////////////////////////////////////////
        // D A T A   D I S P L A Y
        // Provide a text entry box to show output
        data = new JLabel();
        data.setFont(new Font("SansSerif", Font.BOLD, 12));
        add(data, BorderLayout.CENTER);

        // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);

        // Initialize the dislay
        updateDisplay();

        // Make everything in the JFrame visible
        setVisible(true);
    }
    protected void onNewClick()
    {
        store = new Store("Jade");
        msg.setFont(new JLabel().getFont());
        data.setText("Welcome to JADE");
    }

    protected void onOpenClick()
    {
        JFileChooser fc = new JFileChooser(filename);
        FileFilter jadeFiles = new FileNameExtensionFilter("Jade files", "jade");
        fc.addChoosableFileFilter(jadeFiles);
        fc.setFileFilter(jadeFiles);

        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            filename = fc.getSelectedFile();

            try(BufferedReader br = new BufferedReader(new FileReader(filename))){

                String line ;
                while((line=br.readLine())!=null)
                    data.setText(line + '\n');

            }catch (Exception e){
                JOptionPane.showMessageDialog(this, "Unable to open" + filename + '\n' + e,
                        "Failed", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void save(BufferedWriter bw) throws IOException
    {
        bw.write(java.toString() + '\n');
        bw.write(donut.toString() + '\n');
        bw.write(customer.toString() + '\n');
    }

    protected void onSaveClick()
    {
        JFileChooser fc = new JFileChooser(filename);
        FileFilter jadeFiles = new FileNameExtensionFilter("Jade files", "jade");
        fc.addChoosableFileFilter(jadeFiles);
        fc.setFileFilter(jadeFiles);

        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true))) {
                save(bw);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e, "Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void onSaveAsClick()
    {
        final JFileChooser fc = new JFileChooser(filename);
        FileFilter jadeFiles = new FileNameExtensionFilter("Jade Files", "jade");
        fc.addChoosableFileFilter(jadeFiles);
        fc.setFileFilter(jadeFiles);

        int result = fc.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            filename = fc.getSelectedFile();
            if(!filename.getAbsolutePath().endsWith(".jade"))
                filename = new File(filename.getAbsolutePath() + ".jade");
            onSaveClick();
        }
    }

    // ///////////////////////////////////////////////////////////////////
    // Action Listeners

    protected void onCreateJavaClick() {  // Create a new Java product
        try {
            String name = getString("Java name?");
            double price = getDouble("Price?");
            double cost = getDouble("Cost?");
            Darkness darkness = (Darkness) selectFromArray("Darkness?", Darkness.values());
            java = new Java(name, price, cost, darkness);
            while(true) {
                Shot shot = (Shot) selectFromArray("Shot?", Shot.values());
                if(shot.equals(Shot.NONE)) break;
                java.addShot(shot);
            }
            store.addProduct(java);
            updateDisplay();
        } catch (CancelDialogException e) { // ignore a Cancel
        } catch(Exception e) {
            msg.setText("Failed to create new Java: " + e.getMessage());
        }
    }

    protected void onCreateDonutClick() {  // Create a new Java product
        try {
            String name = getString("Donut name?");
            double price = getDouble("Price?");
            double cost = getDouble("Cost?");
            Frosting frosting = (Frosting) selectFromArray("Select a Frosting", Frosting.values());
            Filling filling = (Filling) selectFromArray("Select a Filling", Filling.values());
            String[] options = {"No Sprinkles", "Sprinkles"};
            boolean sprinkles = (JOptionPane.showOptionDialog(this, "Sprinkles?", "",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]) == 1);
            donut = new Donut(name, price, cost, frosting, sprinkles, filling);
            store.addProduct(donut);
            updateDisplay();
        } catch (CancelDialogException e) { // ignore a Cancel
        } catch(Exception e) {
            msg.setText("Failed to create new Donut: " + e);
        }
    }

    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.getContentPane().setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
        about.setTitle("Java and Donut Express");
        about.setSize(640,600);

        try {
            BufferedImage myPicture = ImageIO.read(new File("gui/resources/logo.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            logo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            about.add(logo);
        } catch(IOException e) {
        }

        JLabel title = new JLabel("<html>"
                + "<p><font size=+3>Java and Donut Express</font></p>"
                + "</html>");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(title);

        JLabel copyright = new JLabel("<html>"
                + "<p>Version 0.2</p>"
                + "<p>Copyright 2021 by George F. Rice</p>"
                + "<p>Licensed under Gnu GPL 3.0</p>"
                + "<br/>"
                + "</html>");
        copyright.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(copyright);

        JLabel artists = new JLabel("<html>"
                + "<p>JADE Logo by SaxDeux, licensed under CC BY-SA 3.0</p>"
                + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Logo_JADE.png</p>"
                + "<p>Flat Coffee Cup Icon by superawesomevectors, licensed under CC BY-SA 3.0</p>"
                + "<p><font size=-2>http://fav.me/dbf6otc</p>"
                + "<p><font size=-2>https://creativecommons.org/licenses/by-sa/3.0/us/</p>"
                + "<p>Donut Icon by Hazmat2 via Hyju, public domain</p>"
                + "<p><font size=-2>https://en.wikipedia.org/wiki/File:Simpsons_Donut.svg</p>"
                + "<p>Help Icon by Vector Stall via the Flat Icon license</p>"
                + "<p><font size=-2>https://www.flaticon.com/premium-icon/question-mark_3444393</p>"
                + "<br/>"
                + "</html>");
        artists.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.setAlignmentX(JButton.CENTER_ALIGNMENT);
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);

        about.pack();
        about.setVisible(true);
    }
    protected void onQuitClick() {dispose();}

    // ///////////////////////////////////////////////////////////////////
    // Utilities

    // Thrown if the Cancel button on a dialog is clicked
    protected class CancelDialogException extends Exception {
        public CancelDialogException() {
            super("Dialog canceled");
        }
    }
    private String getString(String prompt) throws CancelDialogException {
        String newPrompt = prompt;
        while(true) {
            try {
                newPrompt = JOptionPane.showInputDialog(this, newPrompt);
                if(newPrompt == null || newPrompt.length() == 0)
                    throw new CancelDialogException();
                break;
            } catch (CancelDialogException e) {
                throw e;  // Rethrow to signal Cancel was clicked
            } catch (Exception e) {
                newPrompt = "ERROR: Invalid string '" + newPrompt + "\n" + prompt;
            }
        }
        return newPrompt;
    }

    private double getDouble(String prompt) throws CancelDialogException {
        String newPrompt = prompt;
        double result = 0.0;
        while(true) {
            try {
                newPrompt = JOptionPane.showInputDialog(this, newPrompt);
                if(newPrompt == null) throw new CancelDialogException();
                result = Double.parseDouble(newPrompt);
                break;
            } catch (CancelDialogException e) {
                throw e;  // Rethrow to signal Cancel was clicked
            } catch (Exception e) {
                newPrompt = "ERROR: Invalid double '" + newPrompt + "\n" + prompt;
            }
        }
        return result;
    }

    private Object selectFromArray(String prompt, Object[] options) throws CancelDialogException {
        JComboBox<Object> comboEnum = new JComboBox<>();
        comboEnum.setModel(new DefaultComboBoxModel<Object>(options));
        int button = JOptionPane.showConfirmDialog(this, comboEnum, prompt,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.CANCEL_OPTION) throw new CancelDialogException();
        return comboEnum.getSelectedItem();
    }

    private void updateDisplay() {
        data.setText("<html>" + store.toString()
                .replaceAll("<","&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\n", "<br/>")
                + "</html>");
    }

    protected void OnCustomerClick()
    {
        JDialog cust = new JDialog((Dialog) null, "New Customer");
        
    }


    // ///////////////////////////////////////////////////////////////////
    // Main

    public static void main(String[] args) {
        MainWin myApp = new MainWin("JADE");
        myApp.setVisible(true);
    }

    // ///////////////////////////////////////////////////////////////////
    // Attributes

    private Store store;

    private JLabel data;                    // Display of output in main window
    private JLabel msg;                     // Status message display
    private JButton bJava;                  // Button to select 1 stick
    private JButton bDonut;
    private File filename;
    Java java = null;
    Donut donut = null;
    Customer customer = null;
    // Button to select 2 sticks
[7:04 AM, 11/9/2021] Yarharth Uta: protected void addPerson(Person person) {   this.persons.add(person);   }

    protected int numberOfPeople() {    return this.persons.size(); }

    protected String personToString(int productIndex) {  return this.products.get(productIndex).name;   }

    protected String personToString()
    {
        String result = "Welcome to " + storeName + "\n\n";
        for(int i=0; i<persons.size(); ++i) {
            result += i + ") " + persons.get(i) + "\n";
        }
        return result;
    }

}
