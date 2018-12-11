

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Jack{
	public Hand player;
	public Hand dealer;
	public Deck deck;
	private int play = 0;
	private int hit = 0;
	public BlackJackGUI BJ;
	private int stand =0;
	public Jack(){
	BJ =  new BlackJackGUI();
	BJ.setPlayAction(new PlayAction());
	BJ.setHitAction(new HitAction());
	BJ.setStandAction(new StandAction());
	BJ.enablePlayButton();
	}
	class PlayAction implements ActionListener {
	 public void actionPerformed (ActionEvent e) {
	 deck = new Deck();
	 deck.shuffle();
	 player = new Hand();
	 dealer = new Hand();
	 player.add(deck.nextCard());
	 dealer.add(deck.nextCard());
	 player.add(deck.nextCard());
	 dealer.add(deck.nextCard());
	 BJ.displayPlayer(player);
	 BJ.displayDealerCard(dealer.getTopCard());
	if(!player.hasBlackJack() && !dealer.hasBlackJack() && !player.isBusted()){
	BJ.enableHitAndStandButtons();}
	 if(player.hasBlackJack() || dealer.hasBlackJack() || player.isBusted()){
		 finishGame();
                             }
                         }
	}

	class HitAction implements ActionListener{ 
	 public void actionPerformed (ActionEvent e) {

		 if(!player.isBusted() && player.valueOf() !=21){
			 player.add(deck.nextCard());
			 BJ.displayPlayer(player);
		 }
		 if(player.isBusted() || player.valueOf()==21){
		 finishGame();}
	 }
	}
	class StandAction implements ActionListener{
	public void actionPerformed (ActionEvent e) {
	
		finishGame();
	}
	}
	private void finishGame(){
		if(player.hasBlackJack()){
		BJ.displayDealer(dealer);
		BJ.displayPlayer(player);
		BJ.displayOutcome("You Win");}
		else if(dealer.hasBlackJack()){
		BJ.displayDealer(dealer);
		BJ.displayPlayer(player);
		BJ.displayOutcome("You Lose");}
		else if (player.isBusted()){
		BJ.displayDealer(dealer);
		BJ.displayPlayer(player);
		BJ.displayOutcome("You Lose");}
                                      else if (dealer.hasBlackJack() && player.hasBlackJack()){
		BJ.displayDealer(dealer);
		BJ.displayPlayer(player);
		BJ.displayOutcome("Push");}
		else {
			while( dealer.valueOf()<17 && !dealer.isBusted() ){
			 dealer.add(deck.nextCard());
			}
		   if(dealer.isBusted())
			   {BJ.displayDealer(dealer);
		           BJ.displayPlayer(player);
			   BJ.displayOutcome("You Win");}
                                              else if (player.valueOf() > dealer.valueOf()){
			   BJ.displayDealer(dealer);
		           BJ.displayPlayer(player);
		           BJ.displayOutcome("You Win");}
			 
		   else if (dealer.valueOf() == player.valueOf())
			   {BJ.displayDealer(dealer);
			   BJ.displayPlayer(player);
			   BJ.displayOutcome("You Push");}
                   
		   else if (dealer.valueOf() > player.valueOf()){
			   BJ.displayDealer(dealer);
	                   BJ.displayPlayer(player);
		   	   BJ.displayOutcome("You Lose");}
		   else if
                           (dealer.hasBlackJack()){
			   BJ.displayDealer(dealer);
		           BJ.displayPlayer(player);
		           BJ.displayOutcome("You Lose");
			   } 
                           
                                      }
		BJ.enablePlayButton();
	}	
	public static void main(String[] args){
		new Jack();
	}

}