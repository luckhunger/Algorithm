package levelSix;

import java.io.IOException;
import java.util.Scanner;

/*
문제 : 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 
	   즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
	  QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
입력 : 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 
 	   각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. 
 	  S의 길이는 적어도 1이며, 20글자를 넘지 않는다. 
출력 : 각 테스트 케이스에 대해 P를 출력한다.
*/


public class RepeatWord {

	public static void main(String[] args) throws IOException {
		// Scanner 사용
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스의 개수 > 총 몇 개의 반복횟수와 문자열을 입력받을지 작성
		// 예를 들어 테스트 케이스가 2이면 >> 2 AAA / 3 BBB 라는 2개의 문자열을 입력 가능하다는 의미
		int T = sc.nextInt();
		int R;
		char[] S;
		
		for(int i=0; i<T; i++) {
			// 반복 횟수
			R = sc.nextInt();
			// 문자열을 입력받고, 해당 문자열을 toCharArray()를 통해서 문자로 잘라 배열로 만들어줌 
			// nextLine()은 공백까지 읽어버리기에 사용 불가
			S = sc.next().toCharArray();
			
			// 입력한 문자열의 갯수만큼 반복
			for(int j=0; j<S.length; j++) {
//				System.out.println("j : " + j);
				// 반복 횟수만큼 반복하며 해당 인덱스에 반복되는 동일한 문자 출력
				for(int z=0; z<R; z++) {
//					System.out.println("z : " + z);
					System.out.print(S[j]);
				}
			}
			// 줄 넘기기 기능이 없어 임의로 작성
			System.out.println();
		}
	}
}
