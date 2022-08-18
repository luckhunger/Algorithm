package string;

import java.util.ArrayList;
import java.util.Scanner;

/*
문제 : N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
입력 : 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
	   두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
출력 : N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
*/

public class ReverseWord {

	public static ArrayList<String> reverse(int n, String[] wordList) {
		ArrayList<String> result = new ArrayList<>();
		
		for(String word : wordList) {
			// StringBuilder : String과 문자열을 더할 때 새로운 객체를 생성하지 않고 기존의 데이터에 더하는 방식
			// 				      속도가 빠르고 상대적으로 부하가 적다.
			// reverse : 문자열을 뒤집어주는 메소드
			// toString : String 형태로 변환
			String reverseWordList = new StringBuilder(word).reverse().toString();
			
			// result에 reverseWordList 값을 넣어줌
			result.add(reverseWordList);
		}
		
//		// reverse를 직접 구현하기
//		for(String word : wordList) {
//			
//			// toCharArray 를 사용해서 문자 배열 생성
//			char[] reverseWord = word.toCharArray();
//			
//			// 좌측 알파벳의 index
//			int leftIndex = 0;
//			// 단어의 길이 -1 을 통해 맨 마지막 알파벳의 인덱스 설정
//			int rightIndex = word.length()-1;
//			
//			// 인덱스를 통해 양쪽 끝의 알파벳을 서로 하나씩 바꿔줌
//			
//			while(leftIndex < rightIndex) {
//				char tmp = reverseWord[leftIndex];
//				reverseWord[leftIndex] = reverseWord[rightIndex];
//				reverseWord[rightIndex] = tmp;
//				
//				leftIndex++;
//				rightIndex--;
//			}
//			// valueOf : 괄호 안에 입력한 객체를 String 형으로 변환한다.
//			String reverseWordList = String.valueOf(reverseWord);
//			result.add(reverseWordList);
//		}
//		
		return result;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] wordList = new String[n];
		
		// words 배열에 입력한 문자 삽입
		for(int i=0; i<n; i++) {
			wordList[i] = sc.next();
		}
		
		for(String x : reverse(n, wordList)) {
			System.out.println(x);
		}

	}

}
