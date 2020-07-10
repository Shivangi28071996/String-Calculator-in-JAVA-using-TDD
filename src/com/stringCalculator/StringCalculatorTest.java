package com.stringCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void noNumberAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(0,result);
	}
	
	@Test
	public void oneNumberAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1,result);
	}
	
	@Test
	public void twoNumberAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("1,2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(3,result);
	}
	
	@Test
	public void unknownNumbersAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("1,2,3,4,5");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(15,result);
	}
	
	@Test
	public void newLineAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("1\n2,3");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(6,result);
	}
	
	@Test
	public void differentDelimeterAddTest() {
		StringCalculator sc = new StringCalculator();
		int result = 0;
		try {
			result = sc.Add("//:,;\n1;2,3:5,1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(12,result);
	}
	
	@Test
	public void negativeNumberTest() {
		StringCalculator sc = new StringCalculator();
		try {
			sc.Add("//:,;\n1;2,-3:-5,-1");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("negatives not allowed"));
		}
	}
	
}
