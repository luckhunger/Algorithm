package sorting_Searching;

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

public class LeastRecentlyUsed {

	public int[] solution(int size, int N, int[] arr) {
		int[] cache = new int[size];
		
		// 기존 배열에 x 값이 있는지(hit) 없는지(miss) 확인
		for(int x : arr) {
			// pos : 인덱스
			int pos = -1;
			
			// size : cache 배열의 크기
			for(int i=0; i<size; i++) {
				// x 값이 캐시 배열에 있으므로 hit
				// hit이면 그 지점을 저장한다.
				// miss라면 pos가 -1 유지
				if(x == cache[i]) pos = i;
			}
			
			// x 값이 캐시 배열에 없으므로 miss
			// miss 면 앞의 값을 뒤로 하나씩 이동한다.
			if(pos == -1) {
				// i가 size-1  : 인덱스는 0부터 시작하므로 1을 빼줘야 맨 끝 값을 가져올 수 있음
				for(int i = size-1; i>=1; i--) {
					cache[i] = cache[i-1];
				}
			}	// hit 된 상황일 때 
			else {
				// pos : hit 된 지점
				// hit 된 지점부터 1번째까지 하나씩 줄면서 앞뒤 값을 바꿔줌
				for(int i=pos; i>=1; i--) {
					cache[i] = cache[i-1];
				}
			}
			// 신규로 들어온 값을 0번째에 넣어준다.
			cache[0] = x;
		}
		
		return cache;
	}
	
	public static void main(String[] args) {
		LeastRecentlyUsed L = new LeastRecentlyUsed();
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int x : L.solution(size, N, arr)) {
			System.out.print(x + " ");
		}
	}
}