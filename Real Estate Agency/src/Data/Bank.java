package Data;

import java.util.ArrayList;

public class Bank {

	private int balance, currentHouse = 0;
	private ArrayList<House> properties = new ArrayList<House>();
	
	public Bank(int openAmount){
		
		this.balance = openAmount;
	}
	
	public void buyHouse(House h) {

		balance -= h.getPrice();
		properties.add(h);
	}
	
	public void sellHouse(House h, int sellPrice){
		
		balance += sellPrice;
		properties.remove(h);
		
		if(currentHouse > properties.size() - 1) {currentHouse = 0;}
	}
	
	public boolean canAfford(House h){
		
		if(h.getPrice() <= balance){
			
			return true;
		}
		
		return false;
	}
	
	public void nextHouse() {
		
		currentHouse++;
		if(currentHouse >= properties.size() || properties.size() == 0) {currentHouse = 0;}
	}
	
	public void previousHouse() {
		
		currentHouse--;
		if(currentHouse < 0 && properties.size() > 1) {currentHouse = properties.size() - 1;}
		else {currentHouse = 0;}
	}
	
	public House getHouse() {
		
		if(properties.size() > currentHouse){
			
			return properties.get(currentHouse);
		}
		
		return null;
	}
	
	public void setSellPrice(int sellPrice) {
		
		properties.get(currentHouse).setSellPrice(sellPrice);
	}
	
	public int getBalance() {return balance;}
	public String getBalanceAsString() {return "Balance: $" + Integer.toString(balance);}
	
	public int getHouseCount() {return properties.size();}
	public String getHouseCountAsString() {return Integer.toString(properties.size());}
}
