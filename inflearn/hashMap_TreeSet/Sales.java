package hashMap_TreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
문제 : 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
	   각  구간별로 구하라고 했습니다.
	   만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
	  20 12 20 10 23 17 10
	   각 연속 4일간의 구간의 매출종류는
	   첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
	   두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
	   세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
	   네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
	  N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
	   매출액의 종류를 출력하는 프로그램을 작성하세요.
입력 : 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
	   두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
출력 : 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
*/

public class Sales {

	public ArrayList<Integer> solve(int N, int K, int[] arr) {
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// 고정된 윈도우 크기를 구하는 방식은 아래와 같다.
		// 1. 고정 크기보다 하나 작게 적용한다.(left pointer)
		// 2. 적용하지 않았던 마지막 하나를 적용해 원하는 크기를 만든다.(right pointer)
		// 3. left pointer가 증가해서 하나 빠지고, right pointer가 증가해서 하나 추가되는 방식으로 윈도우를 민다.
		// 고정 크기의 슬라이딩 윈도우를 배울 때에 기본적으로 배우는 방식이다.
		
		// left pointer에 3개 값을 넣어줌
		for(int i=0; i<K-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
//			System.out.println("i : " + map.keySet());
//			System.out.println("i : " + map.get(arr[i]));
		}
		
		int lt = 0;
		for(int rt=K-1; rt<N; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
			result.add(map.size());
			map.put(arr[lt], map.get(arr[lt])-1);
			
			if(map.get(arr[lt]) == 0) {
				map.remove(arr[lt]);
			}
			
			lt++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Sales S = new Sales();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int x : S.solve(N, K, arr)) {
			System.out.print(x + " ");
		}
	}
}
