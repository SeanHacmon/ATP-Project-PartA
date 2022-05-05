package algorithms.mazeGenerators;
import java.util.Random;
public class SimpleMazeGenerator extends AMazeGenerator
{
    static int paths;
    Maze simpleMaze;
    public Maze generate(int row, int col)
    {
        Random random = new Random();
        simpleMaze = new Maze(row, col);
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (i==0 && j ==0)
                {
                    simpleMaze.maze[i][j] = 0;
                    continue;
                }
                simpleMaze.maze[i][j] = random.nextInt(2);
            }
        }
        if (getRoute(simpleMaze,row, col)<= 0)
            setRoute(simpleMaze);
        return simpleMaze;
    }

    public static void setRoute(Maze m)
    {
        int i = m.startPosition.getRowIndex();
        int j = m.startPosition.getColumnIndex();
        while (i != m.goalPosition.getRowIndex() || j != m.goalPosition.getColumnIndex())
        {
            Random ran = new Random();
            int index = ran.nextInt(2);
            if (index == 1 && legitMove(m, i+1, j))
            {
                m.maze[i + 1][j] = 0;
                i++;
            }
            else
            {
                if (legitMove(m, i, j+1))
                {
                    m.maze[i][j + 1] = 0;
                    j++;
                }
            }
        }

    }


    public static int getRoute(Maze simple, int row, int col)
    {
        Maze solGrid = new Maze(row, col);
        for (int i = 0; i < row; i++)
        {
            if (simple.maze[i][0]== 0)
                solGrid.maze[i][0]= 1;
            else break;
        }
        for (int i = 1; i < col; i++)
        {
            if (simple.maze[0][i] == 0)
                solGrid.maze[0][i] = 1;
            else break;
        }
        for (int i = 1; i < row; i++)
        {
            for (int j = 1; j < col; j++)
            {
                if (simple.maze[i][j] == 1)
                    continue;
                if (solGrid.maze[i-1][j] > 0)
                    solGrid.maze[i][j] = (solGrid.maze[i][j] + solGrid.maze[i-1][j]);
                if (solGrid.maze[i][j-1] > 0)
                    solGrid.maze[i][j] = (solGrid.maze[i][j] + solGrid.maze[i][j-1]);
            }
        }
        if (solGrid.maze[row-1][col-1] > 0)
            return solGrid.maze[row-1][col-1];
        else
            return -1;
    }

    public static boolean legitMove(Maze m, int i, int j)
    {
        return (0 <= i && i <= m.goalPosition.getRowIndex()) && (0 <= j && j <= m.goalPosition.getColumnIndex());
    }
}
