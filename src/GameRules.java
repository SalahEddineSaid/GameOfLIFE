
public interface GameRules {

	public int countNeighboursLives(int[][] grid, int x, int y);

	public void getNextGeneration();

	public boolean livMoreThanThreeNeighboursCell(int[][] grid, int x, int y);

	public boolean liveHasTwoOrThreeNeighboursCell(int[][] grid, int x, int y);

	public boolean DeadHasThreeNeighboursCell(int[][] grid, int x, int y);

	public boolean livLessThanTwoNeighboursCell(int[][] grid, int x, int y);

	public boolean isCelAlive(int element);


}
