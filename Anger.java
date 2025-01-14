import java.util.Random;
public class Anger extends Adventurer{
  private int rage;
  private int specialMax = 10;
  private String specialName = "EXPLODE!";
  private boolean debuff = false;
  private boolean buff = false;

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
    if(n >= getSpecialMax()){
      this.rage = getSpecialMax();
    }
    rage = n;
  }

  public int getSpecialMax(){
    return specialMax;
  }

  /*Deal 4-10 damage to opponent, restores 2 caffeine*/
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*6+2)+2 + damageMod(buff,debuff);
    other.applyDamage(damage);
    restoreSpecial(1);
    return this + " punches "+ other + ", burning "+ other + " for " + damage +
    " points of damage. \nRage UP! (" + getSpecial() + ")";
  }


  public String special(Adventurer other){
    if(getSpecial() >= 5){
      int damage = (getSpecial()*3)+(int)(Math.random()*5) + damageMod(buff,debuff);
      setSpecial(0);
      other.applyDamage(damage);
      return this + " EXPLODES and deals "+ damage + " to " + other + "!";
    }else{
      int damage = 15 + (int)(Math.random()*5) + damageMod(buff,debuff);
      int selfdamage = 5 * (5-getSpecial());
      setSpecial(0);
      setHP(getHP() - selfdamage);
      other.applyDamage(damage);
      return "Not enough rage to use \"EXPLODE!\". Consumed " + selfdamage + " health!" +
    "\n" + this + " EXPLODES and deals "+ damage + " to " + other + "!";
    }

  }
  /*Restores 5 special to other*/
  public String support(Adventurer other){
    return "Gives a coffee to "+other+" and restores "
    + other.restoreSpecial(5)+" "+other.getSpecialName();
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    buffOn();
    return this+" gaslights himself into being angry, boosting damage!";
  }
  public String charge(){
    setSpecial(getSpecial+3);
    return this + " is charging up his rage!";
  }
}
