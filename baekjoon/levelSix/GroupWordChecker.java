package levelSix;

import java.util.ArrayList;
import java.util.Scanner;

/*
문제 : 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
	   예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
	  aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
           단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
입력 : 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 
           둘째 줄부터 N개의 줄에 단어가 들어온다. 
           단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
출력 : 첫째 줄에 그룹 단어의 개수를 출력한다.
*/

public class GroupWordChecker {
	
	public static boolean Check(String str) {
		ArrayList<String> alphaList = new ArrayList<String>();
		
		for(int i=0; i<str.length(); i++) {
			// 입력받은 문자열을 하나씩 자른다.
			String word = str.substring(i, i+1);
			System.out.println(word);
			
			// 분리한 문자열이 배열에 없다면 추가로 넣는다.
			if(!alphaList.contains(word)) {
				alphaList.add(word);
			// 배열에 문자가 있는데 앞 문자와 동일하지 않다면 그룹단어가 아니므로  false를 리턴한다.
			}else if(str.charAt(i-1) != str.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력할 단어의 개수
		int N = sc.nextInt();
		// 그룹단어의 개수
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			// 입력한 개수만큼 돌면서 단어 입력
			String str = sc.next();
			
			// 그룹 단어 체크하는 함수 수행하고, true면 cnt에 1씩 더하기
			if(Check(str)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
