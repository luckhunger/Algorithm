package twoPointers_SlidingWindow;

import java.util.Scanner;

/*
문제 : N 입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
	  만약 N=15이면
	 7+8=15
	 4+5+6=15
	 1+2+3+4+5=15
	  와 같이 총 3가지의 경우가 존재한다.
입력 : 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
출력 : 첫 줄에 총 경우수를 출력합니다.
*/

public class NaturalNumSum {

	public int count(int N) {
		int result = 0;
		int sum = 0;
		int lt = 0;
		int M = N/2+1;
		int[] arr = new int[M];
		
		for(int i=0; i<M; i++) {
			// i는 인덱스 값으로 0~14까지 생성되는데, 우리에게 필요한 값은 1~15이므로 1씩 더해서 배열에 넣어준다.
			arr[i] = i+1;
		}	
		
		for(int rt=0; rt<M; rt++) {
			// sum : arr[lt] 부터 arr[rt]까지의 합
			sum += arr[rt];
			if(sum == N) result++;
			
			while(sum >= N) {
				// sum에서 arr[lt] 값을 뺀 후에 lt++
				sum -= arr[lt++];
				if(sum == N) result++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		NaturalNumSum num = new NaturalNumSum();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
 		System.out.print(num.count(N));
	}

}