package LinkedList_2;

// �л� ���� ���� Ŭ����
public class StdInfo {
	
	// ��� ����
	int		id;
	String	name;
	int		grade;
	String	gender;
	
	
	// ������ : �л� �� ���� �й�, �̸�, ����, ���� ����
	// StdInfo ��ü �� ���� �� ���� �л��� ��Ÿ��
	public StdInfo(int argId, String argName, int argGrade, String argGender){
		id		= argId;
		name	= argName;
		grade	= argGrade;
		gender	= argGender;
	}
	
	// �׽�Ʈ ��¹� �޼���
	public String toString() {
		String msg = "";
		msg += "[ �й� : "		+ id 
				+ ", �̸� : "		+ name 
				+ ", ���� : "		+ gender 
				+ ", ���� : "		+ grade 
				+ " ]"; 
		return msg;
	}
}
