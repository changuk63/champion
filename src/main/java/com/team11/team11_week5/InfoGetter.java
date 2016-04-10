package com.team11.team11_week5;
import java.util.Scanner;
import java.util.logging.Logger;

import java.util.logging.Level;

public class InfoGetter {
	private String plan;
	private int minutesUsed;
	private int numberOfLines;
	private Logger log;
	Scanner scan = new Scanner(System.in);
	

	public InfoGetter(){
		setInfo();
	}
	
	public void setInfo() {
		log = Logger.getLogger("Logger");
		
		log.log(Level.INFO, "Input the plan : (Gold or Silver)");
		this.plan = scan.next();
		
		log.log(Level.INFO, "Input the minutes used : ");
		this.minutesUsed = scan.nextInt();
		
		log.log(Level.INFO, "Input the number of lines : ");
		this.numberOfLines = scan.nextInt();
	}
	
	/// delete
	public InfoGetter(String plan, int min, int num){
		log = Logger.getLogger("Logger");
		
		log.log(Level.INFO, "Input the plan : (Gold or Silver)\n"+plan);
		this.plan = plan;
		
		log.log(Level.INFO, "Input the minutes used : \n"+min);
		this.minutesUsed = min;
		
		log.log(Level.INFO, "Input the number of lines : \n"+num);
		this.numberOfLines = num;
	}
	
	public String getPlan(){
		return plan;
	}
	
	public int getMinutesUsed(){
		return minutesUsed;
	}
	
	public int getNumberOfLines(){
		return numberOfLines;
	}
	
}
