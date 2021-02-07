package org.academiadecodigo.bootcamp.gfx.simplegfx;
import org.academiadecodigo.bootcamp.grid.SpermGridDirection;
import org.academiadecodigo.bootcamp.grid.position.SpermAbstractGridPosition;
import org.academiadecodigo.bootcamp.whales.SpermMouseHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SpermSimpleGfxGridPosition extends SpermAbstractGridPosition {

    private Picture picture;
    private OceanSimpleGfxGrid simpleGfxGrid;
    private Picture pictureLeft;
    private SpermMouseHandler mouseHandler;
    private int arpoons = 5;
    private int whalesLeft = 5;
    private boolean dead = false;

    public SpermSimpleGfxGridPosition(OceanSimpleGfxGrid grid) {

        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        picture = new Picture((int) (Math.random() * (grid.getCols()-50)+50),(int) (Math.random() * (grid.getRows()-50)+50),"src/resources/cachalot.png");
        pictureLeft = new Picture(picture.getX(),picture.getY(),"src/resources/cachaloteLeft.png");
        pictureLeft.delete();
        simpleGfxGrid = grid;
        mouseHandler = new SpermMouseHandler(picture,pictureLeft,dead);
        Mouse remi = new Mouse( mouseHandler);

        remi.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    @Override
    public void show() { picture.draw();};

    @Override
    public void hide() {
      picture.delete();
    }

    @Override
    public void moveInDirection(SpermGridDirection direction, int distance) {

        if (mouseHandler.isDead()){
            return;
        }
        int yInicial = picture.getY();
        int xInicial = picture.getX();
        super.moveInDirection(direction, distance);
        int yFinal = super.getRow();
        int xFinal= super.getCol();
        picture.translate(simpleGfxGrid.columnToX(xFinal)-xInicial, simpleGfxGrid.rowToY(yFinal)-yInicial);
        pictureLeft.translate(simpleGfxGrid.columnToX(xFinal)-xInicial, simpleGfxGrid.rowToY(yFinal)-yInicial);

        if (direction == SpermGridDirection.RIGHT) {
            show();
            pictureLeft.delete();
        }

        else if (direction == SpermGridDirection.LEFT) {
            pictureLeft.draw();
            hide();
        }

        else {
            show();
            pictureLeft.delete();
        }
    }

}
