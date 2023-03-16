package levelOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제 : 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
제한사항 : s는 길이가 1 이상, 100이하인 스트링입니다.
*/

public class CenterString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		String answer = "";
		
		// substring(a,b) : a부터 b-1의 위치까지의 문자를 리턴한다.
		if(s.length()%2 == 0) {
			answer = s.substring(s.length()/2 -1, s.length()/2+1);
		}else {
			answer = s.substring(s.length()/2, s.length()/2+1);
		}
		
		System.out.println(answer);
	}
}
