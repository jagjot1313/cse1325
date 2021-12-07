import java.util.*;

abstract class Product 
{
protected String name;
protected double unitcost;
protected int quantity;
  
public product(String name, double unitCost)  
{
  this.name=name;
  this.unitcost=unitcost;
  this.quantity=0;
}

public abstract Product placeorder Product(int qunatity);

public abstract double price();

  public String toString()
  {
    
  }

}
