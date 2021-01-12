#include "CMyListEx.h"
/*
CMyListEx::CMyListEx(int num)
{
	CMyList::Insert(num);
}*/

void CMyListEx::TestV()
{
	//cout << "자식, 성공";
	int sum = 0;
	Node* tail = GetTail();
	Node* head = GetHead();
	if (head == nullptr) {
		cout << "list에 더할 값이 없습니다." << endl;
	}
	else {
		while (tail) {
			if (tail->f_link) {
				sum += tail->data;
			}
			else {
				sum += tail->data;
				break;
			}
			tail = tail->f_link;
			
		}
		cout << "합은 " <<sum << endl;
	}
	//cout << "헤드에서 삽입은 자식 클래스인 CMyListEx에서 이루어집니다." << endl;
}

void CMyListEx::TestNow() // virtual 부모 메소드 호출
{
	CMyList::Test(); // 자식이 호출이 안됨
}

//테일에서 삽입
void CMyListEx::Insert_tail(Data data)
{
	CMyList::Insert(data);
}

//헤드에서 삽입
void CMyListEx::Insert_head(Data num)
{
	Node* newNode = new Node;

	newNode->data = num;
	newNode->b_link = nullptr;
	newNode->f_link = nullptr;

	if (GetTail() == nullptr) {
		cout << "tail 널임";
		SetTail(newNode);
	}
		
	else {
		cout << "tail 널아님";
		GetHead()->f_link = newNode;
		newNode->b_link = GetHead();
	}
	SetHead(newNode);
	PrintData();
}


// 헤드에서 삭제
void CMyListEx::Delete_head() {
	if (GetHead() == nullptr) {
		cout << "삭제할 값이 없습니다."<<endl;
		return;
	}
	else if (GetTail() == NULL) {
		cout << "삭제할 값이 없습니다." << endl;
		return;
	}
	if (GetHead()->b_link == NULL) {
		Node* Head = GetHead();
		//Head->data == NULL;
		delete(Head);

		//SetHead(NULL);
		SetHead(NULL);
		cout << "마지막 노드입니다."<<endl;
		

		/*Node* Head = GetHead();
		delete(Head); // delete?
		cout << "마지막 노드를 삭제했습니다. 리스트가 비었습니다."; //마지막 노드일 때
		*/
		return;
		//exit(-1);
	}
	Node* Head = GetHead();
	Node* nextHead = GetHead()->b_link;
	//Head->data == NULL;
	delete(Head);
	
	//SetHead(NULL);
	SetHead(nextHead);
	PrintData();
}

// 테일에서 삭제
void CMyListEx::Delete_tail() {
	

	if (GetTail() == NULL) {
		cout << "삭제할 값이 없습니다." << endl;
		return;
	} else if(GetHead() == NULL) {
		cout << "삭제할 값이 없습니다." << endl;
		return;
	}
	if (GetTail()->f_link == NULL) {
		Node* Tail = GetTail();
		//Head->data == NULL;
		delete(Tail);

		//SetHead(NULL);
		SetTail(NULL);
		//Delete_list();
		cout << "마지막 노드입니다."<<endl;
		return;

		/*Node* Head = GetHead();
		delete(Head); // delete?
		cout << "마지막 노드를 삭제했습니다. 리스트가 비었습니다."; //마지막 노드일 때
		*/
		//exit(-1);
	}
	
	//Head->data == NULL;
	Node* Tail = GetTail();
	Node* beforTail = GetTail()->f_link;
	delete(Tail);

	//SetHead(NULL);
	SetTail(beforTail);
	
	Print_tail();
}

// 헤드에서 데이터 출력
void CMyListEx::Print_head()
{
	CMyList::PrintData();
}



// 테일에서 데이터 출력
void CMyListEx::Print_tail()
{
	int count = 0;
	Node* tail = GetTail();
	Node* head = GetHead();
	if (head == nullptr) {
		cout << "출력할 데이터가 없습니다." << endl;
	}
	else {
		cout << "\nCMyList 데이터 : ";
		cout << "[Tail] ";
		while (tail) {
			if (tail->f_link) {
				cout << tail->data << " - ";
			}
			else {
				cout << tail->data;
				count++;
				break;
			}
			tail = tail->f_link;
			count++;
		}
		cout << " [Head]" << endl;
		cout << "데이터 개수 : " << count << "개\n" << endl;
	}
}

// 동적 할당 해제
void CMyListEx::Delete_list() {
	while (GetHead()!=NULL||GetTail() != NULL) {
		cout << "null 아임" << endl;
		Node* Head = GetHead();
		if (GetHead()->b_link != NULL) {
			Node* nextNode = GetHead()->b_link;
			delete(Head);
			SetHead(nextNode);
			break;
		}
		else {
			delete(Head);
			exit(-1);
		}	
	}
	exit(-1);
}


int CMyListEx::PrintMenu()
{
	int num;
	cout << "------------" << endl;
	cout << "CMyList 메뉴" << endl;
	cout << "1 Head에 삽입" << endl;
	cout << "2 Tail에 삽입" << endl;
	cout << "3 Head에서 삭제" << endl;
	cout << "4 Tail에서 삭제" << endl;
	cout << "5 Head->Tail 출력" << endl;
	cout << "6 Tail->Head 출력" << endl;
	cout << "7 list 값 더하기" << endl;
	cout << "0 종료" << endl;
	cout << "------------" << endl;
	cout << "메뉴를 고르세요(숫자 입력) : " << endl;
	cin >> num;
	return num;
}
/*
static int PrintMenu() {
	
}*/
// 메뉴 출력
/*
int CMyListEx::PrintMenu()
{
	int num;
	cout << "------------" << endl;
	cout << "CMyList 메뉴" << endl;
	cout << "1 Head에 삽입" << endl;
	cout << "2 Tail에 삽입" << endl;
	cout << "3 Head에서 삭제" << endl;
	cout << "4 Tail에서 삭제" << endl;
	cout << "5 Head->Tail 출력" << endl;
	cout << "6 Tail->Head 출력" << endl;
	cout << "0 종료" << endl;
	cout << "------------" << endl;
	cout << "메뉴를 고르세요(숫자 입력) : " << endl;
	cin >> num;
	return num;
}*/
