package catchALotProject;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

//Shark class.
public class SharkKeyboardHandler implements KeyboardHandler {

    private int speed = 20;
    //Pictures needed as parameters for constructor.
    private Picture sharkD;
    private Picture sharkL;

    //Constructor, with 2 pictures, (left and right).
    public SharkKeyboardHandler(Picture sharkD,Picture sharkL){
        this.sharkD = sharkD;
        this.sharkL = sharkL;
    }

    //It is what it is.
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    //Keyboard method where we define the picture/class movement.
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        //Decided to go with switch case, makes sense too.
        switch (keyboardEvent.getKey()) {

            //The Ifs prevent the picture from leaving the background/canvas.
            case KeyboardEvent.KEY_D:
                if(sharkL.getMaxX() >= 959 && sharkD.getMaxX() >= 959){
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
                if(sharkL.getMaxY() >= 536 && sharkD.getMaxY() >= 536){
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

