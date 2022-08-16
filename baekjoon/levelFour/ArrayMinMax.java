package levelFour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
문제 : N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
입력 : 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
츨력 :  첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
*/

public class ArrayMinMax {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		
//		int[] arr = new int[N];
		
//		int max = -1000000;
//		int min = 1000000;
		
//		for(int i=0; i<arr.length; i++) {
//			
//			arr[i] = sc.nextInt();
			
//			if(arr[i] < min) {
//				min = arr[i];
//			}
//			
//			if(arr[i] > max) {
//				max = arr[i];
//			}
			
//		}
		
//		Arrays.sort(arr);	// 배열에 저장된 원소 값을 오름차순으로 정렬해주는 메소드
		
//		System.out.println(min + " " + max);
//		System.out.println(arr[0] + " " + arr[N-1]);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
//			if(arr[i] < min) {
//				min = arr[i];
//			}
//			
//			if(arr[i] > max) {
//				max = arr[i];
//			}
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[0] + " " + arr[N-1]);
//		System.out.println(min + " " + max);
		
	}

}
