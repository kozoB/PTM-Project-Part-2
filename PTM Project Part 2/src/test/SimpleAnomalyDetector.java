package test;

import java.util.ArrayList; //////////////////////
import java.util.List;

public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {
	

	@Override
	public void learnNormal(TimeSeries ts)
	{
		System.out.println(ts.GetRowsNum());
		float[] arr = ts.GetColumnArrFloat("A");
		System.out.println("Debug");
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
