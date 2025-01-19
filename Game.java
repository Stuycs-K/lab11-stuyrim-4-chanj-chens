import java.util.*;
import java.util.ArrayList;

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
        for (int i = 1; i <= WIDTH; i++){
          Text.go(7,i);
            System.out.print(Text.colorize("_", BORDER_BACKGROUND));;
        }
        for (int i = 1; i <= WIDTH; i++){
          Text.go(23,i);
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
          for (int j = 0; j < party.size(); j++){
            if (i==0){
              TextBox(startRow, 9+ j*(80/3), 80/3 -3, 1, party.get(j).getName());
            }
            if (i==1){
              TextBox(startRow + 1, 9 + j*(80/3), 80/3 -3, 1, "HP: " + colorByPercent(party.get(j).getHP(),party.get(j).getmaxHP()));
            }
            if (i==2){
              TextBox(startRow + 2, 9 + j*(80/3), 80/3 -3, 1, party.get(j).getSpecialName() + ": " + party.get(j).getSpecial());
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
    if (((double)hp/maxHP) < .25){
      return Text.colorize(output, Text.RED); 
    }
    // under 75% : yellow
    if (((double)hp/maxHP) < .75){
      return Text.colorize(output, Text.YELLOW); 
    }
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
  public static void drawScreen(ArrayList<Adventurer> party, ArrayList<Adventurer> enemies){

    

    //draw player party
    drawParty(party, 25);
    //draw enemy party
    drawParty(enemies, 3);

    drawBackground();
    Text.go(29, 2);
  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(29, 55);
      //show cursor
      Text.showCursor();
      String input = in.nextLine();

      //clear the text that was written
      Text.clear();
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

    // int enemyNum = (int)(Math.random() *3);
    //   if (enemyNum == 0){
    //     enemies.add(new Boss());
    //   }
    //   if (enemyNum == 1){
    //     enemies.add(createRandomAdventurer());
    //     enemies.add(createRandomAdventurer());
    //   }
    //   if (enemyNum == 2){
    //     enemies.add(createRandomAdventurer());
    //     enemies.add(createRandomAdventurer());
    //     enemies.add(createRandomAdventurer());
    //   }
      
    // if (input.equals("1")){
    //   enemies.add(new Boss());
    // }
    // if (input.equals("2")){
    //   enemies.add(createRandomAdventurer());
    //   enemies.add(createRandomAdventurer());
    // }
    // if (input.equals("3")){
    //   enemies.add(createRandomAdventurer());
    //   enemies.add(createRandomAdventurer());
    //   enemies.add(createRandomAdventurer());
    // }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    party.add(createRandomAdventurer());
    party.add(createRandomAdventurer());
    party.add(createRandomAdventurer());
    
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party,enemies);//initial state.
    
    //display this prompt at the start of the game.
    String preprompt1 = "How many enemies do you want to play against?";
    TextBox(29, 2, 60, 1, preprompt1);
 
    
    //Main loop
    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      if (input.equals("1")){
        enemies.add(new Boss());
      }
      if (input.equals("2")){
        enemies.add(createRandomAdventurer());
        enemies.add(createRandomAdventurer());
      }
      if (input.equals("3")){
        enemies.add(createRandomAdventurer());
        enemies.add(createRandomAdventurer());
        enemies.add(createRandomAdventurer());
      }
      //example debug statment
      //TextBox(24,2,78,1,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );
      
      String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      TextBox(29, 2, 60, 1, preprompt);

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

          TextBox(20,4,34,5,(party.get(whichPlayer).attack(enemies.get(target))));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("special") || input.startsWith("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          TextBox(20,4,34,5,(party.get(whichPlayer).special(enemies.get(target))));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        //this is how we do the others
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          TextBox(20,4,34,5,(party.get(whichPlayer).support(party.get(target))));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+ party.get(whichPlayer)+": attack/special/quit";
          TextBox(29, 2, 55, 1, prompt);
          

        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";
          TextBox(29, 2, 55, 1, prompt);
          
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
          TextBox(20,42,34,5,enemies.get(whichOpponent).attack(party.get(choicePlayer)));
        }
        if (choiceAction == 1){
          TextBox(20,42,34,5,enemies.get(whichOpponent).special(party.get(choicePlayer)));
        }
        if (choiceAction == 2){
          TextBox(20,42,34,5,enemies.get(whichOpponent).support(lowestHP(enemies)));
        }
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";
        TextBox(29, 2, 55, 1, prompt);
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
      drawScreen(party,enemies);


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
