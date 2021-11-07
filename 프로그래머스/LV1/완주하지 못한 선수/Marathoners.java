package programmers_해시_완주하지못한선수;

import java.util.Arrays;
import java.util.HashMap;
public class Marathoners {

	public static void main(String[] args) {
		String[] participant = new String[] {"mislav", "stanko", "mislav", "ana"};
		String[] completion = new String[] {"stanko", "ana", "mislav"};
		
		System.out.println("답: "+findPlayerDidntFinishRace(participant, completion));
	}

	public static String findPlayerDidntFinishRace(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String man : participant) {
        	map.put(man, map.getOrDefault(man, 0)+1);
        }
        
        for(String man : completion) {
        	map.put(man, map.get(man)-1);
        }

        for(String key : map.keySet()) {
        	if(map.get(key)>0) {
        		answer = key;
        		break;
        	}
        }
        
        return answer;
    }
	
	public static String findPlayerBySorting(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		int i = 0;
		for(i=0; i<completion.length; i++) {
			if(!participant[i].equals(completion[i]))
				break;
		}
		
		return participant[i];
	}
}
