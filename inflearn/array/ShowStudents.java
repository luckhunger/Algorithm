package array;

import java.util.Scanner;

/*
문제 : 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
	   선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
입력 : 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
출력 : 선생님이 볼 수 있는 최대학생수를 출력한다.
*/


public class ShowStudents {

	public int ShowHeight(int N, int[] height) {
		int result = 1;
		int max = height[0];
		
		for(int i=1; i<N; i++) {
			// 최대값보다 학생의 키가 크면 result에 1을 더하고 학생의 키 값을 max에 저장
			if(height[i] > max) {
				result++;
				max = height[i];
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// 메소드 사용 위한 객체 생성
		ShowStudents Height = new ShowStudents();
		Scanner sc = new Scanner(System.in);
		// 학생의 수
		int N = sc.nextInt();
		// 학생들의 키 데이터가 들어갈 배열
		int[] height = new int[N];
		
		for(int i=0; i<N; i++) {
			height[i] = sc.nextInt();
		}
		System.out.println(Height.ShowHeight(N, height));
	}

}
