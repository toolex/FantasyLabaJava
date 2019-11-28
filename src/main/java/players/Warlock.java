package players;

import items.Creature;

import java.util.ArrayList;

public class Warlock extends Player {
    private ArrayList<Creature> petList;

    public Warlock(){
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
