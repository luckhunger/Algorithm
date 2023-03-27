package levelOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제:    정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
제한사항: n은 0 이상 3000이하인 정수입니다.
*/

public class Measure {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int answer = 0;
			
			
			for(int i=1; i<=Math.sqrt(N); i++) {
				// 나누어 떨어질 경우
				if(N % i == 0) {
					
					// 제곱근일 경우
					if(i * i == N) {
						answer += i;
					} else {
						// 제곱근이 아니기에 자기 자신을 결과에 더함
						answer += i;
						// i와 나눈 몫을 더함
						answer += N/i;
						// 4를 예로 들면 i로 1이 더해지고, N/i로 4가 더해져서 answer는 총 5가 됨
					}
				}
			}
			System.out.println(answer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
