package test;

import java.util.List;

public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {
	

	@Override
	public void learnNormal(TimeSeries ts) // Perform an upper triangle matrix scan to correlate between each column with the others and find the strongest correlation
	{
		int size = ts.GetColumnsNum();
		float[] maxPearsArray = new float[size]; // Array containing the max Pearson correlation of each column (indexes of the array are by the order of the columns in the TimesSeries)
		
		for(int i = 0; i < size - 1; i++) // The current column to compare with the others (does not include the last column because it does not have anyone to compare to)
		{			
			System.out.println("current column's index: " + i + "\n");
			for (int j = i+1; j < size; j++) // The current column which is compared to the 'i' column (does not include the i column itself so it wont compare a column with itself)
			{
				System.out.println("current compared column's index: " + j);
				float pears = test.StatLib.pearson(ts.GetColumnArrFloat(i), ts.GetColumnArrFloat(j)); // Perform a Pearson correlation
				pears = Math.abs(pears); // If the result is negative, make it positive
				if (pears > maxPearsArray[i]) // If the current correlation is the maximum one for the current iterated (i) column (maximum value for each column is stored in 'maxPearsArray')
				{
					maxPearsArray[i] = pears; // Update the max value for this iterated column
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
		
		return null;
	}
}
