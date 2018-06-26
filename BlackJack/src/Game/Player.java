package Game;
import java.util.ArrayList;

import Cards.Card;

public class Player {
public ArrayList<Card> cards = new ArrayList<Card>(11);



public Card returnCard(int x){
	return cards.get(x);
}




public int cardValue(){
	int x = 0;
	for(Card i : cards) {
		x+=i.getValue();
	}
	return x;
	
}

public void removeCards()
{
cards.clear();
}

public ArrayList<Card> getCards() {
	return cards;
}




public void setCards(ArrayList<Card> cards) {
	this.cards = cards;
}


}
