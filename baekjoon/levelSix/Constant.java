package levelSix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제 : 상근이의 동생 상수는 수학을 정말 못한다. 상수는 숫자를 읽는데 문제가 있다. 
	   이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다. 
	   상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.
	   상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 
	   예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다. 
	   따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
	   두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.
입력 : 첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
출력 : 첫째 줄에 상수의 대답을 출력한다.
*/

public class Constant {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer : String에서 구분자를 통해서 토큰형태로 나눌 때 사용하는 클래스
		// 공백 기준으로 토큰을 나눔
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// st.nextToken() : 다음 토큰을 불러오는 메서드
		// reverse() : 문자열을 뒤집어주는 메소드
		int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		
		System.out.println(A > B ? A : B);
	}

}
