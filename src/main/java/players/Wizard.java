package players;

import items.Creature;
import players.Player;
import players.baddies.Orc;

import java.util.ArrayList;

public class Wizard extends Player {
    private ArrayList<Creature> petList;

    public Wizard(){
        petList = new ArrayList<Creature>();
    }

    public ArrayList<Creature> getPetList() {
        return petList;
    }

    public void buyPet(Creature pet) {
        petList.add(pet);
    }

    public void petAttack(Creature pet, Player baddie) {
        if (petList.contains(pet)){
        Integer damage = pet.getDamage();
        Integer health = baddie.getHealth();
        baddie.setHealth(health - damage);}
    }
}
