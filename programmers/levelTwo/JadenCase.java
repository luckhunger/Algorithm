package levelTwo;

/*
문제:    JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 
		단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
		문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
제한사항: s는 길이 1 이상 200 이하인 문자열입니다.
		s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
		숫자는 단어의 첫 문자로만 나옵니다.
		숫자로만 이루어진 단어는 없습니다.
		공백문자가 연속해서 나올 수 있습니다.
*/

public class JadenCase {

	public static void main(String[] args) {
		
		String s = "for the last week ";
//		String s = "3people unFollowed me";
		String[] str = s.split(" ");
		String answer = "";
		
		// 런타임 에러...
//		for(String x : str) {
//			String first = x.substring(0, 1);
//			
//			if(first.equals(first.toLowerCase())) {
//				first = first.toUpperCase();
//				x = first + x.substring(1, x.length()).toLowerCase();
//				answer += x + " ";
//			}
//		}
//
//		answer = answer.substring(0, answer.length()-1);
		
		// 런타임 에러 2...
//		for(String x : str) {
//			if(str.length == 0) {
//				answer += " ";
//			} else {
//				answer += x.substring(0, 1).toUpperCase();
//				answer += x.substring(1, x.length()).toLowerCase();
//				answer += " ";
//			}
//		}
//		
//		answer = answer.substring(0, answer.length()-1);
		
		for(int i=0; i<str.length; i++) {
    		String now = str[i];
    		
    		// 문자열의 길이가 0이라면(공백 이라면)
    		// answer에 " "만 추가
    		if(str[i].length() == 0) {
    			answer += " ";
    		} 
    		// 문자가 있다면
    		else {
    			// 0번째 문자는 대문자로
    			answer += now.substring(0, 1).toUpperCase();
    			// 1번째 문자부터 마지막까지는 소문자로
    			answer += now.substring(1, now.length()).toLowerCase();
    			// 마지막에 " " 추가
    			answer += " ";
    		}
    		
    	}
		
		// 이거 안하니까 자꾸 테스트 케이스 하나가 틀리더라..반드시 해야하는 이유가 있나?
		// 입력받은 문자열의 맨 마지막이 " " 라면 answer 바로 반환
		// 근데 이거 쓰면 "me " 입력했을 때, 결과가 "M" 으로 끝나는데..
		// 이클립스라서 다른건가...
		// answer.length()-1 > answer.length() 로 바꾸니까 정상 출력된다!
		if(s.substring(s.length()-1, s.length()).equals(" ")){
			answer = answer.substring(0, answer.length());
    	}
		
		answer = answer.substring(0, answer.length()-1);
		
		System.out.println(answer);
		
	}
}
