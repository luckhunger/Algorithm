import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		int[] seq = new int[size+1];
		int[] dp = new int[size+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=size; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i = 1; i <= size; i++) {
			dp[i] = 1;
			
			for(int j = 1; j < i; j++) {
				
				if(seq[j] > seq[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					
				}
				
			}
			cnt = Math.max(cnt, dp[i]);
		}
		System.out.println(cnt);
	}
}
