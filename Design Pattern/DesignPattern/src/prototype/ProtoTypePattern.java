package prototype;


// Prototype Pattern which can Supports the Cloning
interface Prototype {
    public Prototype clone();
}


// Game Character
class GameCharacter implements Prototype {
    private String characterType;
    private int health;
    private String weapon;

    public GameCharacter(String characterType, int health, String weapon) {
        this.characterType = characterType;
        this.health = health;
        this.weapon = weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void display() {
        System.out.printf("Character=%s,Health=%d,Weapon=%s\n", this.characterType, this.health, this.weapon);

    }

    @Override
    public Prototype clone() {
        return new GameCharacter(
                this.characterType,
                this.health,
                this.weapon
        );
    }
}

// Client Code
public class ProtoTypePattern {

    public static void main(String[] args) {
        // Soldier Character
        GameCharacter soldier = new GameCharacter("Soldier", 100, "Gun");
        // Soldier 2 Character
        GameCharacter soldier2 = (GameCharacter) soldier.clone();

        // Customize the clone
        soldier2.setWeapon("Pistol");

        soldier.display();
        soldier2.display();

        // Address
        System.out.println(soldier.hashCode());
        System.out.println(soldier2.hashCode());
    }
}
