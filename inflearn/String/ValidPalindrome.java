package string;

import java.util.Scanner;

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
