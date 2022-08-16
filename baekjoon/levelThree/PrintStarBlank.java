package levelThree;

import java.util.Scanner;

/*
문제 : 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
     하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
입력 : 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
출력 : 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
*/

/*
공백 for문을 A , * for문을 B 라고 했을 때에 2를 입력받는다고 하면
A는 1~1까지 돌아서 처음에 딱 한 자리만 차지하게 되고
B는 0~1까지 돌아서 두 자리를 차지하게 되는 것이다
여기에서 A가 먼저 작성되어 있으므로 공백이 일정횟수만큼 수행된 후에 *를 일정 횟수만큼 찍는 것이다
이를 위해 입력받은 수 만큼 도는 for 문의 안에 A,B를 따로 작성한 것이다
*/
public class PrintStarBlank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N-i; j++) {
				System.out.print(" ");
			}
			for(int z=0; z<i; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
