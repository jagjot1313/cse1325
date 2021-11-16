	package store;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.IOException;
	import java.util.*;

	public class Order {

	    private int id;
	    private Customer customer;
	    private Server server;
	    private HashMap<Product, Integer> products = new HashMap<>();

	    public Order(Customer customer, Server server)
	    {
	        this.customer = customer;
	        this.server = server;
	    }

	    public Order(BufferedReader in) throws IOException
	    {

	    }

	    public void save(BufferedWriter out) throws IOException
	    {
	        out.write(id + '\n');
	        out.write(customer + "\n");
	        out.write(server + "\n");

	    }
	}

