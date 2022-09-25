package twoPointers_SlidingWindow;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/*
문제 : A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
입력 : 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
	   두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
	   세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
	   네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
	   각 집합의 원소는 1,000,000,000이하의 자연수입니다.
출력 : 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
*/

public class CommonElement {

	public ArrayList<Integer> common(int N, int[] A, int M, int[] B) {
		ArrayList<Integer> result = new ArrayList<>();
		
		// Arrays : Arrays 클래스는 배열의 복사, 항목 정렬, 검색과 같은 배열을 조작 기능을 가지고 있다.
		// Arrays.sort() : 베열을 자동으로 오름차순으로 정렬해준다.
		Arrays.sort(A);
		Arrays.sort(B);
		
		// A 배열에 포인터 값
		int p1 = 0;
		// B 배열에 포인터 값
		int p2 = 0;
		
		// 작은 값이 있으면, 작은 값이 있는 배열만 포인트 증가
		// A[] = 1, 2, 3 / B[] = 2, 3, 4 이면 A[]에서 1을 결과 배열에 넣을 때에 B[] 배열에 있는 2가 나중에 A[] 배열에 있으므로 B[] 배열은 포인터 증가하면 안됨
		while(p1<N && p2<M) {
			if((A[p1] == B[p2])) {
				result.add(A[p1++]);
				p2++;
				// 작은 값이 있는 배열에 포인터 증가
			} else if(A[p1] < B[p2]) {
				p1++;
			} else {
				p2++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		CommonElement element = new CommonElement();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		int[] B = new int[M];
		for(int i=0; i<M; i++) {
			B[i] = sc.nextInt();
		}
		
		for(int x : element.common(N, A, M, B)) {
			System.out.print(x + " ");
		}
	}

}
