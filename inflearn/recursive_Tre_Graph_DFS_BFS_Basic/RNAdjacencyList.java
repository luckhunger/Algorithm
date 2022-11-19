package recursive_Tre_Graph_DFS_BFS_Basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
문제 : 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
           아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
      1 2 3 4 5
      1 2 5
      1 3 4 2 5
      1 3 4 5
      1 4 5
            총 6 가지입니다.
입력 : 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다.
           그 다음부터 M 줄에 걸쳐 연결정보가 주어진다.
출력 : 총 가지수를 출력한다.
*/

public class RNAdjacencyList {
	static int N, M, result = 0;
	// ArrayList<Integer> 를 저장할 수 있는 객체를 저장하는 ArrayList
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch;
	
	public void DFS(int v) {
		if(v == N) {
			result++;
		} else {
			// v번 ArrayList와 nv 대응
			for(int nv : graph.get(v)) {
				if(ch[nv] == 0) {
					ch[nv] = 1;
					DFS(nv);
					ch[nv] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		RNAdjacencyList routeList = new RNAdjacencyList();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		
		// 객체 생성 필수!! 중요함
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		ch = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			// graph 자체는 0부터 N까지 존재하지만 get으로 접근했기에 get(A)가 1번째가 된다.
			// A 값은 1부터 입력되므로
			// get(A) : A번 ArrayList에 접근함
			// get(A)에 1이 입력되면 1번, 3이 입력되면 3번 0번은 존재하지만 입력되지 않으므로 없는걸로 취급한다.
			// graph에서 A 값을 가져온 후에 그 뒤에 B 값을 더해서 넣는다.
			graph.get(A).add(B);
		}
		
		ch[1] = 1;
		routeList.DFS(1);
		System.out.println(result);
	}
}