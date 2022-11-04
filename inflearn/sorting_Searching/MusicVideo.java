package sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

/*
문제 : 지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
	  DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
	   순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
	  1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
	   지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
	   고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
	   그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
입력 : 첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
	   다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
	   부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.
출력 : 첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.
*/

public class MusicVideo {

	// capacity : DVD 1장의 용량
	// DVD가 몇 장 필요한지를 리턴해주는 메소드
	// count : 장 수를 의미한다.
	public int count(int[] arr, int capacity) {
		// DVD 장수
		int cnt = 1;
		// DVD에 담는 곡의 합
		int sum = 0;
		
		for(int x : arr) {
			// 곡의 수가 DVD 용량보다 크다
			// sum : 현재 DVD에 들어간 노래의 수(용량)
			if(sum + x > capacity) {
				// 새 DVD를 한 장 추가한다는 의미
				cnt++;
				sum = x;
			} else {
				// DVD에 용량이 남아있으면 새 곡을 누적함
				sum += x;
			}
		}
		return cnt;
	}
	
	
	public int solution(int N, int M, int[] arr) {
		int result = 0;
		// stream : 리덕션 메소드들 제공
		// 최대,최소,합 등 큰 데이터에서 의미있는 값을 찾아내는 것 : 리덕션
		// Arrays.stream().max().getAsInt : 최대값 리턴해줌(getAsInt를 int형으로 리턴받기 위해 필수)
		// max() : 결과를 Optional로 반환함
		// getAsInt() : max 결과를 int형으로 변환하기 위해 사용
		int lt = Arrays.stream(arr).max().getAsInt();
		// stream().sum() : sum은 리턴형 지정 안해도 됨
		int rt = Arrays.stream(arr).sum();
		
//		System.out.println(lt + " " + rt);
		
		while(lt <= rt) {
			int mid = (lt+rt) / 2;
			
			// M보다 작은 값으로도 담을 수 있다는 것을 의미한다.
			// 즉, count를 통해 2장이 나왔는데 이는 M보다 더 적게 담을 수 있다는 의미이므로 결과를 변경한다.
			if(count(arr, mid) <= M) {
				result = mid;
				// 더 좋은 답을 위해 변경
				rt = mid -1;
			} else {
				// 더 좋은 답을 위해 변경
				lt = mid +1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		MusicVideo D = new MusicVideo();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(D.solution(N, M, arr));
	}
}