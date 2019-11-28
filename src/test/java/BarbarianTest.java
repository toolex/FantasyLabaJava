import items.Axe;
import items.Item;
import items.Sword;
import org.junit.Before;
import org.junit.Test;
import players.Barbarian;
import players.baddies.Orc;

import static org.junit.Assert.assertEquals;

public class BarbarianTest {
    private Barbarian barbarian;
    private Orc orc;
    private Sword sword;
    private Axe axe;

    @Before
    public void before(){

        barbarian = new Barbarian();

        sword = new Sword();

        axe = new Axe();

        orc = new Orc();
    }

    @Test
    public void startWithNoStuff(){
        assertEquals(0, barbarian.getInventory().size());
    }

    @Test
    public void canAddSwordToInv(){
        barbarian.buyItem(sword);
        assertEquals(1, barbarian.getInventory().size());
    }

    @Test
    public void canHaveMultipleItems(){
        barbarian.buyItem(sword);
        barbarian.buyItem(axe);
        assertEquals(2, barbarian.getInventory().size());
    }


    @Test
    public void canEquipItem(){
        barbarian.buyItem(sword);
        barbarian.equipItem(sword);
        assertEquals(sword, barbarian.getEquippedItem());
    }

    @Test
    public void canTakeItemFromInv(){
        barbarian.buyItem(sword);
        barbarian.buyItem(axe);

        barbarian.equipItem(sword);

        assertEquals(2, barbarian.getInventory().size());
        assertEquals(sword, barbarian.getEquippedItem());
    }

    @Test
    public void canSwap() {
        barbarian.buyItem(sword);
        barbarian.buyItem(axe);

        barbarian.equipItem(sword);
        barbarian.equipItem(axe);

        assertEquals(2, barbarian.getInventory().size());
        assertEquals(axe, barbarian.getEquippedItem());
    }

    @Test
    public void canUseOnTarget() {
        barbarian.buyItem(sword);
        barbarian.buyItem(axe);

        barbarian.equipItem(sword);
        barbarian.equipItem(axe);
        barbarian.useItem(orc);
        assertEquals(95, orc.getHealth(), 0);
    }
}
