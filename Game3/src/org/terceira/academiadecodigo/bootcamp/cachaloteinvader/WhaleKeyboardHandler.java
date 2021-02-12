package org.terceira.academiadecodigo.bootcamp.cachaloteinvader;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class WhaleKeyboardHandler implements KeyboardHandler {

    private int speed = 20;
    private Picture pictureLeft;
    private Picture pictureRight;

    private boolean keyboardEndGame = false;

    public WhaleKeyboardHandler(Picture pictureLeft, Picture pictureRight) {

        this.pictureLeft = pictureLeft;
        this.pictureRight = pictureRight;
        keyboardEndGame = false;
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if(keyboardEndGame == true) {
            return;
        }

        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if(pictureRight.getMaxX() >= 950) {
                    return;
                }
                pictureLeft.delete();
                pictureRight.draw();
                pictureRight.translate(speed,0);
                pictureLeft.translate(speed,0);
                break;

            case KeyboardEvent.KEY_LEFT:
                if(pictureLeft.getX() <= Game3.PADDING) {
                    return;
                }
                pictureRight.delete();
                pictureLeft.draw();
                pictureLeft.translate(-speed,0);
                pictureRight.translate(-speed,0);
                break;

            case KeyboardEvent.KEY_UP:
                if(pictureLeft.getY() <= Game3.PADDING) {
                    return;
                }
                pictureLeft.translate(0,-speed);
                pictureRight.translate(0,-speed);
                break;

            case KeyboardEvent.KEY_DOWN:
                if(pictureLeft.getMaxY() >= 502) {
                    return;
                }
                pictureLeft.translate(0,speed);
                pictureRight.translate(0,speed);
                break;

       } }

    public boolean setKeyboardEndGameTrue() {
        return keyboardEndGame = true;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }


}
