package catchALotProject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ConfirmBiteGM2 {

    // We're gonna need this.. to make the whale proper dead.
    private boolean bite = false;

    // Pictures needed as parameters for constructor.
    private Picture whaleD;
    private Picture whaleL;
    private Picture sharkD;
    private Picture sharkL;

    // Constructor, with 4 pictures as parameters. (to check if the whale's been bitten by the shark).
    public ConfirmBiteGM2(Picture whaleD, Picture whaleL, Picture sharkD, Picture sharkL){
        this.whaleD = whaleD;
        this.whaleL = whaleL;
        this.sharkD = sharkD;
        this.sharkL = sharkL;
    }

    // Boolean getter.
    public boolean isBitten(){
        return bite;
    }

    // Crucial method that will check if the shark took a bite or not.
    // PS: Thank you Rui and Sal.
    public void bite() {
        if((sharkD.getX() >= whaleD.getX() && sharkD.getX() <= whaleD.getMaxX() &&
                sharkD.getY() >= whaleD.getY() && sharkD.getY() <= whaleD.getMaxY()) ||
        (sharkD.getMaxX() >= whaleD.getX() && sharkD.getMaxX() <= whaleD.getMaxX() && sharkD.getMaxY() >= whaleD.getY()
                && sharkD.getMaxY() <= whaleD.getMaxY())){
            bite = true;
            whaleD.delete();
            whaleL.delete();
        }
    }
}
