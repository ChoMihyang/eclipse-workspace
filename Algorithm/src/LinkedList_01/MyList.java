package LinkedList_01;
// Linked List 내 노드 리스트 클래스
public class MyList {

	// 멤버 변수 선언
	Node	head;
	Node	tail;
	int		numOfNode;
	float	avg;

	// 생성자 : MyList 객체 생성 시 head 노드, tail 노드 생성
	public MyList() {
		tail = new Node(null, null);
		head = new Node(tail, null);
	}

	// 입력 데이터를 리스트 제일 끝에 추가
	public void addNode(Student argValue) {

		// 임시 노드 생성
		Node temp = head;

		// tail 노드 앞까지 순회
		while(temp.nextNode != tail) {
			temp = temp.nextNode;
		}
		// 새로운 노드 추가
		// 새로운 노드의 다음 노드를 tail 노드로 설정
		Node newNode = new Node(tail, argValue);

		// tail 앞 노드의 다음 노드를 새로운 노드로 설정
		temp.nextNode = newNode;

		// 노드의 갯수 추가
		numOfNode++;
	}

	// 리스트 내 데이터 갯수 반환
	public int getSize() {
		return numOfNode;
	}

	// 리스트 내 모든 Student 객체의 각 평균값에 대한 전체 평균값 반환
	public float getAvg() {

		// 전체 평균의 합 
		float sumOfAvg = 0.0f;

		// 임시 노드 생성
		Node temp = head.nextNode;

		// tail 노드 앞까지 순회하며 해당 객체의 평균 값 저장
		while(temp != tail) {
			sumOfAvg	+= temp.value.getAvg();
			temp		= temp.nextNode;
		}

		// 총 평균 구하기 : 전체 평균의 합 / 학생 객체의 수(노드의 수)
		if(numOfNode == 0) return 0.0f;
		else			   return sumOfAvg / numOfNode;
	}

	// 리스트 내 모든 Student 객체의 값 출력
	public String toString() {

		String msg = "";

		// 임시 노드 생성
		Node temp = head.nextNode;

		// tail 노드 앞까지 순회하며 Student 객체의 값 출력
		while(temp != tail) {
			msg  += temp.value + "";
			temp = temp.nextNode;
		}
		return msg;
	}
}
