package sorting_Searching;

import java.util.Scanner;

/*
문제 : N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
	   정렬하는 방법은 삽입정렬입니다.
입력 : 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
	   두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
출력 : 오름차순으로 정렬된 수열을 출력합니다.
*/

public class InsertionSort {

	public int[] sort(int N, int[] arr) {
		
		for(int i=1; i<N; i++) {
			
			// arr[i]가 자기 자리를 찾아 들어갈 수 있도록 임의의 변수 tmp에 저장 
			int tmp = arr[i];
			// j 를 for문 밖에서 돌려야하므로 여기에 선언
			int j;
			
			// 삽입정렬이기 때문에 j는 i 바로 앞자리부터 맨 앞까지 돌며 i와 비교한다.
			for(j=i-1; j>=0; j--) {
				// i번째 값보다 j번째 값이 크면 뒤에 있는 값이 크다는 의미이다.
				if(arr[j] > tmp) {
					// 뒤에 있는 값이 크면 뒤에 있는 값을 앞으로 변경해준다.
					arr[j+1] = arr[j];
				} else break;
			}
			// 미리 저장했던 i = tmp = 앞의 수를 j+1 자리에 넣음으로써 정렬한다.
			arr[j+1] = tmp;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		InsertionSort I = new InsertionSort();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr= new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int x : I.sort(N, arr)) {
			System.out.print(x + " ");
		}
	}

}
