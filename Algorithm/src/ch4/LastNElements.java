package ch4;
import java.util.Scanner;
//원하는 개수만큼 값을 입력받아 요솟수가 N인 배열에 마지막 N개를 저장

public class LastNElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int N = 10;
		int[] a = new int[N];      //입력 받은 값을 저장
		int cnt = 0;               //입력 받은 개수
		int retry;                 //다시?
		
		System.out.println("정수를 입력하세요.");
		
		do {
			System.out.printf("%d번째 정수:", cnt + 1);
			a[cnt++ % N] = sc.nextInt();  //후휘연산은 %N을 수행하고 진행 
			
			System.out.print("계속 할까요? (예.1 / 아니요.0) : ");
			retry = sc.nextInt();
		} while(retry ==1);
		
		int i = cnt - N;
		if(i<0) i=0;
		
		for(; i<cnt; i++)
			System.out.printf("%2d번째의 정수=%d\n", i+1, a[i%N]);
		

	}

}
