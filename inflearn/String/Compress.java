package string;

import java.util.Scanner;

/*
문제 : 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 
	   반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
	   단 반복횟수가 1인 경우 생략합니다.
입력 : 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
출력 : 첫 줄에 압축된 문자열을 출력한다.
*/

public class Compress {

	public String Press(String str) {
		String result = "";
		str = str + " ";	// 맨 마지막에 i와 i+1을 비교하기 위해 임의의 빈 문자를 넣어준다.
		int cnt = 1;
		
		// str.length() 까지로 구하면 맨 마지막에 빈 문자까지 구하기 떄문에 -1을 해서 실제 문자까지의 길이를 구한다.
		// ex) TEST_ > T(i)와 빈문자(i+1)를 통해 중복유무 체크
		for(int i=0; i<str.length()-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				cnt++;
			} else {
				// 중복문자가 없으면 인덱스의 문자를 그대로 출력
				result += str.charAt(i);
				// 중복이 1회 이상인 경우에는 중복 카운트 출력
				if(cnt>1) {
					result += String.valueOf(cnt);
					cnt = 1;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Compress C = new Compress();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(C.Press(str));
	}

}
