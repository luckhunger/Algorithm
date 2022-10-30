package sorting_Searching;

import java.util.Scanner;

/*
문제 : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
	   정렬하는 방법은 선택정렬입니다.
입력 : 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
	   두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
출력 : 오름차순으로 정렬된 수열을 출력합니다.
*/

public class SelectionSort {

	public int[] sort(int N, int[] arr) {
		
		// 맨 마지막 원소는 그 앞에 과정을 통해 자동적으로 정렬되므로 한번 더 돌 필요는 없다.
		for(int i=0; i<N-1; i++) {
			// 가장 작은 숫자의 인덱스 번호를 저장하기 위한 변수
			int idx = i;
			
			for(int j=i+1; j<N; j++) {
				if(arr[j] < arr[idx]) {
					idx = j;
				}
			}
			
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		SelectionSort S = new SelectionSort();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int x : S.sort(N, arr)) {
			System.out.print(x + " ");
		}
		
	}
}