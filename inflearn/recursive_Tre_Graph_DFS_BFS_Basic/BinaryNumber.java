package recursive_Tre_Graph_DFS_BFS_Basic;

/*
문제 : 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용해서 출력해야 합니다.
입력 : 첫 번째 줄에 1진수 N(1<=N<=1,000)이 주어집니다.
출력 : 첫 번째 줄에 이진수를 출력하세요.
*/

public class BinaryNumber {

	public void DFS(int N) {
		if(N == 0) return;
		else {
			System.out.println(N % 2 + " ");
			DFS(N/2);
		}
	}
	
	public static void main(String[] args) {
		BinaryNumber B = new BinaryNumber();
		
		B.DFS(11);
	}
}