package com.team11.team11_week5;

public abstract class PlanRates {
	public static final double BASICMONTHLYRATE = 0;
	public static final double RATEPEREXCESSMINUTE = 0;
	public static final int INCLUDEMINUTES = 0;
	public static final double ADDITIONALLINERATE=0;

	public abstract double getBasicMonthlyRate();
	
	public abstract int getIncludedMinutes();
	
	public abstract double getRatePerExcessMinute();
	
	public abstract double getAdditionalLineRate();
}
