package levelOne;

/*
문제 : 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. 
	  numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
제한사항 : 1 ≤ numbers의 길이 ≤ 9
	     0 ≤ numbers의 모든 원소 ≤ 9
         numbers의 모든 원소는 서로 다릅니다.
*/

public class NoNumAdd {
	static int[] numbers;
	
	public int solution(int[] numbers) {
		int result = -1;
		int sum = 45;
		
		for(int i=0; i<numbers.length; i++) {
			sum -= numbers[i];
		}
		
		result = sum;
		
		return result;
	}
	
	public static void main(String[] args) {
		NoNumAdd num = new NoNumAdd();
		int[] numbers = new int[] {1,2,3,4,6,7,8,0};
		
		System.out.println(num.solution(numbers));
	}

}
