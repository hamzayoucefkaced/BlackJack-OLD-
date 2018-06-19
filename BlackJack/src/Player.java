
public class Player {
private static int x = 0;
public static Card[] cards = new Card[11];

public Card returnCard(int x){
	return cards[x];
}


public void addCard(){
Card a = new Card(this);
if (search(a.getValue(),0,1)){cards[x++]=a;}
else addCard();
}

public boolean search(int z, int a, int b){
if (a==x){return true;}
else if (b==4){return false;}	
else if (cards[a].getValue() == z){return search(z,a+1,b+1);	}
else {return search(z,a+1,b);}	
}


public int cardValue(){
	int x = 0;
	int b = 0;
	while(cards[b]!=null){
		x+=cards[b].getValue();
		b++;
	}
	return x;
	
}

public void removeCards()
{for (int b = x; b>=0; b--){
	cards[b]=null;
}
x=0;
}

}
