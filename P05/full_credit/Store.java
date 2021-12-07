import java.util.*;
import java.util.Scanner;

public class Store{
  public void cl()
  {
    Scanner in =new Scanner(System.in) ;
    int quant, choice;
   double amt=0.0;


  Product[] arr= new Product[6];
  arr[0]= new Taxfree("Milk ($2.85)");
  arr[1]= new Taxfree("Bread ($1.99)");
  arr[2]= new Taxfree("Cheese($0.99)");
  arr[3]= new Taxed("Ice Cream($4.95)");
  arr[4]= new Taxed("Poptarts($3.49)");
  arr[5]=new Taxed("Oreos($5.99)");
  product[] car= new Product[6];
  
while(quant!=0)
{
System.out.println("==========================");
System.out.println("  Welcome to the Store") ;
System.out.println("==========================");
System.out.println("0) Milk ($2.85)");
System.out.println("1) Bread ($1.99)");
System.out.println("2) Cheese($0.99)");
System.out.println("3) Ice Cream($4.95)");
System.out.println("4) Poptarts($3.49)");
System.out.println("5) Oreos($5.99)");

System.out.println("Current Oreder:");
int count=0;

for(int i=0;i<count;i++)
{
  system.out.println(cart[i]);
}

System.out.println("The amount due is "+ truncateDecimal(amount,2));
System.out.println("Enter quantity () to complete order) and product #")
Scanner user=new Scanner(System.in);
quant=in.nextInt();

if()
choice=in.nextInt();
if (quant==0)
{
  System.out.println()
}


if( quant>0 && choice>=0 && choice<6)
}
System.out.println("")

}
public static void main(String[] args)
{
  
}


