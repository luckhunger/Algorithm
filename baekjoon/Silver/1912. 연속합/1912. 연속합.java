import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		int max;
		int[] seq = new int[size];
		int[] val = new int[size];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<size; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		val[0] = seq[0];
		max = seq[0];
		
		for(int i=1; i<size; i++) {
			val[i] = Math.max(val[i -1] + seq[i], seq[i]);
			max = Math.max(val[i], max);
		}
		
		System.out.println(Math.max(seq[0], max));
	}
}
