public class Boss extends Adventurer{
  private String[] names1 = {"Joe", "Bob", "Samuel", "Joe #2", "Joe #3", "Alpha", "Beta", "Sigma"};
  private String[] names2 = {"Lone", "Big", "Old", "Chubby", "Evil", "Malicious", "Young", "Wise"};
  private String[] names3 = {"Broccoli", "Cabbage", "Carrot", "Aspargus", "Spinach", "Radish", "Onion", "Brussel Sprout"};
  public String namegen(){
    return names1[(int) Math.random()*9] + " " + names2[(int) Math.random()*9] + " " + names3[(int) Math.random()*9];
  }
}
