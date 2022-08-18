package string;

import java.util.Scanner;

/*
문제 : 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
	   특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
입력 : 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
출력 : 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
*/

public class SpecificReverseWord {

	
	public static String reverseAlphaWord(String word) {
		String result = "";
		char[] Alphabet = word.toCharArray();
		int left = 0;
		int right = word.length()-1;
		
		while(left < right) {
			// isAlphabetic : Character에 내장되어있는 클래스 중 하나로, 영문자를 판단하여 true/false를 반환한다.
			// isDigit : 숫자를 판단하여 true / false를 반환한다.
			if(!Character.isAlphabetic(Alphabet[left])) left++;
			else if(!Character.isAlphabetic(Alphabet[right])) right--;
			else {
				char tmp = Alphabet[left];
				Alphabet[left] = Alphabet[right];
				Alphabet[right] = tmp;
				left++;
				right--;
			}
		}
		// valueOf : 괄호 안에 입력한 객체를 String 형으로 변환한다.
		result = String.valueOf(Alphabet);
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		System.out.println(reverseAlphaWord(word));
	}

}
