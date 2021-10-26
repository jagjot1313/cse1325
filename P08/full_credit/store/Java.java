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

import java.util.ArrayList;

public class Java extends Product {
    public Java(String name, double price, double cost, Darkness darkness) {
        super(name, price, cost);
        this.darkness = darkness;
        this.shots = new ArrayList<>();
    }
    public void addShot(Shot shot) {
        shots.add(shot);
    }
    @Override
    public String toString() {
        String result = name + " (" + darkness + " with ";
        if (shots.size() == 0) result += "no shots";
        else {
            String separator = "";
            for(Shot s : shots) {
                result += separator + s;
                separator = ", ";
            }
        }
        result += ") $" + price;
        return result;
    }

    Darkness darkness;
    ArrayList<Shot> shots;
}