public class Joy extends Adventurer{
  int optimism, optimismMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/

  public CodeWarrior(String name, int hp){
    super(name,hp);
    optimismMax = 10;
    optimism = optimismMax/2;
  }

  public CodeWarrior(String name){
    this(name,20);
  }

  public CodeWarrior(){
    this("Joy");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "optimism";
  }

  public int getSpecial(){
    return caffeine;
  }

  public void setSpecial(int n){
    if (n <= optimismMax){
      optimism = n;
    }
  }

  public int getSpecialMax(){
    return optimismMax;
  }

  /*Deal 2-7 damage to opponent, restores 2 caffeine*/
  public String attack(Adventurer other){
    int damage = 3;
    other.applyDamage(damage);
    restoreSpecial(2);
    return this + " overloaded "+ other + " with serotonin and dealt "+ damage +
    " points of damage.";
  }

  /*Deal 3-12 damage to opponent, only if caffeine is high enough.
  *Reduces caffeine by 8.
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 2){
      this.set
      return this + " used their "+preferredLanguage+
      " skills to hack the matrix. "+
      " This glitched out "+other+" dealing "+ damage +" points of damage.";
    }else{
      return "Not optimistic enough to use Pep Talk. Instead "+attack(other);
    }

  }
  /*Restores 5 special to other*/
  public String support(Adventurer other){
    return "Gives a coffee to "+other+" and restores "
    + other.restoreSpecial(5)+" "+other.getSpecialName();
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    int hp = 1;
    setHP(getHP()+hp);
    return this+" drinks a coffee to restores "+restoreSpecial(6)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
