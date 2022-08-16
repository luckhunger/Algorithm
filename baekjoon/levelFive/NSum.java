package levelFive;

/*
문제 : 
입력 : 
출력 : 
*/
public class NSum {

	public static void main(String[] args) {
		
		class Test {
			long sum(int[] a) {
				long sum = 0;
				
				for(int i=0; i<a.length; i++) {
					sum = sum + a[i];
				}
				
				return sum;
			}
		}
	}
}
