package complete;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// gpt 도움
public class week2_1966 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt(); // 문서 수
            int targetIndex = scanner.nextInt(); // 목표 문서의 인덱스
            Queue<int[]> q = new LinkedList<>(); // 문서의 우선순위와 인덱스를 저장할 큐

            // 문서 우선 순위 입력
            for (int j = 0; j < k; j++) {
                int priority = scanner.nextInt(); // 문서의 우선 순위
                q.add(new int[]{priority, j}); // 우선 순위와 인덱스를 큐에 저장
            }

            System.out.println(m(q, targetIndex)); // 결과 출력
        }

        scanner.close();
    }

    public static int m(Queue<int[]> q, int targetIndex) {
        int count = 0; // 인쇄된 문서 수

        while (!q.isEmpty()) {
            int[] first = q.poll(); // 큐의 앞 문서 꺼내기
            boolean hasHigherPriority = false;

            // 현재 문서보다 우선 순위가 높은 문서가 있는지 체크
            for (int[] document : q) {
                if (document[0] > first[0]) {
                    hasHigherPriority = true; // 더 높은 우선 순위 문서가 있음
                    break;
                }
            }

            // 우선 순위가 높은 문서가 있다면 다시 큐에 추가
            if (hasHigherPriority) {
                q.add(first); // 가장 뒤로 이동
            } else {
                count++; // 인쇄 카운트 증가
                // 현재 문서가 목표 문서라면 카운트 리턴
                if (first[1] == targetIndex) { // 인덱스 비교
                    return count; // 몇 번째로 인쇄되었는지 반환
                }
            }
        }
        return -1; // 이 코드는 실행되지 않음
    }
}
