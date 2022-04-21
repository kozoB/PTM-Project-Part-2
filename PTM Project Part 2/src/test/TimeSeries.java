package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TimeSeries
{
	//public List<String> rows = new ArrayList<String>(); // each list is a row in the csv file
	public ArrayList<String>[] arr1; // actual array used in class by other classes
	
	public TimeSeries(String csvFileName)
	{
		BufferedReader reader = null;
		String line = "";
		
		try
		{
			reader = new BufferedReader(new FileReader(csvFileName));
			int idx = 0; // the index of each line
			int rowNum = 0; // to count the number of a rows in the csv file and determine the size of the ArrayList
			
			/* Count number of columns */
			while((line = reader.readLine()) != null)
			{
				String[] row1 = line.split(",");
				rowNum++;
				System.out.println("size: " + rowNum);
			}
			reader.close();
			/* <End>Count number of columns */
			
			reader = new BufferedReader(new FileReader(csvFileName));
			line = "";
			ArrayList<String>[] arr = new ArrayList[rowNum]; // Array of lists (each arr[idx] is a list which resembles a row)
			
			while((line = reader.readLine()) != null)
			{
				arr[idx] = new ArrayList<String>();
				String[] row = line.split(",");
				
				for(String index : row)
				{	
					arr[idx].add(index); // add row's value to the list
					System.out.println("new index: " + arr[idx]);
				}
				
				System.out.println(arr);
				arr1 = arr; // copy arr's values to arr1's values so arr1 can be used as the class'es data container
				idx++;
				System.out.println("arr1: "+arr1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
