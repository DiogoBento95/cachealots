package org.academiadecodigo.bootcamp.grid.position;
import org.academiadecodigo.bootcamp.gfx.simplegfx.OceanSimpleGfxGrid;
import org.academiadecodigo.bootcamp.grid.SpermGridDirection;

public abstract class SpermAbstractGridPosition implements SpermGridPosition {

    private int col;
    private int row;
    private OceanSimpleGfxGrid grid;

    public SpermAbstractGridPosition(int col, int row, OceanSimpleGfxGrid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    public OceanSimpleGfxGrid getGrid() { return grid; }

    public void moveUp(int dist) {
        int maxRowsUp = dist < getRow() ? dist : getRow();
        setPos(getCol(), getRow() - maxRowsUp);
    }

    public void moveDown(int dist) {
        int maxRowsDown = dist > getGrid().getRows() - (getRow() + 1) ? getGrid().getRows() - (getRow() + 1) : dist;
        setPos(getCol(), getRow() + maxRowsDown);
    }

    public void moveLeft(int dist) {
        int maxRowsLeft = dist < getCol() ? dist : getCol();
        setPos(getCol() - maxRowsLeft, getRow());
    }

    public void moveRight(int dist) {
        int maxRowsRight = dist > getGrid().getCols() - (getCol() + 1) ? getGrid().getCols() - (getCol() + 1) : dist;
        setPos(getCol() + maxRowsRight, getRow());
    }

    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    @Override
    public int getCol() { return col; }

    @Override
    public int getRow() { return row; }

    @Override
    public void moveInDirection(SpermGridDirection direction, int distance) {

        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }
    }

    @Override
    public boolean equals(SpermGridPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
    }

}
