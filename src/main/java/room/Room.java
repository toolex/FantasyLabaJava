package room;

import players.Player;

import java.util.ArrayList;

public class Room {
    private String name;
    private Integer treasure;
    private ArrayList<Player> goodies;
    private ArrayList<Player> baddies;

    public Room(String name, Integer treasure){
        this.name = name;
        this.treasure = treasure;
        this.goodies = new ArrayList<Player>();
        this.baddies = new ArrayList<Player>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getBaddies() {
        return baddies;
    }

    public ArrayList<Player> getGoodies() {
        return goodies;
    }

    public Integer getTreasure() {
        return treasure;
    }

    public void enterPlayer(Player player){
        goodies.add(player);
    }

    public void enterEnemy(Player player){
        baddies.add(player);
    }

    public void checkPlayer(Player player) {
        if (goodies.contains(player)){
            if (!player.checkAlive()) {
            goodies.remove(player);
        }}
        if (baddies.contains(player)){
            if (!player.checkAlive()) {
                baddies.remove(player);
            }
        }
    }

    public void giveOutTreasure() {
        Integer treasurePerPerson = treasure/goodies.size();
        for (Player goodie : goodies){
            goodie.setWallet(goodie.getWallet() + treasurePerPerson);
        }
    }
}
