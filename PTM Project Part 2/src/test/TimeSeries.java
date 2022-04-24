package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TimeSeries
{
	public String[] values; // actual array used in class by other classes
	public int collumnsNum; // TODO Change to 0
	public List<String> lists;
	
	public TimeSeries(String csvFileName) // Ctor
	{
		BufferedReader reader = null;
		String line = "";
		
		try
		{
			reader = new BufferedReader(new FileReader(csvFileName));
			
			/* Get the number of columns into a variable */
			line = reader.readLine();
	    	values = line.split(",");
	    	collumnsNum = values.length;
	    	System.out.println("Num of columns: " + collumnsNum);
		    /* ^Get the number of columns into a variable^ */
			
		    
	    	/* Get each columns into a list */
		    for (int i = 0; i < collumnsNum; i++)
		    {
		    	reader.close();
		    	reader = new BufferedReader(new FileReader(csvFileName));
		    	while((line = reader.readLine()) != null)
		    	{
		    		values = line.split(",");
		    		System.out.println("Time: " + values[i]);		
		    	}
		    }
		    /* Get each columns into a list */
		}
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public String GetAttributeColumn(int arrIndex)
	{
		return this.values[arrIndex];
	}
}
