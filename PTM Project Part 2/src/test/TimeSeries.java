package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TimeSeries
{
	public String[] values;
	public int collumnsNum;
	public List<ArrayList<String>> columnsList = new ArrayList<ArrayList<String>>(); // a list of each column in an array of lists
	
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
		    	ArrayList<String> column = new ArrayList<String>(); // Create a new list which represents a column
		    	reader.close();
		    	reader = new BufferedReader(new FileReader(csvFileName));
		    	
		    	while((line = reader.readLine()) != null) // Iterate through the collumn's values
		    	{
		    		values = line.split(",");
		    		System.out.println("Value: " + values[i]);	// TODO: 	DEBUG
			    	column.add(values[i]); // Add the current iterated value to the column's list
		    	}
		    	System.out.println("\n**************\n");   // TODO:   	DEBUG

		    	columnsList.add(column); // Add the new column to the list of columns
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

	public ArrayList<String> GetAttributeColumn(int arrIndex) // Given an index as a parameter and return the column of this index from the list of columns
	{
		return columnsList.get(arrIndex);
	}
	
	public List<ArrayList<String>> GetColumnsList() // Return the list of columns of the TimeSeries
	{
		return columnsList;
	}
	
	public int GetColumnsNum() // Return the number of columns i the TimeSeries
	{
		return this.collumnsNum;
	}
	
	public String GetColumnTimeValue(String columnName, int timeStep) // Given a column Name and a time step (row index) Return the value in that same cell of the TimeSeries 
	{
		for (ArrayList<String> column : this.columnsList) // Iterate through each column
		{
			if (column.get(0).equals(columnName)) // Find the desired column
			{
				System.out.println("Returned desired value: " + column.get(timeStep));
				return column.get(timeStep); // Return the value in the given row number
			}
		}
		
		System.out.println("Given column name does not exist in the TimeSeries");
		return null; // If given column name does not exist in the TimeSeries return null
	}
}