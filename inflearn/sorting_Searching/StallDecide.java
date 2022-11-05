package sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

/*
문제 : N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
	   현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
	   가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
	  C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
입력 : 첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
	   둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.
출력 : 첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.
*/

public class StallDecide {

	// 결정 알고리즘의 핵심. 이 함수를 만들 수 있냐 없냐가 답의 해결책!
	// dist : 말 사이의 거리(mid 값이 들어옴)
	public int count(int[] arr, int dist) {
		// 배치한 말의 마리 수
		int cnt = 1;
		// 가장 왼쪽 좌표
		// 가장 왼쪽 좌표에 말을 넣어야 가장 많이 말을 넣을 수 있다.
		int ep = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			// 두 말 사이의 거리가 dist보다 크거나 같으면 말을 한 마리 더 배치할 수 있음
			if(arr[i] - ep >= dist) {
				cnt++;
				ep = arr[i];
			}
		}
		return cnt;
	}
	
	public int solution(int N, int C, int[] arr) {
		int result = 0;
		
		// 배열 정렬
		// Arrays.sort() : 배열을 자동으로 오름차순으로 정렬해준다.
		Arrays.sort(arr);
		
		// 맨 첫번째로, 무조건 1로 시작
		int lt = 1;
		// 맨 마지막 값
		int rt = arr[N-1];
		
		// 결정 알고리즘의 이 과정은 외우기!
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			
			// count로 리턴된 마리수가 C 보다 크거나 같으면 mid 값이 정답으로 유효한 후보이다.
			if(count(arr, mid) >= C) {
				result = mid;
				// 거리가 최대인 값을 구해야하므로 mid보다 큰 값으로 유효한 값이 더 나오는지 찾기 위해 lt + 1 을 한다.
				lt = mid + 1;
			} else {
				// 해당 거리로는 모든 말을 배치할 수 없으므로 mid 값을 줄여서 다시 탐색한다.
				rt = mid - 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		StallDecide sd = new StallDecide();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(sd.solution(N, C, arr));
	}

}
