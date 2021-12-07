import java.util.*;
class Taxfree extends Products 
{

public Taxfree(String name,double unicost)
{
  super(name,unicost);
}
@Override
public Product placeOrder(int qunatity )
{

  this.quantity=quantity;
  return this;
}
  @Override
public double price()
{
  double priced=this.unitCost*this.quantity;
  return priced;
}

}
