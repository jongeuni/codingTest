package complete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 재귀_17478 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

        List<String> chats = new ArrayList<>();
        chats.add("\"재귀함수가 뭔가요?\"");
        chats.add("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        chats.add("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        chats.add("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        self(n, chats, 0);
    }

    public static void self(int n, List<String> chats, int dashCount) {

        String dash = "_".repeat(dashCount);
        if(n==0) {
            System.out.println(dash + "\"재귀함수가 뭔가요?\"");
            System.out.println(dash + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(dash + "라고 답변하였지.");
            return;
        }

        chats.forEach(chat -> {
            System.out.println(dash+chat);
        });

        self(n-1, chats, dashCount + 4);

        System.out.println(dash + "라고 답변하였지.");
    }
}