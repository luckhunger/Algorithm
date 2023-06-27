import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner 사용
//		Scanner sc = new Scanner(System.in);
		
		// hasNext : boolean 타입으로 반환 즉, true / false로 반환된다.
		// 다음에 가져올 값이 있으면 true, 없으면 false를 반환한다.
		// next : 매개변수 혹은 iterator 되는 타입으로 반환한다.
		// 아무 타입으로 반환할 수 있다. String으로 입력받으면 String으로 반환된다.
//		while(sc.hasNext()) {
//			System.out.println(sc.nextLine());
//		}
		
		// BuufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = "";
		
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
    }
}