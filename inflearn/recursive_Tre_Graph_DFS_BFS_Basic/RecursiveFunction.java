package recursive_Tre_Graph_DFS_BFS_Basic;

/*
문제 : 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
입력 : 첫 번째 줄은 정수 N(3<=N<=10)이 입력된다.﻿
출력 : 첫째 줄에 출력한다.

*/

public class RecursiveFunction {

	// DFS :깊이우선탐색의 약자
	public void DFS(int N) {
		// 재귀함수 코드
		if(N == 0) {
			return;
		} else {
//			System.out.print(N + " ");
			// 자기가 자신을 호출함
			DFS(N-1);
			System.out.print(N + " ");
		}
	}
	
	public static void main(String[] args) {
		RecursiveFunction R = new RecursiveFunction();
		R.DFS(3);
	}

}
