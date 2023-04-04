package levelThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제:    두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 
		아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
		1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
		2. words에 있는 단어로만 변환할 수 있습니다.
		예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
		두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
제한사항: 각 단어는 알파벳 소문자로만 이루어져 있습니다.
		각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
		words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
		begin과 target은 같지 않습니다.
		변환할 수 없는 경우에는 0를 return 합니다.
*/

public class ChangeWord {
	static boolean[] ch;
	static int answer = 0;

	public void DFS(int cnt, int cur, String target, String[] words) {
		
		if(target.equals(words[cur])) {
			answer = cnt;
			return;
		}else {
			for(int i=0; i<words.length; i++) {
				if(!ch[i] && compare(words[cur], words[i]) == 1) {
					ch[i] = true;
					DFS(cnt + 1, i, target, words);
					ch[i] = false;
				}
			}
		}
	}
	
	// 다른 스펠링이 몇 개인지 개수 찾기
	public static int compare(String begin, String target) {
		int n = 0;
		
		for(int i=0; i<target.length(); i++) {
			if(begin.charAt(i) != target.charAt(i)) {
				n++;
			}
		}
		
		return n;
	}
	
	public static void main(String[] args) throws IOException {
		ChangeWord word = new ChangeWord();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String begin = st.nextToken();
		String target = st.nextToken();
		
		String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
		
		for(int i=0; i<words.length; i++) {
			// 다른 스펠링이 1개 이하일 때
			if(compare(begin, words[i]) <= 1) {
				ch = new boolean[words.length];
				ch[i] = true;
				word.DFS(1, i, target, words);
			}
		}
		
		
		System.out.println(answer);
	}

}
