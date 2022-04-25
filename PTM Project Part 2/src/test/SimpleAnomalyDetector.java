package test;

import java.util.ArrayList; //////////////////////
import java.util.List;

public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {
	

	@Override
	public void learnNormal(TimeSeries ts)
	{
		/*
		System.out.println("RESULTS:\n");
		for(String i : ts.GetAttributeColumn(0))
		{
			
		}
		ArrayList<String> col = ts.GetAttributeColumn(0);
		for (String i : col)
		{
			System.out.println(i);
		}
		*/
		
		System.out.println("RESULTS:\n");
		System.out.println(ts.GetAttributeColumn(0));
		System.out.println("\n");
		System.out.println(ts.GetAttributeColumn(1));
		System.out.println("\n");
		System.out.println(ts.GetAttributeColumn(2));
		System.out.println("\n");
		System.out.println(ts.GetAttributeColumn(3));
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
