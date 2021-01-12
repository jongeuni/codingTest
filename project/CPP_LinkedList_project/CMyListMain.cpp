#include <iostream>
#include "CMyListEx.h"

using namespace std;
int main() {
	int first;
	Data arr[5];
	cout << "리스트 초기화를 진행할 거라면 1, 아니라면 0을 입력해 주세요. 다른 숫자를 누를 시 종료합니다.";
	cin >> first;
	if (first == 1) {
		cout << "리스트 초기화를 진행합니다. Tail에서 삽입으로 진행됩니다. 원하는 숫자를 다섯 개 입력해 주세요.";
		for (int i=0; i < 5; i++) {
			cin >> arr[i];
		}
		CMyListEx* myListex = new CMyListEx(arr);
		CMyList* List1 = new CMyList;
		CMyList* List2 = new CMyListEx;
		int menu;
		Data data;
		
		while (1) {
			switch (myListex->PrintMenu())
			{
			case 1:
				List1->Test(); //
				cout << "\n삽입할 데이터를 입력해주세요: ";
				cin >> data;
				if (myListex->Search(data) == true) {
					cout << data << "는 중복입니다!" << endl;
				}
				else {
					myListex->Insert_head(data);
				}
				break;
			case 2:
				List2->Test(); //
				cout << "\n삽입할 데이터를 입력해주세요: ";
				cin >> data;
				if (myListex->Search(data) == true) {
					cout << data << "는 중복입니다!" << endl;
				}
				else {
					myListex->Insert(data);
				}
				break;
			case 3:
				myListex->Delete_head(); // 헤드에서 삭제
				break;
			case 4:
				myListex->Delete_tail(); // 테일에서 삭제
				break;
			case 5:
				myListex->Print_head(); // 헤드부터 데이터 출력
				break;
			case 6:
				myListex->Print_tail(); // 테일부터 데이터 출력
				break;
			case 0:
				myListex->Delete_list(); // 동적 할당 해제
				cout << "종료합니다.";
				delete myListex;
				delete List1;
				delete List2;
				return 0;
			default:
				cout << "0, 1, 2 중 숫자를 입력하세요~!" << endl;
				continue;
			}
		}

		// 리스트 초기화 생성자
	}
	else if (first == 0) {
		CMyList* List1 = new CMyList;
		CMyList* List2 = new CMyListEx;
		int menu;
		Data data;
		CMyListEx* myListex = new CMyListEx();
		while (1) {
			switch (myListex->PrintMenu())
			{
			case 1:
				cout << "\n삽입할 데이터를 입력해주세요: ";
				cin >> data;
				if (myListex->Search(data) == true) {
					cout << data << "는 중복입니다!" << endl;
				}
				else {
					myListex->Insert_head(data);
				}
				break;
			case 2:
				
				//List2->Test(); //
				cout << "\n삽입할 데이터를 입력해주세요: ";
				cin >> data;
				if (myListex->Search(data) == true) {
					cout << data << "는 중복입니다!" << endl;
				}
				else {
					myListex->Insert(data);
				}
				break;
			case 3:
				myListex->Delete_head(); // 헤드에서 삭제
				break;
			case 4:
				myListex->Delete_tail(); // 테일에서 삭제
				break;
			case 5:
				myListex->Print_head(); // 헤드부터 데이터 출력
				break;
			case 6:
				myListex->Print_tail(); // 테일부터 데이터 출력
				break;
			case 7:
				myListex->TestNow(); // 가상함수
				break;
			case 0:
				myListex->Delete_list(); // 동적 할당 해제
				cout << "종료합니다.";
				delete myListex;
				delete List1;
				delete List2;
				return 0;
			default:
				cout << "0, 1, 2 중 숫자를 입력하세요~!" << endl;
				continue;
			}
		}
		// 계속 진행
	}
	else {
		cout << "종료합니다.";
	}
	
	//CMyListEx* myListex = new CMyListEx(num);
	/*CMyListEx* myListex = new CMyListEx();
	CMyList* List1 = new CMyList;
	CMyList* List2 = new CMyListEx;
	int menu;
	Data data;*/
	/*
	while (1) {
		switch (myListex->PrintMenu())
		{
		case 1:
			List1->Test(); //
			cout << "\n삽입할 데이터를 입력해주세요: ";
			cin >> data;
			if (myListex->Search(data) == true) {
				cout << data << "는 중복입니다!" << endl;
			}
			else {
				myListex->Insert_head(data);
			}
			break;
		case 2:
			List2->Test(); //
			cout << "\n삽입할 데이터를 입력해주세요: ";
			cin >> data;
			if (myListex->Search(data) == true) {
				cout << data << "는 중복입니다!" << endl;
			}
			else {
				myListex->Insert(data);
			}
			break;
		case 3:
			myListex->Delete_head(); // 헤드에서 삭제
			break;
		case 4:
			myListex->Delete_tail(); // 테일에서 삭제
			break;
		case 5:
			myListex->Print_head(); // 헤드부터 데이터 출력
			break;
		case 6:
			myListex->Print_tail(); // 테일부터 데이터 출력
			break;
		case 0:
			myListex->Delete_list(); // 동적 할당 해제
			cout << "종료합니다.";
			delete myListex;
			delete List1;
			delete List2;
			return 0;
		default:
			cout << "0, 1, 2 중 숫자를 입력하세요~!" << endl;
			continue;
		}
	}*/
	return 0;
}
