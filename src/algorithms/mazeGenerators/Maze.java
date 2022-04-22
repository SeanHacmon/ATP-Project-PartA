package algorithms.mazeGenerators;

import kotlin.Pair;

public class Maze
{
    // constructor creates an empty maze[][] & initialize 0's
    int[][] maze;
    Position startPosition;
    Position goalPosition;
    int row;
    int col;
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
        this.row = this.maze.length;
        this.col = this.maze[0].length;
    }
    public void print()
    {
        ///TODO
    }
    public Position getStartPosition() {return this.startPosition;}
    public Position getGoalPosition() {return this.goalPosition;}


}
