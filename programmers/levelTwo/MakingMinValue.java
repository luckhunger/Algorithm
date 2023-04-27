package levelTwo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
문제:    길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
		배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 
		이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다. 
		이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다. 
		(단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)
		예를 들어 A = [1, 4, 2] , B = [5, 4, 4] 라면
		A에서 첫번째 숫자인 1, B에서 첫번째 숫자인 5를 뽑아 곱하여 더합니다. (누적된 값 : 0 + 5(1x5) = 5)
		A에서 두번째 숫자인 4, B에서 세번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 5 + 16(4x4) = 21)
		A에서 세번째 숫자인 2, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 21 + 8(2x4) = 29)
		즉, 이 경우가 최소가 되므로 29를 return 합니다.
		배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.
제한사항: 배열 A, B의 크기 : 1,000 이하의 자연수
		배열 A, B의 원소의 크기 : 1,000 이하의 자연수
*/

public class MakingMinValue {

	public static void main(String[] args) {
		int[] A = new int[] {1, 4, 2};
		int[] B = new int[] {5, 4, 4};
//		int[] A = new int[] {1, 2};
//		int[] B = new int[] {3, 4};
		int answer = 0;
		
		Arrays.sort(A);
		// B 배열 정렬
		// Stream API 사용(시간초과 에러 발생 > 코테에선 잘 쓰이지 않음)
//		int[] arrB = Arrays.stream(B)            // 또는 IntStream.of(arr) 사용
//                .boxed()
//                .sorted(Collections.reverseOrder())
//                .mapToInt(Integer::intValue)
//                .toArray();
		
		// B 배열 정렬
		// Comparator 사용 (미완)
//		Arrays.sort(B, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1.B;
//			}
//			
//		});
		
		// B 배열 정렬
		// sort 직접 구현
		Arrays.sort(B);
		for(int i=0; i<B.length/2; i++) {
			int temp = B[i];
			B[i] = B[B.length -i -1];
			B[B.length -i -1] = temp;
			System.out.println(B[i]);
		}
		
		// B 배열 정렬
		// Heap sort
		
		
		for(int i=0; i<A.length; i++) {
			answer += A[i] * B[i];
//			answer += A[i] * arrB[i];
		}
		System.out.println(answer);
	}

}
