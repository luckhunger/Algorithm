package array;

import java.util.ArrayList;
import java.util.Scanner;

/*
문제 : N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
	  (첫 번째 수는 무조건 출력한다)
입력 : 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
출력 : 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
*/


public class BigNumber {

	public static ArrayList<Integer> Compare(int N, int[] number) {
		ArrayList<Integer> result = new ArrayList<>();
		
		// 첫번째를 반드시 출력해야 하므로 0번째를 넣어준다.
		result.add(number[0]);
		
		// 0번째를 넣었으니 1번째부터 시작
		for(int i=1; i<N; i++) {
			if(number[i] > number[i-1]) {
				result.add(number[i]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력받을 정수의 개수
		int N = sc.nextInt();
		int[] number = new int[N];
		
		for(int i=0; i<N; i++) {
			number[i] = sc.nextInt();
		}
		
		for(int x : Compare(N, number)) {
			System.out.print(x + " ");
		}

	}

}
