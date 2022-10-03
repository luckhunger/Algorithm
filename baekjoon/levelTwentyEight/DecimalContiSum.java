package levelTwentyEight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
문제 : 하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다. 몇 가지 자연수의 예를 들어 보면 다음과 같다.
	  3 : 3 (한 가지)
	  41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
	  53 : 5+7+11+13+17 = 53 (두 가지)
	   하지만 연속된 소수의 합으로 나타낼 수 없는 자연수들도 있는데, 20이 그 예이다. 
	  7+13을 계산하면 20이 되기는 하나 7과 13이 연속이 아니기에 적합한 표현이 아니다.
	   또한 한 소수는 반드시 한 번만 덧셈에 사용될 수 있기 때문에, 3+5+5+7과 같은 표현도 적합하지 않다.
	   자연수가 주어졌을 때, 이 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하는 프로그램을 작성하시오.
입력 : 첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 4,000,000)
출력 : 첫째 줄에 자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 출력한다.
*/

public class DecimalContiSum {
	static ArrayList<Integer> arr;
	
	public static void prime(int N) {
//		ArrayList<Integer> arr = new ArrayList<>();
		boolean[] isPrime = new boolean[N+1];
		// 배열의 모든 값을 같은 값으로 초기화하는 메서드
		// Arrays.fill()을 사용하지 않으면 for문을 사용해서 배열의 값을 일정하게 초기화해야한다.
		Arrays.fill(isPrime , true);
		
		// 0과 1은 소수가 아니므로 false
		isPrime[0] = false;
		isPrime[1] = false;
		
		// 2부터 시작해서 자신의 배수가 되는 수들을 제외한다.
		// 만약 53이라고 하면 8*8=64 이므로 2부터 8의 배수들만 지워도 된다.
		for(int i=2; i*i<=N; i++) {
			// isPrime이 true라면 즉, 소수이거나 i의 배수로 지워지지 않은 수라면 다음 작업을 추가로 진행한다.
			// isPrime[i]가 true이면, i 이후의 i 배수는 약수로 i를 가지고 있는 것이 되므로 모두 true값을 준다.
			// isPrime[i]가 false이면, i는 이미 소수가 아니므로 i의 배수 역시 소수가 아니게 된다. 그러므로 검사할 필요가 없다.
			if(isPrime[i]) {
				for(int j=i*i; j<=N; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		// isPrime[i] 가 true 라면 소수이므로 arr에 추가한다.
		for(int i=1; i<=N; i++) {
			if(isPrime[i]) {
				arr.add(i);
			}
		}
		
		// arr 배열에 마지막으로 0을 추가해서 투 포인터 탐색 시 끝까지 탐색할 수 있도록 한다.
		arr.add(0);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		
		prime(N);
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		
		while(start <= end && end < arr.size()) {
			if(sum < N) {
				// arr 배열에서 end 포인터에 값을 가져오고, end를 증가시킨다.
				sum += arr.get(end++);
			} else {
				if(sum == N) {
					cnt++;
				}
				// arr 배열에서 start 포인터에 값을 가져오고, start를 증가시킨다.
				sum -= arr.get(start++);
			}
		}
		 System.out.println(cnt);
	}
}
