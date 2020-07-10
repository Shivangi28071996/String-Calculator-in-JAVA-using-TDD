package com.stringCalculator;

public class StringCalculator {
	static int count = 0;
	public int Add(String numbers) throws Exception {
		int result=0;
		String[] arr = null;
		String delimiter = "";
		String negativeNumber="";
		count = count+1;
		if(numbers.length()==0) {
			return result;
		}
		else if(numbers.length()==1) {
			result = Integer.parseInt(numbers);
			if(result>1000) {
				return 0;
			}
			else {
				return result;
			}
		}
		else if(numbers.length()>1 && numbers.startsWith("//")) {
			int startIndex = 2;
			int endIndex = numbers.indexOf("\n");
			String newNumber=numbers.substring(endIndex+1);
			delimiter = numbers.substring(startIndex, endIndex);
			
			if(delimiter.startsWith("[")) {
				String newDelimiter ="";
				if(delimiter.indexOf("[")==delimiter.lastIndexOf("[")) {
					newDelimiter = delimiter.substring(1, 2);
				}
				else {
					for(int i=0;i<delimiter.length();i++) {
						if(delimiter.charAt(i)=='[') {
							newDelimiter = newDelimiter + delimiter.substring(i+1, delimiter.indexOf("]", i));
						}
					}
				}
				arr = newNumber.split("[\\"+newDelimiter+"]+");
			}
			else {
				arr = newNumber.split("[\\"+delimiter+"]+");
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
		else{
			for(int i=0;i<numbers.length();i++) {
				if(!Character.isDigit(numbers.charAt(i))) {
					delimiter=delimiter+numbers.charAt(i);
				}
			}
			arr = numbers.split("[\\"+delimiter+"]+");
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
	}
	
	public int GetCalledCount()  {
		return count;
	}
}
