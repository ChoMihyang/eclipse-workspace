package LinkedList_01;

import java.util.Scanner;
// ���� Ŭ����
public class MyMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// �л� ��ü ����
		Student	std		= null;
		// ����Ʈ ��ü ����
		MyList	myList	= new MyList();

		// ����� �Է°� ����
		int	myValue	= 0;

		// ���α׷��� ����� ������ ���� �޴� ���, �Է°� �ޱ� �ݺ�
		do {
			// ���� �޴� ���
			System.out.println(
					"====================="
							+ "\n1. �л� ���� �Է�"
							+ "\n2. �л� ��� ���(�Է� ��)"
							+ "\n3. ���α׷� ����"
							+ "\n\n�� �Էµ����� ���� : " + myList.getSize()
							+ "\n��ü �л� ��� ��   : " + myList.getAvg()
							+ "\n====================="
					);

			// ����ڷκ��� �޴� �Է�
			System.out.print("�޴��� ������ �ּ��� : ");
			myValue = scan.nextInt();

			// �Է°��� ���� ���� ����
			// '3' ���� �� : ���α׷� ����
			if(myValue == 3) {
				break;
			}
			// '1' ���� �� : �л� ���� �Է�
			else if(myValue == 1) {
				System.out.println("�й��� �Է��ϼ���.");
				int inputId = scan.nextInt();

				System.out.println("�̸��� �Է��ϼ���.");
				String inputName = scan.next();

				System.out.println("���� ������ �Է��ϼ���.");
				int inputGradeKor = scan.nextInt();

				System.out.println("���� ������ �Է��ϼ���.");
				int inputGradeEng = scan.nextInt();

				System.out.println("���� ������ �Է��ϼ���.");
				int inputGradeMath = scan.nextInt();	

				// �Է� ���� �л� ������ Student ��ü�� ����
				std = new Student(inputId, inputName);

				// �Է� ���� �л� ����, ����, ���� ���� ���� �� �հ�� ��� ���
				std.setGrade(inputGradeKor, inputGradeEng, inputGradeMath);

				// Student��ü�� MyList �� �߰� 
				myList.addNode(std);

			}

			// '2' ���� �� : �л� ��� ���
			else if(myValue == 2) {
				System.out.println(myList.toString());
			}
		}while(true);
		// ���α׷� ���� ���	
		System.out.println("���α׷� ����");
	}
}
