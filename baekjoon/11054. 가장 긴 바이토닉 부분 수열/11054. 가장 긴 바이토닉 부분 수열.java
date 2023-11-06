import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int[] seq;
	static int[] dpL, dpR;
	
	public static void LDP() {
		for(int i=0; i<size; i++) {
			dpL[i] = 1;
			
			for(int j=0; j<i; j++) {
				if(seq[i] > seq[j]) {
					dpL[i] = Math.max(dpL[i], dpL[j]+1);
				}
			}
		}
	}
	
	public static void RDP() {
		for(int i=size-1; i>=0; i--) {
			dpR[i] = 1;
			
			for(int j=size-1; j>i; j--) {
				if(seq[i] > seq[j]) {
					dpR[i] = Math.max(dpR[i], dpR[j]+1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		seq = new int[size];
		dpL = new int[size];
		dpR = new int[size];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<size; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		LDP();
		RDP();
		
		int cnt = 0;
		for(int i=0; i<size; i++) {
			cnt = Math.max(cnt, dpL[i]+dpR[i]);
		}
		System.out.println(cnt -1);
	}
}
