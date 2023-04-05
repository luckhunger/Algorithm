package levelThree;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
문제:    이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
		명령어	수신 탑(높이)
		I 숫자	큐에 주어진 숫자를 삽입합니다.
		D 1	큐에서 최댓값을 삭제합니다.
		D -1	큐에서 최솟값을 삭제합니다.
		이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

제한사항: operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
		operations의 원소는 큐가 수행할 연산을 나타냅니다.
		원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
		빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
*/

public class DoublePriorityQueue {
	
	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
		
		// 최소 값이 우선순위인 형태
		PriorityQueue<Integer> minPq = new PriorityQueue<>();
		// 최대 값이 우선순위인 형태(reverseOrder)
		PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(String x : operations) {
			StringTokenizer st = new StringTokenizer(x);
			// D, I 와 같은 명령어 문자 추출
			String judge = st.nextToken();
			// 문자 뒤에 오는 숫자 추출(띄어쓰기 기준으로 나뉘기에 가능)
			int value = Integer.parseInt(st.nextToken());
			
			// 큐가 비어있고, 삭제 명령어가 들어오면 그대로 무시
			if(minPq.isEmpty() && judge.equals("D")) {
				continue;
			}
			
			// I 이면 최소, 최대 힙에 value 삽입
			if(judge.equals("I")) {
				minPq.offer(value);
				maxPq.offer(value);
				// continue; 없으면 결과가 무조건 0,0이 나오며 큐가 전부 비어있음
				continue;
			}
			
			// D 이면서 value가 -1인 경우
			if(value < 0) {
				// 최소 힙에서 최소값인 맨 앞 요소를 제거 후 해당 값을 리턴
				int min = minPq.poll();
				// 최대 힙에서 min 값을 삭제
				// remove() : 큐에서 데이터를 삭제한다.(위치 상관 없음)
				maxPq.remove(min);
				// continue; 없으면 큐에 모든 값이 제거되니 주의!
				continue;
			} else {
				int max = maxPq.poll();
				minPq.remove(max);
			}
		}
		
		if(!minPq.isEmpty()) {
			answer[0] = maxPq.poll();
			answer[1] = minPq.poll();
		}
		
		System.out.print(answer[0] + "," + answer[1]);
		
		return answer;
	}
	
	public static void main(String[] args) {
		
//		String[] operations = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		String[] operations = new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		solution(operations);
	}

}
