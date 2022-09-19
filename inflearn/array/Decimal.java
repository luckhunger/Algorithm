package array;

import java.util.Scanner;

/*
문제 : 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
	   만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
입력 : 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
출력 : 첫 줄에 소수의 개수를 출력합니다.
*/

public class Decimal {

	public int Count(int N) {
		int result = 0;
		// 0이면 소수, 1이면 소수가 아님을 표현할 배열 Arr[] 선언
		// N번째 수까지 값이 필요하기에 N+1만큼 배열 생성
		int[] Arr = new int[N+1];
		
		for(int i=2; i<=N; i++) {
			
			// Arr[]가 0이면 소수이므로 result++
			if(Arr[i]==0) {
				result++;
				
				// i의 배수로 돌아야하기 때문에 i씩 증가
				// i의 배수이면 소수가 아니므로 Arr[] 배열에 1이라는 값을 넣어줌
				for(int j=i; j<=N; j=j+i) {
					Arr[j] = 1;
				}
			}
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		Decimal sosu = new Decimal();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(sosu.Count(N));
	}

}
