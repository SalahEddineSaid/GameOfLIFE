import java.util.Random;

public class Game implements GameRules {

	int[][] nextGenerationGrid;
	GridGame gridgame;

	public Game(GridGame gridgame) {

		this.gridgame = gridgame;

	}

	@Override
	public int countNeighboursLives(int[][] grid, int x, int y) {

		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int newcols = (x + i + grid.length) % grid.length;
				int newrows = (y + j + grid[i].length) % grid[i].length;
				sum += grid[newcols][newrows];
			}
		}

		return sum;

	}

	public void getNextGeneration() {

		System.out.println();

		int[][] nextGenerationGrid = this.gridgame.getGrid();
		for (int i = 0; i < this.gridgame.getGrid().length; i++) {
			for (int j = 0; j < this.gridgame.getGrid()[i].length; j++) {

				int element = nextGenerationGrid[i][j];

				int neighboursLives = countNeighboursLives(nextGenerationGrid, i, j);
				/*
				 * first methode if (element==0 && neighboursLives==3) {
				 * nextGenerationGrid[i][j] = 1; } else if (isAlive(element) && (neighboursLives
				 * < 2 || neighboursLives > 3)) { nextGenerationGrid[i][j] = 0; } else {
				 * nextGenerationGrid[i][j] = element;
				 * 
				 * }
				 * 
				 */

				if (DeadHasThreeNeighboursCell(nextGenerationGrid, i, j)) {
					nextGenerationGrid[i][j] = 1;
				} else if (liveHasTwoOrThreeNeighboursCell(nextGenerationGrid, i, j)) {
					nextGenerationGrid[i][j] = 1;
				} else if (livMoreThanThreeNeighboursCell(nextGenerationGrid, i, j)) {
					nextGenerationGrid[i][j] = 0;
				} else if (livLessThanTwoNeighboursCell(nextGenerationGrid, i, j)) {
					nextGenerationGrid[i][j] = 0;
				} else {
					nextGenerationGrid[i][j] = element;

				}
			}
			this.gridgame.display();

		}

		this.gridgame.setGrid(nextGenerationGrid);

	}

	@Override
	public boolean livLessThanTwoNeighboursCell(int[][] grid, int x, int y) {
		int neighboursLives = countNeighboursLives(grid, x, y);
		return isCelAlive(grid[x][y]) && neighboursLives < 2;

	}

	@Override
	public boolean DeadHasThreeNeighboursCell(int[][] grid, int x, int y) {
		int neighboursLives = countNeighboursLives(grid, x, y);
		return isCelDead(grid[x][y]) && neighboursLives == 3;
	}

	@Override
	public boolean liveHasTwoOrThreeNeighboursCell(int[][] grid, int x, int y) {
		int neighboursLives = countNeighboursLives(grid, x, y);
		return isCelAlive(grid[x][y]) && (neighboursLives == 2 || neighboursLives == 3);
	}

	@Override
	public boolean livMoreThanThreeNeighboursCell(int[][] grid, int x, int y) {
		int neighboursLives = countNeighboursLives(grid, x, y);
		return isCelAlive(grid[x][y]) && neighboursLives > 3;
	}

	@Override
	public boolean isCelAlive(int element) {
		return element == 1;
	}

	public boolean isCelDead(int element) {
		return element == 0;
	}

}
