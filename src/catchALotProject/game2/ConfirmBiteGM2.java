package catchALotProject.game2;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ConfirmBiteGM2 {

    // We're gonna need this.. to make the whale proper dead.
    private boolean bite = false;

    // Pictures needed as parameters for constructor.
    private Picture whaleD;
    private Picture sharkD;

    // Constructor, with 4 pictures as parameters. (to check if the whale's been bitten by the shark).
    public ConfirmBiteGM2(Picture whaleD, Picture sharkD) {
        this.whaleD = whaleD;
        this.sharkD = sharkD;
    }

    // Boolean getter.
    public boolean isBitten(){
        return bite;
    }

    // Crucial method that will check if the shark took a bite or not.
    // PS: Thank you Rui and Sal.
    public void bite() {
        if((whaleD.getMaxX() >= sharkD.getX() && whaleD.getMaxX() <= sharkD.getMaxX()) &&
                ( whaleD.getMaxY() >= sharkD.getY() && whaleD.getMaxY() <= sharkD.getMaxY())
                ||
                (whaleD.getMaxX() >= sharkD.getX() && whaleD.getMaxX() <= sharkD.getMaxX()) &&
                        ( whaleD.getY() >= sharkD.getY() && whaleD.getY() <= sharkD.getMaxY())
                ||
                ((sharkD.getMaxX() >= whaleD.getX() && sharkD.getMaxX() <= whaleD.getMaxX()) &&
                        ( sharkD.getMaxY() >= whaleD.getY() && sharkD.getMaxY() <= whaleD.getMaxY())
                        ||
                        (sharkD.getMaxX() >= whaleD.getX() && sharkD.getMaxX() <= whaleD.getMaxX()) &&
                                ( sharkD.getY() >= whaleD.getY() && sharkD.getY() <= whaleD.getMaxY())))
        {
            bite = true;
            whaleD.delete();
        }
    }
}
