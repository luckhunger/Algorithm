package hashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

/*
문제 : 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
	   투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
	   선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
	   반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
입력 : 첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
 	   두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.
출력 : 학급 회장으로 선택된 기호를 출력합니다.
*/

public class ClassPresident {

	public static char solution(int N, String str) {
		char result = ' ';
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		// x : 입력받은 A,B,C,D,E의 값
		for(char x : str.toCharArray()) {
			// map.put() : Key와 Value 값을 HashMap에 넣는다. 만약 키 값이 없으면 생성한다.
			// Key : Character형, value : Integer 형
			// map.getOrDefault(Key 값, Default 값) : 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메소드이다.
			// x > B 라고 가정하고, 기존에 B에는 1이라는 Value가 있다고 생각해보자.
			// map.getOrDefault(x,0)+1 을 통해서 B를 찾고, 찾은 후에 B값의 value를 1 증가시켜서 결과적으로 B는 2라는 value를 갖게 되는 것이다.
			// map.getOrDefault() 는 자주 쓰이므로 꼭 알아두기
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		
		// containsKey() : 키가 있는지 없는지를 true/false로 리턴한다.
//		System.out.println(map.containsKey('A'));
		// size() : key의 개수를 리턴한다.
//		System.out.println(map.size());
		// remove() : 키를 삭제한다.
//		System.out.println(map.remove('A'));
		
		int max = Integer.MIN_VALUE;
		// key, Value 출력하기
		// map.keySet() : Map에 저장되어있는 키(Key)들을 반환하는 메소드이다.
		// map.get() : Map에 저장되어있는 Value 들을 반환하는 메소드이다.
		for(char key : map.keySet()) {
//			System.out.println(key + " " + map.get(key));
			if(map.get(key) > max) {
				max = map.get(key);
				result = key;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		
		System.out.println(solution(N, str));
	}
}
