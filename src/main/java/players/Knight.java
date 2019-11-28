package players;

public class Knight extends Player {

    private boolean divineShield;
    public Knight(){
        this.divineShield = false;
    }

    public Boolean getDivineShield(){
        return this.divineShield;
    }

    public void divineShield() {
        divineShield = true;
    }
}
