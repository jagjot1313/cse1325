package store;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JToolBar;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import store.Store;
import store.Product;
import store.Donut;
import store.Frosting;
import store.Filling;
import store.Java;
import store.Darkness;
import store.Shot;
public class Donut extends Product {
    public Donut(String name, double price, double cost, Frosting frosting, Filling filling, boolean sprinkles) {
        super(name, price, cost);
        this.frosting = frosting;
        this.filling = filling;
        this.sprinkles = sprinkles;
        if(sprinkles && frosting == Frosting.Unfrosted)
            throw new IllegalArgumentException("Unfrosted Donut cannot have sprinkles");
    }

    @Override
    public String toString() {
        return name + " ("
                + ((frosting != Frosting.Unfrosted) ? "frosted with " : "") + frosting
                + ((filling != Filling.Unfilled) ? " filled with " : " ") + filling
                + ((sprinkles) ? " add sprinkles" : "")
                + ") $" + price;
    }

    Frosting frosting;
    Filling filling;
    boolean sprinkles;
}