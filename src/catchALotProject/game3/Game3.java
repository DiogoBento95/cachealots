package catchALotProject.game3;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class Game3 {

    public static final int PADDING = 10;

    public Picture cachaloteLeft;
    public Picture squid;

    private ConfirmBite confirmBite;

    private Picture shark1;
    private Picture shark2;
    private Picture shark3;
    private Picture shark4;
    private Picture shark5;
    private Picture shark6;

// Starts the game, instantiates the background, whale, keyboard eventlisteners
// initializes the enemy method
public void init() throws InterruptedException {
    SoundGame3 soundGame3 = new SoundGame3(" resources/puddipuddimusic.wav");
    soundGame3.play(true);

    Picture sea = new Picture(PADDING,PADDING, "resources/ocean2.gif");
    sea.draw();

    cachaloteLeft = new Picture(460,260, "resources/WhaleL.png");

    cachaloteLeft.draw();

    squid = new Picture(200,200, "resources/squid.png");
    squid.draw();

    WhaleKeyboardHandler whaleHandler = new WhaleKeyboardHandler(cachaloteLeft);
    Keyboard whaleKey = new Keyboard(whaleHandler);

    whaleKey.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_RELEASED);
    whaleKey.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_RELEASED);
    whaleKey.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_RELEASED);
    whaleKey.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_RELEASED);

    enemy();
    soundGame3.stop();
    whaleHandler.setKeyboardEndGameTrue();

    return;

}

// Instantiates sharks and moves them against the wale
public void enemy() throws InterruptedException {

    Picture[] arraySharks = new Picture[6];

    arraySharks[0] = shark1;
    arraySharks[1] = shark2;
    arraySharks[2] = shark3;
    arraySharks[3] = shark4;
    arraySharks[4] = shark5;
    arraySharks[5] = shark6;

    // method that receives the game's animals
    confirmBite = new ConfirmBite(cachaloteLeft, arraySharks, squid);

        // checks if the whale has been bitten
        while(!confirmBite.isCachaloteBitten()) {

            for (int i = 0; i < 3; i++) {
                int randomY = (int) Math.round(Math.random() * 460);
                arraySharks[i] = new Picture(810,randomY, "resources/sharkL.gif");
                arraySharks[i].draw();
            }

            for (int i = 3; i < arraySharks.length; i++) {
                int randomY = (int) Math.round(Math.random() * 460);
                arraySharks[i] = new Picture(PADDING,randomY, "resources/sharkD.gif");
                arraySharks[i].draw();
            }

            // checks the X and Y limits for the sharks to swim
            while(arraySharks[0].getX() > PADDING  && !confirmBite.isSquidBitten()) {

                    for (int i = 0; i < arraySharks.length; i++) {

                        // invokes the method for the squid to be eaten
                        confirmBite.biteSquid();

                        // if player eats X squids, he/she will win
                        if(confirmBite.getSquidsEaten() > 10) {

                            List<Shape> shapes = Canvas.getInstance().getShapes();
                            shapes.clear();

                            Picture sea = new Picture(PADDING,PADDING, "resources/ocean2.gif");
                            sea.draw();

                            Picture youWin = new Picture(10,10, "resources/you win.png");

                            youWin.draw();

                            return;

                        }

                        // control flow for the sharks to swim
                        if (i < 3) {
                            arraySharks[i].translate(-20, 0);
                            confirmBite.bite(i);
                            Thread.sleep(20);
                            continue;

                        }
                        arraySharks[i].translate(20, 0);
                        confirmBite.bite(i);
                        Thread.sleep(20);

                        // end game menu
                        if(confirmBite.isCachaloteBitten()) {
                            Picture endGame = new Picture(PADDING,PADDING, "resources/you lose.jpeg");
                            endGame.draw();
                            return;
                        }
                    }
            }

            // hides all sharks
            for (int j = 0; j < arraySharks.length; j++) {
                arraySharks[j].delete();
            }

        }

        return;

    }

    }


