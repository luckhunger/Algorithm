package string;

import java.util.Scanner;

/*
문제 : 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
입력 : 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
           문자열은 영어 알파벳으로만 구성되어 있습니다.
출력 : 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
*/

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
