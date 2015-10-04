import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class mainX {
//private static Scanner sc;
//private static Scanner sc2;
//private static Scanner sc4;
public static market market1;
private static File currentPriceFile= null;
private static File currentVolumeFile= null;
//private int randomSymbolNumber;

public static void main(String[] args) throws IOException 
{
	/** 
	 *  
	 * @param market1 A market object that is based on the market class.
	 * @param currentPriceFile A file object that will have the current stock's price written to it.
	 * @param currentVolumeFile A file object that will have the current stock's volume written to it.
	 *  
	 */ 
	ArrayList<buyer> buyerList = new ArrayList<buyer>();

	market1 = new market();

	for(int i = 1; i <= 1000; i++)
	{		
		buyer b = new buyer();
		System.out.println("Buyer Number: " + i);
		buyerList.add(b);


	}
	for (buyer b1: buyerList)
	{
		double PricePerStock = 0;
		double CurrentPriceSpent = 0;
		double OriginalBudget = b1.GetBudget();
		if( b1.GetBudget() > 0 && b1.unfulfilledStock.size() > 0)
		{
//			System.out.println("This action occurred.");
			for(int i1 = 1; i1 <= b1.unfulfilledStock.size(); i1++)
			{
				stock sample2 = b1.unfulfilledStock.get(i1);
			 	if (sample2.SellersList.size() > 0 )
			 	{
					buyer b2 = sample2.SellersList.get(0);
					 System.out.println("Stock available from " + b2.BuyerName);

					String input = 	FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\" + b1 +"-"+sample2.getSymbol()+ "-price.txt");
					String input2 = FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\" + b1 +"-"+sample2.getSymbol()+ "-volume.txt");
					int input2int = (int) Double.parseDouble(input2);
					PricePerStock =(sample2.getPrice()*input2int);
					sample2.SellersList.remove(b1);
					Transaction t1 = new Transaction( sample2.getPrice() , input2int);  
				 	if(t1 != null) 
				 	{ 
				 		sample2.setVolume(sample2.getVolume() - input2int);
//				 		sample2.addToMyLog(t1);//adds the latest sale information, to that stock's log	
						String input3 = FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample2.getSymbol() + "-transactions.txt");
						String inputPrice = String.valueOf(sample2.getPrice());
						String inputVolume = String.valueOf(sample2.getVolume());
						currentVolumeFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + b1.BuyerName+ "-" + sample2.getSymbol()+ "-volume.txt");
						checkcurrentVolumeFile();
//						FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample2.getSymbol() + "-transactions.txt", input3 + "Transaction: Price-" + inputPrice + " Volume-" + inputVolume);
						FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample2.getSymbol() + "-volume.txt",String.valueOf(sample2.getVolume()));
						FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\"+ b1.BuyerName +"-"+ sample2.getSymbol() + "-volume.txt",input2);
						b1.	portfolio.add(sample2.getSymbol());
						b1.portfolioStock.add(sample2);
						currentPriceFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + b1.BuyerName+ "-" + sample2.getSymbol()+ "-price.txt");
						checkcurrentPriceFile();			
			 	} 
//				 	System.out.println("Original Price: " + sample.getPrice());
//				 	System.out.println("New price: " + sample.getPrice());
				 	
				 	CurrentPriceSpent = (CurrentPriceSpent + PricePerStock);
					b1.budget = OriginalBudget-CurrentPriceSpent;	
//					System.out.println("Transaction complete. " + b1.BuyerName + " just bought " +b1.S1 + " shares of " + sample2.getSymbol()+ " from " + b2.BuyerName + " for $" + input5));
//		Delete the file after sale.
//					File file = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + sample.getSymbol()+"-price.txt");
//					file.delete();
			 	}
		
			}
		}
		else
		{
			
		}
	}
	}
