package algorithms.mazeGenerators;

import java.awt.*;
import javax.swing.*;

public class Maze
{
    // constructor creates an empty maze[][] & initialize 0's
    int[][] maze;
    Position startPosition;
    Position goalPosition;
    int row;
    int col;
    public Maze(int row, int col)
    {
        this.maze =new int[row][col];
        this.startPosition = new Position();
        this.goalPosition = new Position();
//        this.startPosition.RowIndex = 0;
//        this.startPosition.ColumnIndex = 0;
//        this.goalPosition.RowIndex = this.maze.length-1;
//        this.goalPosition.ColumnIndex = this.maze[0].length-1;
        this.startPosition.setRowIndex(0);
        this.startPosition.setColumnIndex(0);
        this.goalPosition.setRowIndex(this.maze.length-1);
        this.goalPosition.setColumnIndex(this.maze[0].length - 1);
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                this.maze[i][j] = 0;
            }
        }
        this.row = this.maze.length;
        this.col = this.maze[0].length;
    }
    public Position getStartPosition() {return this.startPosition;}
    public Position getGoalPosition() {return this.goalPosition;}

    public void print()
    {
        for (int row = 0; row < this.maze.length; row++)
        {
            System.out.printf("%s","{ ");
            for (int col = 0; col < this.maze[0].length; col++)
            {
                if (row == startPosition.getRowIndex() && col == startPosition.getColumnIndex())
                {
                    System.out.printf("%s","S ");
                    continue;
                }
                if (row == goalPosition.getRowIndex()  && col == goalPosition.getColumnIndex())
                {
                    System.out.printf("%s","E ");
                    continue;
                }

                System.out.printf("%s",this.maze[row][col]+ " ");
            }
            System.out.printf("%s", "}\n");
        }
//        System.out.printf("%s"," }");
    }










    //******************************************************************************************************//
    // NOT PART OF THE PROJECT, FUNCTIONS TO DISPLAY THE MAZE OUTSIDE OF THE TERMINAL.
    private void initializeWindow()
    {
        JFrame mainFrame = new JFrame("MazeSolver");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(maze.length, maze[0].length));
        mainFrame.setLocationRelativeTo(null);
        for (int row = 0; row < maze.length; row++)
        {
            for (int col = 0; col < maze[0].length; col++)
            {
                if ((row == 0 && col == 0) || (row == maze.length - 1 && col == maze[0].length - 1))
                {
                    JLabel label1 = new JLabel();
                    label1.setHorizontalAlignment(JLabel.CENTER);
                    label1.setPreferredSize(new Dimension(40, 40));
                    label1.setBackground(Color.orange);
                    label1.setOpaque(true);
                    label1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    mainFrame.add(label1);
                }
                else
                {
                    JLabel label = makeLabel(maze[row][col]);
                    mainFrame.add(label);
                }
            }
        }
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    private JLabel makeLabel(int c)
    {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(40, 40));
        switch(c)
        {
            case 1:
                label.setBackground(Color.BLACK);
                break;
            case 0:
                label.setBackground(Color.WHITE);
                break;
            default:
                label.setBackground(Color.BLACK);
                break;
        }
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        return label;
    }


}
