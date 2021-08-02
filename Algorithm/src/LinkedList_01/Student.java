package LinkedList_01;
// 학생 정보 클래스
public class Student {
	// 멤버 변수 선언
	int				id;
	String			name;
	int				gradeKor;
	int				gradeEng;
	int				gradeMath;
	private int		sum;
	private float	avg;

	// 생성자 : 학생 객체 생성 시 id와 이름 저장
	public Student(int argId, String argName) {
		id		= argId;
		name	= argName;
	}

	// 학생 성적 저장 : 국어, 영어, 수학
	// 합계, 평균 계산
	public void setGrade(int argKor, int argEng, int argMath) {
		gradeKor	= argKor;
		gradeEng	= argEng;
		gradeMath	= argMath;

		sum			= gradeKor + gradeEng + gradeMath;
		avg			= (float)sum / 3;
	}

	// 성적 합계 : sum 멤버변수 반환
	public int getSum() {
		return sum;
	}

	// 성적 평균 : avg 멤버변수 반환
	public float getAvg() {
		return avg;
	}

	// 데이터 값 출력
	public String toString() {
		String msg = "";

		msg += "[ id : "	+ id		+ " "
				+ "name : " + name		+ " "
				+ "kor : "	+ gradeKor	+ " "
				+ "eng : "	+ gradeEng	+ " "
				+ "math : " + gradeMath + " "
				+ "sum : "	+ sum		+ " "
				+ "avg : "	+ avg 		+ " ]\n";

		return msg;
	}
}
