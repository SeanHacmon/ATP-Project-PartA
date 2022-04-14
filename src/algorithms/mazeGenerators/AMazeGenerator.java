package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator
{
    public long measureAlgorithmTimeMillis(int row, int col)
    {
        generate(row, col);
        long time = System.currentTimeMillis();
        return time;
    }
}
