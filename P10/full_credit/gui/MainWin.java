package gui;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.regex.Pattern;

import store.*;

public class MainWin extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected enum Display {PRODUCTS, PEOPLE};

    public MainWin(String title)
    {
        super(title);

        store = new Store("JADE");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 500);

        JMenuBar menubar = new JMenuBar();

        JMenu    file     = new JMenu("File");
        JMenuItem mNew = new JMenuItem("New");
        JMenuItem mOpen = new JMenuItem("Open");
        JMenuItem mSave = new JMenuItem("Save");
        JMenuItem mSaveAs = new JMenuItem("Save As");
        JMenuItem mquit    = new JMenuItem("Quit");



        JMenu     create  = new JMenu("Create");
        JMenuItem mJava    = new JMenuItem("Java");
        JMenuItem mDonut   = new JMenuItem("Donut");
        JMenuItem mCustomer = new JMenuItem("Customer");
        JMenuItem mServer = new JMenuItem("Server");

        JMenu     mView     = new JMenu("View");
        JMenuItem mProducts = new JMenuItem("Products");
        JMenuItem mPeople   = new JMenuItem("People");

        JMenu     mHelp    = new JMenu("Help");
        JMenuItem mAbout   = new JMenuItem("About");


        mNew.addActionListener(event -> onNewClick());
        mOpen.addActionListener(event -> onOpenClick());
        mSave.addActionListener(event -> onSaveClick());
        mSaveAs.addActionListener(event -> onSaveAsClick());
        mquit .addActionListener(event -> onQuitClick());
        mJava .addActionListener(event -> onCreateJavaClick());
        mDonut.addActionListener(event -> onCreateDonutClick());
        mCustomer.addActionListener(event -> onCreateCustomerClick());
        mServer.addActionListener(event->onCreateServerClick());
        mProducts.addActionListener(event -> updateDisplay(Display.PRODUCTS));
        mPeople  .addActionListener(event -> updateDisplay(Display.PEOPLE));
        mAbout.addActionListener(event -> onAboutClick());


        file.add(mNew);
        file.add(mOpen);
        file.add(mSave);
        file.add(mSaveAs);
        file.add(mquit);

        create.add(mJava);
        create.add(mDonut);
        create.add(mCustomer);
        create.add(mServer);

        mView  .add(mProducts);
        mView  .add(mPeople);

        mHelp .add(mAbout);

        menubar.add(file);
        menubar.add(create);
        menubar.add(mView);
        menubar.add(mHelp);

        setJMenuBar(menubar);


        JToolBar toolbar = new JToolBar("JADE Controls");

        JButton bNew = new JButton(new ImageIcon("img/new.png"));
        bNew.setActionCommand("New Game");
        bNew.setToolTipText("Create a new game, discarding any in progress");
        bNew.setBorder(null);
        toolbar.add(bNew);
        bNew.addActionListener(event -> onNewClick());


        JButton bOpen = new JButton(new ImageIcon("img/open.png"));
        bOpen.setActionCommand("Open Game");
        bOpen.setToolTipText("Open a selected file and load data from that file");
        bOpen.setBorder(null);
        toolbar.add(bOpen);
        bOpen.addActionListener(event -> onOpenClick());

        JButton bSave = new JButton(new ImageIcon("img/save.png"));
        bSave.setActionCommand("Save Game");
        bSave.setToolTipText("Save existing data to the most recent file");
        bSave.setBorder(null);
        toolbar.add(bSave);
        bSave.addActionListener(event -> onSaveClick());

        JButton bSaveAs = new JButton(new ImageIcon("img/saveas.png"));
        bSaveAs.setActionCommand("Save Game");
        bSaveAs.setToolTipText("Save As file");
        bSaveAs.setBorder(null);
        toolbar.add(bSaveAs);
        bSaveAs.addActionListener(event -> onSaveAsClick());
        
        bJava  = new JButton(new ImageIcon("gui/resources/about.png"));
        bJava.setActionCommand("Create new Java");
        bJava.setToolTipText("Create a new coffee selection");
        toolbar.add(bJava);
        bJava.addActionListener(event -> onCreateJavaClick());

        bDonut = new JButton(new ImageIcon("gui/resources/about.png"));
        bDonut.setActionCommand("Create new donut");
        bDonut.setToolTipText("Create a new donut selection");
        toolbar.add(bDonut);
        bDonut.addActionListener(event -> onCreateDonutClick());

        JButton bAbout = new JButton(new ImageIcon("gui/resources/about.png"));
        bAbout.setActionCommand("About JADE Manager");
        bAbout.setToolTipText("About JADE Manager");
        toolbar.add(bAbout);
        bAbout.addActionListener(event -> onAboutClick());

       JButton bCustomer = new JButton(new ImageIcon("gui/resources/new_customer.png"));
        bCustomer.setActionCommand("Create new customer");
        bCustomer.setToolTipText("Create a new customer");
        toolbar.add(bCustomer);
        bCustomer.addActionListener(event -> onCreateCustomerClick());

        JButton bListPeople = new JButton(new ImageIcon("gui/resources/list_customers.png"));
        bListPeople.setActionCommand("List people");
        bListPeople.setToolTipText("List people");
        toolbar.add(bListPeople);
        bListPeople.addActionListener(event -> updateDisplay(Display.PEOPLE));

        JButton bServer = new JButton(new ImageIcon("gui/resources/new_customer.png"));
        bServer.setActionCommand("Create new server");
        bServer.setToolTipText("Create a new server");
        toolbar.add(bServer);
        bServer.addActionListener(event -> onCreateServerClick());

        getContentPane().add(toolbar, BorderLayout.PAGE_START);

        data = new JLabel();

        data.setFont(new Font("SansSerif", Font.BOLD, 12));

        data.setText("Welcome To JADE");


        add(data, BorderLayout.CENTER);

        msg = new JLabel();

        add(msg, BorderLayout.PAGE_END);
        setVisible(true);

        onNewClick();
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

        String Line1 = "";
        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            filename = fc.getSelectedFile();

            try(BufferedReader br = new BufferedReader(new FileReader(filename))){

                String line ;
                while((line=br.readLine())!=null)
                {
                    Line1 = Line1 + line;
                }




            }catch (Exception e){
                JOptionPane.showMessageDialog(this, "Unable to open" + filename + '\n' + e,
                        "Failed", JOptionPane.ERROR_MESSAGE);
            }
        }

        data.setText(Line1);

    }

    Java java;
    Donut donut;


    public void save(BufferedWriter bw) throws IOException
    {
        bw.write(java.toString() + '\n');
        bw.write(donut.toString() + '\n');
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

    protected void onQuitClick()
    {
        System.exit(0);
    }


    protected void onCreateJavaClick()
    {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(width,height);

        JLabel name = new JLabel("<HTML><br/>Name</HTML>");
        names = new JTextField(20);

        JLabel p = new JLabel("<HTML><br/>Price</HTML>");
        SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 0.95);
        price = new JSpinner(range);



        JLabel c = new JLabel("<HTML><br/>Cost</HTML>");
        SpinnerModel range1 = new SpinnerNumberModel(0, 0, 100, 0.95);
        cost = new JSpinner(range1);


        JLabel d = new JLabel("<HTML><br/>Darkness</HTML>");
        String[] options = {"BLOND", "LIGHT", "MEDIUM", "DARK", "EXTREME"};
        D = new JComboBox<String>(options);
        D.setEditable(true); // Allow custom types as well


        JLabel s = new JLabel("<HTML><br/>Shot</HTML>");
        String[] options1 = {"NONE", "CHOCOLATE", "VANILLA", "HAZELNUT"};
        S = new JComboBox<String>(options1);
        S.setEditable(true); // Allow custom types as well


        Object[] objects = {  // Array of widgets to display
                name,   names,
                p, price,
                c, cost,
                d, D,
                s, S};
        int button = JOptionPane.showConfirmDialog( // Show the dialog
                this,
                objects,
                "New Java",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION)  // Show data
            JOptionPane.showMessageDialog(
                    this,
                    names.getText() + " ("
                            + D.getSelectedItem() + " "
                            + S.getSelectedItem()
                            + " Price" + price.getValue() + ")");
//        try {
//            String name = getString("Java name?");
//
//            double price = getDouble("Price?");
//
//            double cost = getDouble("Cost?");
//
//            Darkness darkness = (Darkness) selectFromArray("Darkness?", Darkness.values());
//
//            java = new Java(name, price, cost, darkness);
//
//            while(true)
//            {
//                Shot shot = (Shot) selectFromArray("Shot?", Shot.values());
//
//                if(shot.equals(Shot.NONE)) break;
//                java.addShot(shot);
//            }
//            store.addProduct(java);
//
//            data.setText("<html>" + java.toString()
//                    .replaceAll("<","&lt;")
//                    .replaceAll(">", "&gt;")
//                    .replaceAll("\n", "<br/>")
//                    + "</html>");
//
//        } catch (CancelDialogException e) {
//        } catch(Exception e) {
//            msg.setText("Failed to create new Java: " + e.getMessage());
//        }
    }

    protected void onCreateDonutClick()
    {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(width,height);


        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(width,height);

        JLabel name = new JLabel("<HTML><br/>Name</HTML>");
        names = new JTextField(20);

        JLabel p = new JLabel("<HTML><br/>Price</HTML>");
        SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 0.95);
        price = new JSpinner(range);



        JLabel c = new JLabel("<HTML><br/>Cost</HTML>");
        SpinnerModel range1 = new SpinnerNumberModel(0, 0, 100, 0.95);
        cost = new JSpinner(range1);


        JLabel f = new JLabel("<HTML><br/>Shot</HTML>");
        String[] options = {"UNFROSTED", "CHOCOLATE", "VANILLA", "STRAWBERRY"};
        F = new JComboBox<String>(options);
        F.setEditable(true); // Allow custom types as well


        JLabel f1 = new JLabel("<HTML><br/>Shot</HTML>");
        String[] options1 = {"UNFILLED", "CREME", "BAVARIAN", "STRAWBERRY"};
        F1 = new JComboBox<String>(options1);
        F1.setEditable(true); // Allow custom types as well


        JLabel f2 = new JLabel("<HTML><br/>Shot</HTML>");
        String[] options2 = {"Yes Sprinkles", "No Sprinkles"};
        F2 = new JComboBox<String>(options2);
        F2.setEditable(true); // Allow custom types as well


        Object[] objects = {  // Array of widgets to display
                name,   names,
                p, price,
                c, cost,
                f, F,
                f1, F1,
                f2, F2};
        int button = JOptionPane.showConfirmDialog( // Show the dialog
                this,
                objects,
                "New Donut",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION)  // Show data
            JOptionPane.showMessageDialog(
                    this,
                    names.getText() + " ("
                            + F.getSelectedItem() + " "
                            + F1.getSelectedItem() + F2.getSelectedItem()
                            + " Price" + price.getValue() + ")");


