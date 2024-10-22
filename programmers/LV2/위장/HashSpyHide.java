package programmers_해시_위장;

import java.util.HashMap;

public class HashSpyHide {
	
	public static int clothesCount(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i= 0; i < clothes.length; i++) {
			String key = clothes[i][1];
			
			map.put(key,map.getOrDefault(key, 0)+1);
		}
		
		
		int answer=1;
		
		for (String key : map.keySet()) {
			answer *= (map.get(key)+1);
		}
		return answer - 1;
	}
	
	public static void main(String[] args) {
		String[][] clothes = new String[][] {
			{"yellowhat", "headgear"}, 
			{"bluesunglasses", "eyewear"}, 
			{"green_turban", "headgear"}
		};
		clothesCount(clothes);
	}

}