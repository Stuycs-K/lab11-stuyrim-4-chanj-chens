public class Joy extends Adventurer{
  int optimism, optimismMax;
  private boolean buff = false;
  private boolean debuff = false;
  private int maxHP = 22;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/

  public Joy(String name, int hp){
    super(name,hp);
    optimismMax = 10;
    optimism = optimismMax/2;
  }

  public Joy(String name){
    this(name,22);
  }

  public Joy(){
    this("Joy");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "optimism";
  }

  public int getSpecial(){
    return optimism;
  }

  public void setSpecial(int n){
    if (n >= optimismMax){
      optimism = optimismMax;
    }
    optimism = n;
  }

  public int getSpecialMax(){
    return optimismMax;
  }

 
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*3)+2 + damageMod(buff,debuff);
    other.applyDamage(damage);
    restoreSpecial(2);
    return this + " overloaded "+ other + " with serotonin and dealt "+ damage +
    " points of damage.";
  }


  public String special(Adventurer other){
    if(other.getHP() == 0){
      return "This guy is dead bud, you just wasted a turn";
    }
    if(getSpecial() >= 2){
      this.setSpecial(this.getSpecial() - 2);
      return "Gives a Pep Talk to "+other+" and restores "
      + other.restoreSpecial(5)+" "+other.getSpecialName();
    }else{
      return "Not optimistic enough to use Pep Talk. Instead "+support(other);
    }

  }

  /*Restores 5 HP to other*/
  public String support(Adventurer other){
    int prevHP = other.getHP();
    if(prevHP + 5 > getmaxHP()) other.setHP(other.getmaxHP());
    else other.setHP(other.getHP() + 5);
    return "Says encouraging words to "+other+" and restores their HP from "
    + prevHP +" to " + other.getHP();
  }
  /*Restores 3 special and 1 hp to self.*/
  public String support(){
    int hp = 3;
    setHP(getHP()+hp);
    return this+" watches cat videos to restores "+restoreSpecial(3)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
