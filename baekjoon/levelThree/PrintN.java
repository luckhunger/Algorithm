package levelThree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
문제 : 자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
입력 : 첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다. 	
출력 : 첫째 줄부터 N번째 줄 까지 차례대로 출력한다.
*/
public class PrintN {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		
//		for(int i=1; i<=N; i++) {
//			System.out.println(i);
//		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			bw.write(i + "\n") ;
		}
		br.close();
		bw.flush();	// 츨력하려면 flush 혹은 close를 사용해야 함 : 남아있는 데이터를 모두 출력
		bw.close();	// 닫아준다.

	}

}
