package sorting_Searching;

import java.util.Scanner;

/*
문제 : N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
	   정렬하는 방법은 버블정렬입니다.
입력 : 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
	   두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
출력 : 오름차순으로 정렬된 수열을 출력합니다.
*/

public class BubbleSort {

	public int[] sort(int N, int[] arr) {
		
		for(int i=0; i<N-1; i++) {
			// j는 정렬이 될 수록 마지막-1 까지만 돌아도 됨
			// 맨 마지막 원소는 그 뒤에 값이 없으므로 비교할 필요가 없다.
			// 앞의 원소와 비교한 것으로 마지막 정렬이 끝나기 때문이다.
			for(int j=0; j<N-i-1; j++) {
				int tmp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = tmp;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		BubbleSort B = new BubbleSort();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int x : B.sort(N, arr)) {
			System.out.print(x + " ");
		}
	}

}
