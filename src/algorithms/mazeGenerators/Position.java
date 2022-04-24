package algorithms.mazeGenerators;

import kotlin.Pair;

import java.util.Objects;

public class Position
{
    private int RowIndex;
    private int ColumnIndex;

    public Position()
    {
        this.RowIndex = 0;
        this.ColumnIndex = 0;
    }

    public Position(int rowIndex, int columnIndex)
    {
        this.RowIndex = rowIndex;
        this.ColumnIndex = columnIndex;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return RowIndex == position.RowIndex && ColumnIndex == position.ColumnIndex;
    }

    public int hashCode() {
        return Objects.hash(RowIndex, ColumnIndex);
    }

    public int getRowIndex() {return RowIndex;}
    public void setRowIndex(int rowIndex) {RowIndex = rowIndex;}
    public int getColumnIndex() {return ColumnIndex;}
    public void setColumnIndex(int columnIndex) {ColumnIndex = columnIndex;}

    public String toString() {
        return "{"+ this.getRowIndex()+","+this.ColumnIndex+"}";
    }
}
