package com.stringCalculator;

public class StringCalculator {
	public int Add(String numbers) {
		int result=0;
		String[] arr = null;
		
		if(numbers.length()==1) {
			return Integer.parseInt(numbers);
		}
		else if(numbers.length()>1 && numbers.contains(",")) {
			arr = numbers.split(",");
			for(int i =0;i<arr.length;i++) {
				result = result + Integer.parseInt(arr[i]);
			}
			return result;
		}
		return result;
	}
}
