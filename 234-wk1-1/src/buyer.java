import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
public class buyer 
{
	private static File symbolsFile= null;
	private static File pricesFile= null;
	private static File volumeFile= null;
	private static File currentPriceFile= null;
//	private static File currentBuyerFile= null;
	private static File currentVolumeFile= null;
//	private static File currentS1File= null;
	private static File sellPriceFile= null;
	private static File sellVolumeFile= null;
	double budget;
	int portfolioDepth;
	public ArrayList<stock> portfolioStock = new ArrayList<stock>(); 
	public ArrayList<stock> unfulfilledStock = new ArrayList<stock>(); 
	public ArrayList<String> portfolio = new ArrayList<String>(); 
	public ArrayList<String> portfolioPricesString = new ArrayList<String>(); 
	public String BuyerName;
	Random r1 = new Random();
//	double Budget = r1.nextDouble();
	public buyer() throws IOException
	
	{
		boolean buyModeOn = true;
		this.BuyerName = getInitialName();
		System.out.println("UserID: "+ BuyerName);
		this.budget = CreateRandomBudget();
		double OriginalBudget = this.budget;
		double CurrentPriceSpent = 0;
		double PricePerStock = 0;
//		stock sample2 = mainX.market1.market.get(5000);
//		sample2.setVolume(0);
	
	while(CurrentPriceSpent < OriginalBudget)
	{
	
			int R = (int) (Math.random() * (100 - 1)) + 1;
		double S = (double) (Math.random() * (50 - 1)) + 1;
		double S1 =  Math.round(S);
//		currentS1File = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\S1.txt");
//		checkS1File();
//		FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\S1.txt", String.valueOf(S1));
		stock sample = mainX.market1.market.get(R);
		PricePerStock =(sample.getPrice()*S1);
			symbolsFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\"+ BuyerName + "-" + sample.getSymbol()+ "-price.txt");
		checkFile();
//		 if (sample.SellersList.size() > 0)
//		 {
//		 buyer b1 = sample.SellersList.get(0);
//		 currentBuyerFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\currentbuyer.txt");
//		 FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\currentbuyer.txt", b1.BuyerName);
//		 String input5 = 	FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\" + b1.BuyerName +"-"+sample.getSymbol()+ "-price.txt");
//			String input6 = FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\" + b1.BuyerName+"-"+sample.getSymbol()+ "-volume.txt");
//			int inputint = (int) Double.parseDouble(input5);
//			int input2int = (int) Double.parseDouble(input6);
//			int PricePerStock3 = inputint * (int)S1;
//		 }
//		System.out.println("Your current budget is: "+this.budget);
		if (PricePerStock <= this.budget && sample.getVolume()>0 && buyModeOn == true && this.budget > 0 )
		{
			Transaction t1 = new Transaction( sample.getPrice() , (int)S1);  
		 	if(t1 != null) 
		 	{ 
		 		sample.setVolume(sample.getVolume() - (int)S1);
				sample.addToMyLog(t1);//adds the latest sale information, to that stock's log	
				String input = 	FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample.getSymbol() + "-transactions.txt");
				String inputPrice = String.valueOf(sample.getPrice());
				String inputVolume = String.valueOf(sample.getVolume());
				currentVolumeFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + sample.getSymbol()+ "-volume.txt");
				checkcurrentVolumeFile();
				FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample.getSymbol() + "-transactions.txt", input + "Transaction: Price-" + inputPrice + " Volume-" + inputVolume);
				FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample.getSymbol() + "-volume.txt",String.valueOf(sample.getVolume()));
				FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\"+ BuyerName +"-"+ sample.getSymbol() + "-volume.txt",String.valueOf(S1));
				portfolio.add(sample.getSymbol());
			portfolioStock.add(sample);
			currentPriceFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + sample.getSymbol()+ "-price.txt");
			checkcurrentPriceFile();
		
			String	StringPrice = String.valueOf(sample.getPrice());
			FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + sample.getSymbol()+ "-price.txt",StringPrice);
		 	sample.setPrice(sample.getPrice()+sample.getNewPrice());
			String	StringNewPrice = String.valueOf(sample.getPrice());
		 	FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" +  sample.getSymbol()+ "-price.txt",StringNewPrice);
		 	} 
