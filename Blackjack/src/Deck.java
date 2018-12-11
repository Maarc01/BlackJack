import java.awt.*;
import java.util.*;

public class Deck{
	private Card[] ArrDeck = new Card[52];
	private int index = 0;
	public Deck() {
		int index2 = 0;
		for(int i =0; i<4; i++){
			for(int j=0; j<13; j++){
			Card a = new Card(i,j);
			 ArrDeck[index2] = a;
			 index2++;
			}
		}
	}
	public void shuffle(){
		index = 0;
		int cont=0;
		while (cont<1000){
		Random rand = new Random();
		int x= rand.nextInt(52);
		int y= rand.nextInt(52);
		Card stored = ArrDeck[x];
		ArrDeck[x] = ArrDeck[y];
		ArrDeck[y] = stored;
		cont++;
	}
	}
	public boolean hasNextCard(){
		return index<52;
	}
	public Card nextCard(){
		if(index<52){
		index++;
		return ArrDeck[index-1];
		
		}
		else{
		return null;
		}
	}
	public static void main(String[] args){
		Deck a = new Deck();
		System.out.println(a.toString());
		while(a.hasNextCard()){
		System.out.println(a.nextCard());
		}
		a.shuffle();
		System.out.println(a.toString());
		
		while(a.hasNextCard()){
			System.out.println(a.nextCard());
		}
	}
}