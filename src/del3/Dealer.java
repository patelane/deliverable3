/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package del3;

import java.util.ArrayList;

/**
 *
 * @author aneen
 */
public class Dealer {
    ArrayList<Card> hand;
private int handvalue=0;
private Card[] aHand;
private int Aces;
Dealer(GroupOfCards deck)
{
    hand = new ArrayList<>();
    aHand = new Card[]{};
    int Aces=0;
    for(int i=0; i<2; i++)
    {
        hand.add(deck.draw());
    }
    aHand = hand.toArray(aHand);
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            Aces++;
        }
        while(Aces>0 && handvalue>21)
        {
            handvalue-=10;
            Aces--;
        }
    }
}
public void show()
{
    Card[] firstCard = new Card[]{};
    firstCard = hand.toArray(firstCard);
    System.out.println(firstCard[0]);
}

public void Hit(GroupOfCards deck)//Gives the dealer another card and updates the value of his hand. Takes into account the value of aces.
{
    hand.add(deck.draw());
    aHand = hand.toArray(aHand);
    handvalue = 0;
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            Aces++;
        }
        while(Aces>0 && handvalue>21)
        {
            handvalue-=10;
            Aces--;
        }
    }
}
public boolean wantsToHit()
{
    if(handvalue<17)
    {
        return true;
    }
    return false;
}

public boolean hasBlackJack()
{
    if(hand.size()==2 && handvalue==21)
    {
        System.out.println("The dealer has blackjack!");
        return true;
    }
    return false;
}
public void showHand()
{
    System.out.println(hand);
}

public int getHandValue()
{
    return handvalue;
}

public boolean busted(int handvalue)
{
    if(handvalue>21)
    {
        System.out.println("The dealer busted!");
        return true;
    }
    return false;
}
public int takeTurn(GroupOfCards deck)
{
    while(wantsToHit())
    {
        System.out.println("The dealer hits");
        Hit(deck);
        if(busted(handvalue))
        {
            break;
        }
    }
    if(handvalue<=21)
    {
        System.out.print("The dealer stands.");
    }
    return handvalue;
}
}
