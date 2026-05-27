package utils;

//location of file directory -> src -> utils -> GameCharacters.Java
public class GameCharacters {

    private String name;
    private String charType;
    private int health;

    //constructor
    public GameCharacters(){

    }

    public String getName(){

        return name;
    }

    public void setName(String TempName){
        this.name = TempName;
    }

    public String getCharType() {
        return charType;
    }

    public void setCharType(String charType) {
        this.charType = charType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;


        }

    @Override
    public String toString() {
        return String.format("character info");
    }
}
