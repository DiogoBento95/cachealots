package org.academiadecodigo.bootcamp.grid.position;
import org.academiadecodigo.bootcamp.grid.SpermGridDirection;

public interface SpermGridPosition {

    int getCol();

    int getRow();

    void setPos(int col, int row);

    void show();

    void hide();

    void moveInDirection(SpermGridDirection direction, int distance);

    boolean equals(SpermGridPosition position);

}
