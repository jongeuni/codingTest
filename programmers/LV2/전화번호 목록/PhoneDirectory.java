package programmers_�ؽ�_��ȭ��ȣ���;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {

	public static void main(String[] args) {
		String[] phoneDir = new String[] {"119", "97674223", "1195524421"};
		prefixCheck(phoneDir);
	}
	public static boolean prefixCheck(String[] phoneDir) {
		Map<String, String> newPhoneDir = new HashMap<>();
		for(String phoneNum: phoneDir) {
			newPhoneDir.put(phoneNum, phoneNum);
		}
		
		for(String check : phoneDir) {
			for(int i=0; i<check.length(); i++) {
				if(newPhoneDir.containsKey(check.substring(0,i))) {
					return false;
				}
			}
		}
		return true;
    }
	
	// ȿ���� �׽�Ʈ ����
	public boolean prefixCheckUseList(String[] phoneDir) {
		List<String> newPhoneDir = new ArrayList<>();
		for(String phoneNum: phoneDir) {
			newPhoneDir.add(phoneNum);
		}
		for(String check : phoneDir) {
			for(int i=0; i<check.length(); i++) {
				if(newPhoneDir.contains(check.substring(0,i))) {
					return false;
				}
			}
		}
		return true;
	}
}
