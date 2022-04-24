package test;

import java.util.List;

public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {
	

	@Override
	public void learnNormal(TimeSeries ts)
	{
//		for() 
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
