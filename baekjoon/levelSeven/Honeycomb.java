package levelSeven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Honeycomb {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 최소로 지나가는 방의 개수
		int count = 1;
		// 
		int range = 2;
		
		if(N == 1) {
			System.out.println(1);
		}else {
			while(range <= N) {
				// 한 둘레(=범위)는 6개 
				range = range + (6 * count);
				count++;
			}
			System.out.println(count);
		}
	}
}
