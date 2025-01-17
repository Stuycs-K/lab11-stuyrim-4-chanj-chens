public class Boss extends Adventurer{

  private int veg;
  private String specialName = "EAT YOUR VEGETABLES!";
  private int specialMax = 10;
  private String name;
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
    this(name, hp, 3, 10);
  }

  public Boss(String name){
    this(name, 30);
  }

  public Boss(){
    this(namegen());
  }

}
