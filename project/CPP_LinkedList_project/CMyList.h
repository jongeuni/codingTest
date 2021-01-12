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
	~CMyList() { // 노드 전체 삭제 (메모리 해제)
	}
	void Insert(Data num);	// 새로운 노드 생성(메모리 할당) 및 link 연결
	void PrintData();
	bool Search(Data num);
	//int PrintMenu();

	 void Test(); //가상함수

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