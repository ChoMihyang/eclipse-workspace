package LinkedList_01;
// �л� ���� Ŭ����
public class Student {
	// ��� ���� ����
	int				id;
	String			name;
	int				gradeKor;
	int				gradeEng;
	int				gradeMath;
	private int		sum;
	private float	avg;

	// ������ : �л� ��ü ���� �� id�� �̸� ����
	public Student(int argId, String argName) {
		id		= argId;
		name	= argName;
	}

	// �л� ���� ���� : ����, ����, ����
	// �հ�, ��� ���
	public void setGrade(int argKor, int argEng, int argMath) {
		gradeKor	= argKor;
		gradeEng	= argEng;
		gradeMath	= argMath;

		sum			= gradeKor + gradeEng + gradeMath;
		avg			= (float)sum / 3;
	}

	// ���� �հ� : sum ������� ��ȯ
	public int getSum() {
		return sum;
	}

	// ���� ��� : avg ������� ��ȯ
	public float getAvg() {
		return avg;
	}

	// ������ �� ���
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
