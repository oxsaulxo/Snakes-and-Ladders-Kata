import java.util.HashMap;

public class SnakesLadders {
  
    private HashMap <Integer, Integer> playerPosition; // position player key value.
    private int currentPlayer;
    final static int maxBoardNumber = 100;
    private HashMap <Integer, Integer> laddersAndSnakes; // current coordinates of ladders.
  
    public SnakesLadders() {
      
      
    
      currentPlayer = 1;
      
      playerPosition = new HashMap<Integer,Integer>();
      playerPosition.put(1,0);
      playerPosition.put(2,0);
      
      
      // moviments wiuth ladder and snakes.
      
        laddersAndSnakes = new HashMap<Integer, Integer>() {{
            put(2, 38);
            put(7, 14);
            put(8, 31);
            put(15, 26);
            put(21, 42);
            put(28, 84);
            put(36, 44);
            put(51, 67);
            put(71, 91);
            put(78, 98);
            put(87, 94);
            put(16, 6);
            put(46, 25);
            put(49, 11);
            put(62, 19);
            put(64, 60);
            put(74, 53);
            put(89, 68);
            put(92, 88);
            put(95, 75);
            put(99, 80);
        }};
      

    }
                
  
    // getters and setters
                            
      

    private int getCurrentPlayer(){
      
      return currentPlayer;
      
    }

    private void setCurrentPlayer(){
    
        currentPlayer = ( getCurrentPlayer() == 1) ? 2 : 1; // if actual player is 1 set 2, if not 1, set to 1.
      
    }

    private void setPlayerPosition( int newValue ){
      
      playerPosition.replace(getCurrentPlayer(),newValue ); // replace hash value with key current player.
      
    }

    public int getPlayerPosition(int currentPlayer){
      
      return playerPosition.get(currentPlayer); // for key get value.
        
    }



    //methods
  
    private boolean gameIsOver(){
      
      boolean status1 = getPlayerPosition(1) == 100 ? true : false;
      boolean status2 = getPlayerPosition(2) == 100 ? true : false;
      boolean status =  status1 | status2 == true ? true : false;
      
      return status;
        
      
    }

    private int calculateNewPosition(int die1, int die2){
      
      final int currentPosition = getPlayerPosition(getCurrentPlayer());
          
      int newPosition = currentPosition + die1 + die2;
      
      newPosition = newPosition > 100 ? (100 - ( newPosition - 100)) : newPosition;
      
      newPosition = laddersAndSnakes.get(newPosition) != null ? laddersAndSnakes.get(newPosition) : newPosition;
      
      return newPosition;
      
    }
  
    private void calculateNextPlayer(int die1,int die2){
      
    
      if(die1 == die2){
        
          return;
        
      }else{
        
        setCurrentPlayer();
        
      }
      
    }
    
  

    // die1 and die2 sends by client

    public String play(int die1, int die2) {
      
        if( gameIsOver() ) return "Game over!";
      
        final int position = calculateNewPosition(die1,die2);
      
        setPlayerPosition(position);
          
        if( position == 100 ) return String.format("Player %s Wins!", getCurrentPlayer());
      
        String statusMessage = String.format("Player %s is on square %s", getCurrentPlayer(), position);
          
        calculateNextPlayer(die1,die2);
      
        return statusMessage;
    }
  
  
}
