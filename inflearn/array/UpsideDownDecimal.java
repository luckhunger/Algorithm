package array;

import java.util.ArrayList;
import java.util.Scanner;

/*
문제 : N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
	   예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
	   첫 자리부터의 연속된 0은 무시한다.
입력 : 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
	   각 자연수의 크기는 100,000를 넘지 않는다.
출력 : 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
*/

public class UpsideDownDecimal {

	public boolean isPrime(int num) {
		// 1은 소수가 아니므로 무조건 false
		if(num==1) {
			return false;
		}
		
		for(int i=2; i<num; i++) {
			// i로 나누어 떨어지면 소수가 아니므로 false
			if(num%i==0) return false;
		}
		return true;
	}
	
	public ArrayList<Integer> sosu(int N, int[] arr) {
		ArrayList<Integer> result = new ArrayList<>();
		
		// 나머지(%)와 몫(/)을 이용해서 숫자를 뒤집어줌
		for(int i=0; i<N; i++) {
			int res = 0;
			
			int tmp = arr[i];
			
			// 자연수가 들어간 변수 tmp가 0보다 크지 않으면 계속 돌아감
			while(tmp>0) { // tmp : 123
				int t = tmp % 10;	// t : 3 > 2 > 1
				res = res * 10 + t;	// res : 3 > 32 > 321
				tmp = tmp / 10;	// tmp : 12 > 1 > 0 >> 더 이상 돌지 않음
			}
			if(isPrime(res)) {
				result.add(res);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		UpsideDownDecimal decimal = new UpsideDownDecimal();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 소수인 수들을 담을 배열
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		for(int x : decimal.sosu(N, arr)) {
			System.out.print(x + " ");
		}
	}

}
