package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator
{
    public long measureAlgorithmTimeMillis(int row, int col)
    {
//        this.generate(row, col);
        return System.currentTimeMillis();
    }
    
}
