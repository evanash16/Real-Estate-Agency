package Data;

public class House {
	
	private int price, sellPrice, squareFootage, numBath, numBedroom;
	private boolean lawn, pool;
	
	public House(int price, int squareFootage, int numBath, int numBedroom, boolean lawn, boolean pool){
		
		this.price = price;
		this.sellPrice = price - (price % 100);
		this.squareFootage = squareFootage;
		this.numBath = numBath;
		this.numBedroom = numBedroom;
		this.lawn = lawn;
		this.pool = pool;
	}
	
	public House(){
		
		this.price = 0;
		this.sellPrice = 0;
		this.squareFootage = 0;
		this.numBath = 0;
		this.numBedroom = 0;
		this.lawn = false;
		this.pool = false;
	}
	
	public void remodel() {
		
		
	}
	
	public int getRemodelPrice(Market market) {
		
		int remodelPrice = price;
		
		if(lawn == false) {remodelPrice += (0.05 * price);}
		if(pool == false) {remodelPrice += (0.25 * price);}
		
		remodelPrice += price * ((double) (market.getSquareFootage() - squareFootage) / (double) market.getSquareFootage());
		
		return remodelPrice;
	}
	
	public void setPrice(int price) {this.price = price; this.sellPrice = price - (price % 100);}
	public int getPrice() {return price;}
	
	public void setSellPrice(int sellPrice) {this.sellPrice = sellPrice;}
	public int getSellPrice() {return sellPrice;}
	
	public void setSquareFootage(int squareFootage) {this.squareFootage = squareFootage;}
	public int getSquareFootage() {return squareFootage;}
	
	public void setNumBath(int numBath) {this.numBath = numBath;}
	public int getNumBath() {return numBath;}
	
	public void setNumBedroom(int numBedroom) {this.numBedroom = numBedroom;}
	public int getNumBedroom() {return numBedroom;}
	
	public void setLawn(boolean lawn) {this.lawn = lawn;}
	public boolean getLawn() {return lawn;}
	
	public void setPool(boolean pool) {this.pool = pool;}
	public boolean getPool() {return pool;}
	
	public String getSquareFootageAsString() {return "Square Footage: " + Integer.toString(squareFootage) + " sq. ft.";}
	public String getPriceAsString() {return "Price: $" + Integer.toString(price);}
	public String getSellPriceAsString() {return "Sell Price: $" + Integer.toString(sellPrice);}
	public String getNumBedroomsAsString() {return "Bedrooms: " + Integer.toString(numBedroom);}
	public String getNumBathAsString() {return "Bathrooms: " + Integer.toString(numBath);}
	public String getLawnAsString() {if(lawn) {return "Lawn: ✓";} else {return "Lawn: X";}}
	public String getPoolAsString() {if(pool) {return "Pool: ✓";} else {return "Pool: X";}}

}
