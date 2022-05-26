package algorithms.search;

import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Position;
import org.junit.jupiter.api.Test;

import java.io.Console;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest
{
    // Constructor for best search & bfs & dfs algorithm.
    BestFirstSearch best = new BestFirstSearch();
    BreadthFirstSearch bfs = new BreadthFirstSearch();

    MyMazeGenerator mmg = new MyMazeGenerator();
    EmptyMazeGenerator emg = new EmptyMazeGenerator();

    @Test // Test1
    public void testSearchEmpty() throws Exception
    {
        try {
            // Created a few types of mazes to check edge cases.
            Maze m0 = new Maze(1, 1);

            // Created a searchable mazes by the mazes we have created.
            SearchableMaze emptyMaze = new SearchableMaze(m0);

            // get Array + state.
            AState x0 = best.search(emptyMaze);
            Solution s0 = best.solve(emptyMaze);

            // Check we get a null result from an 0x0 maze.
            assertNull(x0);
            assertNotNull(s0);
        }
        catch (Exception e){e.getMessage();}

    }
    @Test // Test2
    public void TestSearchPrim() throws Exception
    {
        Maze m2 = mmg.generate(2, 2);

        // initialize a new maze by prim algo.
        SearchableMaze primMaze = new SearchableMaze(m2);

        // gets the solution that contains an array of states.
        Solution s2 = best.solve(primMaze);
        ArrayList<AState> sol2 = s2.getSolutionPath();

        // Check prim algorithm maze 2x2 with best search algorithm (best take the lowest cost which is start and end).
        assertTrue (sol2.size() <= 2);

    }
    @Test // Test3
    public void TestSearch3x3() throws Exception
    {
        Maze m1 = emg.generate(3, 3);

        SearchableMaze normalMaze = new SearchableMaze(m1);

        Solution s1 = best.solve(normalMaze);

        // Checking Best search grabs only the states that are in cross.
        ArrayList<AState> sol1 = s1.getSolutionPath();

        AState curr1 = sol1.get(0);
        AState curr2 = sol1.get(1);
        AState curr3 = sol1.get(2);

        assertEquals(curr1.getState(), "{0,0}");
        assertEquals(curr2.getState(), "{1,1}");
        assertEquals(curr3.getState(), "{2,2}");
    }

    @Test // Test4
    public void countEvaluated() throws Exception
    {
        Maze m = mmg.generate(100, 100);
        SearchableMaze maze100x100 = new SearchableMaze(m);

        Solution s1 = bfs.solve(maze100x100);

        Solution s2 = best.solve(maze100x100);

        assertFalse(s1.states.size() > s2.states.size());
    }

    @Test // Test5
    public void getBestPath() throws Exception
    {
        Maze m = emg.generate(10,10);
        Position p = new Position(0, 9);
        m.setStartPosition(p);
        SearchableMaze maze10x10 = new SearchableMaze(m);
        Solution s = best.solve(maze10x10);
        ArrayList<AState> path = s.getSolutionPath();
        assertEquals(path.size(), 10);
    }

}