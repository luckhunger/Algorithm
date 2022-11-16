package recursive_Tre_Graph_DFS_BFS_Basic;

/*
문제 : 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
입력 : 첫 줄에 총 항수 N(1<=N<=10)이 주어집니다.
출력 : 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래 츌력예제와 같은 순서로 출력한다.
	   단 공집합은 출력하지 않습니다.
*/

public class Subset {
	// 집합 원소의 개수
	static int N;
	// 부분집합의 사용여부 값을 저장할 배열
	static int[] ch;
	
	// 원소 사용 여부 확인 위해
	public void DFS(int L) {
		if(L == N + 1) {
			String tmp = "";
			
			for(int i=1; i<=N; i++) {
				if(ch[i] == 1) {
					tmp += (i + " ");
				}
			}
			// tmp.length == 0 이면 공집합
			if(tmp.length() > 0) {
				System.out.println(tmp);
			}
		} else {
			// L = 1 > 사용한다
			ch[L] = 1;
			// 왼쪽 노드 : 사용 한다.
			DFS(L+1);
			// L = 0 > 사용하지 않는다
			ch[L] = 0;
			// 오른쪽 노드 : 사용 하지 않는다.
			DFS(L+1);
		}
	}
	
	public static void main(String[] args) {
		Subset S = new Subset();
		N = 3;
		// ch 배열의 인덱스 번호를 원소로 사용하기 위해 1을 더함
		ch = new int[N+1];
		S.DFS(1);
	}
}