package ch3;
import java.util.Scanner;
//선형검색

public class SeqSearch {
	
	static int seqSearch(int[] a, int n, int key) {
		int i=0;
		
		while (true) {
			if (i ==n)
				return -1; //검색 실패!(-1을 반환)
			if (a[i] == key) 
				return i;  //검색 성공!(인덱스 반환)
			i++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("요솟수:");
		int num = sc.nextInt();
		int[] x = new int[num];       //요솟수가 num인 배열
		
		for (int i=0; i<num; i++) {
			System.out.println("x["+i+"]:");
			x[i] = sc.nextInt();
		}
		
		System.out.println("검색할 값:"); //키 값을 입력
		int ky = sc.nextInt();
		
		int idx = seqSearch(x, num, ky); //배열 x에서 키 값이 ky인 요소
		
		if (idx == -1)
			System.out.println("해당 요소가 없음");
		else
			System.out.println(ky + "은 x[" + idx + "]에 있음"
					+ "");

	}

}
