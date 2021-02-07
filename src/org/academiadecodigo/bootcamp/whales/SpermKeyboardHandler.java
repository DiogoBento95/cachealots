package org.academiadecodigo.bootcamp.whales;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SpermKeyboardHandler implements KeyboardHandler {

    private Picture cachealot;
    private boolean gameMenu = false;

    public SpermKeyboardHandler(Picture cachealot, boolean gameMenu){
        this.cachealot = cachealot;
        this.gameMenu = gameMenu;
    }

    public boolean getgameMenu() { return gameMenu; }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) { }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                cachealot.delete();
                gameMenu = true;
                break;
        }
    }
}
