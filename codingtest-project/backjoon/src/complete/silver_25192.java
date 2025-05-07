package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class silver_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int chatCount = Integer.parseInt(br.readLine());

        String[] chats = new String[chatCount];

        Set<String> uniqueUsers = new HashSet<>();
        int gomgomCount = 0;
        for(int i = 0; i < chatCount; i++){
            chats[i] = br.readLine();


            if(chats[i].equals("ENTER")) {
                uniqueUsers.clear();
            } else {
                if(!uniqueUsers.contains(chats[i])) {
                    uniqueUsers.add(chats[i]);
                    gomgomCount++;
                }
            }
        }

        System.out.println(gomgomCount);
    }
}
