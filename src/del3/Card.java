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
public class Card {
  private int type;
private int suit;
private int value;
private static String[] types = {"Joker","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
Card(int suit, int values)
{
    this.type=values;
    this.suit=suit;
}
public String toString()
{
    return types[type]+" of "+suits[suit];
}

public int getRank()
{
    return type;
}

public int getSuit()
{
    return suit;
}
public int getValue()
{
    if(type>10)
    {
        value=10;
    }
    else if(type==1)
    {
        value=11;
    }
    else
    {
        value=type;
    }
    return value;
}

public void setValue(int set)
{
    value = set;
}  
}
