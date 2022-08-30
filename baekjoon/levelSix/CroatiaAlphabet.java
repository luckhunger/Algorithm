package levelSix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제 : 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
	   예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 
	   단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
	  dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. 
	  lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
입력 : 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
	   단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
출력 : 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
*/

public class CroatiaAlphabet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		// 변형 문자 배열로 저장
		String[] croat = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		// 배열 크기만큼 돌면서 문자 일치 여부 확인
		// contains() : 대상 문자열에 특정 문자열이 포함되어 있는지 확인하는 함수이다.
		for(int i=0; i<croat.length; i++) {
			if(str.contains(croat[i])) {
				// 배열에 있는 문자가 입력받은 문자열에 있으면 #로 변환한다.
				// 다른 알파벳으로 변경하면 개수로 세버리기 때문에 특수문자로 변환
				str = str.replace(croat[i], "#");
			}
		}
		System.out.println(str.length());
	}
}
