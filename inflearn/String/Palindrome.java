package string;

import java.util.Scanner;

/*
문제 : 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
	   문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
	   단 회문을 검사할 때 대소문자를 구분하지 않습니다.
입력 : 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
출력 : 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
*/

public class Palindrome {

	public static String Soluction(String str) {
//		String result = "YES";
//		// 대소문자 구분을 하지 않기 위해 모든 문자를 대문자로 변경
//		str = str.toUpperCase();
//		int length = str.length();
//		
//		for(int i=0; i<length/2; i++) {
////			System.out.println(str.charAt(i) + " " + str.charAt(length-i-1));
//			if(str.charAt(i)!=str.charAt(length-i-1)) return "NO";
//		}
		
		// StringBuilder, reverse, equalsIgnoreCase 사용하는 방식
		String result = "NO";
		String word = new StringBuilder(str).reverse().toString();
		
		// equalsIgnoreCase : 대소문자를 구분하지 않고 문자열 자체로만 비교한다.
		// equals : 대소문자 구분을 하고 비교한다.
		if(str.equalsIgnoreCase(word)) result = "YES";
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(Soluction(str));

	}

}
