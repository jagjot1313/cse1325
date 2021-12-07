public class Store 
{
  protected String storeName;
  protected ArrayList<Product>products=new ArrayList<>();

  public Store(String storeName)
  {
    this.storeName=storeName;
  }
  public String storeName()
  {
    return StoreName;
  }
  public void addProduct(Product product)
  {
    this.products.add(products);
  }
  public int numberofProducts()
  {
    return this.product.size();
  }
  public String toString(int productindex)
  {
    return this.product.get(productindex).name;
  }
  @override
  public String toString()
  {
    String strr="Confirmed";
    return strr;
  }
}
