package array;

import java.util.Scanner;

/*
문제 : 5*5 격자판에 아래와 같이 숫자가 적혀있습니다.
	  N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
입력 : 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
	   두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
출력 : 최대합을 출력합니다.
*/

public class GratingMaxSum {

	public int maxSum(int N, int[][] num) {
		// MIN_VALUE : -2의 31제곱(-2,147,483,648) 으로 초기화해주는 메소드
		int result = Integer.MIN_VALUE;
		int sum1; // 행
		int sum2; // 열
		
		// 가로, 세로의 합 구하기
		for(int i=0; i<N; i++) {
			// 다음 행/열의 합을 위해 초기화
			sum1 = 0;
			sum2 = 0;
			for(int j=0; j<N; j++) {
				// [i][j] 는 행을 고정하고 우측으로 이동
				sum1 += num[i][j];
				// [j][i] 는 열을 고정하고 아래로 이동
				sum2 += num[j][i];
			}
			// Math.max : 입력받은 두 개의 인자 중 작은 값을 리턴한다.
			result = Math.max(result, sum1);
			result = Math.max(result, sum2);
		}
		
		sum1 = 0;
		sum2 = 0;
		// 대각선의 합 구하기
		for(int i=0; i<N; i++) {
			// [i][i] : 행과 열이 같은 (0,0) / (1,1) 좌표의 값들
			sum1 += num[i][i];
			// [i][N-i-1] : 우측에서 좌측으로 가는 거꾸로 대각선
			sum2 += num[i][N-i-1];
		}
		result = Math.max(result, sum1);
		result = Math.max(result, sum2);
		return result;
	}
	
	public static void main(String[] args) {
		GratingMaxSum sum = new GratingMaxSum();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] num = new int[N][N]; 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		System.out.println(sum.maxSum(N, num));
	}
}
