package com.stringCalculator;

public class StringCalculator {
	static int count = 0;
	public int Add(String numbers) throws Exception {
		int result=0;
		String[] arr = null;
		String delimiter = "[,\n]+";
		String negativeNumber="";
		count = count+1;
		if(numbers.length()==1) {
			return Integer.parseInt(numbers);
		}
		else if(numbers.length()>1 && numbers.startsWith("//")) {
			int startIndex = 2;
			int endIndex = numbers.indexOf("\n");
			delimiter = numbers.substring(startIndex, endIndex);
			String newNumber = numbers.substring(endIndex+1);
			arr = newNumber.split("["+delimiter+"]+");
			for(int i =0;i<arr.length;i++) {
				if(Integer.parseInt(arr[i])<0) {
					negativeNumber = negativeNumber+arr[i]+",";
				}
				if(negativeNumber.length()==0) {
					result = result + Integer.parseInt(arr[i]);
				}
			}
			if(negativeNumber.length()>0) {
				throw new Exception("negatives not allowed:"+negativeNumber.substring(0, negativeNumber.length()-1));
			}
			return result;
		}
		else if(numbers.length()>1 && numbers.contains(",")) {
			arr = numbers.split(delimiter);
			for(int i =0;i<arr.length;i++) {
				if(Integer.parseInt(arr[i])<0) {
					negativeNumber = negativeNumber+arr[i]+",";
				}
				if(negativeNumber.length()==0) {
					result = result + Integer.parseInt(arr[i]);
				}
			}
			if(negativeNumber.length()>0) {
				throw new Exception("negatives not allowed:"+negativeNumber.substring(0, negativeNumber.length()-1));
			}
			return result;
		}
		return result;
	}
	
	public int GetCalledCount()  {
		return count;
	}
}
