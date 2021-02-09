package catchALotProject;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

//Whale class.
public class WhaleKeyboardHandler implements KeyboardHandler {

    private int speed = 30;
    //So it goes away.
    private ConfirmBite bitten;
    //Pictures needed as parameters for constructor.
    private Picture whaleL;
    private Picture whaleD;

    //Constructor, with 2 pictures, (left and right).
    public WhaleKeyboardHandler(Picture whaleL,Picture whaleD,ConfirmBite bitten){
        this.whaleL = whaleL;
        this.whaleD = whaleD;
        this.bitten = bitten;
    }

    //It is what it is.
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    //Keyboard method where we define the picture/class movement.
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(bitten.isBitten()){
            return;
        }

        //Decided to go with switch case, makes sense too.
        switch (keyboardEvent.getKey()) {

            //The Ifs prevent the picture from leaving the background/canvas.
            case KeyboardEvent.KEY_RIGHT:
                if(whaleL.getMaxX() >= 959 && whaleD.getMaxX() >= 959){
                    return;
                }
                whaleL.translate(speed, 0);
                whaleD.translate(speed,0);
                whaleL.delete();
                whaleD.draw();
                break;

            case KeyboardEvent.KEY_LEFT:
                if(whaleL.getX() <= Game2.PADDING && whaleD.getX() <= Game2.PADDING){
                    return;
                }
                whaleL.translate(-speed, 0);
                whaleD.translate(-speed,0);
                whaleD.delete();
                whaleL.draw();
                break;

            case KeyboardEvent.KEY_UP:
                if(whaleL.getY() <= Game2.PADDING && whaleD.getY() <= Game2.PADDING){
                    return;
                }
                whaleL.translate(0, -speed);
                whaleD.translate(0,-speed);
                whaleL.delete();
                whaleD.draw();
                break;

            case KeyboardEvent.KEY_DOWN:
                if(whaleL.getMaxY() >= 536 && whaleD.getMaxY() >= 536){
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
