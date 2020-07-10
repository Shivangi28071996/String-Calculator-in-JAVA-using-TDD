package com.stringCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringCalculatorTest {

	@Test
	public void t01_noNumberAddTest() {
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
	public void t02_oneNumberAddTest() {
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
	public void t03_twoNumberAddTest() {
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
	public void t04_unknownNumbersAddTest() {
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
	public void t05_newLineAddTest() {
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
	public void t06_differentDelimeterAddTest() {
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
	public void t07_negativeNumberTest() {
		StringCalculator sc = new StringCalculator();
		try {
			sc.Add("//:,;\n1;2,-3:-5,-1");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void t08_countAddMethodCalled() {
		StringCalculator sc = new StringCalculator();
		int count = sc.GetCalledCount();
		assertEquals(7, count);
	}
	
	@Test
	public void t09_equalTo1000AddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("1\n2,3\n1000");
			assertEquals(1006,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void t10_greaterThan1000AddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("1\n2,3\n1005");
			assertEquals(6,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