//        try {
//            String name = getString("Donut name?");
//
//            double price = getDouble("Price?");
//
//            double cost = getDouble("Cost?");
//
//            Frosting frosting = (Frosting) selectFromArray("Select a Frosting", Frosting.values());
//
//            Filling filling = (Filling) selectFromArray("Select a Filling", Filling.values());
//
//            String[] options = {"No Sprinkles", "Sprinkles"};
//
//            boolean sprinkles = (JOptionPane.showOptionDialog(this, "Sprinkles?", "",
//
//                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
//
//                    null, options, options[0]) == 1);
//
//            donut = new Donut(name, price, cost, filling, sprinkles, frosting);
//
//            store.addProduct(donut);
//
//            data.setText("<html>" + donut.toString()
//                    .replaceAll("<","&lt;")
//                    .replaceAll(">", "&gt;")
//                    .replaceAll("\n", "<br/>")
//                    + "</html>");
//
//        } catch (CancelDialogException e) { // ignore a Cancel
//        } catch(Exception e) {
//            msg.setText("Failed to create new Donut: " + e);
//        }
    }

    protected void onAboutClick()
    {
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



    protected void onCreateCustomerClick()
    {
        // Customer Name
        JLabel lName = new JLabel("Name");
        JTextField dName = new JTextField(20);

        // Phone Number
        JLabel lPhone = new JLabel(
                "<HTML><BR/>Phone  <SMALL>(Example: 123-45-6789)</SMALL></HTML>");
        JTextField dPhone = new JTextField(20);

        Object[] objects = {
                lName,  dName,
                lPhone,   dPhone,
        };

        final Pattern phoneFormat = Pattern.compile("^(\\d{3})-(\\d{3})-(\\d{4})$");

        while(true) {
            try {
                int button = JOptionPane.showConfirmDialog(
                        this,
                        objects,
                        "New Customer",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if(button == JOptionPane.OK_OPTION) {
                    String name = dName.getText();
                    String phone = dPhone.getText();
                    if(!phoneFormat.matcher(phone).find())
                        throw new IllegalArgumentException("Invalid Phone: " + phone);
                    store.addPerson(new Customer(name, phone));
                    updateDisplay(Display.PEOPLE);
                }
                break;
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    protected void onCreateServerClick()
    {
        // Server Name
        JLabel lName = new JLabel("Name");
        JTextField dName = new JTextField(20);

        // Phone Number
        JLabel lPhone = new JLabel(
                "<HTML><BR/>Phone  <SMALL>(Example: 123-45-6789)</SMALL></HTML>");
        JTextField dPhone = new JTextField(20);

        JLabel lsocial = new JLabel(
                "<HTML><BR/>SSN  <SMALL>(Example: 123-45-6789)</SMALL></HTML>");
        JTextField dsocial = new JTextField(20);

        Object[] objects = {
                lName,  dName,
                lPhone, dPhone,
                lsocial,dsocial
        };

        final Pattern phoneFormat = Pattern.compile("^(\\d{3})-(\\d{3})-(\\d{4})$");

        while(true) {
            try {
                int button = JOptionPane.showConfirmDialog(
                        this,
                        objects,
                        "New Server",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if(button == JOptionPane.OK_OPTION) {
                    String name = dName.getText();
                    String phone = dPhone.getText();
                    String social = dsocial.getText();
                    if(!phoneFormat.matcher(phone).find())
                        throw new IllegalArgumentException("Invalid Phone: " + phone);
                    store.addPerson(new Server(name, phone, social));
                    store.addPerson(new Server(social, social, social));
                    updateDisplay(Display.PEOPLE);
                }
                break;
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void updateDisplay(Display display) {
        String s = "ERROR: Invalid display request: " + display;
        if(display == Display.PRODUCTS) s = store.toString();
        if(display == Display.PEOPLE)  s = store.peopleToString();
        data.setText("<html>" + s.replaceAll("<","&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\n", "<br/>")
                + "</html>");
    }

    protected static class CancelDialogException extends Exception
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CancelDialogException()
        {
            super("Dialog canceled");
        }
    }
    public static void main(String[] args)
    {
        MainWin myApp = new MainWin("JADE");
        myApp.setVisible(true);
    }

    private Store store;
    private JLabel data;
    private JLabel msg;
    private JButton bJava;
    private JButton bDonut;
    private File filename;

    private JTextField names;
    private JSpinner price;
    private JSpinner cost;
    private JComboBox D;
    private JComboBox S;
    private JComboBox F;
    private JComboBox F1;
    private JComboBox F2;


    private boolean canceled;

    private final static int width = 300;  // Default dialog size
    private final static int height = 110;

}
