package recursive_Tre_Graph_DFS_BFS_Basic;

import java.util.LinkedList;
import java.util.Queue;

/*
문제 : 아래 그림과 같은 이진트리를 레벨탐색 연습하세요.
입력 : 
출력 : 레벨 탐색 순회 출력 : 1 2 3 4 5 6 7
*/

// 다른 파일에 Node가 존재해서 임의로 이름 변경
class NodeTwo {
	// 각 트리의 값이 들어갈 변수
	int data;
	// lt : 왼쪽 자식의 노드
	// rt : 오른쪽 자식의 노드
	// lt, rt : 인스턴스 변수 / 노드 클래스의 객체 주소를 저장하는 변수
	Node lt, rt;
	
	// val : data 값이 넘어옴
	public NodeTwo(int val) {
		data = val;
		lt = rt = null;
	}
}

public class BinaryTreeCircuitLevel {
	Node root;
	
	// main에서 BFS(tree.root) 에 입력된 tree.root가 Node root에 들어감
	public void BFS(Node root) {
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);
		// 루트 노드의 레벨은 0이므로
		// 이 레벨은 최단거리에 필수이므로 반드시 숙지할 것
		int L = 0;
		
		// 비어있지 않으면 계속 돌기
		while(!Q.isEmpty()) {
			// 각 레벨에 있는 노드의 개수
			int len = Q.size();
			// 1회차 : L = 0
//			System.out.println(L + " ");
			
			for(int i=0; i<len; i++) {
				Node cur = Q.poll();
				// 1회차 : 루트 노드의 값은 1이므로 1 출력
				System.out.print(cur.data + " ");
				
				// cur.lt : 현재 노드의 왼쪽 노드
				// 왼쪽 노드가 없다 = 말단 노드이다.
				// 1회차 : 왼쪽, 오른쪽 노드인 2,3을 각각 출력
				if(cur.lt != null) Q.offer(cur.lt);
				if(cur.rt != null) Q.offer(cur.rt);
			}
			L++;
//			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeCircuitLevel tree = new BinaryTreeCircuitLevel();
		
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		// tree.root : root 노드의 주소를 가지고 있음
		tree.BFS(tree.root);
	}
}