package LinkedList_01;

import java.util.Scanner;
// 메인 클래스
public class MyMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 학생 객체 생성
		Student	std		= null;
		// 리스트 객체 생성
		MyList	myList	= new MyList();

		// 사용자 입력값 선언
		int	myValue	= 0;

		// 프로그램이 종료될 때까지 선택 메뉴 출력, 입력값 받기 반복
		do {
			// 선택 메뉴 출력
			System.out.println(
					"====================="
							+ "\n1. 학생 성적 입력"
							+ "\n2. 학생 목록 출력(입력 순)"
							+ "\n3. 프로그램 종료"
							+ "\n\n현 입력데이터 갯수 : " + myList.getSize()
							+ "\n전체 학생 평균 값   : " + myList.getAvg()
							+ "\n====================="
					);

			// 사용자로부터 메뉴 입력
			System.out.print("메뉴를 선택해 주세요 : ");
			myValue = scan.nextInt();

			// 입력값에 따라 실행 구분
			// '3' 선택 시 : 프로그램 종료
			if(myValue == 3) {
				break;
			}
			// '1' 선택 시 : 학생 성적 입력
			else if(myValue == 1) {
				System.out.println("학번을 입력하세요.");
				int inputId = scan.nextInt();

				System.out.println("이름을 입력하세요.");
				String inputName = scan.next();

				System.out.println("국어 성적을 입력하세요.");
				int inputGradeKor = scan.nextInt();

				System.out.println("영어 성적을 입력하세요.");
				int inputGradeEng = scan.nextInt();

				System.out.println("수학 성적을 입력하세요.");
				int inputGradeMath = scan.nextInt();	

				// 입력 받은 학생 정보를 Student 객체에 저장
				std = new Student(inputId, inputName);

				// 입력 받은 학생 국어, 수학, 영어 성적 저장 후 합계와 평균 계산
				std.setGrade(inputGradeKor, inputGradeEng, inputGradeMath);

				// Student객체를 MyList 내 추가 
				myList.addNode(std);

			}

			// '2' 선택 시 : 학생 목록 출력
			else if(myValue == 2) {
				System.out.println(myList.toString());
			}
		}while(true);
		// 프로그램 종료 출력	
		System.out.println("프로그램 종료");
	}
}
