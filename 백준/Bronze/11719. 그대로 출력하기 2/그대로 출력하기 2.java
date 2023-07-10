import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
        
		// hasNext : boolean 타입으로 반환 즉, true / false로 반환된다.
		// 다음에 가져올 값이 있으면 true, 없으면 false를 반환한다.
//		Scanner sc = new Scanner(System.in);
		
//		while(sc.hasNext()) {
//			System.out.println(sc.nextLine());
//		}
		
	}

}
