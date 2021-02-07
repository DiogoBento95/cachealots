package org.academiadecodigo.bootcamp;

public class Player {

    // number of arpoons of the game
    private int arpoons = 3;

    // decreases the number of arpoons
    public void arpoonL() {
        arpoons--;
    }

    // gets the number of arpoons left
    public int getArpoons() {
        return arpoons;
    }

    // Method that shoots arpoons
    public void shoot() { arpoonL(); }
}