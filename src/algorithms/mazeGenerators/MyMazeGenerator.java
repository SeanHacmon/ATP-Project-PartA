package algorithms.mazeGenerators;
import kotlin.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator
{
    private List<Position> wallSet;
    private List<Position> Visited;

    public MyMazeGenerator()
    {
        this.wallSet = new ArrayList<>() {};
        this.Visited = new ArrayList<>() {};
    }

    public Maze generate(int row, int col)
    {
        // creating our maze full of walls.
        Maze onlyWalls = FullOfWalls(row, col);
        onlyWalls.goalPosition.setRowIndex(row-1);
        onlyWalls.goalPosition.setColumnIndex(col-1);
        Random ran1 = new Random();
        Random ran2 = new Random();

        // get the random starting position on the maze.
        int beginRow = ran1.nextInt(row);
        int beginCol = ran2.nextInt(col);
        onlyWalls.startPosition.setRowIndex(beginRow);
        onlyWalls.startPosition.setColumnIndex(beginCol);
        Position p1 = new Position(beginRow, beginCol);
        Visited.add(p1);
        WallTooPassage(p1, onlyWalls);
        AddNewWalls(onlyWalls, beginRow, beginCol, wallSet);

        // the Prim algorithm
        while (!wallSet.isEmpty() && onlyWalls.maze[onlyWalls.goalPosition.getRowIndex()][onlyWalls.goalPosition.getColumnIndex()] == 1)
        {
            Random ran = new Random();
            int index = ran.nextInt(wallSet.size());
            Position p = wallSet.get(index);
            Visited.add(p);
            if (!VerifyNeighbors(onlyWalls, p))
                WallTooPassage(p, onlyWalls);
            wallSet.remove(p);
            AddNewWalls(onlyWalls, p.getRowIndex(), p.getColumnIndex(), wallSet);
        }

        return onlyWalls;
    }
    // Checking we are not out of bounds of the maze.
    public static boolean CheckBounds(Maze m, int cellR, int cellC)
    {
        return (0 <= cellC && cellC < m.maze.length && 0 <= cellR && cellR < m.maze[0].length);
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

    // Receive a pair and a maze and turns the specific cell from 1 to 0.
    public static void WallTooPassage(Position p, Maze m)
    {
        int r = p.getRowIndex();
        int c = p.getColumnIndex();
        m.maze[r][c] = 0;
    }

    // Adding new walls to the WallSet by a specific cell getting his neighbors.
    public void AddNewWalls(Maze onlyWalls, int beginRow, int beginCol, List<Position> wallSet)
    {
        // adds the neighbor below if it is in bound.
        if (CheckBounds(onlyWalls, beginRow+1, beginCol))
        {
            Position p = new Position(beginRow + 1, beginCol);
            if (!this.Visited.contains(p))
                wallSet.add(p);
        }

        // adds the neighbor above if it is in bound.
        if (CheckBounds(onlyWalls, beginRow, beginCol+1))
        {
            Position p = new Position(beginRow, beginCol+1);
            if (!this.Visited.contains(p))
                wallSet.add(p);
        }

        // adds the neighbor from the left if it is in bound.
        if (CheckBounds(onlyWalls, beginRow-1, beginCol))
        {
            Position p = new Position(beginRow-1, beginCol);
            if (!this.Visited.contains(p))
                wallSet.add(p);
        }

        // adds the neighbor from the right if it is in bound.
        if (CheckBounds(onlyWalls, beginRow, beginCol-1))
        {
            Position p = new Position(beginRow, beginCol-1);
            if (!this.Visited.contains(p))
                wallSet.add(p);
        }
    }

    // Setters.
    public void setVisited(List<Position> visited) {Visited = visited;}
    public void setWallSet(List<Position> wallSet) {this.wallSet = wallSet;}

    // Checks if a all the neighbors of a specific position are all have been visited.
    public boolean VerifyNeighbors(Maze m, Position p)
    {
        Position p1 = new Position(p.getRowIndex()+1,p.getColumnIndex());
        Position p2 = new Position(p.getRowIndex(),p.getColumnIndex()+1);
        Position p3 = new Position(p.getRowIndex()-1,p.getColumnIndex());
        Position p4 = new Position(p.getRowIndex(),p.getColumnIndex()-1);
        return ((Visited.contains(p1) || !(CheckBounds(m, p.getRowIndex()+1, p.getColumnIndex())))&&
                (Visited.contains(p2) || !(CheckBounds(m, p.getRowIndex(), p.getColumnIndex()+1)))&&
                (Visited.contains(p3) || !(CheckBounds(m, p.getRowIndex()-1, p.getColumnIndex())))&&
                (Visited.contains(p4) || !(CheckBounds(m, p.getRowIndex(), p.getColumnIndex()-1))));
    }
}


