/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package del3;

/**
 *
 * @author aneen
 */
public class Player extends Game
{
    private int playerID; //the unique ID for this player
    private String playerName;
    
    /**
     * A constructor that allows you to set the player's unique ID
     * @param name the unique ID to assign to this player.
     */
    public Player(String givenName,int id,String name)
    {
        super(givenName);
        playerID= id;
        playerName=name;
    }
    
    /**
     * @return the playerID
     */
    public int getPlayerID() 
    {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID(int givenID) 
    {
        playerID = givenID;
    }
    
    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}