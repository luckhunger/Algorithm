package stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/*
문제 : 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
	   만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
입력 : 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
	   식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
출력 : 연산한 결과를 출력합니다.
*/

public class PostfixNotation {

	public int solution(String str) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		
		// toCharArray() : 입력된 문자열을 문자 하나씩 분리해서 문자 배열을 생성함
		for(int x : str.toCharArray()) {
			// isDiit() : char 값이 숫자 인지를 판단하여 true 또는 false 값으로 리턴한다.
			if(Character.isDigit(x)) {
				// char 형이라서 아스키코드 값으로 리턴되기 때문에 0의 아스키코드값이 48을 빼서 자연수 형태로 바꿔준다.
				stack.push(x-48);
			} else {
				// rt : 먼저 나오는 숫자
				int rt = stack.pop();
				// lt : 나중에 나오는 숫자
				int lt = stack.pop();
				
				if(x == '+') stack.push(lt + rt);
				else if(x == '-') stack.push(lt - rt);
				else if(x == '*') stack.push(lt * rt);
				else if(x == '/') stack.push(lt / rt);
			}
		}
		// 스택에는 계산된 값 하나만이 들어가 있을 것이기에 0번째 값을 가져온다.
		// get() : 스택의 가장 최근 값을 가져온다.
		result = stack.get(0);
		
		return result;
	}
	
	public static void main(String[] args) {
		PostfixNotation post = new PostfixNotation();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(post.solution(str));
	}

}
