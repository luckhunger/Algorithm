package recursive_Tre_Graph_DFS_BFS_Basic;

/*
문제 : 아래 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요.
	   전위순회 출력 : 1 2 4 5 3 6 7
	   중위순회 출력 : 4 2 5 1 6 3 7
	   후위순회 출력 : 4 5 2 6 7 3 1
입력 : 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
출력 : 첫 줄에 피보나치 수열을 출력합니다.
*/

class Node {
	// 각 트리의 값이 들어갈 변수
	int data;
	// lt : 왼쪽 자식의 노드
	// rt : 오른쪽 자식의 노드
	// lt, rt : 인스턴스 변수 / 노드 클래스의 객체 주소를 저장하는 변수
	Node lt, rt;
	
	// val : data 값이 넘어옴
	public Node(int val) {
		data = val;
		lt = rt = null;
	}
}

public class BinaryTreeCircuit {
	// 1번 노드
	Node root;
	
	public void DFS(Node root) {
		// 말단 노드이면 끝을 의미하므로 바로 return
		if(root == null) return;
		else {
			// 전위순회
			System.out.print(root.data + " ");
			
			// 왼쪽 노드 생성
			DFS(root.lt);
			
			// 중위순회
			System.out.print(root.data + " ");
			
			// 오른쪽 노드 생성
			DFS(root.rt);
			
			// 후위순회
			System.out.print(root.data + " ");
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTreeCircuit tree = new BinaryTreeCircuit();
		
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		tree.DFS(tree.root);
	}

}
