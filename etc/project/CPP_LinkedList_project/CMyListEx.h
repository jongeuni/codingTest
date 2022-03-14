#pragma once
#include "CMyList.h"
class CMyListEx :
	public CMyList
{
public:
	CMyListEx() {}
	CMyListEx(Data* arr) {

		for (int i = 0; i < 5; i++) {

			CMyList::Insert(arr[i]);

		}

		cout << "리스트 초기화 완료.";
	}
	/*
	CMyListEx(Data *arr) {
		for (int i = 0; i < 5; i++) {
			Node* newNode = new Node;

			newNode->data = arr[i];
			newNode->b_link = nullptr;
			newNode->f_link = nullptr;

			if (GetHead() == nullptr)
				SetHead(newNode);
			else {
				GetTail()->b_link = newNode;
				newNode->f_link = GetTail();
			}
			SetTail(newNode);
			//CMyList::Insert(arr[i]);
		}
		cout << "리스트 초기화 완료.";
	}*/
	~CMyListEx() {}

	void TestV();
	void TestNow(); // virtual 호출하는

	void Insert_tail(int num);	// 새로운 노드 생성(메모리 할당) 및 link 연결
	void Insert_head(int num);
	void Delete_head();
	void Delete_tail();
	void Print_tail();
	void Print_head();
	void Delete_list();

	static int PrintMenu();
};