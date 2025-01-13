import java.util.Random;
public class Anger extends Adventurer{
  private int rage;
  private int specialMax = 10;
  private String specialName = "EXPLODE!";

  public int getSpecial(){
    return rage;
  }
  public Anger(String name, int hp, int rage, int specialMax){
    super(name,hp);
    this.specialMax = specialMax;
    this.rage = rage;
  }

  public Anger(String name, int hp){
    this(name, hp, 0, 10);
  }

  public Anger(String name){
    this(name, 30);
  }

  public Anger(){
    this("Anger");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return specialName;
  }


  public void setSpecial(int n){
    rage = n;
  }

  public int getSpecialMax(){
    return specialMax;
  }


  public String attack(Adventurer other){
    int damage = (int)(Math.random()*6+2)+2;
    other.applyDamage(damage);
    restoreSpecial(1);
    return this + " punches "+ other + ", burning "+ other + " for " + damage +
    " points of damage. \nRage UP! (" + getSpecial() + ")";
  }


  public String special(Adventurer other){
    if(getSpecial() >= 5){
      int damage = (getSpecial()*3)+(int)(Math.random()*5);
      setSpecial(0);
      other.applyDamage(damage);
      return this + " EXPLODES and deals "+ damage + " to " + other + "!";
    }else{
      int damage = 15 + (int)(Math.random()*5);
      int selfdamage = 5 * (5-getSpecial());
      setSpecial(0);
      setHP(getHP() - selfdamage);
      other.applyDamage(damage);
      return "Not enough rage to use \"EXPLODE!\". Consumed " + selfdamage + " health!" +
    "\n" + this + " EXPLODES and deals "+ damage + " to " + other + "!";
    }

  }

  public String support(Adventurer other){
    other.buffOn();
    return this + " makes "+other+" angry, boosting damage!";
  }

  public String support(){
    buffOn();
    return this+" gaslights himself into being angry, boosting damage!";
  }
}
