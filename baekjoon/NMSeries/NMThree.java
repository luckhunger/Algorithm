package nMSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	  1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	    고른 수열은 오름차순이어야 한다.
입력 : 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
출력 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
	   중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	   수열은 사전 순으로 증가하는 순서로 출력해야 한다.
*/

public class NMThree {
	static int N, M;
	static int[] graph;
	static StringBuilder sb = new StringBuilder();
	
	public void DFS(int depth) {
		if(depth == M) {
			for(int x : graph) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			for(int i=1; i<=N; i++) {
				graph[depth] = i;
				System.out.println("depth " + depth);
				System.out.println("i " + i);
				DFS(depth+1);
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		NMThree three = new NMThree();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[M];
		
		three.DFS(0);
		System.out.println(sb);
		
	}

}
