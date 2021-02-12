package catchALotProject;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

// Shark class.
public class SharkKeyboardHandlerGM2 implements KeyboardHandler {

    private boolean endTime = false;
    private static final int speed = 25;
    // Pictures needed as parameters for constructor.
    private Picture sharkD;
    private Picture sharkL;

    public boolean isEndTime() {
        return endTime;
    }

    public void setEndTime(boolean endTime) {
        this.endTime = endTime;
    }

    // Constructor, with 2 pictures, (left and right).
    public SharkKeyboardHandlerGM2(Picture sharkD, Picture sharkL){
        this.sharkD = sharkD;
        this.sharkL = sharkL;
    }

    // It is what it is.
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    // Keyboard method where we define the picture/class movement.
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // To restrict/delete the shark.
        if(endTime == true){
            return;
        }

        // Decided to go with switch case, makes sense too.
        switch (keyboardEvent.getKey()) {

            // The Ifs prevent the picture from leaving the background/canvas.
            case KeyboardEvent.KEY_D:
                if(sharkL.getMaxX() >= 910 && sharkD.getMaxX() >= 910){
                    return;
                }
                sharkL.translate(speed, 0);
                sharkD.translate(speed,0);
                sharkL.delete();
                sharkD.draw();
                break;

            case KeyboardEvent.KEY_A:
                if(sharkL.getX() <= Game2.PADDING && sharkD.getX() <= Game2.PADDING){
                    return;
                }
                sharkL.translate(-speed, 0);
                sharkD.translate(-speed,0);
                sharkD.delete();
                sharkL.draw();
                break;

            case KeyboardEvent.KEY_W:
                if(sharkL.getY() <= Game2.PADDING && sharkD.getY() <= Game2.PADDING){
                    return;
                }
                sharkL.translate(0, -speed);
                sharkD.translate(0,-speed);
                sharkL.delete();
                sharkD.draw();
                break;

            case KeyboardEvent.KEY_S:
                if(sharkL.getMaxY() >= 510 && sharkD.getMaxY() >= 510){
                    return;
                }
                sharkL.translate(0, speed);
                sharkD.translate(0,speed);
                sharkL.delete();
                sharkD.draw();
                break;

        }
    }
}

