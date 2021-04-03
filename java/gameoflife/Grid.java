package gameoflife;

import java.util.Random;

public class Grid {
    private Cell[][] cells;
    private int sizeGrid;
    private Random rd;
    int M = 10, N = 10;
    private Cell[][] futurCells = new Cell[M][N];
    private int cmpt;


    public Grid(int sizeGrid) {
        this.rd = new Random();
        this.sizeGrid = sizeGrid;
        generateRandomInitialState();
    }

    Grid(int sizeGrid, Cell[][] cells) {
        this.sizeGrid = sizeGrid;
        this.cells = cells;
    }

    private void generateRandomInitialState() {
        // Loop through every cell
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // Random generation at 50/50 chance
                if((int)Math.random() % 2 == 1){
                    cells[i][j] = new Cell(true);
                }else{
                    cells[i][j] = new Cell(false);
                }
            }
        }
    }


    public void generateNextState() {
        // Loop through every cell
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                // finding no Of Neighbours that are alive
                int cmpt = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++ )
                        if(cells[l + i][m + j].isAlive() == true)
                            cmpt += 1;


                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                if(cells[l][m].isAlive() == true)
                    cmpt -= 1;
                // Implementing the Rules of Life
                futurCells[l][m] = cells[l][m];
                // Cell dies due to over population or under population
                if (cells[l][m].isAlive() == true)
                    futurCells[l][m].setIsAlive(Cell.processState(true, cmpt));


                    // A new cell is born
                else if (cells[l][m].isAlive() == false)
                    futurCells[l][m].setIsAlive(Cell.processState(false, cmpt));
            }
        }
    }

    public String toString() {
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                futurCells[i][j].toString();
        return "";
    }
}
