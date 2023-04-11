package levelTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
문제:    문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
		str 에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
		예를 들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
제한사항: s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
*/

public class MaxAndMin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = "1 2 3 4";
		String[] str = s.split(" ");
		// 방법 1
//		int[] arr = new int[str.length];
		
		// 방법 2
//		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
		
		// 방법 3
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<str.length; i++) {
			// 방법 1
//			arr[i] = Integer.parseInt(str[i]);
			
			// 방법 2
//			int num = Integer.parseInt(str[i]);
//			
//			Math.min(min, num);
//			Math.max(max, num);
			
			// 방법 3
			arr.add(Integer.parseInt(str[i]));
		}
		
		// 방법 1
//		Arrays.sort(arr);
//		int min = arr[0];
//		int max = arr[str.length-1];
		
		// 방법 1,2
//		System.out.println(min + " " + max);
		
		// 방법 3
		System.out.println(Collections.min(arr) + " " + Collections.max(arr));
		
	}

}
