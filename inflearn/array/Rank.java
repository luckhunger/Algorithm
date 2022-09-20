package array;

import java.util.Scanner;

/*
문제 : N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
	   같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
	   즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
입력 : 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
출력 : 입력된 순서대로 등수를 출력한다.
*/

public class Rank {

	public int[] rankScore(int N, int[] score) {
		int[] rank = new int[N];
		
		// 기준이 되는 점수가 있는 for문
		for(int i=0; i<N; i++) {
			// 맨 처음 등수는 1이므로 for문 돌때마다 1로 초기화
			int cnt = 1;
			// 순위를 비교할 점수가 있는 for문
			// 예를 들어 90 100 92 라는 점수가 있으면 90은 [i] for문이고, 이 90이라는 점수를 기준으로 해서 [j] for문에서 100, 92를 비교한다.
			// [j]에 있는 100이 [i]에 90보다 크므로 cnt에 1 더해준다.
			// 그 후에 다시 [i]에 90과 [j]에 92를 비교하고, 또다시 [j]가 크므로 cnt에 1을 더해서 결과적으로 90점은 3등이 된다.
			for(int j=0; j<N; j++) {
				if(score[j] > score[i]) {
					cnt++;
				}
			}
			rank[i] = cnt;
		}
		return rank;
	}
	
	public static void main(String[] args) {
		Rank rank = new Rank();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] score = new int[N];
		
		// 점수 입력
		for(int i=0; i<N; i++) {
			score[i] = sc.nextInt();
		}
		
		for(int x : rank.rankScore(N, score)) {
			System.out.print(x + " ");
		}
	}
}
