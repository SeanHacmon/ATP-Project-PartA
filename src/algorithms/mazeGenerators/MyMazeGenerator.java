package algorithms.mazeGenerators;
import kotlin.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator
{
    private Maze onlyWalls;
    private List<Position> wallSet;

    public MyMazeGenerator()
    {
        this.wallSet = new ArrayList<>() {};
        this.onlyWalls = null;
    }

    public Maze generate(int row, int col)
    {

        // creating our maze full of walls.
        onlyWalls = FullOfWalls(row, col);
        setRandomStart(row, col);
        Position pos = onlyWalls.startPosition;
        this.onlyWalls.PositionArray[pos.getRowIndex()][pos.getColumnIndex()].setVisited(true);
        WallTooPassage(pos, onlyWalls);
        AddNewWalls(onlyWalls.startPosition.getRowIndex(), onlyWalls.startPosition.getColumnIndex());

        // the Prim algorithm
        while (!wallSet.isEmpty())
        {
            Random ran = new Random();
            int index = ran.nextInt(wallSet.size());
            Position p = wallSet.get(index);
            if (!p.isVisited() && CheckAllNeighbors(onlyWalls, p))
            {
                WallTooPassage(p, onlyWalls);
                BreakBetween(onlyWalls, p);
                AddNewWalls(p.getRowIndex(), p.getColumnIndex());
            }
            wallSet.remove(p);
        }
        Random r = new Random();
        int randomPick = r.nextInt(2);
        if (randomPick==1)
            WallTooPassage(this.onlyWalls.PositionArray[row-1][col-2], onlyWalls);
        else
            WallTooPassage(this.onlyWalls.PositionArray[row-2][col-1], onlyWalls);
        WallTooPassage(this.onlyWalls.PositionArray[row-1][col-1], onlyWalls);
        return onlyWalls;
    }
    // Checking we are not out of bounds of the maze.
    public static boolean CheckBounds(Maze m, int cellR, int cellC)
    {
        return (0 <= cellC && cellC <= m.goalPosition.getRowIndex() && 0 <= cellR && cellR <= m.goalPosition.getColumnIndex());
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
    public void WallTooPassage(Position p, Maze m)
    {
        int r = p.getRowIndex();
        int c = p.getColumnIndex();
        onlyWalls.PositionArray[r][c].setVisited(true);
        m.maze[r][c] = 0;
    }

    // Adding new walls to the WallSet by a specific cell getting his neighbors.
    public void AddNewWalls(int beginRow, int beginCol)
    {
        // adds the neighbor below if it is in bound.
        if (CheckBounds(onlyWalls, beginRow+2, beginCol))
        {
            Position p2 = onlyWalls.PositionArray[beginRow + 2][beginCol];
            if (!p2.isVisited())
            {
                wallSet.add(p2);
            }
        }

        // adds the neighbor above if it is in bound.
        if (CheckBounds(onlyWalls, beginRow, beginCol+2))
        {
            Position p2 = onlyWalls.PositionArray[beginRow][beginCol + 2];
            if (!p2.isVisited())
            {
                wallSet.add(p2);
            }
        }

        // adds the neighbor from the left if it is in bound.
        if (CheckBounds(onlyWalls, beginRow-2, beginCol))
        {
            Position p2 = onlyWalls.PositionArray[beginRow-2][beginCol];
            if (!p2.isVisited())
            {
                wallSet.add(p2);
            }
        }

        // adds the neighbor from the right if it is in bound.
        if (CheckBounds(onlyWalls, beginRow, beginCol-2))
        {
            Position p2 = onlyWalls.PositionArray[beginRow][beginCol-2];
            if (!p2.isVisited())
            {
                wallSet.add(p2);
            }
        }
    }

    // Setters.
    public void setWallSet(List<Position> wallSet) {this.wallSet = wallSet;}

    public void BreakBetween(Maze m, Position p)
    {
        Position p1, p2, p3, p4;
        if (CheckBounds(m, p.getRowIndex()+2, p.getColumnIndex()))
        {
            p1 = onlyWalls.PositionArray[p.getRowIndex() + 2][p.getColumnIndex()];
            if (p1.isVisited())
            {
                Position pos = onlyWalls.PositionArray[p.getRowIndex()+1][p.getColumnIndex()];
                WallTooPassage(pos, onlyWalls);
                AddNewWalls(pos.getRowIndex(),pos.getColumnIndex());
                return;
            }

        }
        if (CheckBounds(m, p.getRowIndex(), p.getColumnIndex()+2))
        {
            p2 = onlyWalls.PositionArray[p.getRowIndex()][p.getColumnIndex() + 2];
            if (p2.isVisited())
            {
                Position pos = onlyWalls.PositionArray[p.getRowIndex()][p.getColumnIndex()+1];
                WallTooPassage(pos, onlyWalls);
                AddNewWalls(pos.getRowIndex(),pos.getColumnIndex());
                return;
            }
        }

        if (CheckBounds(m, p.getRowIndex()-2, p.getColumnIndex()))
        {
            p3 = onlyWalls.PositionArray[p.getRowIndex()-2][p.getColumnIndex()];
            if (p3.isVisited())
            {
                Position pos = onlyWalls.PositionArray[p.getRowIndex()-1][p.getColumnIndex()];
                WallTooPassage(pos, onlyWalls);
                AddNewWalls(pos.getRowIndex(),pos.getColumnIndex());
                return;
            }
        }
        if (CheckBounds(m, p.getRowIndex(), p.getColumnIndex()-2))
        {
            p4 = onlyWalls.PositionArray[p.getRowIndex()][p.getColumnIndex()-2];
            if (p4.isVisited())
            {
                Position pos = onlyWalls.PositionArray[p.getRowIndex()][p.getColumnIndex()-1];
                WallTooPassage(pos, onlyWalls);
                AddNewWalls(pos.getRowIndex(),pos.getColumnIndex());
                return;
            }
        }
    }
    public boolean CheckAllNeighbors(Maze m, Position p)
    {
        int r = p.getRowIndex();
        int c = p.getColumnIndex();
        if (CheckBounds(m, r+1, c))
            if (onlyWalls.PositionArray[r+1][c].isVisited())
                return false;
        if (CheckBounds(m, r+1, c+1))
            if (onlyWalls.PositionArray[r+1][c+1].isVisited())
                return false;
        if (CheckBounds(m, r, c+1))
            if (onlyWalls.PositionArray[r][c+1].isVisited())
                return false;
        if (CheckBounds(m, r-1, c))
            if (onlyWalls.PositionArray[r-1][c].isVisited())
                return false;
        if (CheckBounds(m, r-1, c-1))
            if (onlyWalls.PositionArray[r-1][c-1].isVisited())
                return false;
        if (CheckBounds(m, r, c-1))
            if (onlyWalls.PositionArray[r][c-1].isVisited())
                return false;
        if (CheckBounds(m, r-1, c+1))
            if (onlyWalls.PositionArray[r-1][c+1].isVisited())
                return false;
        if (CheckBounds(m, r+1, c-1))
            if (onlyWalls.PositionArray[r+1][c-1].isVisited())
                return false;
        return true;
    }

    public void setRandomStart(int row, int col)
    {
        Random r1 = new Random();
        Random r3 = new Random();
        int l = r1.nextInt(Math.min(row,col));
        int choose = r3.nextInt(2); // 0 = left, 1 = right, 2 = up, 3 = down.
        if (choose == 0)
        {
            Position p = new Position(l, 0);
            this.onlyWalls.setStartPosition(p);
//            this.onlyWalls.
//            this.onlyWalls.startPosition.setRowIndex(l);
//            this.onlyWalls.startPosition.setColumnIndex(0);
//            this.onlyWalls.PositionArray[l][0].setVisited(true);
        }

        else
        {
            Position p = new Position(l, 0);
            this.onlyWalls.setStartPosition(p);
        }
//            this.onlyWalls.startPosition.setRowIndex(0);
//            this.onlyWalls.startPosition.setColumnIndex(l);
//            this.onlyWalls.PositionArray[0][l].setVisited(true);
    }


}



