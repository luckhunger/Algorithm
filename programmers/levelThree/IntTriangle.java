package levelThree;

/*
문제 : 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 
	   아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 
	   예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.
	   삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.
제한사항 : 삼각형의 높이는 1 이상 500 이하입니다.
	         삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
*/

public class IntTriangle {

	public static int solution(int[][] triangle) {
		int[][] copyTriangle = new int[triangle.length][triangle.length];
		// 맨 위 노드의 값은 기존 배열의 값을 그대로 넣는다.
		copyTriangle[0][0] = triangle[0][0];
		
		for(int i=1; i<triangle.length; i++) {
			// 왼쪽 끝 값
			copyTriangle[i][0] = copyTriangle[i-1][0] + triangle[i][0];
			// 오른쪽 끝 값
			copyTriangle[i][i] = copyTriangle[i-1][i-1] + triangle[i][i];
		}
		
		// 위에서부터 수를 비교하며 최대값을 복사한 배열에 넣어준다.
		for(int i=2; i<triangle.length; i++) {
			for(int j=1; j<i; j++) {
				// Math.max() : 입력받은 두 개의 인자 중 큰 값을 리턴한다.
				copyTriangle[i][j] = Math.max(copyTriangle[i-1][j-1], copyTriangle[i-1][j]) + triangle[i][j];
			}
		}
		
		// copyTriangle 배열의 맨 마지막 값들이 해당 경로의 최대 값들을 의미한다.
		int max = copyTriangle[copyTriangle.length-1][0];
		// 맨 마지막 값들 중에서 최대값을 찾아 출력한다.
		for(int i=1; i<triangle.length; i++) {
			int tmp = copyTriangle[copyTriangle.length-1][i];
			
			if(max < tmp) {
				max = tmp;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		System.out.println(IntTriangle.solution(triangle));
	}
}