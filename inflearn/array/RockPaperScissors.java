package array;

import java.util.Scanner;

/*
문제 : A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
	  가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
	  두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
입력 : 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
	   두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
	   세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
출력 : 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
*/


public class RockPaperScissors {

	public String Winner(int N, int[] A, int[] B) {
		String result = "";
		
		for(int i=0; i<N; i++) {
			if(A[i] == B[i]) {
				result += "D";
			}else if((A[i]==1 & B[i]==3)) {
				result += "A";
			}else if((A[i]==2 & B[i]==1)) {
				result += "A";
			}
			else if((A[i]==3 & B[i]==2)) {
				result += "A";
			}else{
				result += "B";
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		RockPaperScissors rps = new RockPaperScissors();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			B[i] = sc.nextInt();
		}

		for(char x : rps.Winner(N, A, B).toCharArray()) {
			System.out.println(x);
		}
		
	}

}
