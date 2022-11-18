package recursive_Tre_Graph_DFS_BFS_Basic;

/*
문제 : 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단 노드 까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
	   각 경로의 길이는 루트도느에서 말단노드까지 가는데 디동하는 횟수를 즉 간선(에지)의 개수를 길이로 하겠습니다.
입력 : 
출력 : 3번 노드까지의 길이인 1
*/

class NodeThree {
	int data;
	Node lt, rt;
	
	public NodeThree(int val) {
		data = val;
		lt = rt = null;
	}
}

public class TreeDFS {
	Node root;
	
	public int DFS(int L, Node root) {
		// 말단 노드임을 확인
		if(root.lt == null && root.rt == null) {
			return L;
		} else {
			// Math.min 으로 인해 자식 노드 둘 중, 더 작은 레벨값을 부모 노드가 리턴받음
			return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
		}
		
	}
	
	public static void main(String[] args) {
		TreeDFS tree = new TreeDFS();
		
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		
		System.out.println(tree.DFS(0, tree.root));
	}

}
