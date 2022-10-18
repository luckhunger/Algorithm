package stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/*
문제 : 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
입력 : 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
출력 : 남은 문자만 출력한다.
*/

public class RemoveBracket {

	public String delBracket(String str) {
		String result = "";
		Stack<Character> stack = new Stack<>();
		
		for(char x : str.toCharArray()) {
			if(x == ')') {
				
				// 여는 괄호를 꺼내고 멈춘다.
				while(stack.pop() != '(');
				
				// 닫는 괄호 만나는 순간, 맨 상단에 값을 꺼낸다.
//				System.out.println(stack.pop());
			} else stack.push(x);
		}
		
		// size() : 스택에 남아있는 원소의 크기
		for(int i=0; i<stack.size(); i++) {
			// get() : 스택의 가장 최근 값을 가져온다.
			result += stack.get(i);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		RemoveBracket R = new RemoveBracket();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(R.delBracket(str));
	}

}
