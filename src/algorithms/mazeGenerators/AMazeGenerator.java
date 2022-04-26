package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator
{
    public long measureAlgorithmTimeMillis(int row, int col)
    {
        long first = System.currentTimeMillis();
        this.generate(row, col);
        long second = System.currentTimeMillis();
        return second - first;
    }
}
