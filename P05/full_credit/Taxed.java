import java.util.*;

class Taxed extends Product 
{
public static double tax=0.0825;
public Taxed(String name,double unitcost)
{
 super(name,unitCost);
}
public setSalesTaxRate(double salesTaxRate)
{
tax=salesTaxRate;
}
@Override
public Product placeOrder(int quantity)
{
this.quantity=quantity;
return this;
}
@Override
public double price()
{
  double priced=this.quantity*(1+tax)*this.unitCost;
 return priced;
}

}

