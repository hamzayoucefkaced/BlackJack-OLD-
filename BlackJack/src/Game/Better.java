package Game;

public class Better extends Player{
	private int money;	
	public Better(){
	money = 200;
	}
	
	public int getMoney(){
		return money;
	}
	
	public void setMoney(int mon) {
		money = mon;
	}

	public void addMoney(int newmoney){
		money += newmoney;
		
	}

	public void removeMoney(int newmoney){
		money -= newmoney;
		
	}

}
