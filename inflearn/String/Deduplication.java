package string;

import java.util.Scanner;

/*
문제 : 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
	   중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
입력 : 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
출력 : 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
*/

public class Deduplication {

	public static String DelDup(String str) {
		String result = "";
		
		for(int i=0; i<str.length(); i++) {
			// str.charAt() : str에 들어간 문자열을 하나씩 쪼개서 문자 배열로 만들어 저장함
			// i : 각 문자의 인덱스
			// indexOf() : 특정 문자나 문자열에 앞에서부터 처음으로 발견되는 인덱스를 반환한다.
//			System.out.println(str.charAt(i) + " " + i + str.indexOf(str.charAt(i)));
			
			// 해당 문자가 처음 발견된 위치와 해당 문자의 실제 인덱스 값이 같으면 결과값에 해당 문자를 추가한다.
			if(str.indexOf(str.charAt(i)) == i) {
				result += str.charAt(i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(DelDup(str));
		
	}

}
