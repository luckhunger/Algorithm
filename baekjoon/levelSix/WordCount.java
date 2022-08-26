package levelSix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
문제 : 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 
	   이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 
	   단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
입력 : 첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 
	   이 문자열의 길이는 1,000,000을 넘지 않는다. 
	   단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 
	   또한 문자열은 공백으로 시작하거나 끝날 수 있다.
출력 : 첫째 줄에 단어의 개수를 출력한다.
*/

public class WordCount {

//	public static int Count(String str) {
//		int result = 0;
//		// trim() : 앞뒤 공백을 제거한 문자열의 복사본을 리턴한다.
//		str = str.trim();
//		
//		// isEmpty() : 문자열의 길이가 0인 경우에, true를 리턴한다. 
//		if(str.isEmpty() == false) {
//			String[] word = str.split(" ");
//			for(int i=0; i<word.length; i++) {
////				System.out.println(word[i]);
//				result++;
//			}
//		}
//		return result;
//	}
	
	public static void main(String[] args) throws IOException{
//		Scanner sc = new Scanner(System.in);
//		// 공백을 포함해서 한 줄로 입력받기 위해 nextLine() 사용
//		String str = sc.nextLine();
//		
//		System.out.println(Count(str));
		
		// StringTokenizer 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer : 하나의 문자열을 여러 개의 토큰으로 분리하는 클래스
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// StringTokenizer 클래스의 안에서 제공하는 기본 메서드
		// nextToken 메서드를 호출 할 수 있는 횟수를 계산한다.
		// StringTokenizer의 남아있는 토큰 갯수를 반환한다.
		System.out.println(st.countTokens());
	}
}
