import java.util.scanner;
import java.util.array;

public class Roller
{
	public static void main(String[] args)
	{
		int dice,roll,sum;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number time the die rolls");

        dice=in.nextInt();
          
        System.out.println("Enter the faces of the die")  ;

        roll=in.nextInt();

        if(args !=2)
        {
        	System.out.println("usage: java Roller [#dices] [#sides]");

        	System.exit(0);
        }

        int[] intarray=new int[dice]; 

        for(int i=0;i<dice;i++)
        {
         intarray= (int) (Math.random()*(roll)) +1;

         sum=sum+intarray;
        }
        Arrays.sort(intarray); 

        for(int j=0;j<intarray.length;j++)
        {
        	System.out.println(intarray[j]+' ') ;
        } 
        
        System.out.println(sum);  
        System.out.println(sum/dice);
	}
}

