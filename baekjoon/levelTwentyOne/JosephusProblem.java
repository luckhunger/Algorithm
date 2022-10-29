package levelTwentyOne;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

/*
문제 : 요세푸스 문제는 다음과 같다.
	  1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 
	   이제 순서대로 K번째 사람을 제거한다. 
	   한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
	   이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 
	   원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
	   예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
	  N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
입력 : 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)
출력 : 예제와 같이 요세푸스 순열을 출력한다.
*/

public class JosephusProblem {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// StringBuilder : String과 문자열을 더할 때 새로운 객체를 생성하지 않고 기존의 데이터에 더하는 방식이다.
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			Q.offer(i);
		}
		
		// 출력 형태와 동일하게 만들기 위해 작성
		// append() : 문자열 끝에 문자열을 추가한다.
		sb.append("<");
		
		// 마지막 값이 출력된 후에 공백 없이 '>'가 출력되므로 마지막-1 값까지만 수행한다.
		while(Q.size() > 1) {
			
			// 위와 같은 이유로 K-1까지만 돌리면서 뺀 값을 큐에 다시 넣는다.
			for(int j=0; j<K-1; j++) {
				Q.offer(Q.poll());
			}
			
			// ,와 공백을 넣어주기 위해 작성한다.
			sb.append(Q.poll()).append(", ");
		}
		
		// 마지막 원소를 넣고, > 를 추가하여 출력한다.
		sb.append(Q.poll()).append(">");
		System.out.println(sb);
	}
}