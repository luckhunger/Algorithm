package recursive_Tre_Graph_DFS_BFS_Basic;

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

public class RouteNavigation {
	static int N, M;
	static int result = 0;
	static int[][] graph;
	static int[] ch;
	
	public void DFS(int v) {
		// 입력받은 값이 정점 노드이면 그대로 결과 출력
		if(v == N) {
			result++;
		} else {
			for(int i=1; i<=N; i++) {
				// graph[v][i] > 입력받은 v행에서 i~N번째 열을 확인한다. 이 값이 1이라면 갈 수 있다는 의미이다.
				// ch[i] == 0 > 방문 하지 않았음
				if(graph[v][i] == 1 && ch[i] == 0) {
					// 방문했다는 의미로 1을 넣는다.
					ch[i] = 1;
					// v 에서 i로 즉, 현재 입력받은 행에 대한 경로는 확인이 끝났으니 다음 행을 찾기 위해 i로 변경하여 작업한다.
					DFS(i);
					// 호출 한 후에 뒤로 돌아갈 때에는 방문하지 않았다는 0을 넣어서 다음 탐색을 한다.
					ch[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		RouteNavigation route = new RouteNavigation();
		Scanner sc = new Scanner(System.in);
		// 노드의 개수
		N = sc.nextInt();
		// 간선의 개수
		M = sc.nextInt();
		// 1번 ~ N번까지의 정점 번호를 담아야 하므로 N+1
		// graph 배열의 각 행,열은 정점 번호를 의미한다.
		graph = new int[N+1][N+1];
		// 1번부터 N번까지 필요하므로 마찬가지로 +1
		ch = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			// 방향 그래프 : A에서 B로 간다는 의미이다.
			graph[A][B] = 1;
		}
		
		ch[1] = 1;
		route.DFS(1);
		System.out.println(result);
	}
}