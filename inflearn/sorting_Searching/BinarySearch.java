package sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

/*
문제 : 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
	   이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
입력 : 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
	   두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
출력 : 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
*/

public class BinarySearch {

	public int solution(int N, int M, int[] arr) {
		int result = 0;
		
		Arrays.sort(arr);
		int lt = 0;
		int rt = N-1;
		
		while(lt <= rt) {
			// mid : 중간값
			int mid = (lt + rt) / 2;
			
			// mid번째에 찾고자 하는 M 값이 있으면
			if(arr[mid] == M) {
					// mid는 인덱스 번호이므로 1을 더해준다.
					result = mid + 1;
					break;
			}
			
			// mid 번째 값이 M보다 크면 큰 쪽인 맨 마지막 값(rt)에 1을 뺀다.
			// 이를 통해 그 뒤의 값은 탐색하는 범위에서 제외시킨다.
			if(arr[mid] > M) {
				rt = mid - 1;
			} else {
				lt = mid + 1;
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		BinarySearch B = new BinarySearch();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(B.solution(N, M, arr));
	}

}
