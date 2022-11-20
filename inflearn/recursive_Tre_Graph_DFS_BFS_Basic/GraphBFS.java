package recursive_Tre_Graph_DFS_BFS_Basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
문제 : 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
입력 : 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다.
           그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
출력 : 1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례로 출력하세요.
*/

public class GraphBFS {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch, dis;
	
	public void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		// v가 1일때 1로 해서 시작
		ch[v] = 1;
		// 출발지점 0부터 시작
		dis[v] = 0;
		
		queue.offer(v);
		
		while(!queue.isEmpty()) {
			// cv : 현재의 정점
			int cv = queue.poll();
			
			for(int nv : graph.get(cv)) {
				if(ch[nv] == 0) {
					ch[nv] = 1;
					queue.offer(nv);
					// 중요!! 2차원 배열에서 이렇게 씀
					dis[nv] = dis[cv] + 1;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		GraphBFS G = new GraphBFS();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		ch = new int[N+1];
		dis = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			graph.get(A).add(B);
		}
		
		// 1번부터 시작해라
		G.BFS(1);
		
		// 결과는 2부터 출력해야 하므로
		for(int i=2; i<=N; i++) {
			System.out.println(i + " : " + dis[i]);
		}
	}

}
