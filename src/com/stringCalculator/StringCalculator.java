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
			result = Integer.parseInt(numbers);
			if(result>1000) {
				return 0;
			}
		}
		else if(numbers.length()>1 && numbers.startsWith("//")) {
			int startIndex = 2;
			int endIndex = numbers.indexOf("\n");
			String newNumber=null;
			delimiter = numbers.substring(startIndex, endIndex);
			if(delimiter.startsWith("[")) {
				String newDelimiter ="";
				if(delimiter.indexOf("[")==delimiter.lastIndexOf("[")) {
					newDelimiter = delimiter.substring(1, 2);
					newNumber = numbers.substring(numbers.indexOf("\n")+1);
					if(newDelimiter.contains("*") || newDelimiter.contains("?") || newDelimiter.contains("+")) {
						arr = newNumber.split("[\\"+newDelimiter.charAt(0)+"]+");
					}
					else {
						arr = newNumber.split("["+newDelimiter.charAt(0)+"]+");
					}
				}
				else {
					for(int i=0;i<delimiter.length();i++) {
						if(delimiter.charAt(i)=='[') {
							newDelimiter = newDelimiter + delimiter.substring(i+1, delimiter.indexOf("]", i));
						}
					}
					newNumber = numbers.substring(endIndex+1);
					if(newDelimiter.contains("*") || newDelimiter.contains("?") || newDelimiter.contains("+")) {
						arr = newNumber.split("[\\"+newDelimiter+"]+");
					}
					else {
						arr = newNumber.split("["+newDelimiter+"]+");
					}
				}
			}
			else {
				newNumber = numbers.substring(endIndex+1);
				arr = newNumber.split("["+delimiter+"]+");
			}
			for(int i =0;i<arr.length;i++) {
				if(Integer.parseInt(arr[i])<0) {
					negativeNumber = negativeNumber+arr[i]+",";
				}
				if(negativeNumber.length()==0 && Integer.parseInt(arr[i])<=1000) {
					result = result + Integer.parseInt(arr[i]);
				}
			}
			if(negativeNumber.length()>0) {
				throw new Exception("negatives not allowed:"+negativeNumber.substring(0, negativeNumber.length()-1));
			}
			return result;
		}
		else if(numbers.length()>1 && numbers.contains(",")) {
			if(numbers.startsWith("//")) {
				if(delimiter.contains("*") || delimiter.contains("?") || delimiter.contains("+")) {
					arr = numbers.split("[\\"+delimiter+"]+");
				}
			}
			else {
				arr = numbers.split(delimiter);
			}
			
			for(int i =0;i<arr.length;i++) {
				if(Integer.parseInt(arr[i])<0) {
					negativeNumber = negativeNumber+arr[i]+",";
				}
				if(negativeNumber.length()==0 && Integer.parseInt(arr[i])<=1000) {
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
