package ch3;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
//신체검사 데이터 배열에서 이진 검색하기
//q7 내림차순

public class PhysExamSearch {
	
	//신체검사 데이터 정의
	static class PhyscData {
		private String name;   //이름
		private int    height; //키
		private double vision; //시력
		
		//생성자
		public PhyscData(String name, int height, double vision) {
			this.name = name; this.height = height; this.vision = vision;
		}
		
		//문자열을 반환하는 메서드(정보 확인용)
		public String toString() {
			return name + " " + height + " " + vision;
		}
		
		
		//오름차순으로 정렬하기 위한 comparator
		/*
		public static final Comparator<PhyscData> HEIGHT_ORDER 
		= new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
			}
		}
		*/
		
		//내림차순 정렬 comparator
		public static final Comparator<PhyscData> HEIGHT_DEORDER
		= new HeightDeorderComparator();
		
		private static class HeightDeorderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height < d2.height) ? 1 : (d1.height > d2.height) ? -1 : 0;
			}
		}
	}
	
	

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		PhyscData[] x = { //키의 오름차순으로 정렬
		    new PhyscData("이나일", 160, 0.3),
		    new PhyscData("이나이", 163, 0.4),
		    new PhyscData("이나삼", 166, 0.5),
		    new PhyscData("이나사", 150, 0.6),
		    new PhyscData("이나오", 155, 0.7),
		    new PhyscData("이나육", 170, 0.8),
		    new PhyscData("이나칠", 180, 0.9),
		    new PhyscData("이나팔", 145, 1.0),	
		};
		
		// 배열을 키(height) 기준으로 내림차순 정렬
        Arrays.sort(x, PhyscData.HEIGHT_DEORDER);
        
		System.out.print("몇 cm인 사람을 찾고 있나요?:");
		int height = sc.nextInt();
		int idx = Arrays.binarySearch(
				x,                               //배열 x에서
				new PhyscData("", height, 0.0),  //키가 height인 요소를
				//PhyscData.HEIGHT_ORDER           //HEIGHT_ORDER에 의해 검색
				PhyscData.HEIGHT_DEORDER           //HEIGHT_ORDER에 의해 검색
				);
		
		if (idx < 0)
			System.out.println("요소가 없음");
		else {
			System.out.println("x[" + idx + "]에 있음");
			System.out.println("찾은 데이터: " + x[idx]);
		}

	}

}
