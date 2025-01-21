public class Anxiety extends Adventurer{
    private int neg;
    private int specialMax = 10;
    private String specialName = "negative energy";
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
        this(name+ "'s Anxiety", 21);
      }
    
      public Anxiety(){
        this("Anxiety");
      }
    
      public String getSpecialName(){
        return specialName;
      }
      public void setSpecial(int n){
        if(n >= getSpecialMax()){
          this.neg = getSpecialMax();
        }
        neg = n;
      }
    
      public int getSpecialMax(){
        return specialMax;
      }

      public String attack(Adventurer other){
        int damage = (int)(Math.random()*2+2)+2 + damageMod(buff,debuff);
        other.applyDamage(damage);
        restoreSpecial(1);
        return this + " yells at "+ other + ", dealing " + damage + " HP!";
      }

      public String special(Adventurer other){
          setSpecial(0);
          other.debuffOn();
          return this + " brings the mood down. " + other + "'s damage decreased!";
        }
        public String support(Adventurer other){
            other.setHP(other.getHP() + 1);
            return this + " heals " + other + " for 1hp. Whyuse Anxiety to heal?";
          }
        public String support(){
            setHP(getHP()+1);
            return this + " heals " + this + " for 1hp. Why use Anxiety to heal?";
        }
}