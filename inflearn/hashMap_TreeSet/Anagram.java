package hashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

/*
문제 : Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
	  예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
	  알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
	  길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
입력 : 첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
	   단어의 길이는 100을 넘지 않습니다.
출력 : 두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.
*/

public class Anagram {

	public String same(String A, String B) {
		String result = "YES";
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		// toCharArray() : str에 입력된 문자열을 문자 하나씩 분리해서 문자 배열을 생성함
		for(char x : A.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		
		for(char y : B.toCharArray()) {
			// map.containsKey() : Map에 파라미터로 입력받은 값과 같은 값이 있으면 true를 리턴하는 메소드
			// map.get() : Map에 저장되어있는 Value 들을 반환하는 메소드이다.
			// value 값이 없으면 기존에 없던 문자라는 의미이므로 NO 리턴
			if(!map.containsKey(y) || map.get(y) == 0) {
				return "NO";
			}
			
			// 이미 위에서 키 값을 가지고 있으므로 getOrDefault() 사용 필요 없음
			// 두번째 HashMap에서 동일한 문자가 있으면 value 값을 감소시킨다.
			map.put(y, map.get(y)-1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Anagram anagram = new Anagram();
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		
		System.out.println(anagram.same(A, B));
	}
}