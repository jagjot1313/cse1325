import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Primes<upper> implements Runnable
{
    int heads;

    ArrayList<Integer> primes = new ArrayList<>();

    public Primes(int heads)
    {

        this.heads = 1;
    }


    void findPrimes(int lower, int upper)
    {
        for (int i = lower; i <= upper; i++)
        {

            if(isPrime(i))
            {
                primes.add(i);
            }

        }
    }

    protected boolean isPrime(int numbs)
    {
        if (numbs == 0 || numbs == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(numbs); i++)
        {
            if (numbs % i == 0)
                return false;
        }

        return  true;
    }
    protected int addPrimes(int lower, int upper )
    {
		return upper;
    	
    }
    protected int findPrimes(int lower, upper upper)
    {
		return lower;
    	
    }

    int numberOfPrimes()
    {
        return primes.size();
    }

    public Integer[] toArray()
    {

        return primes.toArray(new Integer[0]);

    }

    @Override
    public void run()
    {
        System.out.println(Arrays.toString(toArray()));
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int low, upp;
        System.out.println("Lower bound: ");
        low = in.nextInt();

        System.out.println("Upper bound: ");
        upp = in.nextInt();


        if((Integer.parseInt(args[0]))==1)
        {
            Primes<Object> absl = new Primes<Object>((Integer.parseInt(args[0])));
            absl.findPrimes(low,upp);

            for(int i=0; i< (Integer.parseInt(args[0])); ++i)
                absl.run();
        }
    }
}