//		 	System.out.println("Original Price: " + sample.getPrice());
//		 	System.out.println("New price: " + sample.getPrice());
			CurrentPriceSpent = (CurrentPriceSpent + PricePerStock);
			this.budget = OriginalBudget-CurrentPriceSpent;	
//			System.out.println("Your remaining budget is: $" + this.budget);
//			System.out.println("You just bought " + S1 + " shares of "+ sample.getSymbol() +" stock" + " amounting to $" + PricePerStock); 
//			System.out.println("You spent: " + CurrentPriceSpent);
//			System.out.println("Your remaining budget is: " + this.Budget);
		}
//		System.out.println("Your remaining budget is: " + this.Budget);
		 if (PricePerStock > this.budget && sample.getVolume()>0 && buyModeOn == true && this.budget > 0 )
			{
			Transaction t2 = new Transaction( sample.getPrice() ,1 );  
			 	if(t2!= null) 
			 	{ 
			 	sample.setVolume(sample.getVolume() - (int)S1);
				sample.addToMyLog(t2);//adds the latest sale information, to that stock's log	
				String input = 	FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample.getSymbol() + "-transactions.txt");
				String inputPrice = String.valueOf(sample.getPrice());
				String inputVolume = String.valueOf(sample.getVolume());
				FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample.getSymbol() + "-transactions.txt", input + "Transaction: Price-" + inputPrice + " Volume-" + inputVolume);
				FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample.getSymbol() + "-volume.txt",String.valueOf(sample.getVolume()));
				portfolio.add(sample.getSymbol());
				portfolioStock.add(sample);
				currentPriceFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + sample.getSymbol()+ "-price.txt");
				checkcurrentPriceFile();
				currentVolumeFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + sample.getSymbol()+ "-volume.txt");
				checkcurrentVolumeFile();
				String	StringPrice = String.valueOf(sample.getPrice());
				FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + sample.getSymbol()+ "-price.txt",StringPrice);
				FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\"+ BuyerName +"-"+ sample.getSymbol() + "-volume.txt",String.valueOf(S1));
				sample.setPrice(sample.getPrice()+sample.getNewPrice());
				String	StringNewPrice = String.valueOf(sample.getPrice());
			 	FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" +  sample.getSymbol()+ "-price.txt",StringNewPrice);
			 	
			 	} 
				CurrentPriceSpent = (CurrentPriceSpent + this.budget);
				this.budget = OriginalBudget-CurrentPriceSpent;
//				System.out.println("Your remaining budget is: $" + this.budget);


