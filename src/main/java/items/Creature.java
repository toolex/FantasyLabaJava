package items;

public class Creature {

    private Integer damage;
    private String name;

    public Creature(Integer damage, String name){
        this.damage = damage;
        this.name = name;
    }

    public Integer getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}
