#include <iostream>
#include "CMyListEx.h"

using namespace std;
int main() {
	int first;
	Data arr[5];
	cout << "����Ʈ �ʱ�ȭ�� ������ �Ŷ�� 1, �ƴ϶�� 0�� �Է��� �ּ���. �ٸ� ���ڸ� ���� �� �����մϴ�.";
	cin >> first;
	if (first == 1) {
		cout << "����Ʈ �ʱ�ȭ�� �����մϴ�. Tail���� �������� ����˴ϴ�. ���ϴ� ���ڸ� �ټ� �� �Է��� �ּ���.";
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
				cout << "\n������ �����͸� �Է����ּ���: ";
				cin >> data;
				if (myListex->Search(data) == true) {
					cout << data << "�� �ߺ��Դϴ�!" << endl;
				}
				else {
					myListex->Insert_head(data);
				}
				break;
			case 2:
				List2->Test(); //
				cout << "\n������ �����͸� �Է����ּ���: ";
				cin >> data;
				if (myListex->Search(data) == true) {
					cout << data << "�� �ߺ��Դϴ�!" << endl;
				}
				else {
					myListex->Insert(data);
				}
				break;
			case 3:
				myListex->Delete_head(); // ��忡�� ����
				break;
			case 4:
				myListex->Delete_tail(); // ���Ͽ��� ����
				break;
			case 5:
				myListex->Print_head(); // ������ ������ ���
				break;
			case 6:
				myListex->Print_tail(); // ���Ϻ��� ������ ���
				break;
			case 0:
				myListex->Delete_list(); // ���� �Ҵ� ����
				cout << "�����մϴ�.";
				delete myListex;
				delete List1;
				delete List2;
				return 0;
			default:
				cout << "0, 1, 2 �� ���ڸ� �Է��ϼ���~!" << endl;
				continue;
			}
		}

		// ����Ʈ �ʱ�ȭ ������
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
				cout << "\n������ �����͸� �Է����ּ���: ";
				cin >> data;
				if (myListex->Search(data) == true) {
					cout << data << "�� �ߺ��Դϴ�!" << endl;
				}
				else {
					myListex->Insert_head(data);
				}
				break;
			case 2:
				
				//List2->Test(); //
				cout << "\n������ �����͸� �Է����ּ���: ";
				cin >> data;
				if (myListex->Search(data) == true) {
					cout << data << "�� �ߺ��Դϴ�!" << endl;
				}
				else {
					myListex->Insert(data);
				}
				break;
			case 3:
				myListex->Delete_head(); // ��忡�� ����
				break;
			case 4:
				myListex->Delete_tail(); // ���Ͽ��� ����
				break;
			case 5:
				myListex->Print_head(); // ������ ������ ���
				break;
			case 6:
				myListex->Print_tail(); // ���Ϻ��� ������ ���
				break;
			case 7:
				myListex->TestNow(); // �����Լ�
				break;
			case 0:
				myListex->Delete_list(); // ���� �Ҵ� ����
				cout << "�����մϴ�.";
				delete myListex;
				delete List1;
				delete List2;
				return 0;
			default:
				cout << "0, 1, 2 �� ���ڸ� �Է��ϼ���~!" << endl;
				continue;
			}
		}
		// ��� ����
	}
	else {
		cout << "�����մϴ�.";
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
			cout << "\n������ �����͸� �Է����ּ���: ";
			cin >> data;
			if (myListex->Search(data) == true) {
				cout << data << "�� �ߺ��Դϴ�!" << endl;
			}
			else {
				myListex->Insert_head(data);
			}
			break;
		case 2:
			List2->Test(); //
			cout << "\n������ �����͸� �Է����ּ���: ";
			cin >> data;
			if (myListex->Search(data) == true) {
				cout << data << "�� �ߺ��Դϴ�!" << endl;
			}
			else {
				myListex->Insert(data);
			}
			break;
		case 3:
			myListex->Delete_head(); // ��忡�� ����
			break;
		case 4:
			myListex->Delete_tail(); // ���Ͽ��� ����
			break;
		case 5:
			myListex->Print_head(); // ������ ������ ���
			break;
		case 6:
			myListex->Print_tail(); // ���Ϻ��� ������ ���
			break;
		case 0:
			myListex->Delete_list(); // ���� �Ҵ� ����
			cout << "�����մϴ�.";
			delete myListex;
			delete List1;
			delete List2;
			return 0;
		default:
			cout << "0, 1, 2 �� ���ڸ� �Է��ϼ���~!" << endl;
			continue;
		}
	}*/
	return 0;
}
