package levelThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제:    계속되는 폭우로 일부 지역이 물에 잠겼습니다. 
		물에 잠기지 않은 지역을 통해 학교를 가려고 합니다. 
		집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다.
		아래 그림은 m = 4, n = 3 인 경우입니다.
		가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래, 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.
		격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다. 
		오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.
제한사항: 격자의 크기 m, n은 1 이상 100 이하인 자연수입니다.
		m과 n이 모두 1인 경우는 입력으로 주어지지 않습니다.
		물에 잠긴 지역은 0개 이상 10개 이하입니다.
		집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.
*/

public class WayToSchool {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] puddles = new int[][] {{2,2}};
		
		int val = 1000000007;
		int[][] road = new int[n+1][m+1];
		
		// 웅덩이인 경우에는 연산하지 않도록 '-1'로 처리한다.
		for(int i=0; i<puddles.length; i++) {
			// 실제 좌표가 0,0이 아니라 1,1부터 시작하기에 그에 맞게 웅덩이 좌표를 변경한다.
			road[puddles[i][1]][puddles[i][0]] = -1;
		}
		
		road[1][1] = 1;
		for(int i=1; i<n + 1; i++) {
			for(int j=1; j<m + 1; j++) {
				// 물웅덩이 좌표에 도달하면 무시하고 재진행
				if(road[i][j] == -1) continue;
				// 위쪽에서 왔는데, 이미 도달한 경로가 존재하는 경우에는 이전까지 존재한 경로의 개수를 더해서 현재 좌표에 해당하는 경로의 개수를 만든다. 
				if(road[i -1][j] > 0) road[i][j] += road[i -1][j] % val;
				// 왼쪽에서 왔는데, 이미 도달한 경로가 존재하는 경우
				if(road[i][j -1] > 0) road[i][j] += road[i][j -1] % val;
			}
		}
		
		System.out.println(road[n][m] % val);
	}

}
