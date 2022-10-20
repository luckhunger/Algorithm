package stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/*
문제 : 게임개발자인 죠르디는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
	   죠르디는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.
	   게임 화면은 1 x 1 크기의 칸들로 이루어진 N x N 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다.
	   (위 그림은 5 x 5 크기의 예시입니다). 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다.
	   모든 인형은 1 x 1 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다.
	   게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 집어 올린 인형은 바구니에 쌓이게 되는 데,
	   이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.
	   다음 그림은 [1번, 5번, 3번] 위치에서 순서대로 인형을 집어 올려 바구니에 담은 모습입니다.
	   만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다.
	   위 상태에서 이어서 [5번] 위치에서 인형을 집어 바구니에 쌓으면 같은 모양 인형 두 개가 없어집니다.
	   크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
	   또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. (그림에서는 화면표시 제약으로 5칸만으로 표현하였음)
	   게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
	   크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.
입력 : 첫 줄에 자연수 N(5<=N<=30)이 주어집니다.
	   두 번째 줄부터 N*N board 배열이 주어집니다.
	  board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
	  0은 빈 칸을 나타냅니다.
	  1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
	  board배열이 끝난 다음줄에 moves 배열의 길이 M이 주어집니다.
	    마지막 줄에는 moves 배열이 주어집니다.
	  moves 배열의 크기는 1 이상 1,000 이하입니다.
	  moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
출력 : 첫 줄에 터트려져 사라진 인형의 개수를 출력합니다.
*/

public class ClawCraneGame {

	public int solution(int[][] board, int[] moves) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int pos : moves) {
			// 2차원 배열의 행
			for(int i=0; i<board.length; i++) {
				// 인형이 발견되었으면을 의미
				if(board[i][pos-1]!=0) {
					int tmp = board[i][pos-1];
					// 인형을 꺼냈으므로 0으로 값 변경
					board[i][pos-1] = 0;
					
					// 스택에 인형이 있는 상태에서 기존에 있는 인형과 동일한 인형인지 확인
					// isEmpty() : 값이 비었는지 확인하여 true / false로 리턴한다.
					// peek() : 스택에서 가장 상단의 값을 리턴받는다. 단, pop와 달리 값을 꺼내지 않고 단순히 읽는다.
					if(!stack.isEmpty() && tmp == stack.peek()) {
						// 2개가 한번에 터지므로 2씩 더해준다.
						result += 2;
						// 터진 인형을 뺀다.
						stack.pop();
					} else {
						// 그 외에 조건이라는 것은 바구니에 다른 인형이 있다는 의미이므로 그대로 넣어준다.
						stack.push(tmp);
					}
					// 한 번 if문을 돌아서 인형을 찾은 후에 또 다시 for문이 돌면 안되므로 break를 통해 막아준다.
					break;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ClawCraneGame claw = new ClawCraneGame();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] board = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		// 크레인이 이동하는 크기를 저장하기 위한 변수
		int M = sc.nextInt();
		// 크레인의 작동 값을 넣는 배열
		int[] moves = new int[M];
		
		for(int i=0; i<M; i++) {
			moves[i] = sc.nextInt();
		}
		
		System.out.println(claw.solution(board, moves));
	}
}