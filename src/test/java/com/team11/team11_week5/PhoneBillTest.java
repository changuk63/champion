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
		assertEquals("Gold",info.getPlan());
		assertTrue(calc.setPlan(info.getPlan()));
		PlanRates planRates = calc.planRates;
		assertEquals(0, Double.compare(planRates.getBasicMonthlyRate(), 49.95));
		assertEquals(0, Double.compare(planRates.getAdditionalLineRate(), 14.50));
		assertEquals(planRates.getIncludedMinutes(), 1000);
		assertEquals(0, Double.compare(planRates.getRatePerExcessMinute(), 0.45));
	}
	
	@Test
	public void testSilver(){
		info = new InfoGetter("Silver", 1000, 1);
		calc = new Calculator(info);
		assertNotNull(info.getNumberOfLines());
		assertNotNull(info.getMinutesUsed());
		assertEquals("Silver",info.getPlan());
		assertTrue(calc.setPlan(info.getPlan()));
		PlanRates planRates = calc.planRates;
		assertEquals(0, Double.compare(planRates.getBasicMonthlyRate(), 29.95));
		assertEquals(0, Double.compare(planRates.getAdditionalLineRate(), 21.50));
		assertEquals(planRates.getIncludedMinutes(), 500);
		assertEquals(0, Double.compare(planRates.getRatePerExcessMinute(), 0.54));
	}
	
	@Test
	public void testOthers() {
		info = new InfoGetter("Silver", 500, 6);
		calc = new Calculator(info);
		calc.sumTotalRate();
		assertFalse(calc.setPlan("bronze"));
		info = new InfoGetter("Silver", 2000, 1);
		calc = new Calculator(info);
		calc.sumTotalRate();
		info = new InfoGetter("Silver", 2000, 3);
		calc = new Calculator(info);
		calc.sumTotalRate();
		info = new InfoGetter("Silver", 2000, 5);
		calc = new Calculator(info);
		calc.sumTotalRate();
	}

}
