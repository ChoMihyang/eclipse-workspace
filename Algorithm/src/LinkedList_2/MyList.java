package LinkedList_2;

// Linked-List 클래스
public class MyList {
	// 멤버 변수 선언
	Node	head;
	Node	tail;
	int		numOfData;

	// 생성자 : MyList 객체 생성 시 head노드와 tail노드 생성
	public MyList() {
		tail = new Node(null, null);
		head = new Node(tail, null);
	}

	// List 내 argID 입력 값과 매칭되는 학생 객체(StdInfo) 반환
	// 매칭되는 학생이 없을 경우 null반환
	public StdInfo getStdById(int argId) {
		// 임시 노드 생성
		Node temp = head.nextNode;

		// tail 노드 앞까지 순회하며 찾고자 하는 학생 id값 탐색
		while(temp != tail) {
			// 매칭되는 학생이 있을 경우
			if(temp.value.id == argId) {
				return temp.value;
			}
			// 다음 노드 순회
			temp = temp.nextNode;
		}		
		// 매칭되는 학생이 없을 경우
		return null;
	}

	// List 내 argIndex 순서에 해당하는 StdInfo 객체 반환
	StdInfo get(int argIndex) {

		// index 값 유효성 검사 실시 [ 입력 값이 -1 이하 이거나, List 내 저장 데이터 값보다 클경우 ]
		if ( argIndex < 0 || argIndex > numOfData ) return null;

		Node temp = head;
		// argIndex 위치까지 노드 순회
		for (int i = 0 ; i <= argIndex ; i++) 
			temp = temp.nextNode;

		//해당하는 StdInfo 객체 반환
		return temp.value;
	}

	// List 내 argIndex 순서에 해당하는 StdInfo 객체를 List 내 삭제 후 해당 객체 반환
	public StdInfo remove(int argIndex) {

		// Index 값 유효성 검사 실시
		// 입력 값이 -1이하 이거나, List 내 저장 데이터 값보다 같거나 클 경우 null 반환

		// TODO : argIndex >= numOfData
		if(argIndex < 0 || argIndex >= numOfData) return null;

		// 임시 노드 생성
		Node temp = head.nextNode;

		// TODO : 수정 (노드 생성이 아님 -> head)
		// 이전 노드를 나타내는 참조변수 생성
		Node preNode = head;

		// 이전 노드도 함께 저장하면서 argIndex의 위치까지 노드 순회
		for (int iCount = 0 ; iCount < argIndex ; iCount++) {
			preNode = temp;
			temp	= temp.nextNode;
		}

		// temp 노드의 앞 노드의 다음 노드를 temp의 다음 노드로 설정 
		preNode.nextNode = temp.nextNode;

		// 데이터 갯수 감소
		numOfData--;

		// 삭제할 객체 반환
		return temp.value;
	}

	// List 제일 마지막에 argStdInfo 객체 삽입
	void add(StdInfo argStdInfo) {
		// 임시 노드 생성
		Node temp = head;

		// tail 노드 앞까지 순회
		while(temp.nextNode != tail) {
			temp = temp.nextNode;
		}

		// 새로운 노드 생성
		// 1. 새로운 노드의 다음 노드를 tail 노드로 설정
		Node newNode = new Node(tail, argStdInfo);

		// 2. tail 노드 앞에 있던 노드의 다음 노드를 새로운 노드로 설정
		temp.nextNode = newNode;

		// 데이터 갯수 증가
		numOfData++;
	}

	// 현 리스트 내 데이터 개수 반환
	int size() {
		return numOfData;
	}

	// 현 리스트 내 여학생 수 반환
	int sizeOfFemaleStd() {
		// 여학생 수 변수
		int numOfFemale = 0;
		// 임시 노드 생성
		Node temp = head.nextNode;

		// 노드 순회하며 여학생 수 저장
		while(temp != tail) {
			if(temp.value.gender == "여") {
				numOfFemale++;
			}
			temp = temp.nextNode;
		}
		// 여학생 수 반환
		return numOfFemale;
	}

	// 현 리스트 내 남학생 수 반환
	int sizeOfMaleStd() {
		// 남학생 수 변수
		int numOfMale = 0;
		// 임시 노드 생성
		Node temp = head.nextNode;

		// 노드 순회하며 여학생 수 저장
		while(temp != tail) {
			if(temp.value.gender == "남") {
				numOfMale++;
			}
			temp = temp.nextNode;
		}
		// 남학생 수 반환
		return numOfMale;
	}

	// 학생 객체 출력문 
	public String toString() {
		String msg = "";

		// 임시 노드 생성
		Node temp = head.nextNode;
		// tail 노드 앞까지 순회하며 학생 객체 값 출력
		while(temp != tail) {
			System.out.println(temp.value + " ");
			temp = temp.nextNode;
		}

		return msg;
	}
}

// 노드 클래스
class Node {
	Node	nextNode;
	StdInfo	value;

	// 생성자 : 노드 객체 생성 시 <다음 노드의 주소>와 <값>을 저장
	public Node(Node argNextNode, StdInfo argValue) {
		nextNode	= argNextNode;
		value		= argValue;
	}
}