import java.util.Random;

public class MainGameOfLife {

	public static void main(String[] args) {

		int[][] grid = null;
		
		GridGame gridgame = new GridGame(grid, 5, 5);
		
		Game game = new Game(gridgame);

		game.getNextGeneration();

	}

}
