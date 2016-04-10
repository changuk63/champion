package com.team11.team11_week5;

import java.util.logging.Logger;


import java.util.logging.Level;

public class MainProgram {
	private static Logger log;
	
	MainProgram() {

	}
	
	public static void main(String[] args){
		log = Logger.getLogger("Logger");
		InfoGetter userInfo = new InfoGetter();
		
		Calculator calc = new Calculator(userInfo);
		
		log.log(Level.INFO, calc.sumTotalRate());
		
	}
	

}
