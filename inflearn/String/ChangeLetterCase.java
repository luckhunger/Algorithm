package string;

import java.util.Scanner;

public class ChangeLetterCase {

	// 아스키코드 65 ~ 90 : 영어 대문자
	// 아스키코드 97 ~ 122 : 영어 소문자
	
	public String changeCase(String str) {
		String result = "";
		
		for(char x : str.toCharArray()) {
			// isLowerCase : 입력받은 문자가 소문자인지 확인하여 true / false를 반환해줌
			if(Character.isLowerCase(x)) result += Character.toUpperCase(x);
			else result += Character.toLowerCase(x);
		}
		return result;
	}
	
	public static void main(String[] args) {
		ChangeLetterCase Case = new ChangeLetterCase();
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(Case.changeCase(str));
		
	}

}
