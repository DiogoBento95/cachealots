package catchALotProject;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

// Whale class.
public class WhaleKeyboardHandlerGM2 implements KeyboardHandler {

    private boolean endTime = false;
    private static final int speed = 25;
    // Needed to restrict/delete the whale.
    private ConfirmBiteGM2 bitten;
    // Pictures needed as parameters for constructor.
    private Picture whaleL;
    private Picture whaleD;

    public boolean isEndTime() {
        return endTime;
    }

    public void setEndTime(boolean endTime) {
        this.endTime = endTime;
    }

    // Constructor, with 2 pictures, (left and right).
    public WhaleKeyboardHandlerGM2(Picture whaleL, Picture whaleD, ConfirmBiteGM2 bitten){
        this.whaleL = whaleL;
        this.whaleD = whaleD;
        this.bitten = bitten;
    }

    // It is what it is.
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    // Keyboard method where we define the picture/class movement.
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // To restrict/delete the whale.
        if(bitten.isBitten() || endTime == true){
            return;
        }

        // Decided to go with switch case, makes sense too.
        switch (keyboardEvent.getKey()) {

            // The Ifs prevent the picture from leaving the background/canvas.
            case KeyboardEvent.KEY_RIGHT:
                if(whaleL.getMaxX() >= 910 && whaleD.getMaxX() >= 910){
                    return;
                }
                whaleL.translate(speed, 0);
                whaleD.translate(speed,0);
                whaleL.delete();
                whaleD.draw();
                break;

            case KeyboardEvent.KEY_LEFT:
                if(whaleL.getX() <= 10 && whaleD.getX() <= 10 ){
                    return;
                }
                whaleL.translate(-speed, 0);
                whaleD.translate(-speed,0);
                whaleD.delete();
                whaleL.draw();
                break;

            case KeyboardEvent.KEY_UP:
                if(whaleL.getY() <= 10 && whaleD.getY() <= 10 ){
                    return;
                }
                whaleL.translate(0, -speed);
                whaleD.translate(0,-speed);
                whaleL.delete();
                whaleD.draw();
                break;

            case KeyboardEvent.KEY_DOWN:
                if(whaleL.getMaxY() >= 510 && whaleD.getMaxY() >= 510){
                    return;
                }
                whaleL.translate(0, speed);
                whaleD.translate(0,speed);
                whaleL.delete();
                whaleD.draw();
                break;

        }
    }
}
