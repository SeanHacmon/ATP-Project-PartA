package algorithms.mazeGenerators;

import kotlin.Pair;

public class Position
{
    Position startPosition;
    Position goalPosition;
    int RowIndex;
    int ColumnIndex;

    public Position(Position startPosition, Position goalPosition, int rowIndex, int columnIndex)
    {
        this.startPosition = startPosition;
        this.goalPosition = goalPosition;
        RowIndex = rowIndex;
        ColumnIndex = columnIndex;
    }

    public int getRowIndex() {return RowIndex;}
    public void setRowIndex(int rowIndex) {RowIndex = rowIndex;}
    public int getColumnIndex() {return ColumnIndex;}
    public void setColumnIndex(int columnIndex) {ColumnIndex = columnIndex;}

}
