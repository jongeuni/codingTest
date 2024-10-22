package beakjoon_1931;

import java.util.Arrays;
import java.util.Scanner;

// ȸ�ǽ� ���� ����
class EfficientMeeting {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int cnt = 0;
		int finishTime = 0;
		
		int[][] arr = new int[num][2];
		
		for (int i = 0; i<num; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, (o1, o2)->{
			if(o1[1]==o2[1])
				return Integer.compare(o1[0], o2[0]);
			return Integer.compare(o1[1], o2[1]);
		});
		
		for(int j = 0; j<num; j++) {
			if(finishTime <= arr[j][0]) {
				cnt++;
				finishTime = arr[j][1];
			}
		}

		System.out.println(cnt);
		
		sc.close();
	}

}
