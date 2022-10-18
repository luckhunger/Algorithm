package stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/*
문제 : 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
입력 : 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
출력 : 첫 번째 줄에 YES, NO를 출력한다.
*/

public class Bracket {

	public String solution(String str) {
		String result = "YES";
		Stack<Character> stack = new Stack<>();
		
		// toCharArray() : str에 입력된 문자열을 문자 하나씩 분리해서 문자 배열을 생성함
		for(char x : str.toCharArray()) {
			if(x == '(') {
				// push() : 스택에 값을 추가한다.
				stack.push(x);
			} else {
				// else로 넘어왔다는 것은 ')' 가 들어왔다는 것을 의미한다.
				// 즉, 스택에 닫는 괄호가 없으면 여는 괄호에 대한 짝이 없다는 의미이므로 바로 리턴해준다.
				// 닫는 괄호가 더 많은 상황을 의미한다.
				// 닫는 괄호가 많아서 입력되었는데, 스택에는 여는 괄호가 없으므로 이는 올바른 괄호가 아님을 의미한다.
				if(stack.isEmpty()) return "NO";
				// 스택이 비어있지 않으면 닫는 괄호가 있다는 의미이므로 pop()을 통해 가장 상단의 값을 꺼낸다.
				// 스택에는 여는 괄호만을 넣고 x가 닫는 괄호이면, 그와 짝이되는 여는 괄호인 가장 상단의 여는 괄호를 스택에서 빼낸다.
				// pop() : 스택에서 값을 제거한다.
				stack.pop();
			}
		}
		
		// 위에 for문이 다 끝나도 '(' 가 많으면 스택이 비어있지 않는다.
		// 여는 괄호가 더 많은 상황을 의미한다.
		if(!stack.isEmpty()) {
			return "NO";
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Bracket B = new Bracket();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(B.solution(str));
	}
}