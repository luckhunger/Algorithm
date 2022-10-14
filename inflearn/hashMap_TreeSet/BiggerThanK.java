package hashMap_TreeSet;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

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
