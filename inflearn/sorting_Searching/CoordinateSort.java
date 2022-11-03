package sorting_Searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
문제 : N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
	   정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
입력 : 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
	   두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
출력 : N개의 좌표를 정렬하여 출력하세요.
*/

// Point : Comparable 인터페이스의 구현체
// Point 라는 클래스의 객체를 정렬한다
class Point implements Comparable<Point>{
	public int x, y;
	
	// 생성자 생성 및 초기화
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// 정의되어 있는 CompareTo 라는 메소드를 가져와서 문제에 맞게 재정의한다.
	// 외우자...
	@Override
	public int compareTo(Point o) {
		// 무조건 음수가 나오게 계산해야함(? > 일단 외우라니까..)
		// 음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
		if(this.x == o.x) {
			return this.y - o.y;
		} else {
			return this.x - o.x;
		}
	}
}

public class CoordinateSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Point> arr = new ArrayList<>();

		for(int i=0; i<N; i++) {
			// x, y 좌표값을 받음
			int x = sc.nextInt();
			int y = sc.nextInt();
			// 객체를 생성해서 호출한다.
			arr.add(new Point(x, y));
		}
		// Collections.sort() : Comparable 인터페이스를 통해 Point 객체를 정렬한다.
		// 기준을 재정의하지 않으면 오름차순으로 정렬한다.
		// 이 때 정렬의 기준은 내가 작성한 compareTo 이다.
		Collections.sort(arr);
		for(Point o : arr) {
			System.out.println(o.x + " " + o.y);
		}
	}

}
