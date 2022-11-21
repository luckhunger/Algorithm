package levelOne;

import java.util.Scanner;

/*
문제 : 숫자나라 기사단의 각 기사에게는 1번부터 number까지 번호가 지정되어 있습니다. 
	   기사들은 무기점에서 무기를 구매하려고 합니다.
	   각 기사는 자신의 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매하려 합니다. 
	   단, 이웃나라와의 협약에 의해 공격력의 제한수치를 정하고, 
	   제한수치보다 큰 공격력을 가진 무기를 구매해야 하는 기사는 협약기관에서 정한 공격력을 가지는 무기를 구매해야 합니다.
	   예를 들어, 15번으로 지정된 기사단원은 15의 약수가 1, 3, 5, 15로 4개 이므로 공격력이 4인 무기를 구매합니다. 
	   만약, 이웃나라와의 협약으로 정해진 공격력의 제한수치가 3이고 제한수치를 초과한 기사가 사용할 무기의 공격력이 2라면 
	  15번으로 지정된 기사단원은 무기점에서 공격력이 2인 무기를 구매합니다. 
	   무기를 만들 때, 무기의 공격력 1당 1kg의 철이 필요합니다. 
	   그래서 무기점에서 무기를 모두 만들기 위해 필요한 철의 무게를 미리 계산하려 합니다.
	   기사단원의 수를 나타내는 정수 number와 이웃나라와 
	   협약으로 정해진 공격력의 제한수치를 나타내는 정수 limit와 
	   제한수치를 초과한 기사가 사용할 무기의 공격력을 나타내는 정수 power가 주어졌을 때
	   무기점의 주인이 무기를 모두 만들기 위해 필요한 철의 무게를 return 하는 solution 함수를 완성하시오.
*/

public class KnightsWeapon {
    
	public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 약수 구하기(= 공격력 구하기)
        for(int i=1; i<=number; i++) {
        	int cnt = 0;
        	
        	// Math.sqrt() : 제곱근을 반환한다.
        	// 시간복잡도를 줄이기 위해 제곱근을 사용했다.
        	// 이를 통해 나온 약수를 가지고 입력받은 값을 나누게 될 경우 나오는 결과 역시 약수이기 때문이다.
        	for(int j=1; j<=Math.sqrt(i); j++) {
        		if(i % j == 0) {
        			// 중복을 제거하기 위한 조건이다.
        			// 예를 들어 4라고 가정했을때, 2는 4/2 해서 2가 나온다.
        			// 이러한 경우에는 2가 중복이 되므로 1개만 더해준다.
        			// 그 외에는 약수가 자기 자신 + 나온 수 이므로 2씩 더해준다.
        			if(i / j == j) {
        				cnt += 1;
        			} else {
        				cnt += 2;
        			}
        		}
        	}
        	// 해당 기사의 약수의 개수(=공격력)이 제한수치를 넘는다면 협약으로 정해진 공격력의 무기를 구매한다.
        	// 넘지 않는다면 공격력의 무기를 구매한다.
        	answer = cnt > limit? answer + power : answer + cnt;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		KnightsWeapon K = new KnightsWeapon();
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int limit = sc.nextInt();
		int power = sc.nextInt();
		
		System.out.println(K.solution(number, limit, power));
	}
	
}