package algorithms.search;

import algorithms.mazeGenerators.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {

    @Test
    public void search(ISearchable s) throws Exception
    {
        Maze m0 = new Maze(0, 0);
        Maze m1 = new Maze(10, 10);

        SearchableMaze emptyMaze = new SearchableMaze(m0);
        SearchableMaze normalMaze = new SearchableMaze(m1);

        BestFirstSearch best = new BestFirstSearch();

        AState x0 = best.search(emptyMaze);
        AState x1 = best.search(normalMaze);



        assertNull(x0);
//        assertEquals(x1,);
    }

    @Test
    void updateCost() {
    }

    @Test
    void getNumberOfNodesEvaluated() {
    }
}