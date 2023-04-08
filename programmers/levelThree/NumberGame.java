package levelThree;

import java.util.Arrays;
import java.util.Collections;

/*
문제:    xx 회사의 2xN명의 사원들은 N명씩 두 팀으로 나눠 숫자 게임을 하려고 합니다. 두 개의 팀을 각각 A팀과 B팀이라고 하겠습니다. 숫자 게임의 규칙은 다음과 같습니다.
		
		먼저 모든 사원이 무작위로 자연수를 하나씩 부여받습니다.
		각 사원은 딱 한 번씩 경기를 합니다.
		각 경기당 A팀에서 한 사원이, B팀에서 한 사원이 나와 서로의 수를 공개합니다. 
		그때 숫자가 큰 쪽이 승리하게 되고, 승리한 사원이 속한 팀은 승점을 1점 얻게 됩니다.
		만약 숫자가 같다면 누구도 승점을 얻지 않습니다.
		
		전체 사원들은 우선 무작위로 자연수를 하나씩 부여받았습니다. 
		그다음 A팀은 빠르게 출전순서를 정했고 자신들의 출전 순서를 B팀에게 공개해버렸습니다. 
		B팀은 그것을 보고 자신들의 최종 승점을 가장 높이는 방법으로 팀원들의 출전 순서를 정했습니다. 
		이때의 B팀이 얻는 승점을 구해주세요.
		A 팀원들이 부여받은 수가 출전 순서대로 나열되어있는 배열 A와 i번째 원소가 B팀의 i번 팀원이 부여받은 수를 의미하는 배열 B가 주어질 때, 
		B 팀원들이 얻을 수 있는 최대 승점을 return 하도록 solution 함수를 완성해주세요.
		
출력형식: A와 B의 길이는 같습니다.
		A와 B의 길이는 1 이상 100,000 이하입니다.
		A와 B의 각 원소는 1 이상 1,000,000,000 이하의 자연수입니다.
*/

public class NumberGame {

	public static void main(String[] args) {
//		Integer[] A = new Integer[] {5, 1, 3, 7};
//		Integer[] B = new Integer[] {2, 2, 6, 8};
//		Integer[] A = new Integer[] {2, 2, 2, 2};
//		Integer[] B = new Integer[] {1, 1, 1, 1};
		
		int[] A = new int[] {5, 1, 3, 7};
		int[] B = new int[] {2, 2, 6, 8};
//		int[] A = new int[] {2, 2, 2, 2};
//		int[] B = new int[] {1, 1, 1, 1};
		
		int answer = 0;
		// B 배열 인덱스
		int loc = 0;
		
//		Arrays.sort(A, Collections.reverseOrder());
//		Arrays.sort(B, Collections.reverseOrder());
		
		Arrays.sort(A);
		Arrays.sort(B);
		
//		for(int i=0; i<A.length; i++) {
			
			// compare 대신 아래 식을 사용하면 가능 > 단, Integer 사용 필수
//			if(A[i] < B[loc]) {
//				answer++;
//				loc++;
//			}
			
			// Integer.compare : compareTo 메소드 중 하나로, int 형태를 비교하기 위해 변형된 식이다.
			// 아래 식을 사용하면 예시 중 하나의 값이 정상적으로 출력되지 않음 > 더 고민 필요
//			int score = Integer.compare(B[loc], A[i]);
//			
//			if(score == 1) {
//				answer++;
//				loc++;
//			}
//		}
		
		for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
            if(A[i] < B[j]) {
                answer++;
                j--;
            }
        }
		
		System.out.println(answer);
		
	}
}
