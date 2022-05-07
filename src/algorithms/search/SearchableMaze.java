package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;

public class SearchableMaze implements ISearchable
{
    private Maze maze;

    public AState getStartState() {return new MazeState(maze.startPosition);}
    public AState getGoalState() {return new MazeState(maze.goalPosition);}

    public ArrayList<AState> getAllSuccessors(AState s)
    {
        ArrayList<AState> neighbors = new ArrayList<>();
        int row = ((MazeState)s).p.getRowIndex();
        int col = ((MazeState)s).p.getColumnIndex();
        Position p1 = maze.PositionArray[row+1][col];
        Position p2 = maze.PositionArray[row][col+1];
        Position p3 = maze.PositionArray[row-1][col];
        Position p4 = maze.PositionArray[row][col-1];
        Position p5 = maze.PositionArray[row+1][col-1];
        Position p6 = maze.PositionArray[row+1][col+1];
        Position p7 = maze.PositionArray[row-1][col+1];
        Position p8 = maze.PositionArray[row-1][col-1];
        MazeState m1 = new MazeState(p1);
        MazeState m2 = new MazeState(p2);
        MazeState m3 = new MazeState(p3);
        MazeState m4 = new MazeState(p4);
        MazeState m5 = new MazeState(p5);
        MazeState m6 = new MazeState(p6);
        MazeState m7 = new MazeState(p7);
        MazeState m8 = new MazeState(p8);
        neighbors.add(m1);
        neighbors.add(m2);
        neighbors.add(m3);
        neighbors.add(m4);
        neighbors.add(m5);
        neighbors.add(m6);
        neighbors.add(m7);
        neighbors.add(m8);
        return neighbors;
    }
}
