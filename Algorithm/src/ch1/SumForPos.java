package ch1;
//1, 2, ... , n의 합을 구합니다(양수만 입력)

import java.util.Scanner;

public class SumForPos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.println("1부터 n까지의 합을 구함");
		
		do {
			System.out.println("n의 값");
			n = sc.nextInt();
		} while (n <= 0);
		
		int sum = 0;
		
		for (int i =1; i <=n; i++)
			sum += i;
		
		System.out.println("1부터" + n + "까지의 합은" + sum + "입니다");

	}

}
