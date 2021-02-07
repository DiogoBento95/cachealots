package org.academiadecodigo.bootcamp;
import org.academiadecodigo.bootcamp.whales.SpermMouseHandler;
import org.academiadecodigo.bootcamp.whales.SpermWhale;
import org.academiadecodigo.bootcamp.gfx.simplegfx.OceanSimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Game {

    private OceanSimpleGfxGrid grid;
    private SpermWhale[] spermWhales;
    private int delay;
    private int createdWhales = 3;
    private Player player;

    // Constructor of Game
    Game(int cols, int rows, int delay,Player player) {

        this.player=player;
        this.delay = delay;

        grid = new OceanSimpleGfxGrid(cols, rows);

    }

    // Starts the game and instantiates spermwhales
    public void init() {

        SpermMouseHandler.setWhalesKilled(0);

        grid.init();

        spermWhales = new SpermWhale[createdWhales];

        for (int i = 0; i < createdWhales; i++) {
            spermWhales[i] = new SpermWhale(grid.makeGridPosition());
            spermWhales[i].setGrid(grid);
        }

    }

    // Moves the whales and instantiates the "arpoons left" counter
    public void start() {

        while (true) {

            String arpoonsString = "Arpoons left "+(player.getArpoons());
            Text arpoon = new Text(20.00,20.00,(arpoonsString));

            arpoon.draw();

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            moveAllWhales();

        arpoon.delete();

        }

    }
    // Moves all the whales
    public void moveAllWhales() {

        for (SpermWhale c : spermWhales) {
            c.move();
        }

    }

}
