#include "CMyListEx.h"
/*
CMyListEx::CMyListEx(int num)
{
	CMyList::Insert(num);
}*/

void CMyListEx::TestV()
{
	//cout << "�ڽ�, ����";
	int sum = 0;
	Node* tail = GetTail();
	Node* head = GetHead();
	if (head == nullptr) {
		cout << "list�� ���� ���� �����ϴ�." << endl;
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
		cout << "���� " <<sum << endl;
	}
	//cout << "��忡�� ������ �ڽ� Ŭ������ CMyListEx���� �̷�����ϴ�." << endl;
}

void CMyListEx::TestNow() // virtual �θ� �޼ҵ� ȣ��
{
	CMyList::Test(); // �ڽ��� ȣ���� �ȵ�
}

//���Ͽ��� ����
void CMyListEx::Insert_tail(Data data)
{
	CMyList::Insert(data);
}

//��忡�� ����
void CMyListEx::Insert_head(Data num)
{
	Node* newNode = new Node;

	newNode->data = num;
	newNode->b_link = nullptr;
	newNode->f_link = nullptr;

	if (GetTail() == nullptr) {
		cout << "tail ����";
		SetTail(newNode);
	}
		
	else {
		cout << "tail �ξƴ�";
		GetHead()->f_link = newNode;
		newNode->b_link = GetHead();
	}
	SetHead(newNode);
	PrintData();
}


// ��忡�� ����
void CMyListEx::Delete_head() {
	if (GetHead() == nullptr) {
		cout << "������ ���� �����ϴ�."<<endl;
		return;
	}
	else if (GetTail() == NULL) {
		cout << "������ ���� �����ϴ�." << endl;
		return;
	}
	if (GetHead()->b_link == NULL) {
		Node* Head = GetHead();
		//Head->data == NULL;
		delete(Head);

		//SetHead(NULL);
		SetHead(NULL);
		cout << "������ ����Դϴ�."<<endl;
		

		/*Node* Head = GetHead();
		delete(Head); // delete?
		cout << "������ ��带 �����߽��ϴ�. ����Ʈ�� ������ϴ�."; //������ ����� ��
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

// ���Ͽ��� ����
void CMyListEx::Delete_tail() {
	

	if (GetTail() == NULL) {
		cout << "������ ���� �����ϴ�." << endl;
		return;
	} else if(GetHead() == NULL) {
		cout << "������ ���� �����ϴ�." << endl;
		return;
	}
	if (GetTail()->f_link == NULL) {
		Node* Tail = GetTail();
		//Head->data == NULL;
		delete(Tail);

		//SetHead(NULL);
		SetTail(NULL);
		//Delete_list();
		cout << "������ ����Դϴ�."<<endl;
		return;

		/*Node* Head = GetHead();
		delete(Head); // delete?
		cout << "������ ��带 �����߽��ϴ�. ����Ʈ�� ������ϴ�."; //������ ����� ��
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

// ��忡�� ������ ���
void CMyListEx::Print_head()
{
	CMyList::PrintData();
}



// ���Ͽ��� ������ ���
void CMyListEx::Print_tail()
{
	int count = 0;
	Node* tail = GetTail();
	Node* head = GetHead();
	if (head == nullptr) {
		cout << "����� �����Ͱ� �����ϴ�." << endl;
	}
	else {
		cout << "\nCMyList ������ : ";
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
		cout << "������ ���� : " << count << "��\n" << endl;
	}
}

// ���� �Ҵ� ����
void CMyListEx::Delete_list() {
	while (GetHead()!=NULL||GetTail() != NULL) {
		cout << "null ����" << endl;
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
	cout << "CMyList �޴�" << endl;
	cout << "1 Head�� ����" << endl;
	cout << "2 Tail�� ����" << endl;
	cout << "3 Head���� ����" << endl;
	cout << "4 Tail���� ����" << endl;
	cout << "5 Head->Tail ���" << endl;
	cout << "6 Tail->Head ���" << endl;
	cout << "7 list �� ���ϱ�" << endl;
	cout << "0 ����" << endl;
	cout << "------------" << endl;
	cout << "�޴��� ������(���� �Է�) : " << endl;
	cin >> num;
	return num;
}
/*
static int PrintMenu() {
	
}*/
// �޴� ���
/*
int CMyListEx::PrintMenu()
{
	int num;
	cout << "------------" << endl;
	cout << "CMyList �޴�" << endl;
	cout << "1 Head�� ����" << endl;
	cout << "2 Tail�� ����" << endl;
	cout << "3 Head���� ����" << endl;
	cout << "4 Tail���� ����" << endl;
	cout << "5 Head->Tail ���" << endl;
	cout << "6 Tail->Head ���" << endl;
	cout << "0 ����" << endl;
	cout << "------------" << endl;
	cout << "�޴��� ������(���� �Է�) : " << endl;
	cin >> num;
	return num;
}*/
