package twoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

/*
문제 : 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
	  만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
	 1 1 0 0 1 1 0 1 1 0 1 1 0 1
	 여러분이 만들 수 있는 1이 연속된 연속부분수열은
	 1 1 0 0 1 1 1 1 1 1 1 1 0 1
	 이며 그 길이는 8입니다.
입력 : 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
	   두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
출력 : 첫 줄에 최대 길이를 출력하세요.
*/

public class LengthSubsequence {

	public int length(int N, int K, int[] arr) {
		int result = 0;
		int cnt = 0;
		int lt = 0;
		
		for(int rt=0; rt<N; rt++) {
			// rt가 0이면 1로 바꿔야하므로 cnt 증가
			if(arr[rt]==0) {
				cnt++;
			}
			
			// cnt : 0을 1로 바꾼 횟수
			// cnt가 K보다 크면 lt를 1 증가시켜서 포인터를 이동한다.
			// 이동할 때에 lt 값이 1이면 pass, 0이면 cnt를 -1 한다.
			// 그 이유는 cnt는 rt가 0이면 rt를 1로 바꾼 후에 cnt 값이 1 증가하는데
			// rt가 지나가며 1로 바꾼 값을 lt가 다시 지나가며 0으로 바꾸기 때문이다.
			// 1 1 0 0 1 1 0 1 1 0 1 1 0 1
			// rt = 2, lt = 0 > 1 1 0 > cnt에 1 증가
			while(cnt > K) {
				if(arr[lt]==0) cnt--;
				lt++;
			}
			
			// Math.max : 입력받은 두 개의 인자 중 작은 값을 리턴한다.
			result = Math.max(result, (rt-lt)+1);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		LengthSubsequence max = new LengthSubsequence();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt(); 
		}
		System.out.print(max.length(N, K, arr));
	}

}
