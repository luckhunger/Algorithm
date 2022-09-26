package twoPointers_SlidingWindow;

import java.util.Scanner;

/*
문제 : 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
	   만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
	  12 1511 20 2510 20 19 13 15
	   연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
	   여러분이 현수를 도와주세요.
입력 : 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
	   두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
출력 : 첫 줄에 최대 매출액을 출력합니다.
*/

public class MaxSales {

	public int sales(int N, int K, int[] arr) {
		int result = 0;
		int sum = 0;
		
		// 첫 윈도우 만들기
		for(int i=0; i<K; i++) {
			sum += arr[i];
//			System.out.println("arr : " + arr[i]);
		}
		
		result = sum;
		
		// 만들어놓은 윈도우를 1칸씩 이동하면서 sum 변경
		// 12 15 11 20 25 10 20 19 13 15 로 가정해보자.
		// 위에 for문을 통해 arr[0] + arr[1] + arr[2] > sum = 38(12+15+11) 이 된다.
		// 다음으로 아래 for문을 돌면 arr[3] - arr[0] > sum = 46(38+8 ==> 15+11+20) 이 된다.
		// 그 다음에 for문이 한번 더 수행되면 arr[4] - arr[1] > sum = 56(46+10 ==> 11+20+25) 가 된다.
		// 이렇게하면 윈도우로 만들어놓은 3칸의 합을 sum에 누적하고, 다음부터는 i를 통해 맨 마지막 인덱스 값을 하나 늘린 후에, 3칸에서 첫번째 칸 값을 빼서 누적한다.
		// 즉 맨 처음과 마지막 인덱스를 통해 누적 값을 변경하는 것이다.
		for(int i=K; i<N; i++) {
			sum += arr[i] - arr[i-K];
			System.out.println("arr i : " + i + " " + arr[i]);
			System.out.println("sum : " + sum);
			result = Math.max(result, sum);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		MaxSales s = new MaxSales();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print(s.sales(N, K, arr));
	}

}
