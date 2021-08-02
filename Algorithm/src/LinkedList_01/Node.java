package LinkedList_01;
// 노드 클래스
public class Node {

	// 멤버 변수 선언
	Node	nextNode;
	Student value;

	// 생성자 : 노드 객체 생성 시 <값>과 <다음 노드의 주소>로 구성된 노드 객체 생성
	public Node(Node argNextNode, Student argValue) {
		nextNode	= argNextNode;
		value		= argValue;
	}
}
