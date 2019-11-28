import items.Axe;
import items.Sword;
import org.junit.Before;
import org.junit.Test;
import players.Cleric;
import players.Knight;
import players.baddies.Orc;
import room.Room;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    Room room;
    Knight knight;
    Orc orc;
    Sword sword;
    Axe axe;
    Cleric cleric;

    @Before
    public void before(){
        this.axe = new Axe();
        this.sword = new Sword();
        this.knight = new Knight();
        this.room = new Room("Jail", 100);
        this.orc = new Orc();
        this.cleric = new Cleric();
    }

    @Test
    public void roomStartsEmpty(){
        assertEquals(0, room.getBaddies().size());
        assertEquals(0, room.getGoodies().size());
    }

    @Test
    public void playersCanEnter(){
        room.enterPlayer(knight);
        room.enterEnemy(orc);
        assertEquals(1, room.getBaddies().size());
        assertEquals(1, room.getGoodies().size());
    }

    @Test
    public void whenRoomIsClearedBaddieIsGone(){
        room.enterPlayer(knight);
        room.enterEnemy(orc);

        knight.buyItem(sword);

        knight.equipItem(sword);


        knight.useItem(orc);
        room.checkPlayer(orc);
        knight.useItem(orc);
        room.checkPlayer(orc);
        assertEquals(0, room.getBaddies().size());
    }

    @Test
    public void onceRoomClearedGiveOutTreasure(){
        room.enterPlayer(knight);
        room.enterEnemy(orc);

        knight.buyItem(sword);

        knight.equipItem(sword);


        knight.useItem(orc);
        room.checkPlayer(orc);
        knight.useItem(orc);
        room.checkPlayer(orc);

        room.giveOutTreasure();
        assertEquals(200, knight.getWallet(), 0.01);
    }

    @Test
    public void treasureGivenTo(){
        room.enterPlayer(knight);
        room.enterEnemy(orc);
        room.enterPlayer(cleric);

        knight.buyItem(sword);

        knight.equipItem(sword);


        knight.useItem(orc);
        room.checkPlayer(orc);
        knight.useItem(orc);
        room.checkPlayer(orc);

        room.giveOutTreasure();
        assertEquals(150, knight.getWallet(), 0.01);
        assertEquals(150, cleric.getWallet(), 0.01);
    }




}
