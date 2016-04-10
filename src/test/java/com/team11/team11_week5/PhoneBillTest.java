package com.team11.team11_week5;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneBillTest {
	InfoGetter info;
	Calculator calc;
	
	@Test
	public void testGold() {
		info = new InfoGetter("Gold", 1000, 1);
		calc = new Calculator(info);
		assertNotNull(info.getNumberOfLines());
		assertNotNull(info.getMinutesUsed());
		assertNotNull(info.getPlan());
		assertTrue(calc.setPlan(info.getPlan()));
		PlanRates planRates = calc.planRates;
		assertEquals(0, Double.compare(planRates.getBasicMonthlyRate(), 49.95));
		assertEquals(0, Double.compare(planRates.getAdditionalLineRate(), 14.50));
		assertEquals(planRates.getIncludedMinutes(), 1000);
		assertEquals(0, Double.compare(planRates.getRatePerExcessMinute(), 0.45));
		calc.sumTotalRate();
	}
	
	@Test
	public void testSilver(){
		info = new InfoGetter("Silver", 1000, 1);
		calc = new Calculator(info);
		assertNotNull(info.getNumberOfLines());
		assertNotNull(info.getMinutesUsed());
		assertNotNull(info.getPlan());
		assertTrue(calc.setPlan(info.getPlan()));
		PlanRates planRates = calc.planRates;
		assertEquals(0, Double.compare(planRates.getBasicMonthlyRate(), 29.95));
		assertEquals(0, Double.compare(planRates.getAdditionalLineRate(), 21.50));
		assertEquals(planRates.getIncludedMinutes(), 500);
		assertEquals(0, Double.compare(planRates.getRatePerExcessMinute(), 0.54));
	}

}
