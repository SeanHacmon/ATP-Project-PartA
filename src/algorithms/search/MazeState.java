package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState
{
    protected Position p;
    public MazeState(Position position)
    {
        super();
        this.p=position;
        p.setVisited(this.isVisited());
        this.setState("{" + position.getRowIndex() + ","+ p.getColumnIndex() + "}");
        cross = false;
        distance = 0;
    }
    public void updateVisited()
    {
        if (this.isVisited())
        {
            p.setVisited(true);
        }
    }

    public String toString() {
        return "MazeState{" +
                getState() +
                '}';
    }


    public boolean isVisited()
    {
        return this.visited;
    }
    public void setVisited(boolean visited){this.visited = visited;}

//    public void updateDistance()
//    {
//        if (this.getCameFrom() != null)
//        {
//            AState father = (MazeState) this.getCameFrom();
////            int delta1 = this.p.getRowIndex() - father.p.getRowIndex();
////            int delta2 = this.p.getColumnIndex() - father.p.getColumnIndex();
//            if (!cross)
//                distance = father.distance + 1;
//            else
//                distance = father.distance + 2;
//        }
//    }
}
