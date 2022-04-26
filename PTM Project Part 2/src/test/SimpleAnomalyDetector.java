package test;

import java.util.ArrayList; //////////////////////
import java.util.List;

public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {
	

	@Override
	public void learnNormal(TimeSeries ts)
	{
		System.out.println("NODER:\n");
		for (int idx = 0; idx < ts.GetColumnsNum(); idx++)
		{
			for(String i : ts.GetAttributeColumn(idx))
			{
				System.out.println(i);
			}			
		}
		
		System.out.println("\n");
		System.out.println(ts.GetColumnTimeValue("A", 15));
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
