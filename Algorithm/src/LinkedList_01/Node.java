package LinkedList_01;
// ��� Ŭ����
public class Node {

	// ��� ���� ����
	Node	nextNode;
	Student value;

	// ������ : ��� ��ü ���� �� <��>�� <���� ����� �ּ�>�� ������ ��� ��ü ����
	public Node(Node argNextNode, Student argValue) {
		nextNode	= argNextNode;
		value		= argValue;
	}
}
