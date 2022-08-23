package levelSix;

import java.util.Scanner;

/*
문제 : 알파벳 소문자로만 이루어진 단어 S가 주어진다. 
	   각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 
	   포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
입력 : 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
출력 : 각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
	   만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
*/

public class FindAlphabet {

	public static void main(String[] args) {
		FindAlphabet fa = new FindAlphabet();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		// indexOf 사용
		// indexOf() : 특정 문자나 문자열에 앞에서부터 처음으로 발견되는 인덱스를 반환한다.
//		for(char word = 'a'; word <= 'z'; word++) {
//			System.out.print(str.indexOf(word) + " ");
//		}
		
		// indexOf 미사용
		// 영어 소문자 알파벳 개수만큼 배열 생성
		int[] alpha = new int[26];
		
		// 배열만큼 돌면서 초기값 -1로 초기화
		for(int i=0; i<alpha.length; i++) {
			alpha[i] = -1;
		}
		
		
		for(int i=0; i<str.length(); i++) {
			// 입력받은 문자열을 문자 하나씩 쪼개 배열로 만들어 word에 저장
			char word = str.charAt(i);
			
			// 배열이 char 형이므로 2바이트 즉, 2진수의 값이 저장되어 있어 아스키코드값을 통해 10진수 값으로 변형해야 함
			// 이를 위해 'a' 혹은 '97' 값을 빼서 10진수로 변환해준다.
			// 소문자 a 의 아스키코드값은 97
			// alpha[word] == -1 이면 처음 등장한 알파벳을 의미하므로 위치값을 넣어준다.
			// -1이 아니라면 이미 등장한 알파벳이므로 넘어간다.
			if(alpha[word - 'a'] == -1) {
				alpha[word - 'a'] = i;
				System.out.println(alpha[word - 'a']);
			}
		}
		
		// 영어 소문자 알파벳 만큼 돌면서 결과값 출력
		for(int i=0; i<alpha.length; i++) {
			System.out.print(alpha[i] + " ");
		}
		
	}

}
