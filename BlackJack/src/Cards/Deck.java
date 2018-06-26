package Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import Game.Player;

public class Deck extends Stack <Card> {
    //Deck is a stack of cards
    ArrayList < Card.CardType > type = new ArrayList < Card.CardType > (13); //contains the enum names
    ArrayList < Card.CardSuite > suite = new ArrayList < Card.CardSuite > (4);

    public Deck() {
        type.add(Card.CardType.ACE);
        type.add(Card.CardType.TWO);
        type.add(Card.CardType.THREE);
        type.add(Card.CardType.FOUR);
        type.add(Card.CardType.FIVE);
        type.add(Card.CardType.SIX);
        type.add(Card.CardType.SEVEN);
        type.add(Card.CardType.EIGHT);
        type.add(Card.CardType.NINE);
        type.add(Card.CardType.TEN);
        type.add(Card.CardType.QUEEN);
        type.add(Card.CardType.KING);
        type.add(Card.CardType.JACK);
        suite.add(Card.CardSuite.CLUB);
        suite.add(Card.CardSuite.SPADE);
        suite.add(Card.CardSuite.HEART);
        suite.add(Card.CardSuite.DIAMOND);

        for (int i = 0; i < 13; i++) {

            for (int x = 0; x < 4; x++) {
                //adds the cards to the deck, each number with its own suite for a total of 52 cards
                push(new Card(type.get(i), suite.get(x)));

            }
        }
    }
    public void shuffle() {
        Collections.shuffle(this);
    }
    public void deal(Player x) {
        x.getCards().add(pop());
    }
}