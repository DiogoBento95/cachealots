package org.academiadecodigo.bootcamp.grid;

public enum SpermGridDirection {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public boolean isOpposite(SpermGridDirection dir) {
        return dir.equals(oppositeDirection());
    }

    public SpermGridDirection oppositeDirection() {

        SpermGridDirection opposite = null;

        switch (this) {
            case UP:
                opposite = SpermGridDirection.DOWN;
                break;
            case DOWN:
                opposite = SpermGridDirection.UP;
                break;
            case LEFT:
                opposite = SpermGridDirection.RIGHT;
                break;
            case RIGHT:
                opposite = SpermGridDirection.LEFT;
                break;
        }
        return opposite;
    }
}
