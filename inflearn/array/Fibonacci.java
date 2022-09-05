package array;

import java.util.Scanner;

/*
문제 : 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
	   입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
입력 : 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
출력 : 첫 줄에 피보나치 수열을 출력합니다.
*/

public class Fibonacci {

	// 배열 쓰지 않고 작성하는 코드
	public static void Array(int N) {
		int A = 1, B = 1, C;
		
		System.out.print(A + " " + B + " ");
		
		for(int i=2; i<N; i++) {
			C = A + B;
			System.out.print(C + " ");
			A = B;
			B = C;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		int[] A = new int[N];
//		
//		A[0] = 1;
//		A[1] = 1;
//		
//		for(int i=2; i<N; i++) {
//			A[i] = A[i-2] + A[i-1];
//		}
//
//		for(int i=0; i<N; i++) {
//			System.out.print(A[i] + " ");
//		}
		
		// 메소드 호출
		Fibonacci.Array(N);
	}
}
