package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator
{
    public Maze generate(int row, int col)
    {
        Maze emptyMaze = new Maze(row, col);
        return emptyMaze; // the default maze has only 0's.
    }
}
