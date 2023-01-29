package nMSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	  1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
입력 : 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
출력 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
	   중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	   수열은 사전 순으로 증가하는 순서로 출력해야 한다.
*/

public class NMOne {
	static int N, M;
	static int[] ch;
	static int[] graph;
	static StringBuilder sb = new StringBuilder();
	
	public void DFS(int v) {
		if(v == M) {
			for(int x : graph) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			for(int i=1; i<=N; i++) {
				// ch[] == 0 > 방문하지 않았음을 의미한다.
				if(ch[i] == 0) {
					ch[i] = 1;
					// 현재 노드인 v번째에 i 값을 넣는다.
					// 즉, 맨 처음이라고 하면 graph[0] = 1 이 들어간다.
					// 해당 과정을 반복하게 되면 graph[0] = 1 2 3 4 가 된다.
					graph[v] = i;
					// 1을 더함으로써 다음 레벨, graph[1] 에 값을 넣을 수 있게 한다.
					DFS(v+1);
					// 방문 한 노드에서 되돌아가면서 해당 노드를 방문하지 않은 값으로 다시 바꿔준다.
					ch[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		NMOne one = new NMOne();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[M];
		ch = new int[N+1];
		
		one.DFS(0);
		
		System.out.println(sb);
	}
}