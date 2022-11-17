package recursive_Tre_Graph_DFS_BFS_Basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
문제 : 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
	   현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
	   송아지는 움직이지 않고 제자리에 있다.
	   현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
	   최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
입력 : 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.
출력 : 점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.
*/

public class FindingCalf {
	// 최소 횟수를 저장할 변수
	int result = 0;
	// 거리 값들을 배열로 저장
	int[] dis = {1, -1, 5};
	// 한번 Q에 넣은 값들은 넣지 않기 위해 체크배열 선언
	// 시간복잡도 줄이기 위해
	int[] ch;
	
	Queue<Integer> Q = new LinkedList<>();
	
	public int BFS(int S, int E) {
		// 문제에서 배열의 크기가 10000까지이므로 1을 더해서 생성
		ch = new int[10001];
		// 출발지점인 S는 무조건 Q에 들어가므로 1로 값을 정해서 Q에 넣어준다.
		ch[S] = 1;
		Q.offer(S);
		// 레벨
		int L = 0;
		
		while(!Q.isEmpty()) {
			// 레벨 0 = len은 1
			// 레벨 1 = len은 3
			int len = Q.size();
			
			for(int i=0; i<len; i++) {
				int x = Q.poll();
				
				// j는 다음 레벨로, 자식 노드는 무조건 3개까지만 나오므로 3번만 돌게 함
				for(int j=0; j<3; j++) {
					// nx : x의 자식노드
					// x 에 dis 배열의 값들을 각각 더해서 3개의 자식 노드를 생성한다.
					int nx = x + dis[j];
					
					// 송아지 위치에 도달하면 L을 리턴한다
					// L = 노드의 레벨 = 거리
					// nx 는 자식 노드이므로 L에서 1을 더해줘야함
					if(nx == E) return L+1;
					
					// 아직 방문 안했다는 의미
					if(nx>=1 && nx<=10000 && ch[nx]==0) {
						ch[nx] = 1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		FindingCalf F = new FindingCalf();
		Scanner sc = new Scanner(System.in);
		// 현수의 위치
		int S = sc.nextInt();
		// 송아지의 위치
		int E = sc.nextInt();
		
		System.out.println(F.BFS(S, E));
	}
}