private static void checkcurrentPriceFile()
{
	try
	{
		if(!currentPriceFile.exists())
			currentPriceFile.createNewFile();
	}
	catch(IOException ioe)
	{
		ioe.printStackTrace();
	}

}
private static void checkcurrentVolumeFile()
{
	try
	{
		if(!currentVolumeFile.exists())
			currentVolumeFile.createNewFile();
	}
	catch(IOException ioe)
	{
		ioe.printStackTrace();
	}

}
}
//	System.out.println("Welcome to My-Trade Stock Interface");
//	System. out.println( "Do you view stocks up for sale?" );
//	System. out.println( "(1) Yes" );
//	System. out.println( "(2) No" );
//	sc = new Scanner(System.in);
//	int choice = sc.nextInt();
//	switch (choice)
//	{
//	case 1:
//		for(stock s: market1.stocksForSale)
//		{
//			System. out.println(s.getSymbol());
//		}
//	case 2:
//		
//}
//}
//}
//	System.out.println("Current size of market is: " + market.size());

//System.out.println("Your original budget was: " + OriginalBudget);

//	boolean there = false; 
//while (true)
//{
//	sc = new Scanner(System.in);
//	System.out.println("Please enter name of a stock to get: ");
//	String response = sc.nextLine();
//		for(stock s : market1.market) 
//	{
//		if (s.getSymbol().equalsIgnoreCase(response))
//		{
//			there = true;
//		}
//			else
//			{
//				there = false;
//			}
//	if(there == true)		
//	{
//		if (s.getVolume() > 0)
//		{
//	System. out.println( "Just located the stock, what would you like to do?" );
//	System. out.println( "(1) Buy a stock" );
//	System. out.println( "(2) Study the stock" );
//	int choice = sc.nextInt();
//	switch (choice)
//	{
//	case 1:
//	System. out.println( "Entering the buy screen" );
//	System.out.println("The price is: " + s.getPrice());
//	System.out.println("What's your bid?");
//	double bidPrice = sc.nextDouble();
//	System.out.println("How many shares do you want to buy at the price?");
//	System.out.println("Current volume: "+ s.getVolume());
//	int purchasePrice = sc.nextInt();
//	if (purchasePrice > s.getVolume())
//	{
//		new Scanner(System.in);
//		System.out.println("You have entered too many stocks. Please enter a different amount.");
//		System.out.println("Current volume: "+ s.getVolume());
//		System.out.println("Restarting the program.");
//		break;
//	}
//	else
//	{
//	System.out.println("Final confirmation: ");
//	System.out.println("Do you want to purchase " + purchasePrice + " shares of " + s.getSymbol()+" at $"+ bidPrice +"?" );
//	System. out.println( "(1) Yes" );
//	System. out.println( "(2) No" );
//	sc2 = new Scanner(System.in);
//	int choice2 = sc2.nextInt();
//	switch (choice2)
//	{
//	case 1:
//		s.setPrice(bidPrice);
//		s.setVolume(s.getVolume() - purchasePrice);
//		System.out.println( "OK. You have purchased your stock and added the stock to your portfolio." );
//		System.out.println("The new volume level for the stock is: "+ s.getVolume() + " and its price is: $"+ s.getPrice());
//		s.numberOfStockAvailable -= purchasePrice;
//		
//		Transaction t = new Transaction(bidPrice, purchasePrice);  
//		 	if(t != null) 
//		 	{ 
//			s.addToMyLog(t);//adds the latest sale information, to that stock's log 	
//		 	System.out.println("Change in stock: "+ (bidPrice - s.getLastPrice()));
//		 	s.setLastPrice(bidPrice);
//		 	} 
//		 there = false;
//		 break;
//	case 2:
//		System.out.println( "Purchase has been canceled" );
//		there = false;
//		break;
//	}
//	}
//	case 2:
// 	s.printTheTransactionLog(); 	
//	break;
//		}
//	}
//		else
//		{
//			System.out.println( "This stock has been sold out. Please wait until someone is willing to sell this stock.");
//			break;
//		}
//	}
//	}

//	}	
//}
//}

/**
	*@param n, a randomly generated number
	*@return l, a string representing a letter
	*
*/


