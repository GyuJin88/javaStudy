package ch3;
import java.util.Scanner;
//이진 검색

public class BinSearch {
	
	static int binSearch(int[] a, int n, int key) {
		int pl = 0;                 //검색 범위의 첫 인덱스
		int pr = n-1;               //검색 범위의 끝 인덱스
		
		do {
			int pc = (pl + pr) / 2; //중앙 요소의 인덱스
			if (a[pc] == key)
				return pc;          //검색 성공
			else if (a[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while(pl <= pr);
		
		return -1;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("요솟수:");
		int num = sc.nextInt();
		int[] x = new int[num];
		
		System.out.println("오름차순으로 입력하세요");
		
		System.out.print("x[0]:");    //첫 요소 입력
		x[0] = sc.nextInt();
		
		for ( int i=1; i<num; i++) {
			do {
				System.out.print("x[" + i + "]:");
				x[i] = sc.nextInt();
			} while (x[i] < x[i-1]);  //바로 앞의 요소보다 작으면 다시 입력
		}
		
		System.out.print("검색할 값:");  //키 값을 입력
		int ky = sc.nextInt();
		
		int idx = binSearch(x, num, ky);
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없음");
		else
			System.out.println(ky+"은 x[" + idx + "]에 있습니다");

	}

}
