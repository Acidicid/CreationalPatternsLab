package creational.prototype;

public class GameCharacter {
    private String name;
    private int health;
    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }
    public void show(){
        System.out.println(name+ " HP:"+health);
    }
    public GameCharacter clone() {

        try{
            return (GameCharacter) super.clone();
        }
        catch(Exception e){
            return null;
        }
    }
}
