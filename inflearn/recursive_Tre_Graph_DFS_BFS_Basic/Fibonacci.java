package recursive_Tre_Graph_DFS_BFS_Basic;

/*
문제 : 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
	   입력은 피보나치 수열의 총 항의 수이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
입력 : 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
출력 : 첫 줄에 피보나치 수열을 출력합니다.
*/

public class Fibonacci {

	// 더 빠른 계산을 위해 배열을 사용한다.
	// 기존에는 배열 원소값 하나당 3초였는데
	// fibo[] 사용하면 전체 배열 출력에 7초 걸린다.
	static int[] fibo;
	
	public int DFS(int N) {
		// 이미 구해진 값이 있다면 그 값을 바로 리턴한다.
		// 메모리제이션이라고 부른다.
		if(fibo[N] > 0) return fibo[N];
		
		// fibo에 값을 넣어준다.
		if(N == 1) return fibo[N] = 1;
		else if(N == 2) return fibo[N] = 1;
		else return fibo[N] = DFS(N-2) + DFS(N-1);
	}
	
	public static void main(String[] args) {
		Fibonacci F = new Fibonacci();
		int N = 10;
		// 1번부터 N번까지의 인덱스 번호가 필요하기 때문에 +1 을 해준다.
		fibo = new int[N+1];
		F.DFS(N);
		for(int i=1; i<N; i++) {
			System.out.print(fibo[i] + " ");
		}
		
	}

}
