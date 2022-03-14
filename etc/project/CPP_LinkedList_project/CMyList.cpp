#include "CMyList.h"

// 가상함수 테스트
void CMyList::Test() {
	cout << "리스트 안에 있는 값을 모두 더합니다." << endl;
	TestV();
	cout << "완료." << endl;

}
void CMyList::TestV() {
	cout << "부모에서는 아직 구현되지 않았습니다.";
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
	cout << "메뉴를 고르세요(숫자 입력) : ";
	cout << "------------" << endl;
	cout << "CMyList 메뉴" << endl;
	cout << "1 삽입" << endl;
	cout << "2 출력" << endl;
	cout << "0 종료" << endl;
	cout << "------------" << endl;
	cout << "메뉴를 고르세요(숫자 입력) : " << endl;
	cin >> num;
	return num;
}

/*
int CMyList::PrintMenu()
{
	int num;
	cout << "메뉴를 고르세요(숫자 입력) : ";
	cout << "------------" << endl;
	cout << "CMyList 메뉴" << endl;
	cout << "1 삽입" << endl;
	cout << "2 출력" << endl;
	cout << "0 종료" << endl;
	cout << "------------" << endl;
	cout << "메뉴를 고르세요(숫자 입력) : " << endl;
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
		cout << "출력할 데이터가 없습니다." << endl;
	}
	else {
		cout << "\nCMyList 데이터 : ";
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
		cout << "데이터 개수 : " << m_nLength << "개\n" << endl;
	}
}



