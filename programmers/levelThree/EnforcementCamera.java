package levelThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
문제:    고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라를 설치하려고 합니다.
		고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때, 
		모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.
출력형식: 차량의 대수는 1대 이상 10,000대 이하입니다.
		routes에는 차량의 이동 경로가 포함되어 있으며 routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점, routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있습니다.
		차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다.
		차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하입니다.
*/

public class EnforcementCamera {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] routes = new int[][] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		int answer = 0;
		
		// N 차원 배열의 정렬
		// 오름차순 정렬
		Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] route1, int[] route2) {
                return route1[1] - route2[1];
            }
        });
		
		int cam = Integer.MIN_VALUE;
        
        for(int[] route : routes) {
        	// 현재 카메라가 다음 구간의 시작점보다 적으면 새 카메라를 설치한다.
            if(cam < route[0]) {
                // 새로운 카메라를 다음 구간의 종료 지점에 설치한다
                cam = route[1];
                answer++;
            }
        }
        
        System.out.println(answer);
	}
}
