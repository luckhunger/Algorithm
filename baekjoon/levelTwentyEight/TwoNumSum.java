package levelTwentyEight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
문제 : n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다. 
	 ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다. 
	  자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.
입력 : 첫째 줄에 수열의 크기 n이 주어진다. 다음 줄에는 수열에 포함되는 수가 주어진다. 셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)
출력 : 문제의 조건을 만족하는 쌍의 개수를 출력한다.
*/

public class TwoNumSum {

	public int count(int N, int[] arr, int X) {
		int result = 0;
		int sum = 0;
		int lt = 0;
		int rt = N-1;
		
		Arrays.sort(arr);
		
		while(lt < rt) {
			sum = arr[rt] + arr[lt];
			
			if(sum == X) result++;
			
			if(sum < X) {
				lt++;
			}else {
				rt--;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		TwoNumSum num = new TwoNumSum();
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] arr = new int[N];
//		for(int i=0; i<N; i++) {
//			arr[i] = sc.nextInt();
//		}
//		// 위치 주의! 배열 뒤에 X를 입력받아야 함
//		int X = sc.nextInt();
//		
//		System.out.println(num.count(N, arr, X));
		
		// 버퍼 사용해서 배열에 넣고 푸는법
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		// nextToken()을 사용하기 위해 객체화를 해주는데, 객체화를 한 다음에 받을 변수가 없으면 NoSuchElementException 에러 발생
		// 즉, 뽑을 원소가 있으면 뽑기 전에 객체화를 해줘야 한다.
		// N 변수를 위해 앞서 객체화를 하고, arr[] 배열을 위해 앞서 객체화를 한다.
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			// valueOf : 괄호 안에 입력한 객체를 String 형으로 변환한다.
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		int X = Integer.valueOf(br.readLine());
		
		System.out.println(num.count(N, arr, X));
	}

}
