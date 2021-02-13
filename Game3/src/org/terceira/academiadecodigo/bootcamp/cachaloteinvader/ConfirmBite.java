package org.terceira.academiadecodigo.bootcamp.cachaloteinvader;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class ConfirmBite {

    private boolean squidBitten = false;
    private boolean cachaloteBitten = false;
    private Picture cachalote;
    private Picture[] shark;
    private Picture squid;
    private Text counter;
    private int squidsEaten = 0;

    // constructor that receives the animals: whale, sharks array and squid
    public ConfirmBite(Picture cachalote, Picture[] shark, Picture squid) {
        this.cachalote = cachalote;
        this.shark = shark;
        this.squid = squid;
        this.counter = new Text(10, 10, "Squids eaten: " + squidsEaten);
        counter.draw();
    }

    // checks if the cachalote has been bitten, plays the sound of death, hides everything
    // will instantiate the "you loose" image
    public void bite(int j) {
            if(cachaloteBitten == true) {
                return;
            }
            if ((cachalote.getMaxX() >= shark[j].getX() && cachalote.getMaxX() <= shark[j].getMaxX()) &&
                    ( cachalote.getMaxY() >= shark[j].getY() && cachalote.getMaxY() <= shark[j].getMaxY())
                    ||
                    (cachalote.getMaxX() >= shark[j].getX() && cachalote.getMaxX() <= shark[j].getMaxX()) &&
                           ( cachalote.getY() >= shark[j].getY() && cachalote.getY() <= shark[j].getMaxY())
||
        ((shark[j].getMaxX() >= cachalote.getX() && shark[j].getMaxX() <= cachalote.getMaxX()) &&
                ( shark[j].getMaxY() >= cachalote.getY() && shark[j].getMaxY() <= cachalote.getMaxY())
                ||
                (shark[j].getMaxX() >= cachalote.getX() && shark[j].getMaxX() <= cachalote.getMaxX()) &&
                        ( shark[j].getY() >= cachalote.getY() && shark[j].getY() <= cachalote.getMaxY())))


            {
                Sound sound = new Sound("/resources/vixemaria.wav");
                sound.play(true);

                List<Shape> shapes = Canvas.getInstance().getShapes();
                shapes.clear();
                Picture ocean = new Picture(10,10,"resources/ocean.gif");
                ocean.draw();
                setBiteFalse(true);
            }

    }

    // checks if you have caught a squid
    // will play a sound every time you catch a squid
    // counts the number of squids eaten
    // plays a wav every time you eat a squid
    public void biteSquid() {

        if ((cachalote.getMaxX() >= squid.getX() && cachalote.getMaxX() <= squid.getMaxX()) &&
                ( cachalote.getMaxY() >= squid.getY() && cachalote.getMaxY() <= squid.getMaxY())
                ||
                (cachalote.getMaxX() >= squid.getX() && cachalote.getMaxX() <= squid.getMaxX()) &&
                        ( cachalote.getY() >= squid.getY() && cachalote.getY() <= squid.getMaxY())
                ||
                ((squid.getMaxX() >= cachalote.getX() && squid.getMaxX() <= cachalote.getMaxX()) &&
                        ( squid.getMaxY() >= cachalote.getY() && squid.getMaxY() <= cachalote.getMaxY())
                        ||
                        (squid.getMaxX() >= cachalote.getX() && squid.getMaxX() <= cachalote.getMaxX()) &&
                                ( squid.getY() >= cachalote.getY() && squid.getY() <= cachalote.getMaxY())))


        {

            Sound sound = new Sound("/resources/miauf.wav");
            sound.play(true);
            counter.delete();
            squid.delete();
            newSquid();
            squidsEaten++;
            counter.setText("Squids eaten: " + squidsEaten);
            counter.draw();
            System.out.println(squidsEaten);

        }

        return;

    }

    // instantiates a new squid in a random place
    public void newSquid() {

        int randomNumberX = (int) Math.round(Math.random() * 850) + 10;
        int randomNumberY = (int) Math.round(Math.random() * 450) + 10;

        squid = new Picture(randomNumberX,randomNumberY,"resources/squid.png");
        squid.draw();

        biteSquid();

        return;

    }

    // setters and getters
    public void setBiteFalse(boolean bitten) {
        cachaloteBitten = bitten;
    }

    public boolean isCachaloteBitten() {
        return cachaloteBitten;
    }

    public boolean isSquidBitten() {
        return squidBitten;
    }

    public int getSquidsEaten() {
        return squidsEaten;
    }
}
