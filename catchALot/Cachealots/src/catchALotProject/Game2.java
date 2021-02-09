package catchALotProject;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game2 {

    //I mean, why not? it looks good!
    public static final int PADDING = 10;

    // Picture Instantiation.
    private Picture ocean = new Picture(PADDING,PADDING,"resources/ocean.gif");

    private Picture whaleL = new Picture(25,260,"resources/WhaleL.png");
    private Picture whaleD = new Picture(25,260,"resources/WhaleD.png");

    private Picture sharkD = new Picture(880,260,"resources/SharkD.png");
    private Picture sharkL = new Picture(880,260,"resources/SharkL.png");

    //ConfirmBite needs to know the pictures.
    ConfirmBite bitten = new ConfirmBite(whaleD, whaleL, sharkD, sharkL);

    // Method that will start this game mode.
    public void startGM2() throws InterruptedException {

        //Method to invoke the drawing of the background and of our "players".
        ocean.draw();
        //Pro tip: Draw the background picture first. Trust me.
        whaleD.draw();
        sharkL.draw();

        // Handler instantiation.
        WhaleKeyboardHandler whale = new WhaleKeyboardHandler(whaleL,whaleD,bitten);
        SharkKeyboardHandler shark = new SharkKeyboardHandler(sharkD,sharkL);

        // Keyboard instantiation.
        Keyboard keyboard = new Keyboard(whale);
        Keyboard keyboard2 = new Keyboard(shark);

        // Whale Keys.
        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_RELEASED);

        // Shark Keys.
        keyboard2.addEventListener(KeyboardEvent.KEY_D,KeyboardEventType.KEY_RELEASED);
        keyboard2.addEventListener(KeyboardEvent.KEY_A,KeyboardEventType.KEY_RELEASED);
        keyboard2.addEventListener(KeyboardEvent.KEY_W,KeyboardEventType.KEY_RELEASED);
        keyboard2.addEventListener(KeyboardEvent.KEY_S,KeyboardEventType.KEY_RELEASED);

        // While it's not bitten, it'll keep checking until it is, and then... GG WP Whale.
        while(!bitten.isBitten()){
            Thread.sleep(250);
            bitten.bite();
        }
    }
}