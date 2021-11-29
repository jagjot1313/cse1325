import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Board {

	private ArrayList<Tile> tiles = new ArrayList<>();

	public Board(int tiles) {
		tiles = 4;
		String wordsArray[] = {"hello", "pop", "corn", "dog"};
		ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(wordsArray));
		System.out.println("HHH");
		Collections.shuffle(wordsList);
		System.out.println(wordsList);
		
		
		int lengInit = wordsList.size();
		for(int i = 0; i < lengInit; i++) {
			wordsList.add(wordsList.get(i));
		}
		System.out.println(wordsList);
		Collections.shuffle(wordsList);
		for(String str : wordsList) {
			this.tiles.add(new Tile(str));
		}
		Collections.shuffle(this.tiles);
		System.out.println(this.tiles);
	}

	public String attempt(int tile1, int tile2)
	{
		if(tiles.get(tile1).match(tiles.get(tile2)) == true) {
			return tiles.get(tile1).word() + " MATCHES " + tiles.get(tile2).word();
		}
		else return tiles.get(tile1).word() + " " + tiles.get(tile2).word();
	}

	public boolean solved()
	{
		for(Tile tile : tiles) {
			if(tile.matched() == false) {
				return false;
			}
		}
		return true;
	}

	public String tostring()
	{
		int count = 0;
		String boardString = "";
		for(Tile tile : tiles) {
			boardString += count +  ") " + tile.toString() + "\n";
		}
		return boardString;
	}

}
