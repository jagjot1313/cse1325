import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Board board = new Board(4);
		int guessCount = 0;
		while(board.solved() != true) {
			System.out.print("Guess " + guessCount + ", select 2 unmatched tiles: ");
			@SuppressWarnings("resource")
			int int1  =new Scanner(System.in).nextInt();
			@SuppressWarnings("resource")
			int int2  =new Scanner(System.in).nextInt();
			System.out.println(board.attempt(int1, int2));
			System.out.println(board.tostring());
		}
	}	
}
