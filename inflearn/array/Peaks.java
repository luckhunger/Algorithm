package array;

import java.util.Scanner;

/*
문제 : 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
	   각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
	   격자의 가장자리는 0으로 초기화 되었다고 가정한다.
	   만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
입력 : 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
	   두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
출력 : 봉우리의 개수를 출력하세요.
*/

public class Peaks {

	// 전역으로 dx, dy 선언
	// 상하좌우 값을 찾기 위한 배열 생성
	int[] dx = {-1, 0, 1, 0}; 
	int[] dy = {0, 1, 0, -1};
	
	public int count(int N, int[][] arr) {
		int result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 봉우리 여부를 확인하는 flag 선언
				boolean flag = true;
				// k는 4가지의 방향을 찾기 위해 도는 것이기에 4 이전까지만 돌아감
				for(int k=0; k<4; k++) {
					// 행 좌표
					int x = i + dx[k];
					// 열 좌표
					int y = j + dy[k];
					
					// arr[x][y] : 4 방향의 값
					// arr[i][j] : 기준 값
					// 만약 4방향 중에 어떤 값이 기준 값보다 크다면 봉우리가 아니므로 false
					// N*N 외에 밖의 값을 참조하게 되면 ArrayIndexOutOfBoundsException 에러 발생
					// 그레서 x,y가 N*N 범위를 벗어나지 않게 해당 조건 추가함
					// 단, 이 조건이 arr[][] 보다 뒤로 들어가면 이미 참조를 한 후에 해당 조건이 들어가기 때문에 오류가 여전히 발생한다.
					// 그러므로 반드시 앞에 적어서 먼저 벗어나지 않게 처리하고, 배열 조건에 참조한다.
					if(x>=0 && x<N && y>=0 && y<N && arr[x][y] >= arr[i][j]) {
						flag = false;
						break;
					}
				}
				// 4방향이 모두 기준값보다 작으면 기준값이 봉우리이기 때문에 결과값 ++
				if(flag) result++; 
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Peaks peak = new Peaks();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.print(peak.count(N, arr));
	}

}
