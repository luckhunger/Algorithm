package nMSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
문제 : N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
	  N개의 자연수 중에서 M개를 고른 수열
	   같은 수를 여러 번 골라도 된다.
	   고른 수열은 비내림차순이어야 한다.
	   길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
입력 : 첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
	   둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
출력 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
	   중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	   수열은 사전 순으로 증가하는 순서로 출력해야 한다.
*/

public class NMEight {
	static int N, M;
	static int[] graph, arr;
	static StringBuilder sb = new StringBuilder();
	
	public void DFS(int depth, int value) {
		if(depth == M) {
			for(int x : graph) {
				sb.append(x + " ");
			}
			sb.append("\n");
		} else {
			for(int i=value; i<N; i++) {
				graph[depth] = arr[i];
				DFS(depth + 1, i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		NMEight eit = new NMEight();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[M];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		eit.DFS(0, 0);
		System.out.println(sb);
	}

}
