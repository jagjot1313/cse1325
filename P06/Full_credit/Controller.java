
import java.util.*; 
import java.util.Scanner;
import java.util.ArrayList;


public class Controller
{
String nameStore;
int choice;

Java java=null;
Donut donut=null;
Scanner sc=new Scanner(System.in);
System.out.printf("What is the name of the store ? ");
nameStore=sc.nextLine();
Store s1=new Store(nameStore);
System.out.println("Welcome to" + s1.nameStore());
Scanner in =new Scanner(System.in);
int count=0,count1=0,daz=0;
double prr=0;
String[] showw=new String[10];

do
{
  System.out.println("\nOptions \n0) Exit\n1) Add java\n2) Add donut");
  System.out.print("Choice?");
  choice=sc..nextInt();

  switch(choice)
  {
    case1:
    int darr;
    String strr;
    double cc;

    System.outprint("\nName: ");
    strr=in.nextLine();

    System.out.print("Cost: ");
    cc=in.nextDouble();

    System.out.print("Price: ");
    prr=in.nextDouble();

    System.out.println("\n Brew Options");
    System.out.println("================);
    System.out.println("0) Blonde\n1) Light\n2) Medium\n3) Dark\n4) Extreme\n");

    System.out.print(" Which darkness ?");
    darr=in.nextlInt();
    daz=darr;

    Switch(darr)
    {
      case 0:
          java=new Java(strr, cc,prr,Darkness,BLOND);
          break;
      case 1:
          java=new Java(strr,cc, prr,Darkness,LIGHT);
          break;
      case 2:
          java=new Java(strr,cc,prr,Darkness,MEDIUM);
          break;
      case 3:
          java=new Java(strr,cc,prr,Drkness,DARK);
          break;
      case 4:
          java=new Java(strr,cc,prr,Darkness,EXTREME);
          break;
    }
    int chh

    do {
      {
        System.out.println("\n Shot Options");
        System.out.println("================);
        System.out.println("0) None\n1) Choclate\n2) Vanilla\n3) Pepermint\n4) hazelnut\n");

        System.out.print("Add shot (-1 when done) ?" );
        chh= in.nextInt();

        switch(ch)
        {
          case 0:
          java.addShot(Shot.NONE);
          sho[count]="None";
          break;

          case 1:
          java.addshot(Shot.CHOCLATE);
          sho[count]="Choclate";

          case 2:
          java.addShot(Shot.VANILLA);
          sho[count]="Pepermint";
          break;
        }
        count++;
      }
    } while (chh !=1);
    break;
    case 2:
       int froo;
       int fill;
       String ss;
       double pp;
       boolean sprinkles=false;

       System.out.print("\nName");
       strr=in.next();
       System.out.print("Cost ");
       cc=sc.nextDouble();
       System.out.print("Price: ");
       pp=sc.nextDouble();

       System.out.println("\n Frosting Options");
       System.out.println("=====================);
       System.out.println("0) Unfrosted n1) Choclate\n2) Vanilla\n3) Strawberry\n");

       System.out.print("Which Frostig?");
       froo=in.nextInt();

       System.out.println("\n Filling Options");
       System.out.println("====================);
       System.out.println("0) Unfilled\n1) Creme\n2) Bavarlan\n3) Strawberry\n");

       fill=in.nextInt();
       System.out.println("Sprinkles?(Yes/No)");

       if(s.equals("yes")|| s.equals("Yes"))
       {
         sprinkles=true;
       }

       switch(froo)
       {
         case 0:
           donut=new Donut(strr,cc,pp,Frosting,UNFROSTED,sprinkles,Filling,valus()[fill]);

         case 1:
           donut=new Donut(strr,cc,pp,Frosting,CHOCLATE,sprinkles,Filling,valus()[fill];
         case 2:
           donut=new Donut(strr,cc,pp,Frosting,VANILLA,sprinkles,Filling,valus() [fill]);
         case 3:
            donut=new Donut(strr,cc,pp,Frosting,STRAWBERRY,sprinkles,Filling,valus()[fill]);

  }
  count1=-1;
}
}
while (choice!=0);
}
public static void main(String args[]
{
  Controller control=new Controllera();
  control.cli();
}
}