//			 	System.out.println("New price: " + sample.getPrice());
//				System.out.println("You just bought 1" + " shares of "+ sample.getSymbol() +" stock" + " amounting to $" + SpentOnThisOne); 
//				System.out.println("You spent: " + CurrentPriceSpent);
			}
	 else if (sample.getVolume() == 0 && buyModeOn == true && this.budget > 0 ) 
			{
		 System.out.println(sample.getSymbol() + " is not available. Searching for sellers of "+ sample.getSymbol() + ".");

//		System.out.println(String.valueOf("Budget is: "+ String.valueOf(this.budget)));
//		System.out.println(String.valueOf("PricePerStock3's output is: "+ PricePerStock3));
	
		 if (sample.SellersList.size() > 0)
		 {
			 System.out.println("Seller found.");
			 buyer b1 = sample.SellersList.get(0);
//			 currentBuyerFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\currentbuyer.txt");
//			 FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\currentbuyer.txt", b1.BuyerName);
			 String input5 = 	FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\" + b1.BuyerName +"-"+sample.getSymbol()+ "-price.txt");
				String input6 = FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\" + b1.BuyerName+"-"+sample.getSymbol()+ "-volume.txt");
				int inputint = (int) Double.parseDouble(input5);
				int input2int = (int) Double.parseDouble(input6);
				int PricePerStock3 = inputint * (int)S1;
//			String inputbuyer = FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\currentbuyer.txt");
//			 for(buyer b: sample.SellersList)
//			 {
//				 if(inputbuyer.equalsIgnoreCase(b.BuyerName));
//				 {
			
//				String input5 = 	FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\" + b.BuyerName +"-"+sample.getSymbol()+ "-price.txt");
//				String input6 = FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\" + b.BuyerName+"-"+sample.getSymbol()+ "-volume.txt");
//				int inputint = (int) Double.parseDouble(input5);
//				int input2int = (int) Double.parseDouble(input6);
				sample.SellersList.remove(b1);
				Transaction t1 = new Transaction( inputint , input2int);  
			 	if(t1 != null) 
			 	{ 
					String input3 = FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample.getSymbol() + "-transactions.txt");
					String inputPrice = String.valueOf(sample.getPrice());
					String inputVolume = String.valueOf(sample.getVolume());
					currentVolumeFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + sample.getSymbol()+ "-volume.txt");
					checkcurrentVolumeFile();
//					FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample.getSymbol() + "-transactions.txt", input3 + "Transaction: Price-" + input + " Volume-" + input2);
					FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\market\\" + sample.getSymbol() + "-volume.txt",String.valueOf(sample.getVolume()));
					FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\"+ BuyerName +"-"+ sample.getSymbol() + "-volume.txt",input6);
					portfolio.add(sample.getSymbol());
				portfolioStock.add(sample);
				currentPriceFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + sample.getSymbol()+ "-price.txt");
				checkcurrentPriceFile();		
//				System.out.println("Your budget is: " + this.budget);
				} 
//			 	System.out.println("Original Price: " + sample.getPrice());
//			 	System.out.println("New price: " + sample.getPrice());
			 	double PricePerStock2 = S1 *sample.getPrice();
//			 	System.out.println("CurrentPriceSpent output is: "+ String.valueOf(CurrentPriceSpent) + " & "+ "PricePerStock2 output is: " + String.valueOf(PricePerStock2));
//			 	System.out.println("Added together it equals to: " +String.valueOf(CurrentPriceSpent + PricePerStock2));
					 	CurrentPriceSpent = (CurrentPriceSpent + PricePerStock3);
				this.budget = this.budget-CurrentPriceSpent;
				System.out.println("Transaction complete. " + BuyerName + " just bought " +S1 + " shares of " + sample.getSymbol()+ " from " + b1.BuyerName + " for $" + input5);
				
				// System.out.println("Your remaining budget is: $" + this.budget);

//				System.out.println(this.budget);	
//				System.out.println(this.budget);
//	Delete the file after sale.
//				File file = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + sample.getSymbol()+"-price.txt");
//				file.delete();
		 	}
				
			 
		 }
	 else if (sample.SellersList.size() < 0)


		 	{
		 		System.out.println("Seller not found");
		 		unfulfilledStock.add(sample);
		 	}
			
