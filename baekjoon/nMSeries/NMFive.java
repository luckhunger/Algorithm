package nMSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
문제 : N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
      N개의 자연수는 모두 다른 수이다.
	  N개의 자연수 중에서 M개를 고른 수열
입력 : 첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
	   둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
출력 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
	   중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	   수열은 사전 순으로 증가하는 순서로 출력해야 한다.
*/

public class NMFive {
	static int N, M;
	static int[] graph, arr, ch;
	static StringBuilder sb = new StringBuilder();
	
	public void DFS(int depth) {
		
		if(depth == M) {
			for(int x : graph) {
				sb.append(x+ " ");
			}
			sb.append("\n");
			return;
		}else {
			for(int i=0; i<N; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					graph[depth] = arr[i];
					DFS(depth+1);
					ch[i] = 0;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		NMFive f = new NMFive();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			// 출력은 M개만 해야한다.
			graph = new int[M];
			ch = new int[N];
		
			// 토큰을 사용해서 값을 넣기 전에 반드시 아래 코드 필요
			// 아래 코드 없이 실행하면 NoSuchElementException 에러 발생
			// 입력받은 값을 구분자로 나누기 위해 사용하는데 입력받은 값이 없거나 값을 나눠주지 않는다면 에러가 발생한다.
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			f.DFS(0);
			System.out.println(sb);
	}

}
