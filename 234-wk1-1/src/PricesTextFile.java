import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PricesTextFile {
	private static File pricesFile = null;

	private static void checkFile()
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
	public boolean savePrices(ArrayList<String> market)
	{
		PrintWriter out = null;
		try
		{
			checkFile();
			out = new PrintWriter(
					new BufferedWriter(
							new FileWriter(pricesFile)));
			for(int i = 0; i < market.size();i++)
			{
				String country = market.get(i);
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
	public PricesTextFile()
	{
		pricesFile = new File("prices.txt");
		checkFile();
	}
}