//	}
	}
	
	int numberOfStockstoSell = (int) ((Math.random() * (portfolioStock.size() - 1)) + 1);

	for(int i = 1; i <= numberOfStockstoSell; i++) 
	{
		int whichStocktoSell = (int) ((Math.random() * (portfolioStock.size())));
		stock sample1 = portfolioStock.get(whichStocktoSell);
		portfolioStock.remove(sample1);
		sample1.SellersList.add(this);
		System.out.println(sample1.getSymbol() + ": Sell");
		sellPriceFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\"+ BuyerName +"-"+ sample1.getSymbol() + "-price.txt");
		checksellPriceFile();
		double R1 = (Math.random() * (sample1.getPrice() - 100)) + 100;
		String	StringPrice1 = String.valueOf(R1);
		FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\" + BuyerName+"-"+sample1.getSymbol()+ "-price.txt", StringPrice1);
		FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\"+ BuyerName +"-"+ sample1.getSymbol() + "-volume.txt",String.valueOf(sample1.getVolume()));
//		System.out.println("Your remaining budget is: $" + this.budget);

		//		this.budget = this.budget + R1*	Double.parseDouble(FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\S1.txt"));
//System.out.println("Hi!");
		// Code for if the purchase price is greater than current price
//		for(stock s : portfolioStock)
//		{
//			String LoadPrice = FilesUtil.readTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + s.getSymbol()+"-price.txt");
//			double purchasePrice = Double.parseDouble(LoadPrice);
//			String currentSymbol = s.getSymbol();
//			if (purchasePrice <= s.getPrice())
//					{
//				//sell
//				System.out.println(s.getSymbol() + ": Sell");
//			s.SellersList.add(this);	
//			sellPriceFile = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\"+ BuyerName + s.getSymbol() + ".txt");
//				checksellPriceFile();
//				double R1 = (Math.random() * (s.getPrice() - purchasePrice)) + purchasePrice;
//				String	StringPrice1 = String.valueOf(R);
//				FilesUtil.writeToTextFile("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\StocksForSale\\" + BuyerName+"-"+s.getSymbol()+ ".txt", StringPrice1);
////				Somewhat buggy code. Uncomment at own risk!
////				File file = new File("C:\\Users\\ac765\\OneDrive\\Cal Poly Pomona\\CIS 234\\workspace\\234-wk1-1\\Buyers\\" + BuyerName+ "-" + currentSymbol+"-price.txt");
////					file.delete();
//					}
//			else
//			{
//				System.out.println(s.getSymbol() + ": Hold");
//				//hold
//			}
//		}
	}

	System.out.println("Your remaining budget is: $" + this.budget);
		if (this.budget < 0)
	{
		System.out.println("This is negative.");
	}
}
	

	
	
	public double CreateRandomBudget()
	{		
		double BudgetToReturn;
		Random r = new Random();
		 BudgetToReturn = r.nextDouble() * 100000;
		 if(BudgetToReturn < 0)
		 {
			 BudgetToReturn = BudgetToReturn * -1;	 
		 }
		return BudgetToReturn;
	}
	public double GetBudget()
	{		
		return this.budget;
	}
	public void SetBudget(double bdgt)
	{		
	 this.budget = bdgt;
	}
	public String GetBuyerName()
	{		
		return this.BuyerName;
	}
	public void SetBuyerName(String b)
	{		
		this.BuyerName = b;
	}
	public ArrayList<String> generatePortfolio()
			{
		Random r = new Random ();
		double factor = r.nextDouble() * 1000.0; //9879.8789 
		if(factor > 9000.0) 
		{ 
		double difference = factor - 9000.0; 
		factor = factor - difference; //drop it to some number 
		} 
		//choose the stock located at portfolio.itemAt(factor) 
		stock s = new stock(); 
 		this.portfolio.add(s.getSymbol()); 
 		//this.portfolio.get(factor);
		return portfolio;
			}
	private String getInitialName()
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
	int R1 = (int) (Math.random() * (9 - 1)) + 1;
	int R2 = (int) (Math.random() * (9 - 1)) + 1;
	int R3 = (int) (Math.random() * (9 - 1)) + 1;
	int R4 = (int) (Math.random() * (9 - 1)) + 1;
	//System.out.println("First tell me the value of the random: " + ra1);
	//System.out.println("Second tell me the value of the random: " + ra2);
	//System.out.println("Third tell me the value of the random: " + ra3);
	//System.out.println("Fourth tell me the value of the random: " + ra4);
	String symbolLetter1 = generateLetter(ra1);
	String symbolLetter2 = generateLetter(ra2);
	String symbolLetter3 = generateLetter(ra3);
	String symbolLetter4 = generateLetter(ra4);
	String BuyerName = symbolLetter1 + symbolLetter2 + symbolLetter3 + symbolLetter4 + R1 + R2 + R3 + R4 ;
	return BuyerName;
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




		private static void checkFile()
		{
			try
			{
				if(!symbolsFile.exists())
					symbolsFile.createNewFile();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}

		}
		private void close(Closeable stream)
		{
			try
			{
				if(stream !=null)
				stream.close();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		public boolean savePortfolio(ArrayList<String> portfolio)
		{
			PrintWriter out = null;
			try
			{
				checkFile();
				out = new PrintWriter(
						new BufferedWriter(
								new FileWriter(symbolsFile)));
				for(int i = 0; i < portfolio.size();i++)
				{
					String country = portfolio.get(i);
					out.println(country);
				}
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
				return false;
			}
			finally
			{
				close(out);
			}
			return true;
		}
		public boolean saveStock(ArrayList<String> currentPrices)
		{
			PrintWriter out = null;
			try
			{
				checkFile();
				out = new PrintWriter(
						new BufferedWriter(
								new FileWriter(currentPriceFile)));
				for(int i = 0; i < currentPrices.size();i++)
				{
					String country = currentPrices.get(i);
					out.println(country);
				}
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
				return false;
			}
			finally
			{
				close(out);
			}
			return true;
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
		private static void checksellPriceFile()
		{
			try
			{
				if(!sellPriceFile.exists())
					sellPriceFile.createNewFile();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}

		}
//		private static void checkcurrentBuyerFile()
//		{
//			try
//			{
//				if(!currentBuyerFile.exists())
//					currentBuyerFile.createNewFile();
//			}
//			catch(IOException ioe)
//			{
//				ioe.printStackTrace();
//			}
//
//		}
		private void closecurrentPrice(Closeable stream)
		{
			try
			{
				if(stream !=null)
				stream.close();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		public ArrayList<String> getSymbols()
		{
			BufferedReader in = null;
			try
			{
				in = new BufferedReader(
						new FileReader(symbolsFile));
				ArrayList<String> countries = new ArrayList<>();
				String line = in.readLine();
				while(line !=null)
				{
					if(line !=null)
					{
						countries.add(line);
						line = in.readLine();
					}
				
				}
				return countries;
			}
				catch(IOException ioe )
				{
					ioe.printStackTrace();
					return null;
				}finally
				{
					close(in);
				}
		}
		private static void checkPricesFile()
		{
			try
			{
				if(!pricesFile.exists())
					pricesFile.createNewFile();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}

		}
//		private static void checkS1File()
//		{
//			try
//			{
//				if(!currentS1File.exists())
//					currentS1File.createNewFile();
//			}
//			catch(IOException ioe)
//			{
//				ioe.printStackTrace();
//			}
//
//		}
		private void closePrices(Closeable stream)
		{
			try
			{
				if(stream !=null)
				stream.close();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		public boolean savePortfolioPrices(ArrayList<String> portfolio)
		{
			PrintWriter out = null;
			try
			{
				checkFile();
				out = new PrintWriter(
						new BufferedWriter(
								new FileWriter(pricesFile)));
				for(int i = 0; i < portfolio.size();i++)
				{
					String country = portfolio.get(i);
					out.println(country);
				}
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
				return false;
			}
			finally
			{
				close(out);
			}
			return true;
		}
		public ArrayList<String> getPrices()
		{
			BufferedReader in = null;
			try
			{
				in = new BufferedReader(
						new FileReader(pricesFile));
				ArrayList<String> countries = new ArrayList<>();
				String line = in.readLine();
				while(line !=null)
				{
					if(line !=null)
					{
						countries.add(line);
						line = in.readLine();
					}
				
				}
				return countries;
			}
				catch(IOException ioe )
				{
					ioe.printStackTrace();
					return null;
				}finally
				{
					close(in);
				}
		}
	}


