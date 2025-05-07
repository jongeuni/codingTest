package complete;

import java.util.*;

public class week1_15649 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = sc.nextInt();

        int[] arr = createNArr(n);

        self(arr, new ArrayList<>(), count);

    }

    public static int[] createNArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static void self(int[] arr, List<Integer> printArr, int count) {

        for (int i = 0; i < arr.length; i++) {
            List<Integer> newArr = createNewArr(arr, count, i);
            List<Integer> newPrintArr = new ArrayList<>(printArr);
            newPrintArr.add(arr[i]);

            if(newPrintArr.size() == count) {
                print(newPrintArr);
                return;
            }

            self(listToArray(newArr), newPrintArr, count);
        }
    }

    public static List<Integer> createNewArr(int[] arr, int count, int i) {
        List<Integer> newArr = new ArrayList<>();

        // arr[i] 인덱스의 값을 제외한 숫자로 리스트를 만들고 싶음

        for(int j = 0; j < arr.length; j++) {
            if(j != i) {
                newArr.add(arr[j]);
            }
        }
        return newArr;
    }

    public static int[] listToArray(List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public static void print(List<Integer> arr) {
        arr.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

}
