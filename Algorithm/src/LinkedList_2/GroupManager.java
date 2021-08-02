package LinkedList_2;

import java.util.Scanner;

// �� �� Ŭ����
public class GroupManager {

	int		m_numOfGroup;		// ������ �׷� �� : ����ڷκ��� �Է� �ޱ�
	MyList	rawDataListAll;		// ��� �л� ���� ��ü��(StdInfo)�� �����ϴ� ����Ʈ
	MyList	rawDataListMale;	// ���л� ���� ��ü���� �����ϴ� ����Ʈ
	MyList 	rawDataListFemale;	// ���л� ���� ��ü���� �����ϴ� ����Ʈ

	// ������ : GroupManager ��ü ���� �� LoadData �޼��� ����
	public GroupManager() {
		// RawDataList ����Ʈ�� �л� ��ü ����
		LoadData();
	}

	// �л� ������ ��üȭ �� rawDataList�� ����
	void LoadData() {

		RawData stdData		= new RawData();	// �л� ������ ����ִ� Ŭ���� ȣ�� �� ��üȭ
		rawDataListAll		= new MyList();		// ��� �л� ������ ���� MyList Ŭ���� ȣ��
		rawDataListMale		= new MyList();		// ���л� ������ ���� MyList Ŭ���� ȣ�� �� �������  rawDataListMale�� ��üȭ
		rawDataListFemale	= new MyList();		// ���л� ������ ���� MyList Ŭ���� ȣ�� �� ��� ���� rawDataListFemale�� ��üȭ	

		// RawData Ŭ���� ��� ����(�й�, �̸�, ����, ����)�� �� StdInfo ��ü�� ���� �� 
		// rawDataList�� �߰�
		for (int i = 0 ; i < stdData.m_stdId.length ; i++) {
			StdInfo stdInfo = new StdInfo(
					stdData.m_stdId[i], 
					stdData.m_stdName[i], 
					stdData.m_stdGrade[i], 
					stdData.m_stdGender[i]);

			// ��üȭ�� �л� ������ rawDataListAll ����Ʈ�� ����
			rawDataListAll.add(stdInfo);
		}

		// rawDataListAll ����Ʈ�� ����� ��� �л� ������ ������ ���� �� ����Ʈ�� �����Ͽ� ����
		for (int i = 0 ; i < rawDataListAll.size() ; i++) {
			// �л� ���� ����
			String gender = rawDataListAll.get(i).gender;

			// rawDataListAll ����Ʈ �� �л��� ������ '��'�� ��� ���л� ����Ʈ�� �߰�, '��'�� ��� ���л� ����Ʈ�� �߰�
			if(gender == "��")	rawDataListMale.add(rawDataListAll.get(i));
			else				rawDataListFemale.add(rawDataListAll.get(i));
		}

		//����Ʈ rawDataList�� �Էµ� �л� ������ ȭ�鿡 ���
		PrtStdList();
	}

	// rawDataList �� �л� ����(StdInfo ��ü)�� ȭ�鿡 ���
	// [��� ����] 
	// 1) �ڳ���, 1, "��", 15
	// 2) ������, 2, "��", 12
	void PrtStdList() {
		System.out.println("[��ü �л� ���� ���]");
		for (int i = 0 ; i < rawDataListAll.size() ; i++) {
			System.out.printf("%d) %s, %d, %s, %d\n", 
					i + 1, 
					rawDataListAll.get(i).name,
					rawDataListAll.get(i).id,
					rawDataListAll.get(i).gender,
					rawDataListAll.get(i).grade
					);
		}
		System.out.println("---------------------");
	}

