package LinkedList_2;

import java.util.Scanner;

// 조 편성 클래스
public class GroupManager {

	int		m_numOfGroup;		// 생성할 그룹 수 : 사용자로부터 입력 받기
	MyList	rawDataListAll;		// 모든 학생 정보 객체들(StdInfo)을 저장하는 리스트
	MyList	rawDataListMale;	// 남학생 정보 객체들을 저장하는 리스트
	MyList 	rawDataListFemale;	// 여학생 정보 객체들을 저장하는 리스트

	// 생성자 : GroupManager 객체 생성 시 LoadData 메서드 실행
	public GroupManager() {
		// RawDataList 리스트에 학생 객체 저장
		LoadData();
	}

	// 학생 정보를 객체화 후 rawDataList에 저장
	void LoadData() {

		RawData stdData		= new RawData();	// 학생 정보가 들어있는 클래스 호출 후 객체화
		rawDataListAll		= new MyList();		// 모든 학생 정보를 담을 MyList 클래스 호출
		rawDataListMale		= new MyList();		// 남학생 정보를 담을 MyList 클래스 호출 후 멤버변수  rawDataListMale로 객체화
		rawDataListFemale	= new MyList();		// 여학생 정보를 담을 MyList 클래스 호출 후 멤버 변수 rawDataListFemale로 객체화	

		// RawData 클래스 멤버 변수(학번, 이름, 점수, 성별)를 각 StdInfo 객체로 생성 후 
		// rawDataList에 추가
		for (int i = 0 ; i < stdData.m_stdId.length ; i++) {
			StdInfo stdInfo = new StdInfo(
					stdData.m_stdId[i], 
					stdData.m_stdName[i], 
					stdData.m_stdGrade[i], 
					stdData.m_stdGender[i]);

			// 객체화한 학생 정보를 rawDataListAll 리스트에 저장
			rawDataListAll.add(stdInfo);
		}

		// rawDataListAll 리스트에 저장된 모든 학생 정보를 성별에 따라 각 리스트로 구분하여 저장
		for (int i = 0 ; i < rawDataListAll.size() ; i++) {
			// 학생 성별 저장
			String gender = rawDataListAll.get(i).gender;

			// rawDataListAll 리스트 내 학생의 성별이 '남'일 경우 남학생 리스트에 추가, '여'일 경우 여학생 리스트에 추가
			if(gender == "남")	rawDataListMale.add(rawDataListAll.get(i));
			else				rawDataListFemale.add(rawDataListAll.get(i));
		}

		//리스트 rawDataList에 입력된 학생 정보를 화면에 출력
		PrtStdList();
	}

