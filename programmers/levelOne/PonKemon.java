package levelOne;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
문제 : 당신은 폰켓몬을 잡기 위한 오랜 여행 끝에, 홍 박사님의 연구실에 도착했습니다. 
	   홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
	   홍 박사님 연구실의 폰켓몬은 종류에 따라 번호를 붙여 구분합니다. 
	   따라서 같은 종류의 폰켓몬은 같은 번호를 가지고 있습니다. 
	   예를 들어 연구실에 총 4마리의 폰켓몬이 있고, 
	   각 폰켓몬의 종류 번호가 [3번, 1번, 2번, 3번]이라면 이는 3번 폰켓몬 두 마리, 1번 폰켓몬 한 마리, 2번 폰켓몬 한 마리가 있음을 나타냅니다. 
	   이때, 4마리의 폰켓몬 중 2마리를 고르는 방법은 다음과 같이 6가지가 있습니다.
	   첫 번째(3번), 두 번째(1번) 폰켓몬을 선택
	   첫 번째(3번), 세 번째(2번) 폰켓몬을 선택
	   첫 번째(3번), 네 번째(3번) 폰켓몬을 선택
	   두 번째(1번), 세 번째(2번) 폰켓몬을 선택
	   두 번째(1번), 네 번째(3번) 폰켓몬을 선택
	   세 번째(2번), 네 번째(3번) 폰켓몬을 선택
	   이때, 첫 번째(3번) 폰켓몬과 네 번째(3번) 폰켓몬을 선택하는 방법은 한 종류(3번 폰켓몬 두 마리)의 폰켓몬만 가질 수 있지만, 다른 방법들은 모두 두 종류의 폰켓몬을 가질 수 있습니다. 
	   따라서 위 예시에서 가질 수 있는 폰켓몬 종류 수의 최댓값은 2가 됩니다.
	   당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에, 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다. 
	  N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, N/2마리의 폰켓몬을 선택하는 방법 중, 
	   가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
제한사항 : nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
	    nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
		폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
		가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
*/

public class PonKemon {
	
	public int Count(int[] nums) {
		
//		방법 2
		// Arrays.stream : Arrays 클래스에서 제공하는 stream() 메서드를 사용하여 배열을 스트림으로 변환할 수 있다.
		return Arrays.stream(nums)
				// boxed : 원시 타입에 대한 스트림 지원을 클래스 타입으로 전환하여 실행가능하게 하는 기능을 수행하기 위해 존재한다.
				// int 자체로는 Collection에 담지 못하기 Integer 클래스로 변환해서 담는다.
                .boxed()	
                // collections : list, set 의 상위 인터페이스
                // collectingAndThen : 변경할 수 없는 컬렉션을 만들기 위해 사용
                // toSet : 집합 생성
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));

//		방법 1
//		int result = 1;
//		int value = nums[0];
//		
//		for(int i=1; i<nums.length; i++) {
//			if(value != nums[i]) {
//				result++;
//				value = nums[i];
//			}
//		}
//		return result < nums.length / 2 ? result : nums.length / 2;
	}
	
	public static void main(String[] args) {
		PonKemon mon = new PonKemon();
		
//		int[] nums = new int[] {3, 1, 2, 3};
		int[] nums = new int[] {3, 3, 3, 2, 2, 4};
//		int[] nums = new int[] {3, 3, 3, 2, 2, 2};
		
		Arrays.sort(nums);
		System.out.println(mon.Count(nums));
	}
}