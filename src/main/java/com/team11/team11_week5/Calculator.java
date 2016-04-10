package com.team11.team11_week5;

import java.text.NumberFormat;

public class Calculator {
	protected PlanRates planRates;
	private String plan;
	private int minutesUsed;
	private int numberOfLines;
	
	protected double basicMonthlyRate; //private
	private double additionalLineRate;
	private int includedMinutes;
	private double ratePerExcessMinute;
	
	private NumberFormat nf;
	
	
	protected String totalRate; //delete 
	
	public Calculator(InfoGetter userInfo){
		
		plan = userInfo.getPlan();//占쏙옙占�
		minutesUsed = userInfo.getMinutesUsed();//占쏙옙酉�
		numberOfLines = userInfo.getNumberOfLines();//占쌘쏙옙占쏙옙占쏙옙占쏙옙占싼띰옙占싸쇽옙

		setPlan(plan);
		
		basicMonthlyRate = planRates.getBasicMonthlyRate(); //占썩본占쏙옙
		additionalLineRate = planRates.getAdditionalLineRate(); //占쌩곤옙占쏙옙占싸쇽옙占쏙옙占쌩곤옙占쏙옙占�
		includedMinutes = planRates.getIncludedMinutes(); //占썩본占쏙옙占쏙옙占실댐옙占쏙옙화占시곤옙
		ratePerExcessMinute = planRates.getRatePerExcessMinute(); //占싻댐옙占십곤옙占시곤옙占쏙옙占�

		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
	}
	
	protected boolean setPlan(String plan){
		if("Gold".equals(plan)){
			planRates = new Gold();
			return true;
		}
		else if ("Silver".equals(plan)){
			planRates = new Silver();
			return true;
		}
		return false;
	}
	
	protected double calcExcessRateByMinute(){
		if(minutesUsed - includedMinutes <= 0){ //占쏙옙占쏙옙微占� 占십곤옙占쏙옙占쏙옙占쏙옙占쏙옙
			return 0;
		} 
		else { //占쏙옙占쏙옙微占� 占십곤옙占쏙옙占쏙옙占쏙옙
			return (minutesUsed-includedMinutes) * ratePerExcessMinute;
		}
	}
	
	protected double calcExcessRateByLines(){
		if (numberOfLines == 1) 
			return 0;
		else if (numberOfLines>1 && numberOfLines<4){
			return (numberOfLines-1)*additionalLineRate;
		} 
		else{
			return (2*additionalLineRate) + (5*(numberOfLines-3));
		}
		
	}
	public String sumTotalRate(){
		totalRate = nf.format(basicMonthlyRate + calcExcessRateByMinute() + calcExcessRateByLines());
		return "\nBasicMontlyRate : " + basicMonthlyRate + 
				"\nExcessRateByMinute : " + nf.format(calcExcessRateByMinute()) + 
				"\nExcessRateByLines : " + calcExcessRateByLines() +
				"\n-> Expected Bill : " + totalRate;
	}
}
