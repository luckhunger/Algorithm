package recursive_Tre_Graph_DFS_BFS_Basic;

import java.util.LinkedList;
import java.util.Queue;

/*
문제 : 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단 노드 까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
	   각 경로의 길이는 루트도느에서 말단노드까지 가는데 디동하는 횟수를 즉 간선(에지)의 개수를 길이로 하겠습니다.
입력 : 
출력 : 3번 노드까지의 길이인 1
*/

class NodeFour {
	int data;
	Node lt, rt;
	
	public NodeFour(int val) {
		data = val;
		lt = rt = null;
	}
}

public class TreeBFS {
	Node root;
	
	public int BFS(Node root) {
		Queue<Node> Q = new LinkedList<>();
		
		Q.offer(root);
		int L = 0;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			
			for(int i=0; i<len; i++) {
				// cur : 현재 노드
				Node cur = Q.poll();
				
				// 맨 처음으로 발견된 말단 노드로, 가장 짧은 거리로 갈 수 있는 말단 노드를 의미한다.
				if(cur.lt == null && cur.rt == null) {
					return L;
				}
				
				// 말단 노드가 아니면 해당 노드를 큐에 넣는다.
				if(cur.lt != null) Q.offer(cur.lt);
				if(cur.rt != null) Q.offer(cur.rt);
			}
			L++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		TreeBFS tree = new TreeBFS();
		
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		
		System.out.println(tree.BFS(tree.root));
	}

}
