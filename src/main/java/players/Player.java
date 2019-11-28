package players;

import items.Item;

import java.util.ArrayList;

public abstract class Player {

    private Integer health;
    private ArrayList<Item> inventory;
    private Integer wallet;
    private Item equippedItem;
    private Boolean alive;

    public Player(){
        this.health = 100;
        this.inventory = new ArrayList<Item>();
        this.wallet = 100;
        this.equippedItem = null;
        this.alive = true;
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public Integer getHealth() {
        return this.health;
    }

    public void buyItem(Item item) {
        inventory.add(item);
    }

    public Integer getWallet() {
        return this.wallet;
    }

    public Item getEquippedItem() {
        return this.equippedItem;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }

    public void equipItem(Item item){
        if (inventory.contains(item)) {
            this.equippedItem = item;
        }
    }

    public void useItem(Player target) {
            Integer damage = this.equippedItem.getDamage();
            target.health -= damage;
            if (target.health >= 100) {
                target.setHealth(100);
            }
            if (target.getHealth() < 1) {
                target.alive = false;
            }
//        if (((Knight) target).getDivineShield()){
//            target.setHealth(100);
//        }

        }

    public Boolean checkAlive() {
        return this.alive;
    }

}