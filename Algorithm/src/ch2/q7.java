package ch2;

import java.util.Scanner;

public class q7 {
	
	static int cardConvEx(int x, int r, char[] d) {
		int digst = 0;		//��ȯ ���� �ڸ���
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int no;                     //��ȯ�ϴ� ����
		int cd;                     //���
		int dno;                    //��ȯ ���� �ڸ���
		int retry;                  //�ٽ� �� ��?
		char[] cno = new char[32];  //��ȯ �� �� �ڸ��� ���ڸ� �־�δ� ������ �迭
		
		System.out.println("10������ ��� ��ȯ�մϴ�.");
		do {
			do {
				System.out.println("��ȯ�ϴ� ���� �ƴ� ����:");
				no = sc.nextInt();
			} while (no<0);
			
			do {
				System.out.println("� ������ ��ȯ�ұ��? (2~36) : ");
				cd = sc.nextInt();
			} while (cd < 2 || cd > 36);
			
			dno = cardConvR(no, cd, cno); //no�� cd������ ��ȯ
			
			System.out.print(cd + "�����δ� ");
			for (int i=0; i<dno; i++)   //���ڸ����� ���ʷ� ��Ÿ��
				System.out.print(cno[i]);
			System.out.println("�Դϴ�.");
			
			System.out.print("�� �� �� �ұ��? (1.�� / 0.�ƴϿ�) : ");
			retry = sc.nextInt();
		} while (retry == 1);

	}

}