package levelOne;

import java.util.Scanner;

/*
문제:    자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
		예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
제한사항: N의 범위 : 100,000,000 이하의 자연수

*/

public class DigitAdd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int N = sc.nextInt();
		
		while(N > 0) {
			answer += N % 10;
			N /= 10;
		}
		System.out.println(answer);
	}
}
