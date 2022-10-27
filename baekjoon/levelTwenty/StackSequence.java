package levelTwenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
문제 : 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
	   스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
	  1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
	   이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
	   임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 
	   이를 계산하는 프로그램을 작성하라.
입력 : 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 
	   둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 
	   물론 같은 정수가 두 번 나오는 일은 없다.
출력 : 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.
*/

public class StackSequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder : String과 문자열을 더할 때 새로운 객체를 생성하지 않고 기존의 데이터에 더하는 방식
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int start = 0;
		
		// N이 하나씩 감소하면서 0보다 작아질 떄까지 돈다.
		while(N-- > 0) {
			int value = Integer.parseInt(br.readLine());
			
			// 입력받은 값이 시작하는 값보다 크면 값을 넣을 수 있다.
			// value : 5, start : 3 > 스택에는 4, 5를 넣을 수 있음
			if(value > start) {
				// 중복이 안되고, 마지막 값은 제거했으므로 +1을 해서 그 다음 값부터 돈다.
				for(int i=start+1; i<= value; i++) {
					// 스택에 i 를 넣는다.
					stack.push(i);
					// push() 가 되므로 + 를 StringBuilder에 넣어준다.
					sb.append("+\n");
				}
				// 시작 위치를 입력받은 값으로 바꿔준다.
				// value가 5이면 그 다음은 6부터 값을 넣을 수 있도록 하기 위해
				start = value;
			// 스택 최상단 값이 입력받은 값이 아니라면 수열을 만들 수 없으므로 NO를 리턴한다.
			// stack.peek() : 5 / value : 3 > 이라면 3이라는 값은 이미 지워진 값이므로 수열을 만들 수 없다.
			// peek() : 스택에서 가장 상단의 값을 리턴받는다. 단, pop와 달리 값을 꺼내지 않고 단순히 읽는다.
			} else if(stack.peek() != value) {
				System.out.println("NO");
				return;
			}
			// stack.peek()와 value가 같으면 해당 값을 스택에서 빼준다.
			stack.pop();
			// pop() 가 되므로 - 를 StringBuilder에 넣어준다.
			sb.append("-\n");
		}
		
		// toString() : 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드이다.
		System.out.println(sb);
	}

}
