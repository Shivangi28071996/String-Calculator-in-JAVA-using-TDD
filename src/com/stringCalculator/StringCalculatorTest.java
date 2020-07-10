package com.stringCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringCalculatorTest {

	@Test
	public void t1_noNumberAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("");
			assertEquals(0,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void t2_oneNumberAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("1");
			assertEquals(1,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void t3_twoNumberAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("1,2");
			assertEquals(3,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void t4_unknownNumbersAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("1,2,3,4,5");
			assertEquals(15,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void t5_newLineAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("1\n2,3");
			assertEquals(6,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void t6_differentDelimeterAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("//:,;\n1;2,3:5,1");
			assertEquals(12,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void t7_negativeNumberTest() {
		StringCalculator sc = new StringCalculator();
		try {
			sc.Add("//:,;\n1;2,-3:-5,-1");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void t8_countAddMethodCalled() {
		StringCalculator sc = new StringCalculator();
		int count = sc.GetCalledCount();
		assertEquals(7, count);
	}
	
}
