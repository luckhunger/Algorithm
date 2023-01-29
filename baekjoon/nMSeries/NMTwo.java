package nMSeries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
문제 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	  1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	    고른 수열은 오름차순이어야 한다.
입력 : 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
출력 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
	   중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	   수열은 사전 순으로 증가하는 순서로 출력해야 한다.
*/

public class NMTwo {
	static int N, M;
	static int[] graph;
	static StringBuilder sb = new StringBuilder();
	
	public void DFS(int cn, int depth) {
		
		// cn : 시작 위치
		// depth : 깊이
		if(depth == M) {
			for(int x : graph) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			// 해당 문제는 뒤로 돌아가며 또 다른 경로를 찾을 필요가 없다.
			// 이미 한번 방문한 곳은 다시 방문하지 않기 때문이다.
			for(int i=cn; i<=N; i++) {
					// (A, B) 에서 for 문을 돌며 좌표값을 구한다.
					graph[depth] = i;
					// 이전 값보다 큰 수를 탐색하기 위해 1씩 더함
					DFS(i+1, depth+1);
				}
			}
		}
		
	
	public static void main(String[] args) throws IOException {
		NMTwo two = new NMTwo();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[M];
		
		two.DFS(1, 0);
		System.out.println(sb);
	}

}
