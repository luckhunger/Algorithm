package nMSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
문제 : N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	  N개의 자연수 중에서 M개를 고른 수열
입력 : 첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
	   둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
출력 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
	   중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	   수열은 사전 순으로 증가하는 순서로 출력해야 한다.
*/


public class NMNine {
	static int N, M;
	static int[] graph, arr, ch;
	static StringBuilder sb = new StringBuilder();
	
	public void DFS(int depth) {
		if(depth == M) {
			for(int x : graph) {
				sb.append(x + " ");
			}
			sb.append("\n");
		} else {
			// before 값 초기화
			int before = 0;
			for(int i=0; i<N; i++) {
				if(ch[i] == 1) {
					continue;
				} else if(before != arr[i]) {	// 중복 제거
					System.out.println("before : " + before);
					ch[i] = 1;
					graph[depth] = arr[i];
					before = arr[i];	// arr[i] 값을 넣어서 해당 레벨에 중복되는 값 없애기 위해 사용
					System.out.println("before2 : " + before);
					DFS(depth + 1);
					ch[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		NMNine eit = new NMNine();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[M];
		arr = new int[N];
		ch = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		eit.DFS(0);
		System.out.println(sb);
	}

}
