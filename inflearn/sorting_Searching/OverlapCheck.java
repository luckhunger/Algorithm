package sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

/*
문제 : 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
	   필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
	   철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
	  LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
	   캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
	   캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
입력 : 첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
	   두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.
출력 : 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.
*/

public class OverlapCheck {

	public String ckeck(int N, int[] arr) {
		String result = "U";
		// sort() : 오름차순으로 배열을 정렬해준다.
		Arrays.sort(arr);
		
		// 앞뒤 값을 비교해서 동일한 값이 있으면 D, 없으면 U를 출력한다.
		// 오름차순 정렬이므로 동일한 값이 있는 순간 D!
		for(int i=0; i<N-1; i++) {
			if(arr[i] == arr[i+1]) {
				return "D";
			}
		}	
		return result;
	}
	
	public static void main(String[] args) {
		OverlapCheck overlap = new OverlapCheck();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(overlap.ckeck(N, arr));
	}
}
