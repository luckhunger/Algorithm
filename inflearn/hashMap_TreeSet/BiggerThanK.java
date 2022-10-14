package hashMap_TreeSet;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/*
문제 : 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
	   현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
	   기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
	   만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
입력 : 첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
출력 : 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
*/

public class BiggerThanK {

	public int solve(int[] arr, int N, int K) {
		// K번째 수가 없으면 -1 출력하기 위해
		int result = -1;
		// Collections.reverseOrder() : 내림차순으로 자동정렬 / 없으면 자동으로 오름차순 정렬
		TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
				
		for(int i=0; i<N; i++) {
			// i+1 : 중복이 되면 안되기 때문에
			for(int j=i+1; j<N; j++) {
				// j+1 : 중복이 되면 안되기 때문에
				for(int l=j+1; l<N; l++) {
					Tset.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		
		// K 번째 수를 찾기 위해 cnt 선언
		int cnt = 0;
		// x와 Tset가 하나씩 서로 매칭하며 값을 찾음
		for(int x : Tset) {
			// 내림차순으로 출력된 3개의 합들에 순서를 주기 위해 cnt++
			cnt++;
			if(cnt == K) return x;
		}
				
		return result;
	}
	
	public static void main(String[] args) {
		BiggerThanK T = new BiggerThanK();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(T.solve(arr, N, K));
	}
}
