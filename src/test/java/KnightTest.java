import items.Axe;
import items.Sword;
import org.junit.Before;
import org.junit.Test;
import players.Cleric;
import players.Knight;
import players.baddies.Orc;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    Knight knight;
    Orc orc;
    Sword sword;
    Axe axe;

    @Before
    public void before(){
        this.axe = new Axe();
        this.sword = new Sword();
        this.knight = new Knight();
        this.orc = new Orc();
    }

    @Test
    public void canTakeLessDamageWithSkill(){
        orc.buyItem(sword);
        orc.equipItem(sword);
        knight.divineShield();
        orc.useItem(knight);
//        assertEquals(100, knight.getHealth(), 0.01);

    }
}
