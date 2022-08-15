package levelOne;

import java.util.Scanner;

/*
문제 : 
(세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
--------------
   472   -- (1)
  x385   -- (2)
ㅡㅡㅡㅡㅡㅡ
  2360   -- (3)
 3776    -- (4)
1416     -- (5)
ㅡㅡㅡㅡㅡㅡ
181710   -- (6)
--------------
(1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
입력 : 첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.
출력 : 첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
*/

public class ABCmultiple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
//		String B = sc.next();
		String C = sc.next();
		// 472 * 5
//		System.out.println(A * (B.charAt(2) - '0'));
		
		// 472 * 8
//		System.out.println(A * (B.charAt(1) - '0'));
		
		// 472 * 3
//		System.out.println(A * (B.charAt(0) - '0'));
		
		// 472 * 385
//		System.out.println(A * Integer.parseInt(B));
		
		// charAt() 사용
		// charAt()은 아스키 코드값으로 결과값을 반환하므로 -'0' 을 사용하여 우리가 아는 숫자 그대로의 값을 쓰도록 해줌
		// charAt()은 계산 시, 자동으로 형변환을 해주기 때문에 아래 상황에서는 int 형변환이 이루어짐 
		// 이 때 변환된 값은 아스키 코드 값이며 아스키 코드 표에 의해 해당하는 아스키 코드값으로 변환됨
		// 문자 '0' 의 아스키 코드값 > 48
		// 문자 '3' 의 아스키 코드값 > 51
		// 문자 '5' 의 아스키 코드값 > 53
		// 문자 '8' 의 아스키 코드값 > 56
		// 즉 53 - 48 이 되면서 int 형태인 5가 출력되는 것
		// 계산하지 않은 charAt(2> > 5 는 문자형태의 5를 의미하는 것
		System.out.println(A * (C.charAt(2) - '0'));
		System.out.println(A * (C.charAt(1) - '0'));
		System.out.println(A * (C.charAt(0) - '0'));
		
		System.out.println(A * Integer.parseInt(C));
	}

}
