
public class Better{
	private static int x = 0;
	private int money;	
	public static Card[] cards = new Card[11];
	public Better(){
	money = 200;
	}
	
	public int returnMoney(){
		return money;
	}

	public void addMoney(int newmoney){
		money += newmoney;
		
	}

	public void removeMoney(int newmoney){
		money -= newmoney;
		
	}

	public Card returnCard(int x){
		return cards[x];
	}


	public void addCard(){
		Card a = new Card(this);
		if (search(a.getValue(),0,1)==0){cards[x++]=a;}
		else if (search(a.getValue(),0,1)==1) {return;}
		}

	public int search(int z, int a, int b){
		if (a==x){return 0;}
		else if (b==3){return 1;}
		
		else if (cards[a].getValue() == z){return search(z,a+1,b+1);}
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
