package string;

import java.util.Scanner;

/*
문제 : 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
	   문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
	   단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
	   알파벳 이외의 문자들의 무시합니다.
입력 : 알파벳 이외의 문자들의 무시합니다.
출력 : 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
*/

public class ValidPalindrome {

	public static String Soluction(String str) {
		String result = "NO";
		
		// replaceAll("[^...]", "") : ^ 뒤에 입력한 문자들을 제외한 모든 문자를 빈 값으로 변환
		// [A-Z] : 모든 영어 알파벳 대문자 
		// [^A-Z] : 모든 영어 알파벳 대문자 제외
		// replace("ABCD", "") : ABCD 문자들을 빈 값으로 변환
		// replace() 는 정규식을 사용하지 못함
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
//		System.out.println(str);
		String tmp = new StringBuilder(str).reverse().toString();
//		System.out.println(tmp);
		
		if(str.equals(tmp)) return "YES";
		
		return result;
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println(Soluction(str));
	}

}
