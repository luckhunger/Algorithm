package levelTen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
문제 : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.﻿
출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/

public class SortNumberTwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// StringBuilder : String과 문자열을 더할 때 새로운 객체를 생성하지 않고 기존의 데이터에 더하는 방식이다.
		// Collections.sort 만 쓰면 시간초과가 발생하여 사용
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			arr.add(sc.nextInt());
		}
		
		// Collections.sort 에다가 comparator 로 대상 변수만 지정해주면 중복없이 쉽게 정렬이 가능하다.
		Collections.sort(arr);
		
		for(int x : arr) {
			sb.append(x).append('\n');
		}
		System.out.println(sb);
	}

}
