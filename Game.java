import java.util.*;

import javax.swing.text.PlainDocument;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Text.go(1,1);
        for (int i = 1; i <= WIDTH; i++){
            System.out.print(Text.colorize("_", BORDER_BACKGROUND));;
        }
        for (int i = 1; i <= WIDTH; i++){
          Text.go(30,i);
            System.out.print(Text.colorize("_", BORDER_BACKGROUND));;
        }
        for (int i = 1; i <= HEIGHT; i++){
          Text.go(i,1);
            System.out.print(Text.colorize("_", BORDER_BACKGROUND));;
        }
        for (int i = 1; i <= HEIGHT; i++){
          Text.go(i,80);
            System.out.print(Text.colorize("_", BORDER_BACKGROUND));;
        }


    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Text.go(startRow,startCol);
    System.out.println(s);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Text.go(row,col);
    int pos = 0;
    int r = row;
    while (text.length()>0){
      //drawText("" + text.length(),5, 5);
      if (text.length() < width){
        drawText(text,r, col);
        for (int i = text.length(); i <width; i++){
          drawText(" ", r, col + text.length() + i);
        }
        text = "";
      }
      else{
        
        drawText(text.substring(0,width),r, col);
        text = text.substring(width);
        r++;
      }
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      int choicePlayer = (int)(Math.random() *3);
      if (choicePlayer == 0){
        return new CodeWarrior();
      }
      if (choicePlayer == 1){
        return new Anger();
      }
      if (choicePlayer == 2){
        return new Joy();
      }
      return null;
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){

      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      //YOUR CODE HERE
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
            if (i==0){
              TextBox(startRow, 9+ j*(80/3), 80/3, 1, party.get(j).getName());
            }
            if (i==1){
              TextBox(startRow + 1, 9 + j*(80/3), 80/3, 1, "HP: " + party.get(j).getHP());
            }
            if (i==2){
              TextBox(startRow + 2, 9 + j*(80/3), 80/3, 1, party.get(j).getSpecialName() + ": " + party.get(j).getSpecial());
            }
          }
        }
      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    return output;
  }

  public static boolean isNumeric(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch(NumberFormatException e){
      return false;
    }
  }



  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(){

    drawBackground();

    //draw player party

    //draw enemy party

  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location

      //show cursor

      String input = in.nextLine();

      //clear the text that was written

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static Adventurer lowestHP(ArrayList<Adventurer> party){
    int temp = 100;
    Adventurer result = null;
    for (Adventurer adventurer : party) {
      if (adventurer.getHP() < temp){
        temp = adventurer.getHP();
        result = adventurer;
      }
    }
    return result;
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();

    //TextBox(24,3,10,2,"thisis just a test im trying to write as long as posisble");

    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    enemies.add(new CodeWarrior("tempEnemy1"));
    enemies.add(new CodeWarrior("tempEnemy2"));
    enemies.add(new CodeWarrior("tempEnemy3"));
    drawParty(enemies, 3);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    party.add(new CodeWarrior());
    party.add(new CodeWarrior("Relish"));
    party.add(new CodeWarrior("Psyduck",20, "Worrying++"));
    drawParty(party, 25);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen();//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
    drawText(preprompt,10,20);


    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      //TextBox(24,2,78,1,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){
        String sTarget = input.substring(input.length() -1);
        int target = 0;
        if (isNumeric(sTarget)){
          target = Integer.parseInt(sTarget);
        }
        //Process user input for the last Adventurer:
        //attack variables would need to check anger variable
        if(input.startsWith("attack") || input.startsWith("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

          TextBox(24,2,40,5,(party.get(whichPlayer).attack(enemies.get(target))));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("special") || input.startsWith("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          TextBox(24,2,40,5,(party.get(whichPlayer).special(enemies.get(target))));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        //this is how we do the others
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          TextBox(24,2,40,5,(party.get(whichPlayer).support(enemies.get(target))));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+ party.get(whichPlayer)+": attack/special/quit";
          drawText(prompt,10+whichPlayer,20); //temp

        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";
          drawText(prompt,14,20);
          partyTurn = false;//temp
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        int choiceAction = (int)(Math.random() *3);
        int choicePlayer = (int)(Math.random() *3);
        if (choiceAction == 0){
          drawText(enemies.get(whichOpponent).attack(enemies.get(choicePlayer)),15,2);
        }
        if (choiceAction == 1){
          drawText(enemies.get(whichOpponent).special(enemies.get(choicePlayer)),16,2);
        }
        if (choiceAction == 2){
          drawText(enemies.get(whichOpponent).support(lowestHP(enemies)),17,2);
        }
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen();


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
