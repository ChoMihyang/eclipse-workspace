package LinkedList_2;

// Linked-List Ŭ����
public class MyList {
	// ��� ���� ����
	Node	head;
	Node	tail;
	int		numOfData;

	// ������ : MyList ��ü ���� �� head���� tail��� ����
	public MyList() {
		tail = new Node(null, null);
		head = new Node(tail, null);
	}

	// List �� argID �Է� ���� ��Ī�Ǵ� �л� ��ü(StdInfo) ��ȯ
	// ��Ī�Ǵ� �л��� ���� ��� null��ȯ
	public StdInfo getStdById(int argId) {
		// �ӽ� ��� ����
		Node temp = head.nextNode;

		// tail ��� �ձ��� ��ȸ�ϸ� ã���� �ϴ� �л� id�� Ž��
		while(temp != tail) {
			// ��Ī�Ǵ� �л��� ���� ���
			if(temp.value.id == argId) {
				return temp.value;
			}
			// ���� ��� ��ȸ
			temp = temp.nextNode;
		}		
		// ��Ī�Ǵ� �л��� ���� ���
		return null;
	}

	// List �� argIndex ������ �ش��ϴ� StdInfo ��ü ��ȯ
	StdInfo get(int argIndex) {

		// index �� ��ȿ�� �˻� �ǽ� [ �Է� ���� -1 ���� �̰ų�, List �� ���� ������ ������ Ŭ��� ]
		if ( argIndex < 0 || argIndex > numOfData ) return null;

		Node temp = head;
		// argIndex ��ġ���� ��� ��ȸ
		for (int i = 0 ; i <= argIndex ; i++) 
			temp = temp.nextNode;

		//�ش��ϴ� StdInfo ��ü ��ȯ
		return temp.value;
	}

	// List �� argIndex ������ �ش��ϴ� StdInfo ��ü�� List �� ���� �� �ش� ��ü ��ȯ
	public StdInfo remove(int argIndex) {

		// Index �� ��ȿ�� �˻� �ǽ�
		// �Է� ���� -1���� �̰ų�, List �� ���� ������ ������ ���ų� Ŭ ��� null ��ȯ

		// TODO : argIndex >= numOfData
		if(argIndex < 0 || argIndex >= numOfData) return null;

		// �ӽ� ��� ����
		Node temp = head.nextNode;

		// TODO : ���� (��� ������ �ƴ� -> head)
		// ���� ��带 ��Ÿ���� �������� ����
		Node preNode = head;

		// ���� ��嵵 �Բ� �����ϸ鼭 argIndex�� ��ġ���� ��� ��ȸ
		for (int iCount = 0 ; iCount < argIndex ; iCount++) {
			preNode = temp;
			temp	= temp.nextNode;
		}

		// temp ����� �� ����� ���� ��带 temp�� ���� ���� ���� 
		preNode.nextNode = temp.nextNode;

		// ������ ���� ����
		numOfData--;

		// ������ ��ü ��ȯ
		return temp.value;
	}

	// List ���� �������� argStdInfo ��ü ����
	void add(StdInfo argStdInfo) {
		// �ӽ� ��� ����
		Node temp = head;

		// tail ��� �ձ��� ��ȸ
		while(temp.nextNode != tail) {
			temp = temp.nextNode;
		}

		// ���ο� ��� ����
		// 1. ���ο� ����� ���� ��带 tail ���� ����
		Node newNode = new Node(tail, argStdInfo);

		// 2. tail ��� �տ� �ִ� ����� ���� ��带 ���ο� ���� ����
		temp.nextNode = newNode;

		// ������ ���� ����
		numOfData++;
	}

	// �� ����Ʈ �� ������ ���� ��ȯ
	int size() {
		return numOfData;
	}

	// �� ����Ʈ �� ���л� �� ��ȯ
	int sizeOfFemaleStd() {
		// ���л� �� ����
		int numOfFemale = 0;
		// �ӽ� ��� ����
		Node temp = head.nextNode;

		// ��� ��ȸ�ϸ� ���л� �� ����
		while(temp != tail) {
			if(temp.value.gender == "��") {
				numOfFemale++;
			}
			temp = temp.nextNode;
		}
		// ���л� �� ��ȯ
		return numOfFemale;
	}

	// �� ����Ʈ �� ���л� �� ��ȯ
	int sizeOfMaleStd() {
		// ���л� �� ����
		int numOfMale = 0;
		// �ӽ� ��� ����
		Node temp = head.nextNode;

		// ��� ��ȸ�ϸ� ���л� �� ����
		while(temp != tail) {
			if(temp.value.gender == "��") {
				numOfMale++;
			}
			temp = temp.nextNode;
		}
		// ���л� �� ��ȯ
		return numOfMale;
	}

	// �л� ��ü ��¹� 
	public String toString() {
		String msg = "";

		// �ӽ� ��� ����
		Node temp = head.nextNode;
		// tail ��� �ձ��� ��ȸ�ϸ� �л� ��ü �� ���
		while(temp != tail) {
			System.out.println(temp.value + " ");
			temp = temp.nextNode;
		}

		return msg;
	}
}

// ��� Ŭ����
class Node {
	Node	nextNode;
	StdInfo	value;

	// ������ : ��� ��ü ���� �� <���� ����� �ּ�>�� <��>�� ����
	public Node(Node argNextNode, StdInfo argValue) {
		nextNode	= argNextNode;
		value		= argValue;
	}
}