package ch2;
import java.util.Scanner;
//그 해 경과 일 수

public class DayOfYear {
	
	static int[][] mdays = {
			{31,28,31,30,31,30,31,31,30,31,30,31}, //평년
			{31,29,31,30,31,30,31,31,30,31,30,31}  //윤년
	};
	
	//서기 year년은 윤년인가? (윤년:1/ 평년:0)
	static int isLeap(int year) {
		return (year %4 == 0 && year
					%100 !=0 || year %400 ==0)?1:0;
	}
	
	//서기 y년 m월 d일의 그 해 경과 일 수를 구함
	static int dayOfYear(int y, int m, int d) {
		int days = d;      //일 수
		
		for(int i=1; i<m; i++) 
			days += mdays[isLeap(y)][i-1];
		return days;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int retry;         //다시 계산?
		
		System.out.println("그 해 경과 일수를 구합니다");
		
		do {
			System.out.println("년:"); int year = sc.nextInt();
			System.out.println("월:"); int month = sc.nextInt();
			System.out.println("일:"); int day = sc.nextInt();
			
			System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));
			
			System.out.println("한 번 더 할까요? (1.예 / 0.아니요)");
			retry = sc.nextInt();
		} while (retry ==1 );
	}

}
