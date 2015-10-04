import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;


public class market{
	
ArrayList<stock> market = new ArrayList<stock>();
ArrayList<String> symbols = new ArrayList<String>();
ArrayList<String> prices = new ArrayList<String>();
ArrayList<buyer> unfulfilledBuyersList = new ArrayList<buyer>();
private static File currentStockPrice= null;
private static File StockTransactionLog =  null;
private static File currentStockVolume =  null;

public market()  throws IOException 
{
	/** 
	 *  
	 * @param market An ArrayList that contains a list of all of the stock objects in the market.
	 * @param symbols An ArrayList that contains a list of all of the symbols for each stock in the market.
	 * @param price An ArrayList that contains a list of all of the prices for each stock in the market.
	 * @param currentStockPrice A file object that will have the price of the current stock written to it.
	 * @param StockTransactionLog A file object that will contain the list of each of the current stock's transaction's price & volume.
	 *  
	 */ 
	System.out.println("Creating the random stock market...");
for(int i = 1; i <= 100; i++)
{		
	stock s = new stock();
//	s.setPrice(45.00);
//	System.out.println("Stock number: " + i);
//	System.out.println("The price is now: " + s.getPrice());
	System.out.println("");
	currentStockPrice = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" +s.getSymbol ()+ "-price.txt");
	StockTransactionLog = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" +s.getSymbol ()+ "-transactions.txt");
	currentStockVolume = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" +s.getSymbol ()+ "-volume.txt");

market.add(s);
symbols.add(s.getSymbol());
String total2 = String.valueOf(s.getPrice());
prices.add(total2);
FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + s.getSymbol() + "-transactions.txt","Transaction Log: ");
FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + s.getSymbol() + "-price.txt",String.valueOf(s.getPrice()));
FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + s.getSymbol() + "-volume.txt",String.valueOf(s.getVolume()));

}
}
}
