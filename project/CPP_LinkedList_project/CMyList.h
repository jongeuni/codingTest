#pragma once
#include <iostream>
using namespace std;

typedef int Data;
struct Node
{
	Data data;
	Node* f_link;
	Node* b_link;
};

class CMyList
{
public:
	CMyList() {}
	~CMyList() { // ��� ��ü ���� (�޸� ����)
	}
	void Insert(Data num);	// ���ο� ��� ����(�޸� �Ҵ�) �� link ����
	void PrintData();
	bool Search(Data num);
	//int PrintMenu();

	 void Test(); //�����Լ�

	 virtual void TestV();

	static int PrintMenu();
	Node* GetHead() const;
	void SetHead(Node* tmp);
	Node* GetTail() const;
	void SetTail(Node* tmp);
	//int GetLength() const;
	//void SetLength(int num);

private:
	Node* pHead = nullptr;
	Node* pTail = nullptr;
	int m_nLength = 0;
};