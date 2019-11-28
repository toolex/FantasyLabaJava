import items.Creature;
import org.junit.Before;
import org.junit.Test;
import players.Wizard;
import players.baddies.Orc;

import static org.junit.Assert.assertEquals;

public class WizardTest {
    Wizard wizard;
    Creature pet;
    Orc orc;

    @Before
    public void before(){
        wizard = new Wizard();
        pet = new Creature(20, "Imp");
        orc = new Orc();
    }

    @Test
    public void startsWithNoPet(){
        assertEquals(0, wizard.getPetList().size());
    }

    @Test
    public void canAddPet(){
        wizard.buyPet(pet);
        assertEquals(1, wizard.getPetList().size());
    }

    @Test
    public void petCanAttack(){
        wizard.buyPet(pet);
        wizard.petAttack(pet, orc);
        assertEquals(80, orc.getHealth(), 0.01);
    }


}
