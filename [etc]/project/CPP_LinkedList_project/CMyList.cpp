#include "CMyList.h"

// �����Լ� �׽�Ʈ
void CMyList::Test() {
	cout << "����Ʈ �ȿ� �ִ� ���� ��� ���մϴ�." << endl;
	TestV();
	cout << "�Ϸ�." << endl;

}
void CMyList::TestV() {
	cout << "�θ𿡼��� ���� �������� �ʾҽ��ϴ�.";
}

void CMyList::Insert(Data num) 
{
	Node* newNode = new Node;

	newNode->data = num;
	newNode->b_link = nullptr;
	newNode->f_link = nullptr;

	if (GetHead() == nullptr) {
		SetHead(newNode);
	}
	else {
		GetTail()->b_link = newNode;
		newNode->f_link = GetTail();
	}
	SetTail(newNode);
	PrintData();
}

bool CMyList::Search(Data num) {
	Node* head = pHead;
	while (head) {
		if (head->data == num)
			return true;
		else {
			head = head->b_link;
		}
	}
	return false;
}


int CMyList::PrintMenu()
{
	int num;
	cout << "�޴��� ������(���� �Է�) : ";
	cout << "------------" << endl;
	cout << "CMyList �޴�" << endl;
	cout << "1 ����" << endl;
	cout << "2 ���" << endl;
	cout << "0 ����" << endl;
	cout << "------------" << endl;
	cout << "�޴��� ������(���� �Է�) : " << endl;
	cin >> num;
	return num;
}

/*
int CMyList::PrintMenu()
{
	int num;
	cout << "�޴��� ������(���� �Է�) : ";
	cout << "------------" << endl;
	cout << "CMyList �޴�" << endl;
	cout << "1 ����" << endl;
	cout << "2 ���" << endl;
	cout << "0 ����" << endl;
	cout << "------------" << endl;
	cout << "�޴��� ������(���� �Է�) : " << endl;
	cin >> num;
	return num;
}
*/

Node* CMyList::GetHead() const
{
	return pHead;
}

void CMyList::SetHead(Node* tmp)
{
	pHead = tmp;
	//tmp->f_link = nullptr;
}

Node* CMyList::GetTail() const
{
	return pTail;
}

void CMyList::SetTail(Node* tmp)
{
	pTail = tmp;
	//tmp->b_link = nullptr;
}

/*
int CMyList::GetLength() const
{
	return m_nLength;
}

void CMyList::SetLength(int num)
{
	m_nLength = num;
}
*/

void CMyList::PrintData()
{
	Node* head = pHead;
	m_nLength = 0;
	if (head == nullptr) {
		cout << "����� �����Ͱ� �����ϴ�." << endl;
	}
	else {
		cout << "\nCMyList ������ : ";
		cout << "[Head] ";
		while (head) {
			if (head->b_link) {
				cout << head->data << " - ";
			}
			else {
				cout << head->data;
			}
			head = head->b_link;
			m_nLength++;
		}
		cout << " [Tail]" << endl;
		cout << "������ ���� : " << m_nLength << "��\n" << endl;
	}
}



