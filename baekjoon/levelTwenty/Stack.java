package levelTwenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제 : 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
	   명령은 총 다섯 가지이다.
	  push X: 정수 X를 스택에 넣는 연산이다.
	  pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	  size: 스택에 들어있는 정수의 개수를 출력한다.
	  empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	  top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력 : 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 
	   둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 
	   주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 
	   문제에 나와있지 않은 명령이 주어지는 경우는 없다.
출력 : 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
*/

public class Stack {
	
	public static int[] stack;
	public static int i = 0;
	
	public static void push(int X) {
		stack[i] = X;
		i++;
	}
	
	public static int pop() {
		if(i == 0) {
			return -1;
		} else {
			int res = stack[i-1];
			i--;
			return res; 
		}
	}
	
	public static int size() {
		return i;
	}
	
	public static int empty() {
		if(i == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static int top() {
		if(i == 0) {
			return -1;
		} else {
			// i = size 즉, 원소의 개수이므로 최상단을 구하려면 i-1을 해서 가장 마지막에 넣은 값을 출력해야 한다.
			return stack[i-1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder : String과 문자열을 더할 때 새로운 객체를 생성하지 않고 기존의 데이터에 더하는 방식을 사용하여 속도가 빠르다.
		StringBuilder sb = new StringBuilder();
		// StringTokenizer : 문자열을 구분자를 이용하여 분리하기 위해 사용한다.
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		stack = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
				// append() : 문자열 끝에 문자열을 추가한다.
				// 메소드를 수행해서 값을 추가한 후에, 줄넘김 문자를 추가한다.
				sb.append(pop()).append('\n');
				break;
				
			case "size":
				sb.append(size()).append('\n');
				break;
				
			case "empty":
				sb.append(empty()).append('\n');
				break;
				
			case "top":
				sb.append(top()).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}

}
