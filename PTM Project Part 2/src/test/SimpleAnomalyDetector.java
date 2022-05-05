package test;

import java.util.ArrayList;
import java.util.List;

public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {
	
	List<CorrelatedFeatures> corrFeatures = new ArrayList<CorrelatedFeatures>(); // List containing all the CorrelatedFeatures

	@Override
	public void learnNormal(TimeSeries ts) // Perform an upper triangle matrix scan to correlate between each column with the others and find the strongest correlation
	{
		float corrThreshold; // a correlation must be above this value
		int size = ts.GetColumnsNum();
		int rowsNum = ts.GetRowsNum()-1; // The number of rows in each column without the column name row
		float[] maxPearsArray = new float[size]; // Array containing the max Pearson correlation of each column (indexes of the array are by the order of the columns in the TimesSeries)
		
		for(int i = 0; i < size - 1; i++) // The current column to compare with the others (does not include the last column because it does not have anyone to compare to)
		{			
			System.out.println("current column's index: " + i + "\n");
			for (int j = i+1; j < size; j++) // The current column which is compared to the 'i' column (does not include the i column itself so it wont compare a column with itself)
			{
				System.out.println("current compared column's index: " + j);
				float pears = test.StatLib.pearson(ts.GetColumnArrFloat(i), ts.GetColumnArrFloat(j)); // Perform a Pearson correlation
				pears = Math.abs(pears); // If the result is negative, make it positive
				if (pears > 1) // Prevent pears from being larger than 1 (caused by float values being rounded up)
				{
					pears = 1; // Prevent pears from being larger than 1 (caused by float values being rounded up)
				}
				
				if (pears > maxPearsArray[i]) // If the current correlation is the maximum one for the current iterated (i) column (maximum value for each column is stored in 'maxPearsArray')
				{
					maxPearsArray[i] = pears; // Update the max value for this iterated column
					
					//////////////////////////////////////////////////
					// Create parameters to make the Anomaly Report for the current correlation
					corrThreshold = 0.9f; // TODO: NEED TO REMOVE THIS ASSIGNEMENT
					String firstColName = ts.GetAttributeColumn(i).get(0); // Save the first correlated column's name (the one on the left) into a variable
					String secondColName = ts.GetAttributeColumn(j).get(0); // Save the second correlated column's name (the one on the right) into a variable
					test.Point[] points = new test.Point[rowsNum]; // Create an array of Points of which will provide the Linear Regression. each point in the array is a point made by the values of each line of the correlated columns (left column = x, right column = y)
					for(int row = 0; row < rowsNum; row++)
					{
						test.Point point = new test.Point(ts.GetColumnArrFloat(i)[row], ts.GetColumnArrFloat(j)[row]); // Create a point from each value in the correlated column (left column is the point's x value, right column is the point's y value)
						points[row] = point; // Add the created Point to the Points array
					}
					
					test.Line regLine = test.StatLib.linear_reg(points); // Create a Line by Linear Regression from the Points array of this correlation 
					test.CorrelatedFeatures corrFeature = new test.CorrelatedFeatures(firstColName, secondColName, pears, regLine, corrThreshold); // Create a Correlated Feature from the given parameters
					System.out.println(corrFeature);
					corrFeatures.add(corrFeature); // Add each new CorrelatedFeature to the CorrelatedFeatures List				
					//////////////////////////////////////////////////
				}
				
				if (pears > maxPearsArray[j]) // If the current correlation is the maximum one for the current compared (j) column (maximum value for each column is stored in 'maxPearsArray')
				{
					maxPearsArray[j] = pears; // Update the max value for this compared column
				}
				
				System.out.println(i + " column's and " + j + " column's pearson is: " + pears + "\n");
			}
			System.out.println("******************************************************************\n");
		}		

		
		System.out.println("Maximum Pearson correlation values are:\n");
		for (int i = 0; i < size; i++)
		{
			System.out.println("column " + i + ": " + maxPearsArray[i]);
		}
		
		System.out.println("DEBUG");	
	}


	@Override
	public List<AnomalyReport> detect(TimeSeries ts)
	{
		
		return null;
	}
	
	public List<CorrelatedFeatures> getNormalModel()
	{
		
		return corrFeatures;
	}
}
