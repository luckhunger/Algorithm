package levelThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
문제 : 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
입력 : 입력은 여러 개의 테스트 케이스로 이루어져 있다.
      각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
      입력의 마지막에는 0 두 개가 들어온다.
출력 : 각 테스트 케이스마다 A+B를 출력한다.
*/
public class AplusBWhile {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		
//		while(true) {
//			int A = sc.nextInt();
//			int B = sc.nextInt();
//			
//			if(A==0 && B==0) {
//				break;
//			}
//			
//			System.out.println(A + B);
//		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			// nextToken()을 사용하기 위해 객체화를 해주는데, 객체화를 한 다음에 받을 변수가 없으면 NoSuchElementException 에러 발생
			// 즉, 뽑을 원소가 있으면 뽑기 전에 객체화를 해줘야 한다.
			// >> 객체화를 while문 안에서 하는 이유 확실하지 않음 > 추후에 더 찾아서 블로그에 정리 필요
			st = new StringTokenizer(br.readLine()," ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(A==0 && B==0) {
				break;
			}
			sb.append(A+B).append('\n');
		}
		System.out.println(sb);
	}
}
