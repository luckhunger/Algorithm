package string;

import java.util.Scanner;

/*
문제 : 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
	   문장속의 각 단어는 공백으로 구분됩니다.
입력 : 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
출력 : 첫 줄에 가장 긴 단어를 출력한다.
	   가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
*/

public class SentenseInWord {

	public String findWord(String sentense){
		String result = "";
		
		// -2의 31제곱(-2,147,483,648) 으로 초기화해주는 메소드
		//  MAX_VALUE 를 사용하면 2의 31제곱인 (2,147,483,648)로 초기화해준다.
		int max = Integer.MIN_VALUE;
		
		// indexOf 사용하는 방식 
		// indexOf() : 특정 문자나 문자열에 앞에서부터 처음으로 발견되는 인덱스를 반환한다.
		// 찾지 못했을 경우 -1 을 반환한다.
		// indexOf("찾을 특정 문자", "시작할 위치") 형태로 사용하며 위치 생략 시 0부터 찾는다.
//		int pos;
//		while((pos=sentense.indexOf(' '))!=-1) {
//			String str = sentense.substring(0, pos);
//			int length = str.length();
//			
//			if(length > max) {
//				max = length;
//				result = str;
//			}
//			// 단어를 찾은 후 ,그 다음 단어를 찾기 위해 pos에 +1
//			sentense = sentense.substring(pos+1);
//		}
//		// 가장 마지막에 긴 단어가 위치했을 때, 마지막 단어를 출력하기 위해 작성
//		if(sentense.length() > max) result = sentense;
		
		String[] word = sentense.split(" ");
		
		// word가 배열이라서 향상된 for문에 사용 가능
		// 향상된 for 문에 사용할 수 있는 대상은 배열 또는 여러 원소를 포함한 자료형이어야 한다.
		// for(자료형 변수명 : 배열명)
		for(String str : word) {
			// 단어의 길이를 구함
			int length = str.length();
			
			if(length > max) {
				max = length;
				result = str;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		SentenseInWord word = new SentenseInWord();
		Scanner sc = new Scanner(System.in);
		String sentense = sc.nextLine();
		
		System.out.println(word.findWord(sentense));
		
	}

}
