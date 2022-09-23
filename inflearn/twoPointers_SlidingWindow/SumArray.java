package twoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

/*
문제 : 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
입력 : 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
	   두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
	   세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
	   네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
	   각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
출력 : 오름차순으로 정렬된 배열을 출력합니다.
*/

public class SumArray {

	public ArrayList<Integer> sorting(int N, int[] a, int M, int[] b) {
		ArrayList<Integer> result = new ArrayList<>();
		
		// 두 배열의 포인터를 0으로 초기화
		int p1 = 0;
		int p2 = 0;
		
		// 두 배열 중 하나라도 배열의 마지막에 이르면 종료
		while(p1<N && p2<M) {
			// a[] 배열이 b[] 배열보다 값이 적으면 작은 값이 먼저 들어가야 하므로 p1 값을 배열에 넣는다.
			if(a[p1] < b[p2]) {
				// p1++ : p1을 가리키는 값을 a[ ] 배열어 넣은 후, p1을 1 증가
				// ++p1 : p1을 증가시킨 후에, 증가한 값을 a[ ] 배열에 넣으므로 p1++이 맞음
				result.add(a[p1++]);
			} else {
				result.add(b[p2++]);
			}
		}
		// p1에 값이 남아있으면 1씩 증가시키며 계속 넣는다.
		while(p1 < N) {
			result.add(a[p1++]);
		}
		
		// p2에 값이 남아있으면 1씩 증가시키며 계속 넣는다.
		while(p2 < M) {
			result.add(b[p2++]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		SumArray sum = new SumArray();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		int[] b = new int[M];
		for(int i=0; i<M; i++) {
			b[i] = sc.nextInt();
		}
		for(int x : sum.sorting(N, a, M, b)) {
			System.out.print(x + " ");
		}
	}

}
