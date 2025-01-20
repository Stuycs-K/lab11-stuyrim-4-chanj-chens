import java.util.Random;
public class Anger extends Adventurer{
  private int rage;
  private int specialMax = 10;
  private String specialName = "EXPLODE!";
  private boolean debuff = false;
  private boolean buff = false;
  private int maxHP = 35;

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
    this(name, 35);
  }

  public Anger(){
    this("Anger");
  }

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
  public String support(Adventurer other){
    other.buffOn();
    return this + " gaslights "+other+" and makes thema angry!";
  }


  public String support(){
    buffOn();
    setSpecial(getSpecial()+3);
    return this+" gaslights himself into being angry, boosting damage and restoring 3 rage!";
  }
}
