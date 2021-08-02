package LinkedList_01;
// Linked List �� ��� ����Ʈ Ŭ����
public class MyList {

	// ��� ���� ����
	Node	head;
	Node	tail;
	int		numOfNode;
	float	avg;

	// ������ : MyList ��ü ���� �� head ���, tail ��� ����
	public MyList() {
		tail = new Node(null, null);
		head = new Node(tail, null);
	}

	// �Է� �����͸� ����Ʈ ���� ���� �߰�
	public void addNode(Student argValue) {

		// �ӽ� ��� ����
		Node temp = head;

		// tail ��� �ձ��� ��ȸ
		while(temp.nextNode != tail) {
			temp = temp.nextNode;
		}
		// ���ο� ��� �߰�
		// ���ο� ����� ���� ��带 tail ���� ����
		Node newNode = new Node(tail, argValue);

		// tail �� ����� ���� ��带 ���ο� ���� ����
		temp.nextNode = newNode;

		// ����� ���� �߰�
		numOfNode++;
	}

	// ����Ʈ �� ������ ���� ��ȯ
	public int getSize() {
		return numOfNode;
	}

	// ����Ʈ �� ��� Student ��ü�� �� ��հ��� ���� ��ü ��հ� ��ȯ
	public float getAvg() {

		// ��ü ����� �� 
		float sumOfAvg = 0.0f;

		// �ӽ� ��� ����
		Node temp = head.nextNode;

		// tail ��� �ձ��� ��ȸ�ϸ� �ش� ��ü�� ��� �� ����
		while(temp != tail) {
			sumOfAvg	+= temp.value.getAvg();
			temp		= temp.nextNode;
		}

		// �� ��� ���ϱ� : ��ü ����� �� / �л� ��ü�� ��(����� ��)
		if(numOfNode == 0) return 0.0f;
		else			   return sumOfAvg / numOfNode;
	}

	// ����Ʈ �� ��� Student ��ü�� �� ���
	public String toString() {

		String msg = "";

		// �ӽ� ��� ����
		Node temp = head.nextNode;

		// tail ��� �ձ��� ��ȸ�ϸ� Student ��ü�� �� ���
		while(temp != tail) {
			msg  += temp.value + "";
			temp = temp.nextNode;
		}
		return msg;
	}
}
