package levelSix;

import java.util.Scanner;

/*
문제 : 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
입력 : 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
출력 : 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
*/


public class WordStudy {

	public static char countAlpha(String str) {
		// 결과값 출력 변수
		char result = '?';
		// 최대 중복 카운트 저장할 변수
		int max = -1;
		// 알파벳 개수가 26개이고 알파벳당 사용된 갯수를 저장하기 위해 크기가 26인 배열 생성
		int[] cnt = new int[26];
		
//		str = str + " ";
//		char[] S = str.toCharArray();
		
		
		for(int i=0; i<str.length(); i++) {
			// 해당 알파벳의 숫자값을 구하기 위해 65를 뺀다.
			// 구해진 숫자값을 인덱스로 삼아서 해당 인덱스에 값을 더한다.
			cnt[str.charAt(i) - 65]++;
			// test 예시
			// str.charAt(i) > T E S T
			// str.charAt(i) - 65 > 19 4 18 19
//			System.out.println(str.charAt(i) + " " + (str.charAt(i) - 65));
			// T가 중복 > 19번째 배열에 결론 갯수는 '2'가 된다.
//			System.out.println("cnt : " + cnt[19]);
		}
		// 총 26번 즉, 모든 알파벳에 저장된 cnt 값을 확인하는 for문
		for(int j=0; j<cnt.length; j++) {
			// A-Z까지 cnt와 max의 개수를 전부 확인한다.
			System.out.println(cnt[j] + " " + max);
			// cnt[j]에 저장된 수가 max보다 크면 즉, 초기값인 max가 -1이 아니면 cnt[j]의 값을 max에 넣어준다.
			// 이 때, 입력된 문자열 중에 해당하는 알파벳이 없으면 max에 0이 들어가므로 -1로 초기화해주어야 한다.
			// A > cnt[0] : 0 / max : -1 > cnt[0]이 크므로 max는 0이 됨
			// B > cnt[1] : 0 / max : 0 > 둘 다 동일하므로 패스 >> 26번 다 돌고나서 그 후에 확인해서 ? 가 나와야하므로 다 돌기 전까지는 다시 if문으로 넘어옴
			if(cnt[j] > max) {
//				System.out.println(max + " " + cnt[j]);
				max = cnt[j];
				// 알파벳 형태로 출력하기 위해 숫자값에 65를 더한다.
				result = (char)(j+65);
//				System.out.println("result : " + result);
			}else if(cnt[j] == max) {
				result = '?';
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase();
		
		System.out.println(countAlpha(str));

	}

}
