package org.academiadecodigo.bootcamp;
import org.academiadecodigo.bootcamp.whales.SpermKeyboardHandler;
import org.academiadecodigo.bootcamp.whales.SpermMouseHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class OceanBox {

    public static void main(String[] args) throws InterruptedException {

        Player player = new Player();

        boolean menuGame = false;

        Game g = new Game(55, 25, 400,player);

        Picture menu = new Picture(10,10,"resources/sea.jpg");

        menu.draw();

        SpermKeyboardHandler gameMenu = new SpermKeyboardHandler(menu, menuGame);
        Keyboard keyboard = new Keyboard(gameMenu);

        KeyboardEvent e = new KeyboardEvent();
        e.setKey(KeyboardEvent.KEY_SPACE);
        e.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(e);

        while(!menuGame) {

            menuGame = gameMenu.getgameMenu();
            Thread.sleep(400);

        }

        g.init();

        SpermMouseHandler mouseHandler = new SpermMouseHandler(player);
        Mouse spermMouse = new Mouse(mouseHandler);
        spermMouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        g.start();

    }

}
