package levelThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
문제 : 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오. 
입력 : 첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
      둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
출력 : X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
*/

public class SmallerThanX {

    public static void main(String[] args) {
    	// 배열로 Scanner 사용
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	int X = sc.nextInt();
    	int arr[] = new int[N];
    	
    	for(int i=0; i<N; i++) {
    		arr[i] = sc.nextInt();
    		
    		if(arr[i] < X) {
    			System.out.print(arr[i] + " ");
    		}
    	}
    	
    	sc.close();
    	
    	
    	// 배열 없이 Scanner 사용
//    	Scanner sc = new Scanner(System.in);
//    	
//    	int N = sc.nextInt();
//    	int X = sc.nextInt();
//    	
//    	StringBuilder sb = new StringBuilder();
//    	 
//		for(int i = 0 ; i < N ; i++) {
//			
//			int benchMark = sc.nextInt();
//			if(benchMark < X) {
//				sb.append(benchMark+" ");
//			}
//		}
//		System.out.println(sb);	
    	
    	
    	// 배열 없이 BufferedReader 사용
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//        
//        int N =  Integer.parseInt(st.nextToken());
//        int X =  Integer.parseInt(st.nextToken());
//        
//        StringBuilder sb = new StringBuilder();
//        
//        st = new StringTokenizer(br.readLine()," ");
//        
//        for(int i=0; i<N; i++) {
//        	int benchMark = Integer.parseInt(st.nextToken());
//        	
//            if(benchMark < X) {
//            	sb.append(benchMark).append(' ');
//            }
//        }
//        System.out.println(sb);
//        
//        br.close();
    }

}
