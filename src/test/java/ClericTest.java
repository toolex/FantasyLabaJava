import items.Axe;
import items.Potion;
import items.Sword;
import org.junit.Before;
import org.junit.Test;
import players.Cleric;
import players.Knight;
import players.baddies.Troll;

import static org.junit.Assert.assertEquals;

public class ClericTest {
    Cleric cleric;
    Knight knight;
    Troll troll;
    Sword sword;
    Potion potion;
    Axe axe;

    @Before
    public void before(){
        cleric = new Cleric();
        knight = new Knight();
        troll = new Troll();
        sword = new Sword();
        potion = new Potion();
        axe = new Axe();
    }

    @Test
    public void knightStartsAtFullHealth(){
        assertEquals(100, knight.getHealth(), 0.01);
    }

    @Test
    public void trollCanDamageKnight(){
        troll.buyItem(sword);
        troll.equipItem(sword);
        troll.useItem(knight);
        assertEquals(50, knight.getHealth(), 0.01);
    }

    @Test
    public void clericCanHeal(){
        troll.buyItem(sword);
        troll.equipItem(sword);
        troll.useItem(knight);

        cleric.buyItem(potion);
        cleric.equipItem(potion);
        cleric.useItem(knight);
        assertEquals(60, knight.getHealth(), 0.01);
    }

    @Test
    public void cantOverHealTarget(){
        troll.buyItem(axe);
        troll.equipItem(axe);
        troll.useItem(knight);

        cleric.buyItem(potion);
        cleric.equipItem(potion);
        cleric.useItem(knight);
        assertEquals(100, knight.getHealth(), 0.01);
    }
}