	// �������� �׷��� �����Ͽ� ȭ�鿡 ���
	void GenerateGroup() {

		Scanner scan = new Scanner(System.in);

		// �׷��� �����ϱ� �� ���л� ��, ���л� �� ����
		int numOfMale	= rawDataListMale.size();
		int numOfFemale = rawDataListFemale.size();

		// ���� �׷� ������ ����ڷκ��� �Է� �ޱ�
		System.out.print("������ �׷� ���� : ");
		m_numOfGroup = scan.nextInt();
		//m_numOfGroup = 3; // --> �׽�Ʈ �ڵ� �׷� �� : 3

		// �Է� ���� �׷� ����ŭ �迭(��ü�� ����ų ���� ����) ����
		MyList groupArray[] = new MyList[m_numOfGroup];

		// �Է� ���� �׷� ����ŭ MyList ��ü ���� 
		for (int i = 0 ; i < m_numOfGroup ; i++) groupArray[i] = new MyList();

		// 1) ���л� �� ���� ������ �� �׷쿡 �����ϰ� ����
		// �� - ���� �׷� : 3, ���������� 1 ~ 3���� �л����� �����ϰ� 1, 2, 3���� ��
		// 2) ��� ���л��� ������ ������ 1)�� �ݺ�

		// �׷쿡 ���л��� �����ϰ� ������ ������ �׷� ���� �ݺ�
		while(rawDataListMale.size() >= m_numOfGroup) {
			// ���� �׷쿡 �����ϱ� ���� ���� �׷� �迭 ȣ��  
			int[] tempGroupArray = getRandomGrp(m_numOfGroup);
			// int[] tempGroupArray = {1, 0, 2}; --> �׽�Ʈ �ڵ� [1, 0, 2]

			// ���л��� ����������� �����Ͽ� ���� �׷쿡 ����
			for (int i = 0 ; i < tempGroupArray.length ; i++) {

				// rawDataListMale ����Ʈ���� �л� ����
				// remove() ȣ�� �� �л� ��ü�� �����ǰ� ������ ������ �����ϹǷ� �Ź� �ε��� 0�� ��ġ�� �л��� ����
				StdInfo myStudent = rawDataListMale.remove(0);

				// ���� �׷쿡 ����
				groupArray[tempGroupArray[i]].add(myStudent);
			}
		}

		// 3) ��, ���л� ���ڰ� ���� �׷� ���� �¾� �������� ���� ���, ���� �л����� �� ���� ������ ���� ������ ����
		// �� �׷� �� ���� ��� 
		// �׷� �� ��ŭ �� �׷��� ������ ������ �迭 ����
		int[] sumOfGrade = new int[m_numOfGroup];
		// �� �׷� �� ���� ��� �� sumOfGrade �迭�� ����
		for (int i = 0 ; i < m_numOfGroup ; i++) {
			int sum = 0; // �׷� �� �л����� ������ ������ �հ� ���� ����

			for (int j = 0 ; j < groupArray[i].size() ; j++) {
				sum += groupArray[i].get(j).grade;
			}

			// �� �׷��� �հ踦 ������ �����ϴ� �迭�� �߰�
			sumOfGrade[i] = sum;
		}


		// ���� �������� 
		// ���� �迭 �� ���� ���� �������� �������� �����ϸ鼭 �ش��ϴ� �׷쵵 ���� 
		for (int i = 0 ; i < sumOfGrade.length ; i++) {
			for (int j = 0 ; j < i ; j++) {
				if(sumOfGrade[i] < sumOfGrade[j]) {
					// ���� �迭 ����
					int tempGrade	= sumOfGrade[i];
					sumOfGrade[i]	= sumOfGrade[j];
					sumOfGrade[j]	= tempGrade;

					// �׷� �迭�� �Բ� ����
					MyList tempGroup = groupArray[i];
					groupArray[i]	 = groupArray[j];
					groupArray[j]	 = tempGroup;
				}
			}
		}


		// ���� ���л� ����
		// ���� ���л� ���� �����ϴ� ���� ����
		int numOfMaleStd = rawDataListMale.size();
		// ���� ���л��� ���ʴ�� ����
		for (int i = 0 ; i < numOfMaleStd ; i++) {
			// ���л� ����Ʈ �� ���� �л� ����
			StdInfo myStudent = rawDataListMale.remove(0);

			// ���õ� �л� �׷� ����
			groupArray[i].add(myStudent);
		}

		// 4) ���л��� ��� 1������ ���ʴ�� Round Robin ������� ����
		// �� - ���� �׷� : 3, ���л� �� 5�� : 1, 2, 3, 1, 2�� ������ ����
		// ���л��� ��� �׷쿡 ������ ������ �ݺ�
		while(rawDataListFemale.size() != 0) {
			for (int j = 0 ; j < m_numOfGroup ; j++) {
				// ���л� ����Ʈ���� �л� ��ü ����
				StdInfo myStudent = rawDataListFemale.remove(0);

				// groupArray ����Ʈ�� ���ʴ�� �߰�
				groupArray[j].add(myStudent);

				// ���л� ����Ʈ �� ������ ������ 0�� ��� �׷� ���� ����
				if(rawDataListFemale.size() == 0) break;
			}
		}

		// ���� ��� ȭ�� ���
		System.out.println(toString(groupArray, numOfMale, numOfFemale));

	}

	// ���� �׷쿡 �����ϱ� ���� ���� �׷� �迭 ���� �� ��ȯ
	int[] getRandomGrp(int argNumOfGroup) {
		// ���� �׷��� ������ �迭 ����
		int[] randomGrp = new int[argNumOfGroup];

		// �Է� ���� �׷� �� ��ŭ ������ ����
		for (int i = 0 ; i < argNumOfGroup ; i++) {
			// ������ �ߺ� �Ǵ� ���� ����
			boolean randomCheck = false;

			// ������ ����
			int randomValue = (int)(Math.random() * argNumOfGroup);	

			// ������ �ߺ� �Ǵ�
			for (int j = 0 ; j < i ; j++) {
				if(randomGrp[j] == randomValue) {
					randomCheck = true;
					i--;
					break;
				}
			}
			// �ߺ��� ��� ������ �����, �ߺ��� �ƴ� ���  randomGrp�迭�� �߰�
			if(randomCheck) continue;
			randomGrp[i] = randomValue;
		}
		// ���� �׷� �迭 ��ȯ
		return randomGrp;
	}

	// ��� ��¹� �޼���
	public String toString(MyList[] argGroup, int argNumOfMale, int argNumOfFemale) {

		String	msg	= "";
		msg		= "\n���л� �� : "		+ argNumOfMale
				+ "\n���л� �� : "		+ argNumOfFemale 
				+ "\n�� �л� �� : "		+ rawDataListAll.size()
				+ "\n------------------------------------------"
				+ "\n------------------------------------------"
				+ "\n\t\t�� �� ���"
				+ "\n------------------------------------------\n";

		// ��� �л����� �׷� ���� �Ϸ� �� ��� 
		for (int i = 0 ; i < m_numOfGroup ; i++) {
			msg += "\n\t" + (i + 1) + "�� ��� ���";

			for (int j = 0 ; j < argGroup[i].size() ; j++) {

				// ����ϰ��� �ϴ� �׷��� �л��� ����(�й�, �̸�, ����)�� ����
				int		id		= argGroup[i].get(j).id;
				String	name	= argGroup[i].get(j).name;
				String	gender	= argGroup[i].get(j).gender;

				msg += "\n\t\t"		+ (j + 1) + ") "
						+  "�й� : "		+ id
						+  "\t�̸� : "	+ name
						+  "\t���� : "	+ gender;
			}
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		return msg;
	}
}

