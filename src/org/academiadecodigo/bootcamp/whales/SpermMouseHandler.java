package org.academiadecodigo.bootcamp.whales;
import org.academiadecodigo.bootcamp.Player;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.List;

public class SpermMouseHandler implements MouseHandler {

    Picture picture;
    Picture pictureLeft;
    private boolean dead;
    Player player;
    private static int whalesKilled;

    public SpermMouseHandler(Picture picture,Picture pictureLeft,boolean dead) {
        this.picture = picture;
        this.pictureLeft=pictureLeft;
        this.dead = dead;
    }

    public SpermMouseHandler(Player player) { this.player = player; }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if (picture != null) {

            if (mouseEvent.getX() >= picture.getX() + 30 &&
                    mouseEvent.getX() <= picture.getX() + 30 + 55 &&
                    mouseEvent.getY() >= picture.getY() + 45 &&
                    mouseEvent.getY() <= picture.getY() + 49 + 15) {
                picture.delete();
                pictureLeft.delete();
                dead = true;
                whalesKilled++;

                List<Shape> shapes = Canvas.getInstance().getShapes();

                if (shapes.size() == 2) {
                    Picture pictureWin = new Picture(150,40,"src/resources/win.png");
                    pictureWin.draw();
                    return;
                }
                return;
            }
        }


        if (player != null) {

            if (player.getArpoons()>0){
                player.shoot();
            }

            if (player.getArpoons() == 0 && whalesKilled!=3) {
                    Picture pictureSea = new Picture(10,10,"src/resources/sea.jpg");
                    pictureSea.draw();
                    Picture pictureLose = new Picture(200,50,"src/resources/gameover.png");
                    pictureLose.draw();
                }
        }
    }

    public boolean isDead(){
        return dead;
    }

    public static void setWhalesKilled(int whalesKilled) { SpermMouseHandler.whalesKilled = whalesKilled; }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) { }
}
