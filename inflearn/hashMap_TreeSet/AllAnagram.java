package hashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

/*
문제 : S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
	   아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
입력 : 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
	  S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
출력 : S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
*/

public class AllAnagram {

	public int count(String str, String word) {
		int result = 0;
		HashMap<Character, Integer> mapA = new HashMap<>();
		HashMap<Character, Integer> mapB = new HashMap<>();
		
		for(char x : word.toCharArray()) {
			mapB.put(x, mapB.getOrDefault(x,0)+1);
		}
		
		// 고정된 윈도우 크기를 구하는 방식은 아래와 같다.
		// 1. 고정 크기보다 하나 작게 적용한다.(left pointer)
		// 2. 적용하지 않았던 마지막 하나를 적용해 원하는 크기를 만든다.(right pointer)
		// 3. left pointer가 증가해서 하나 빠지고, right pointer가 증가해서 하나 추가되는 방식으로 윈도우를 민다.
		// 고정 크기의 슬라이딩 윈도우를 배울 때에 기본적으로 배우는 방식이다.
		
		int L = word.length()-1;
		for(int i=0; i<L; i++) {
			// getOrDefault(Key 값, Default 값) : 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메소드이다.
			mapA.put(str.charAt(i), mapA.getOrDefault(str.charAt(i), 0)+1);
//			System.out.println("1 : " + mapA);
		}
		
		int lt = 0;
		for(int rt=L; rt<str.length(); rt++) {
			// charAt() : String으로 저장된 문자열 중에서 한 글자만 선택해서char타입으로 변환한다.
			mapA.put(str.charAt(rt), mapA.getOrDefault(str.charAt(rt), 0)+1);
			// A.equals(B) : A와 B가 동일한지 비교해서 true, false로 리턴한다. 이 때, Key와 Value가 모두 동일한 지를 확인한다.
			if(mapA.equals(mapB)) result++;
//			System.out.println("2 : " + mapA);
			mapA.put(str.charAt(lt), mapA.get(str.charAt(lt))-1);
//			System.out.println("3 : " + mapA);
//			System.out.println(str.charAt(lt)+ " " + lt);
			if(mapA.get(str.charAt(lt))==0) mapA.remove(str.charAt(lt));
//			System.out.println("4 : " + mapA);
			lt++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		AllAnagram A = new AllAnagram();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String word = sc.next();
		
		System.out.println(A.count(str, word));
	}

}
