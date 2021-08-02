package LinkedList_2;

// 학생 정보 저장 클래스
public class StdInfo {
	
	// 멤버 변수
	int		id;
	String	name;
	int		grade;
	String	gender;
	
	
	// 생성자 : 학생 한 명의 학번, 이름, 점수, 성별 저장
	// StdInfo 객체 한 개가 한 명의 학생을 나타냄
	public StdInfo(int argId, String argName, int argGrade, String argGender){
		id		= argId;
		name	= argName;
		grade	= argGrade;
		gender	= argGender;
	}
	
	// 테스트 출력문 메서드
	public String toString() {
		String msg = "";
		msg += "[ 학번 : "		+ id 
				+ ", 이름 : "		+ name 
				+ ", 성별 : "		+ gender 
				+ ", 점수 : "		+ grade 
				+ " ]"; 
		return msg;
	}
}