	// rawDataList 내 학생 정보(StdInfo 객체)를 화면에 출력
	// [출력 포맷] 
	// 1) 박나래, 1, "여", 15
	// 2) 이정재, 2, "남", 12
	void PrtStdList() {
		System.out.println("[전체 학생 정보 출력]");
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

	// 랜덤으로 그룹을 생성하여 화면에 출력
	void GenerateGroup() {

		Scanner scan = new Scanner(System.in);

		// 그룹을 배정하기 전 남학생 수, 여학생 수 저장
		int numOfMale	= rawDataListMale.size();
		int numOfFemale = rawDataListFemale.size();

		// 생성 그룹 개수를 사용자로부터 입력 받기
		System.out.print("생성할 그룹 갯수 : ");
		m_numOfGroup = scan.nextInt();
		//m_numOfGroup = 3; // --> 테스트 코드 그룹 수 : 3

		// 입력 받은 그룹 수만큼 배열(객체를 가리킬 참조 변수) 생성
		MyList groupArray[] = new MyList[m_numOfGroup];

		// 입력 받은 그룹 수만큼 MyList 객체 생성 
		for (int i = 0 ; i < m_numOfGroup ; i++) groupArray[i] = new MyList();

		// 1) 남학생 중 성적 순으로 각 그룹에 랜덤하게 배정
		// 예 - 생성 그룹 : 3, 성적순으로 1 ~ 3위의 학생들을 랜덤하게 1, 2, 3조에 편성
		// 2) 모든 남학생이 배정될 때까지 1)을 반복

		// 그룹에 남학생이 동일하게 배정될 때까지 그룹 배정 반복
		while(rawDataListMale.size() >= m_numOfGroup) {
			// 임의 그룹에 배정하기 위해 임의 그룹 배열 호출  
			int[] tempGroupArray = getRandomGrp(m_numOfGroup);
			// int[] tempGroupArray = {1, 0, 2}; --> 테스트 코드 [1, 0, 2]

			// 남학생을 성적순서대로 선택하여 임의 그룹에 배정
			for (int i = 0 ; i < tempGroupArray.length ; i++) {

				// rawDataListMale 리스트에서 학생 선택
				// remove() 호출 시 학생 객체가 삭제되고 데이터 갯수가 감소하므로 매번 인덱스 0에 위치한 학생을 선택
				StdInfo myStudent = rawDataListMale.remove(0);

				// 임의 그룹에 배정
				groupArray[tempGroupArray[i]].add(myStudent);
			}
		}

		// 3) 단, 남학생 숫자가 생성 그룹 수와 맞아 떨어지지 않을 경우, 남은 학생들은 각 조별 총점이 낮은 순으로 배정
		// 각 그룹 별 총점 계산 
		// 그룹 수 만큼 각 그룹의 총점을 저장할 배열 생성
		int[] sumOfGrade = new int[m_numOfGroup];
		// 각 그룹 별 총점 계산 후 sumOfGrade 배열에 저장
		for (int i = 0 ; i < m_numOfGroup ; i++) {
			int sum = 0; // 그룹 내 학생들의 점수를 저장할 합계 변수 선언

			for (int j = 0 ; j < groupArray[i].size() ; j++) {
				sum += groupArray[i].get(j).grade;
			}

			// 각 그룹의 합계를 총점을 저장하는 배열에 추가
			sumOfGrade[i] = sum;
		}


		// 총점 오름차순 
		// 총점 배열 내 값을 총점 기준으로 오름차순 정렬하면서 해당하는 그룹도 정렬 
		for (int i = 0 ; i < sumOfGrade.length ; i++) {
			for (int j = 0 ; j < i ; j++) {
				if(sumOfGrade[i] < sumOfGrade[j]) {
					// 총점 배열 정렬
					int tempGrade	= sumOfGrade[i];
					sumOfGrade[i]	= sumOfGrade[j];
					sumOfGrade[j]	= tempGrade;

					// 그룹 배열도 함께 정렬
					MyList tempGroup = groupArray[i];
					groupArray[i]	 = groupArray[j];
					groupArray[j]	 = tempGroup;
				}
			}
		}


		// 남은 남학생 배정
		// 남은 남학생 수를 저장하는 변수 선언
		int numOfMaleStd = rawDataListMale.size();
		// 남은 남학생을 차례대로 배정
		for (int i = 0 ; i < numOfMaleStd ; i++) {
			// 남학생 리스트 내 남은 학생 선택
			StdInfo myStudent = rawDataListMale.remove(0);

			// 선택된 학생 그룹 배정
			groupArray[i].add(myStudent);
		}

		// 4) 여학생의 경우 1조부터 차례대로 Round Robin 방식으로 배정
		// 예 - 생성 그룹 : 3, 여학생 수 5명 : 1, 2, 3, 1, 2조 순으로 배정
		// 여학생이 모두 그룹에 배정될 때까지 반복
		while(rawDataListFemale.size() != 0) {
			for (int j = 0 ; j < m_numOfGroup ; j++) {
				// 여학생 리스트에서 학생 객체 선택
				StdInfo myStudent = rawDataListFemale.remove(0);

				// groupArray 리스트에 차례대로 추가
				groupArray[j].add(myStudent);

				// 여학생 리스트 내 데이터 갯수가 0일 경우 그룹 배정 종료
				if(rawDataListFemale.size() == 0) break;
			}
		}

		// 조편성 결과 화면 출력
		System.out.println(toString(groupArray, numOfMale, numOfFemale));

	}

	// 임의 그룹에 배정하기 위한 임의 그룹 배열 생성 후 반환
	int[] getRandomGrp(int argNumOfGroup) {
		// 랜덤 그룹을 저장할 배열 생성
		int[] randomGrp = new int[argNumOfGroup];

		// 입력 받은 그룹 수 만큼 랜덤값 생성
		for (int i = 0 ; i < argNumOfGroup ; i++) {
			// 랜덤값 중복 판단 변수 선언
			boolean randomCheck = false;

			// 랜덤값 생성
			int randomValue = (int)(Math.random() * argNumOfGroup);	

			// 랜덤값 중복 판단
			for (int j = 0 ; j < i ; j++) {
				if(randomGrp[j] == randomValue) {
					randomCheck = true;
					i--;
					break;
				}
			}
			// 중복일 경우 랜덤값 재생산, 중복이 아닐 경우  randomGrp배열에 추가
			if(randomCheck) continue;
			randomGrp[i] = randomValue;
		}
		// 임의 그룹 배열 반환
		return randomGrp;
	}

	// 결과 출력문 메서드
	public String toString(MyList[] argGroup, int argNumOfMale, int argNumOfFemale) {

		String	msg	= "";
		msg		= "\n남학생 수 : "		+ argNumOfMale
				+ "\n여학생 수 : "		+ argNumOfFemale 
				+ "\n총 학생 수 : "		+ rawDataListAll.size()
				+ "\n------------------------------------------"
				+ "\n------------------------------------------"
				+ "\n\t\t조 편성 결과"
				+ "\n------------------------------------------\n";

		// 모든 학생들의 그룹 배정 완료 후 결과 
		for (int i = 0 ; i < m_numOfGroup ; i++) {
			msg += "\n\t" + (i + 1) + "조 멤버 목록";

			for (int j = 0 ; j < argGroup[i].size() ; j++) {

				// 출력하고자 하는 그룹의 학생의 정보(학번, 이름, 성별)를 저장
				int		id		= argGroup[i].get(j).id;
				String	name	= argGroup[i].get(j).name;
				String	gender	= argGroup[i].get(j).gender;

				msg += "\n\t\t"		+ (j + 1) + ") "
						+  "학번 : "		+ id
						+  "\t이름 : "	+ name
						+  "\t성별 : "	+ gender;
			}
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		return msg;
	}
}

