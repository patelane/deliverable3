/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package del3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aneen
 */
public class playGame{

    /**
     * @param args the command line arguments
     */
    
private static int cash;
private static int bet;
private static int aces;
private static ArrayList<Card> hand;
private static int handvalue;
private static String name;
public static void main(String[] args){
    Scanner inp = new Scanner(System.in);
    System.out.println("Enter your nickname to play the blackjack game:");
    String n=inp.next();
    System.out.println("Enter your player ID:");
    int playerId=inp.nextInt();
     Player p=new Player(n,playerId);
    System.out.println("Hey "+p.getGameName()+ "Welcome to play black jack");
    System.out.println("Your id is "+p.getPlayerID());
    System.out.println("How much cash do you want to start with?");
    cash = inp.nextInt();
    while(cash>0){
        GroupOfCards deck = new GroupOfCards();//initialize deck, dealer, hands, and set the bet.
        deck.shuffle();
        aces=0;
        Dealer dealer = new Dealer(deck);
        List<Card> hand = new ArrayList<>();
        hand.add(deck.draw());
        hand.add(deck.draw());
        System.out.println("How much would you like to bet?");
        bet=Bet(cash);
        System.out.println("Remaining Cash:"+(cash-bet));
        System.out.println("Money on the table:"+bet);
        System.out.println("Here is your hand: ");
        System.out.println(hand);
        int handvalue = calcHandValue(hand);
        System.out.println("The dealer is showing: ");
        dealer.show();
        if(hasBlackJack(handvalue) && dealer.hasBlackJack())//check if both the user and dealer have blackjack.
        {
            Push();
        }
        else if(hasBlackJack(handvalue))//check if the user has blackjack.
        {
            System.out.println("You have BlackJack!");
            System.out.println("You win 2x your money back!");
            cash=cash+bet;
            Win();
        }
        else if(dealer.hasBlackJack())//check if the dealer has blackjack.
        {
            System.out.println("Here is the dealer's hand:");
            dealer.showHand();
            Lose();
        }
        else
        {
            System.out.println("Would you like to hit or stand?(Enter hit or stand)");//ask if the user will hit or stand
            Scanner hitorstand = new Scanner(System.in);
            String hitter = hitorstand.nextLine();
            
            while(hitter.equals("hit"))//hits the user as many times as he or she pleases.
            {
                Hit(deck, hand);
                System.out.println("Your hand is now:");
                System.out.println(hand);
                handvalue = calcHandValue(hand);
                if(checkBust(handvalue))//checks if the user busted
                {
                    Lose();
                    break;
                }
                
                System.out.println("Would you like to hit or stand?(Enter hit or stand)");
                hitter = hitorstand.nextLine();
            }
            if(hitter.equals("stand"))//lets the user stand.
            {
                int dealerhand = dealer.takeTurn(deck);//takes the turn for the dealer.
                System.out.println("");
                System.out.println("Here is the dealer's hand:");
                dealer.showHand();
                if(dealerhand>21)//if the dealer busted, user wins.
                {
                    Win();
                }
                else
                {
                    int you = 21-handvalue;//check who is closer to 21 and determine winner
                    int deal = 21-dealerhand;
                    if(you==deal)
                    {
                        Push();
                    }
                    if(you<deal)
                    {
                        Win();
                    }
                    if(deal<you)
                    {
                        Lose();
                    }
                }
            }
        }
    System.out.println("Do you want to play again? (yes or no)");//ask if the user wants to keep going
    Scanner yesorno = new Scanner(System.in);
    String answer = yesorno.nextLine();
    
    if(answer.equals("no"))
    {
        break;
    }
}
     System.out.println("Your cash is: "+cash);//if user doesn't want to play or runs out of cash, either congratulates them on their winnings or lets them know
    if(cash==0)
    {
        System.out.println("You don't have any cash left!");
    }
    else
    {
        System.out.println("Good bye!");
    }
}

public static boolean hasBlackJack(int handValue)//Checks if the user has blackjack.
{
    if(handValue==21)
    {
        return true;
    }
    return false;
}

public static int calcHandValue(List<Card> hand)//Calculates the value of a player's hand.
{
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    int handvalue=0;
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            aces++;
        }
        while(aces>0 && handvalue>21)
        {
            handvalue-=10;
            aces--;
        }
    }
    return handvalue;
}
public static int Bet(int cash)
{
    Scanner sc=new Scanner(System.in);
    int bet=sc.nextInt();
    while(bet>cash)
    {
        System.out.println("You cannot bet more cash than you have!");
        System.out.println("How much would you like to bet?");
        bet=sc.nextInt();
    }
    return bet;
}

public static void Win()//Called if the user wins.
{
    System.out.println("Congratulations, you win!");
    cash=cash+bet;
    System.out.println("Cash: "+cash);
}
public static void Lose()
{
    System.out.println("Sorry, you lose!");
    cash=cash-bet;
    System.out.println("Cash: "+cash);
}

public static void Push()//Called if the user pushes
{
    System.out.println("It's a push!");
    System.out.println("You get your money back.");
    System.out.println("Cash: "+cash);
}

public static void Hit(GroupOfCards deck, List<Card> hand)//Adds a card to user's hand and calculates the value of that hand. Aces are taken into account.
{
    hand.add(deck.draw());
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    handvalue = 0;
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            aces++;
        }
        while(aces>0 && handvalue>21)
        {
            handvalue-=10;
            aces--;
        }
    }
}

public static boolean isHitorStand(String hitter)
        {
    if(hitter.equals("hit") || hitter.equals("stand"))
    {
        return true;
    }
    return false;
}

public static boolean checkBust(int handvalue)
{
    if(handvalue>21)
    {
        System.out.println("You have busted!");
        return true;
    }
    return false;
}

public static boolean isyesorno(String answer)
{
    if(answer.equals("yes") || answer.equals("no"))
    {
        return true;
    }
    return false;
}
    }
    

