public class Boss extends Adventurer{

  private int veg;
  private String specialName = "EAT YOUR VEGETABLES!";
  private int specialMax = 10;
  private int maxHP = 70;
  private String name;
  private boolean debuff = false;
  private boolean buff = false;
  private String[] veggies = {"Broccoli", "Cabbage", "Carrot", "Aspargus", "Spinach", "Radish", "Onion", "Brussel Sprout"};
  public static String namegen(){
    String[] names1 = {"Joe", "Bob", "Mr Kamuel Sonstantinovich", "Lebonbon", "Kanye East", "Barracks Oboma", "Bonald Trumpet", "Georgius Washingkilogram"};
    String[] names2 = {"Lone", "Big", "Old", "Chubby", "Evil", "Malicious", "Young", "Wise"};
    String[] names3 = {"Broccoli", "Cabbage", "Carrot", "Aspargus", "Spinach", "Radish", "Onion", "Brussel Sprout"};
    return names1[(int) Math.random()*9] + " the " + names2[(int) Math.random()*9] + " " + names3[(int) Math.random()*9];
  }

  //Accessor Methods
  public String getSpecialName(){
    return specialName;
  }
  public int getSpecial(){
    return veg;
  }
  public int getSpecialMax(){
    return specialMax;
  }
  public void setSpecial(int n){
    if(n >= getSpecialMax()){
      this.veg = getSpecialMax();
    }
    veg = n;
  }

  //Constructors
  public Boss(String name, int hp, int veg, int specialMax){
    super(name,hp);
    this.specialMax = specialMax;
    this.veg = veg;
  }

  public Boss(String name, int hp){
    this(name, 70, 3, 10);
  }

  public Boss(String name){
    this(name, 70);
  }

  public Boss(){
    this(namegen());
  }
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*6+13)+1 + damageMod(buff,debuff);
    other.applyDamage(damage);
    restoreSpecial(1);
    return this + " throws a "+ veggies[(int)Math.random()*9].toLowerCase() + " at "+ other + " for " + damage + " points of damage.";
  }
  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public String support(Adventurer other){
    return "Boss cannot heal!";
  }

  //heal or buff self
  public String support(){
    buffOn();
    debuffOff();
    restoreSpecial(5);
    if(getHP() + 12 > maxHP)
      setHP(maxHP);
    else
      setHP(getHP() + 12);
    return this + " eats some " +  veggies[(int)Math.random()*9].toLowerCase() + " and gains 12 HP!";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String special(Adventurer other){
    int damage = (int)(Math.random()*6) + damageMod(buff,debuff) + getSpecial() * 4;
    setSpecial(0);
    return this + " hurls " + veggies[(int)Math.random()*9].toLowerCase() + " at "+ other + " for " + damage + " points of damage. EAT YOUR VEGETABLES!";
  }
  /*
  standard methods
  */

}
