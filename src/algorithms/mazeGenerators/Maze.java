package algorithms.mazeGenerators;

public class Maze
{
    // constructor creates an empty maze[][] & initialize 0's
    int[][] maze;
    int size_row;
    int size_col;
    public Maze(int row, int col)
    {
        this.maze = new int[row][col];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                this.maze[i][j] = 0;
            }
        }
        this.size_row = this.maze.length;
        this.size_col = this.maze[0].length;
    }
    /// accept this changes
}
