public class Boss extends Adventurer{
  private String[] names1 = {"Joe", "Bob", "Samuel", "Joe #2", "Joe #3", "Alpha", "Beta", "Sigma"};
  private String[] names2 = {"Lone", "Big", "Old", "Chubby", "Evil", "Malicious", "Young", "Wise"};
  private String[] names3 = {"Broccoli", "Cabbage", "Carrot", "Aspargus", "Spinach", "Radish", "Onion", "Brussel Sprout"};
  private int veggieMeter = 3;
  private String specialName = "EAT YOUR VEGETABLES!";
  private int specialMax = 10;
  public String namegen(){
    return names1[(int) Math.random()*9] + " the " + names2[(int) Math.random()*9] + " " + names3[(int) Math.random()*9];
  }

  //Accessor Methods
  public String getSpecialName(){
    return specialName;
  }
  public int getSpecial(){
    return veggieMeter;
  }
  public int getSpecialMax(){
    return specialMax;
  }
  public void setSpecial(int n){
    if(n >= getSpecialMax()){
      this.veggieMeter = getSpecialMax();
    }
    veggieMeter = n;
  }




}
