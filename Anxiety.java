public class Anxiety extends Adventurer{
    private int neg;
    private int specialMax = 10;
    private String specialName = "Demotivate!";
    private boolean debuff = false;
    private boolean buff = false;
    private int maxHP = 21;
    public int getSpecial(){
        return neg;
      }
      public Anxiety(String name, int hp, int neg, int specialMax){
        super(name,hp);
        this.specialMax = specialMax;
        this.neg = neg;
      }
    
      public Anxiety(String name, int hp){
        this(name, hp, 0, 10);
      }
    
      public Anxiety(String name){
        this(name, 21);
      }
    
      public Anxiety(){
        this("Anxiety");
      }
    
      public String getSpecialName(){
        return specialName;
      }
    
}