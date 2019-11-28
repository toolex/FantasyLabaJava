package items;

public abstract class Item {

  private Integer damage;

  public Item(Integer damage){
      this.damage = damage;
  }

  public Integer getDamage() {
    return damage;
  }
}
