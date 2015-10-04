/**
 *  the stock class represents the capacity of one market-listed security
 */
import java.util.Random;
import java.util.ArrayList;
public class stock {
private double price;
private double LastPrice;
private String symbol;
public int numberOfStock; //represents total number of stock initially available 
ArrayList<Transaction> log = new ArrayList<Transaction>();
ArrayList<buyer> SellersList = new ArrayList<buyer>();
public int numberOfStockAvailable;

public stock()
{
	/** 
	 *  
	 * @param price The price of the stock
	 * @param LastPrice The last price the stock was bought at
	 * @param symbol The 4 letter symbol that the stock is represented by.
	 * @param numberOfStock The number of the shares of stock that the stock has remaining.
	 * @param log An ArrayList that contains the log of all of the transactions of this stock.
	 * @param SellersList An ArrayList that contains a list of the sellers of the stock.
	 *  
	 */ 
	this.price = getInitialPrice();
	this.symbol = getInitialSymbol();
	this.numberOfStock = 100;
			; 
	this.LastPrice = getInitialPrice(); 
	this.numberOfStockAvailable = this.numberOfStock;//no sales yet 
//	System.out.println("Symbol: "+ this.symbol);
//	System.out.println("Price: " +   this.price);
//	System.out.println("Volume: "+ this.numberOfStockAvailable);
	}

 	public void addToMyLog(Transaction t) 
 	{ 
 		this.log.add(t); 
 	} 
 	 
 	public void printTheTransactionLog() 
 	{ 
 		System.out.println("Transaction History: "); 
 		for(Transaction t : this.log) 
 		{ 
 			System.out.println("Price: "+   t.getPrice() + " Volume: " + t.getVolume()); 
 		} 
 	} 
 	 
 	/** 
 	 * @return the log 
 	 */ 
 	public ArrayList<Transaction> getLog() { 
 		return log; 
 	} 
 	/** 
 	 * @param log the log to set 
 	 */ 
 	public void setLog(ArrayList<Transaction> log) { 
 		this.log = log; 
 	} 
public double getLastPrice()
{
	return LastPrice;
}
public void setLastPrice(double p)
{
	this.LastPrice = LastPrice;
}
private String getInitialSymbol()
{
	Random r1 = new Random();
	Random r2 = new Random();
	Random r3 = new Random();
	Random r4 = new Random();
//for each stock, determine its ticker symbol, NASDAQ style, four letters
double ra1 = r1.nextDouble(); //generate a number between 0 and 1
double ra2 = r2.nextDouble(); 
double ra3 = r3.nextDouble(); 
double ra4 = r4.nextDouble(); 
//System.out.println("First tell me the value of the random: " + ra1);
//System.out.println("Second tell me the value of the random: " + ra2);
//System.out.println("Third tell me the value of the random: " + ra3);
//System.out.println("Fourth tell me the value of the random: " + ra4);
String symbolLetter1 = generateLetter(ra1);
String symbolLetter2 = generateLetter(ra2);
String symbolLetter3 = generateLetter(ra3);
String symbolLetter4 = generateLetter(ra4);
String symbol = symbolLetter1 + symbolLetter2 + symbolLetter3 + symbolLetter4;
return symbol;
}
public static String generateLetter(double n)
{
	String l = ""; //empty or null, to begin
	 if(n >= 0 && n <= (0.0384615384615385))
	 {
		 l="A";
	 }
	 else if (n>= 0.0384615384615385 && n <= (0.0769230769230769))
	 {
		 l="B";
	 }
	 else if (n>=(0.0769230769230769) && n <= (0.1153846153846154))
	 {
		 l="C";
	 }
	 else if (n>=(0.1153846153846154) && n <= (0.1538461538461538))
	 {
		 l="D";
	 }
	 else if (n>=(0.1538461538461538) && n <= (0.1923076923076923))
	 {
		 l="E";
	 }
	 else if (n>=(0.1923076923076923) && n <= (0.2307692307692308))
	 {
		 l="F";
	 }
	 else if (n>=(0.2307692307692308) && n <= (0.2692307692307692))
	 {
		 l="G";
	 }
	 else if (n>=(0.2692307692307692) && n <= (0.3076923076923077))
	 {
		 l="H";
	 }
	 else if (n>=(0.3076923076923077) && n <= (0.3461538461538462))
	 {
		 l="I";
	 }
	 else if (n>=(0.3461538461538462) && n <= (0.3846153846153846))
	 {
		 l="J";
	 }
	 else if (n>=(0.3846153846153846) && n <= (0.4230769230769231))
	 {
		 l="K";
	 }
	 else if (n>=(0.4230769230769231) && n <= (0.4615384615384615))
	 {
		 l="L";
	 }
	 else if (n>=(0.4615384615384615) && n <= (0.5))
	 {
		 l="M";
	 }
	 else if (n>=(0.5) && n <= (0.5384615384615385))
	 {
		 l="N";
	 }
	 else if (n>=(0.5384615384615385) && n <= (0.5769230769230769))
	 {
		 l="O";
	 }
	 else if (n>=(0.5769230769230769) && n <= (0.6153846153846154))
	 {
		 l="P";
	 }
	 else if (n>=(0.6153846153846154) && n <= (0.6538461538461538))
	 {
		 l="Q";
	 }
	 else if (n>=(0.6538461538461538) && n <= (0.6923076923076923))
	 {
		 l="R";
	 }
	 else if (n>=(0.6923076923076923) && n <= (0.7307692307692308))
	 {
		 l="S";
	 }
	 else if (n>=(0.7307692307692308) && n <= (0.7692307692307692))
	 {
		 l="T";
	 }
	 else if (n>=(0.7692307692307692) && n <=(0.8076923076923077))
	 {
		 l="U";
	 }
	 else if (n>=(0.8076923076923077) && n <= (0.8461538461538462))
	 {
		 l="V";
	 }
	 else if (n>=(0.8461538461538462) && n <= (0.8846153846153846))
	 {
		 l="W";
	 }
	 else if (n>=(0.8846153846153846) && n <= (0.9230769230769231))
	 {
		 l="X";
	 }
	 else if (n>=(0.9230769230769231) && n <= (0.9615384615384615))
	 {
		 l="Y";
	 }
	 else if (n>=(0.9615384615384615) && n <= 1)
	 {
		 l="Z";
	 }
	return l;
}
private static double getInitialPrice() 
{
	double priceToReturn = 8.0;
	Random p = new Random();
	priceToReturn = p.nextDouble() * 100;
	return priceToReturn;
}
public double getNewPrice() 
{
	double priceToRaise = 8.0;
	Random p = new Random();
	priceToRaise = p.nextDouble() * 100;
	return priceToRaise;
}
private static int getInitialVolume() 
{
	int VolumeToReturn;
	Random p = new Random();
	VolumeToReturn = p.nextInt();
	if (VolumeToReturn < 0)
	{
		VolumeToReturn = (VolumeToReturn * -1);
	}
	return VolumeToReturn;
}
public double getPrice()
{
	return this.price;
}
public int getVolume()
{
	return this.numberOfStockAvailable;
}

public String getSymbol()
{
	return this.symbol;
}
public void setPrice(double p)
{
	this.price = p;
}
public void setVolume(int p1)
{
	this.numberOfStockAvailable = p1;
}
}
