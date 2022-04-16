package algorithms.mazeGenerators;
import kotlin.Pair;

import java.util.List;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator
{
    private List<Pair> wallSet;
    private List<Pair> Visited;

    public Maze generate(int row, int col)
    {
        // creating our maze full of walls.
        Maze onlyWalls = FullOfWalls(row, col);
        Random ran1 = new Random();
        Random ran2 = new Random();

        // get the random starting position on the maze.
        int beginRow = ran1.nextInt(row);
        int beginCol = ran2.nextInt(col);
        Pair startPoint = new Pair(beginRow, beginCol);
        Visited.add(startPoint);

        // adds the neighbor below if it is in bound.
        if (CheckBounds(onlyWalls, beginRow+1, beginCol))
        {
            Pair p = new Pair(beginRow + 1, beginCol);
            wallSet.add(p);
        }

        // adds the neighbor above if it is in bound.
        if (CheckBounds(onlyWalls, beginRow, beginCol+1))
        {
            Pair p = new Pair(beginRow, beginCol+1);
            wallSet.add(p);
        }

        // adds the neighbor from the left if it is in bound.
        if (CheckBounds(onlyWalls, beginRow-1, beginCol))
        {
            Pair p = new Pair(beginRow-1, beginCol);
            wallSet.add(p);
        }

        // adds the neighbor from the right if it is in bound.
        if (CheckBounds(onlyWalls, beginRow, beginCol-1))
        {
            Pair p = new Pair(beginRow, beginCol-1);
            wallSet.add(p);
        }

        while (!wallSet.isEmpty())
        {
            Random ran = new Random();
            int index = ran.nextInt(wallSet.size());
            Pair p = wallSet.get(index);
            //// TODO need to continue the algorithm
        }

        
        
        
        
        
        
        return onlyWalls;
    }





    // Checking we are not out of bounds of the maze.
    public static boolean CheckBounds(Maze m, int cellR, int cellC)
    {
        if (0 <= cellC && cellC < m.maze.length && 0 < cellR && cellR < m.maze[0].length)
            return true;
        return false;
    }



    // Creates a Maze of 100% walls.
    public static Maze FullOfWalls(int row, int col)
    {
        Maze onlyWalls = new Maze(row, col);
        for (int i = 0; i < row; i++) 
        {
            for (int j = 0; j < col; j++) 
            {
                onlyWalls.maze[i][j] = 1;
            }   
        }
        return onlyWalls;
    }

}
