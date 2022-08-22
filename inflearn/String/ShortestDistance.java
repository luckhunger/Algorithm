package string;

import java.util.Scanner;

/*
문제 : 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
입력 : 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다. 문자열의 길이는 100을 넘지 않는다.
출력 : 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
*/

public class ShortestDistance {

	// static 사용 이유 : 전역적으로 쉽게 재사용하는 변수나 메소드를 사용할 때 주로 사용한다.
	// 생성 후 클래스 호출이나 객체 생성 필요 없이 바로 사용할 수 있기 때문에 사용성이 좋다.
	// 단점으로는 메모리 자원을 할당해놓고 사용하는 것이기 때문에 너무 많이 사용한다면 메모리를 많이 차지하게 되어서 프로그램이 무거워 집니다.
	public static int[] Distance(String s, char t) {
		int[] result = new int[s.length()];
		int p = 1000;	// 떨어진 위치값을 1000으로 초기화
		
		// 왼쪽으로부터 입력된 문자와 다른 문자들 사이의 거리를 구한다.
		for(int i=0; i<s.length(); i++) {
			// 입력받은 문자가 문자열에 있는 문자와 일치할 때
			if(s.charAt(i) == t) {
				// p를 0으로 초기화
				p = 0;
				// 결과값에 p를 삽입 > 떨어진 위치가 0이므로
				result[i] = p;
			} else {
				// 그게 아닐 경우에는 p에 +1
				p++;
				// 떨어진 위치인 p 값을 삽입
				result[i] = p;
			}
		}
		
		// 오른쪽부터 입력된 문자와 다른 문자들 사이의 거리를 구한다.
		// 입력받은 문자가 여러 곳에 위치할 경우를 위해 작성
		p = 1000;	// 위치 값 초기화
		
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i) == t) {
				p = 0;
			} else {
				p++;
				// Math.min : 입력받은 두 개의 인자 중 작은 값을 리턴한다.
				result[i] = Math.min(result[i], p);
			}
		}
		return result;
	}

	public static void main(String[] args) {
//		ShortestDistance Sd = new ShortestDistance();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char t  = sc.next().charAt(0);
		
		for(int far : Distance(s, t)) {
			// println()은 한 값당 한 줄로 출력하기에 print로 출력하여 여러 값을 한 줄로 출력하기
			System.out.print(far + " ");
		}
	}
}
