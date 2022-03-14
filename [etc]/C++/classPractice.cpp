#include <stdio.h>
#include	<iostream>
using	namespace	std;
#define NUM 10
#define SNUM 6
class CMyDataArr
{
public:
    CMyDataArr(int	num) {
        m_pnArr = new int[num];
    }
    ~CMyDataArr() {
        delete[]	m_pnArr;
    }
    void Insert(int m_pn) {
        
        m_pnArr[count] = m_pn;
        count++;
    }
    void PrintData() {
        cout << "전체 데이터 : ";
        for (int i=0; i < NUM; i++) {
            cout  << m_pnArr[i] << " ";
        }
        cout << "[ " << count << "/ 10 개 ]";
    }

private:
    int* m_pnArr;
    //int m_pnArr[10] //정적
    int count = 0;
};

class CMyStrArr {
public:
    CMyStrArr(int num) {
        m_pszStr = new char*[num];
    }
    ~CMyStrArr() {
        delete[] m_pszStr;
    }
    void Insert(const char* m_pn) {

        m_pszStr[sount] = (char*)m_pn;
        sount++;
    }
    void PrintData() {
        cout << endl << "전체 데이터"<<endl;
        for (int i = 0; i < SNUM; i++) {
            cout << i<< " : " <<m_pszStr[i] << endl;
        }
        cout << "[ " << sount << " / 6 개 ]";
    }
private:
    char** m_pszStr;
    int sount;
};

int main()
{
    CMyDataArr arr(NUM);
    // CMyDataArr arr; //정적

    arr.Insert(10);
    arr.Insert(96);
    arr.Insert(-45);
    arr.Insert(90);
    arr.Insert(-21);
    arr.Insert(100);
    arr.Insert(63);
    arr.Insert(28);
    arr.Insert(14);
    arr.Insert(48);
    arr.PrintData();

    CMyStrArr	arr1(SNUM);
    arr1.Insert("월요일마다고고"); //const char* 형
    arr1.Insert("가나다123");
    arr1.Insert("홍길동	abc");
    arr1.Insert("함수형	!!");
    arr1.Insert("알고리즘	zzz");
    arr1.Insert("Tasla	Linux");
    arr1.PrintData();


    return 0;
}
