
public class GridGame {

	int[][] grid;
	Cell c = new Cell();

	public GridGame() {

	}

	public GridGame(int[][] grid, int cols, int rows) {

		this.grid = new int[cols][rows];

		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {

				this.grid[i][j] = c.generateCel();

			}
		}
	}

	public void display() {
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid[0].length; j++) {

				System.out.print(this.grid[i][j]);
			}
			System.out.println();
		}

	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	public Cell getC() {
		return c;
	}

	public void setC(Cell c) {
		this.c = c;
	}

	public void setupGame(int cols, int rows) {

		this.grid = new int[cols][rows];

		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {

				this.grid[i][j] = c.generateCel();

			}
		}

	}
}
