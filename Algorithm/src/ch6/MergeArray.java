package ch6;
import java.util.Scanner;
//������ ��ģ �迭�� ����

public class MergeArray {

	//������ ��ģ �迭 a, b�� �����Ͽ� �迭 c�� ����
	static void merge(int[] a, int na, int[] b, int nb, int[] c) {
		int pa = 0;
		int pb = 0;
		int pc = 0;
		
		while (pa< na && pb < nb) //���� ���� ����
			c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
		
		while (pa < na)      //a�� ���� �ִ� ��Ҹ� ����
			c[pc++] = a[pa++];
		
		while (pb < nb)      //b�� ���� �մ� ��Ҹ� ����
			c[pc++] = b[pb++];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = {2, 4, 6, 8, 11, 13};
		int[] b = {1, 2, 3, 4, 9, 16, 21};
		int[] c = new int[13];
		
		System.out.println("�� �迭�� ����");
		
		merge(a, a.length, b, b.length, c);
		
		System.out.println("�迭 a�� b�� �����Ͽ� �迭 c�� ����");
		System.out.println("�迭 a :");
		for(int i=0; i<a.length; i++)
			System.out.println("a[" + i + "] = " + a[i]);
		
		System.out.println("�迭b:");
		for(int i=0; i<b.length; i++)
			System.out.println("b[" + i + "]=" + b[i]);
		
		System.out.println("�迭 c:");
		for(int i=0; i<c.length; i++)
			System.out.println("c[" + i + "]=" + c[i]);

	}

}