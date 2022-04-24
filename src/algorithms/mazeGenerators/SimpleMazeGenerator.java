package algorithms.mazeGenerators;
import java.util.Random;
public class SimpleMazeGenerator extends AMazeGenerator
{
    public Maze generate(int row, int col)
    {
        Random random = new Random();
        Maze simpleMaze = new Maze(row, col);
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                simpleMaze.maze[i][j] = random.nextInt(2);
            }

        }
        return simpleMaze;
    }
}
