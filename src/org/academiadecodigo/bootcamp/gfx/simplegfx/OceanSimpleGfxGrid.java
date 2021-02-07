package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.position.SpermGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class OceanSimpleGfxGrid {

    private Picture picture;
    public static final int PADDING = 10;
    private int cols;
    private int rows;
    private int cellSize = 10;

    public OceanSimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        picture = new Picture(PADDING,PADDING,"src/resources/sea.jpg");
    }

    public void init() {
        picture.draw();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
       return rows;
    }

    public int getCellSize() { return cellSize; }

    public SpermGridPosition makeGridPosition() { return new SpermSimpleGfxGridPosition(this); }

    public int rowToY(int row) { return row*getCellSize() + PADDING; }

    public int columnToX(int column) { return column*getCellSize() + PADDING; }

}
