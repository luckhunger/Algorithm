package string;

import java.util.Scanner;

/*
문제 : 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
	   만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
	   추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
입력 : 첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
출력 : 첫 줄에 자연수를 출력합니다.
*/

public class ExtractNumber {

//	// 혼자서 푼 것
//	public static int Extract(String str) {
//		int result = 0;
//		
//		str = str.toUpperCase().replaceAll("[^0-9]", "");
//		
//		result = Integer.parseInt(str);
//		
//		return result;
//	}
	
	// 강의에서 푼 것
	// 아스키코드 사용
//	public static int Extract(String str) {
//		int result = 0;
//		
//		for(char codeValue : str.toCharArray()) {
//			if(codeValue>=48 && codeValue <= 57) {
//				result = result * 10 + (codeValue-48);
//			}
//		}
//		
//		return result;
//	}
	
	// 강의에서 푼 것
	// isDigit() 사용
	// isDigit() : char 값이 숫자인지 여부를 확인하여 true/false를 리턴한다.
	public static int Extract(String str) {
		String result = "";
		
		for(char codeValue : str.toCharArray()) {
			if(Character.isDigit(codeValue)) result += codeValue;
		}
		
		return Integer.parseInt(result);
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(Extract(str));
	}

}
