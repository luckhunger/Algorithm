package utilize_DFS_BFS;

import java.util.Scanner;

/*
문제 : N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
	  두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
	  둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
	  예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
입력 : 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
	   두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
출력 : 첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.
*/

public class Disjoint {
	static String result = "NO";
	static int N, total = 0;
	// YES 발견되면 그 뒤에 재귀함수는 모두 넘기기 위해 선언
	boolean flag = false;
	
	public void DFS(int L, int sum, int[] arr) {
		if(flag) return;
		
		// 만약 부분집합들의 누적합이 절반이 넘으면 더 구할 필요가 없으므로 return
		if(sum > total/2) return;
		
		if(L == N) {
			if((total-sum) == sum) {
				result = "YES";
				flag = true;
			}
		} else {
			// arr[L] 을 부분집합에 사용한다 > sum에 누적
			DFS(L+1, sum+arr[L], arr);
			// arr[L] 을 부분집합에 사용하지 않는다.
			DFS(L+1, sum, arr);
		}
	}
	
	public static void main(String[] args) {
		Disjoint D = new Disjoint();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		D.DFS(0, 0, arr);
		System.out.println(result);
	}
}