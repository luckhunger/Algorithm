package levelTen;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
문제 : 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 N명의 학생들이 응시했다.
	   이들 중 점수가 가장 높은 k명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
	   커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
입력 : 첫째 줄에는 응시자의 수 N과 상을 받는 사람의 수 k가 공백을 사이에 두고 주어진다.
	   둘째 줄에는 각 학생의 점수 x가 공백을 사이에 두고 주어진다.
출력 : 상을 받는 커트라인을 출력하라.
*/

public class CutLine {

	public static int cut(int N, int K, Integer[] arr) {
		int result = 0;
		
		// 번호는 1부터 시작하므로 1을 빼줘야 2번째 인덱스 값을 가져올 수 있다.
		result = arr[K-1];
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Integer[] arr = new Integer[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// Collections.reverseOrder() : 내림차순으로 정렬해준다.
		// Collections.reverseOrder()는 Comparator 객체이다.
		// Comparator는 직접 구현해야하지만, 내림차순은 자주 사용되기 때문에 Collections에서 기본으로 제공해준다.
		Arrays.sort(arr, Collections.reverseOrder());
		
//		for(int i=0; i<N; i++) {
//			System.out.println(arr[i]);
//		}
		
		System.out.println(CutLine.cut(N, K, arr));
	}
}