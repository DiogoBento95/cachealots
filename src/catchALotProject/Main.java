package catchALotProject;

import catchALotProject.game2.Game2;
import catchALotProject.game3.Game3;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Picture menu = new Picture(10,10,"resources/menu.png");
        // Creating an instance of Game2 called catchALot..
        Game2 catchALot = new Game2();




        Game3 game = new Game3();



        MenuKeyboardHandler gameMenu = new MenuKeyboardHandler();

        Keyboard keyboard = new Keyboard(gameMenu);


        keyboardEvents(keyboard);

        while (true) {

            menu.draw();

            if (gameMenu.getGameNumber()==1){
                menu.delete();
                checkIfBack(gameMenu);

            }
            if (gameMenu.getGameNumber()==2){
                menu.delete();
                //..and invoking the startGM2 method to start the game.
                catchALot.startGM2();
                checkIfBack(gameMenu);

            }
            if (gameMenu.getGameNumber()==3){
                menu.delete();
                game.init();
                checkIfBack(gameMenu);

            }



        }
    }




    public static void keyboardEvents(Keyboard keyboard) throws InterruptedException {

        KeyboardEvent a = new KeyboardEvent();
        a.setKey(KeyboardEvent.KEY_B);
        a.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(a);


        KeyboardEvent e = new KeyboardEvent();
        e.setKey(KeyboardEvent.KEY_A);
        e.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(e);


        KeyboardEvent i = new KeyboardEvent();
        i.setKey(KeyboardEvent.KEY_S);
        i.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(i);


        KeyboardEvent o = new KeyboardEvent();
        o.setKey(KeyboardEvent.KEY_D);
        o.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(o);

        KeyboardEvent u = new KeyboardEvent();
        u.setKey(KeyboardEvent.KEY_X);
        u.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(u);


    }

    public static void checkIfBack(MenuKeyboardHandler gameMenu){
        while (gameMenu.getGameNumber()!=0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gameMenu.setGameNumber(4);
        List<Shape> shapes = Canvas.getInstance().getShapes();
        shapes.clear();
    }




    }


