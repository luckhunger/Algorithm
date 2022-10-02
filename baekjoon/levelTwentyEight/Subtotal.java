package levelTwentyEight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제 : 10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 
	   이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.
입력 : 첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다. 
	   둘째 줄에는 수열이 주어진다. 
	   수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수이다.
출력 : 첫째 줄에 구하고자 하는 최소의 길이를 출력한다. 만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.
*/

public class Subtotal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 한 줄 안에서 공백으로 구분된 두 값을 추출하기 위해 StringTokenizer 사용
		// StringTokenizer : 하나의 문자열을 여러 개의 토큰으로 분리하는 클래스
		// br.readLine() : 공백 기준으로 문자열을 나눈다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 한 줄에서 공백 단위로 읽는다.
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lt = 0;
		int rt = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		while(lt <= N && rt <= N) {
			
			if(sum < S) {
				sum += arr[rt++];
			} else if(sum >= S) {
				min = Math.min(min, rt-lt);
				sum -= arr[lt++];
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}