package String;

import java.util.Scanner;

public class FindString {

	public int countString(String str, char c) {
		int result = 0;
		
		str = str.toUpperCase();
		c = Character.toUpperCase(c);
		
//		for(int i=0; i<str.length(); i++) {
//			if(str.charAt(i) == c) result++;
//		}
		
		// 향상된 for문 사용
		// 'char x :' 옆에는 arrayList, List 와 같은 배열만 들어갈 수 있음
		// toCharArray() : str에 입력된 문자열을 문자 하나씩 분리해서 문자 배열을 생성함
		// 즉, 문자 배열의 0번 인덱스부터 끝까지 x 와 하나씩 비교한다.
		for(char x : str.toCharArray()) {
			if(x == c) result++; 
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		// static이 아닌 메소드를 사용하려면 객체 생성이 필요하다.
		FindString cnt = new FindString();
		
		Scanner sc = new Scanner(System.in);
		// 콘솔 창에서 문자열을 하나 읽어들인다.
		String str = sc.next();
		// 0번째의 문자 1개를 가져온다.
		char c = sc.next().charAt(0);
		
		
		System.out.println(cnt.countString(str, c));

	}

}
