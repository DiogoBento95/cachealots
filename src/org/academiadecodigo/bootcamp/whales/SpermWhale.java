package org.academiadecodigo.bootcamp.whales;

import org.academiadecodigo.bootcamp.gfx.simplegfx.OceanSimpleGfxGrid;
import org.academiadecodigo.bootcamp.grid.SpermGridDirection;
import org.academiadecodigo.bootcamp.grid.position.SpermGridPosition;

public class SpermWhale {

    private SpermGridPosition pos;
    private OceanSimpleGfxGrid grid;
    private int directionChangeLevel = 8;
    public final static int SPEED = 1;
    protected SpermGridDirection currentDirection;

    // Instantiates a spermwhale with a certain position
    public SpermWhale(SpermGridPosition pos) {

        this.pos = pos;

        currentDirection = SpermGridDirection.values()[(int) (Math.random() * SpermGridDirection.values().length)];

    }

    public void setGrid(OceanSimpleGfxGrid grid) {
        this.grid = grid;
    }

    // gets the spermwhale position
    public SpermGridPosition getPos() {
        return pos;
    }

    public void move() { accelerate(chooseDirection(), SPEED); }

    // whale's random directions
    public SpermGridDirection chooseDirection() {

        SpermGridDirection newDirection = currentDirection;

        if (Math.random() > ((double) directionChangeLevel) / 10) {
            newDirection = SpermGridDirection.values()[(int) (Math.random() * SpermGridDirection.values().length)];

            if (newDirection.isOpposite(currentDirection)) {
                return chooseDirection();
            }
        }

        return newDirection;

    }

    // whale's direction and speed
    public void accelerate(SpermGridDirection direction, int speed) {

        SpermGridDirection newDirection = direction;

        if (isHittingWall()) {
            newDirection = direction.oppositeDirection();
        }

        this.currentDirection = newDirection;
        for (int i = 0; i < speed; i++) {
            getPos().moveInDirection(newDirection, 1);

        }

    }

    // checks if the whales hit the wall and turns them into another direction
    public boolean isHittingWall() {

        switch (currentDirection) {
            case LEFT:
                if (getPos().getCol() == 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (getPos().getCol() == grid.getCols() - 1) {
                    return true;
                }
                break;
            case UP:
                if (getPos().getRow() == 0) {
                    return true;
                }
                break;
            case DOWN:
                if (getPos().getRow() == grid.getRows() - 1) {
                    return true;
                }
        }

        return false;

    }
}

