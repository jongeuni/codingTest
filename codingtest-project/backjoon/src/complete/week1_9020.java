package complete;

import java.util.*;

public class week1_9020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            list.add(sc.nextInt());
        }

        int maxInput = Collections.max(list);
        ArrayList<Integer> primes = getPrimes(maxInput);
        for (int num : list) {
            gold(num, primes);
        }
    }

    public static ArrayList<Integer> getPrimes(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i<=num; i++) {
            for(int j = 2; j<=Math.floor(Math.sqrt(i)+1); j++) {
                if(j == Math.floor(Math.sqrt(i)+1) ) {
                    list.add(i);
                }
                if(i % j == 0) {
                    break;
                }
            }
        }
        return list;
    }

    public static void gold(int num, ArrayList<Integer> list) {
        // num 까지의 소수를 모두 리스트에 담는다.
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            if(i > num) {
                break;
            }
            for (Integer integer : list) {
                if(integer>num) {
                    break;
                }
                if (list.get(i) + integer == num) {
                    if(map.containsKey(Math.abs(integer - list.get(i)))) {
                        continue;
                    }

                    map.put(Math.abs(integer - list.get(i)), new int[]{list.get(i), integer});
                }
            }
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        int[] nums = map.get(keySet.get(0));
        System.out.println(nums[0] +" "+nums[1]);
    }

}
