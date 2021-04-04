package gameoflife;

public class Cell {
    private boolean isAlive;

    Cell() {
        this.isAlive = false;
    }

    Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public String toString() {
        return isAlive ? "X" : ".";
    }

    boolean isAlive() {
        return isAlive;
    }

    void setIsAlive(boolean newState) {
        this.isAlive = newState;
    }

    static boolean processState(boolean isAlive, int nbNeighbourCellsAlive) {
        // If underpopulated or overpopulated
         if(isAlive == true && (nbNeighbourCellsAlive < 2 || nbNeighbourCellsAlive > 3 ))
            return !isAlive;
        else if(isAlive == false && nbNeighbourCellsAlive == 3 )
            return !isAlive;
        else
            return isAlive;
    }
}
