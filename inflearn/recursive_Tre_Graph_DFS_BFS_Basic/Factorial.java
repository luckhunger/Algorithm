package recursive_Tre_Graph_DFS_BFS_Basic;

import java.util.Scanner;

/*
문제 : 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
	   예를 들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다.
입력 : 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
출력 : 첫 번째 줄에 N팩토리얼 값을 출력합니다.
*/

public class Factorial {

	public int DFS(int N) {
		if(N == 1) return 1;
		else {
			return N * DFS(N-1);
		}
	}
	
	public static void main(String[] args) {
		Factorial F = new Factorial();
		Scanner sc = new Scanner(System.in);
		
		System.out.println(F.DFS(5));
	}

}
