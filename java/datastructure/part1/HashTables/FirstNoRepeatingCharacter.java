package part1.HashTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstNoRepeatingCharacter {


    public char fistNonRepeatingCharacter_v1(String input){

        for (int i = 0; i < input.length(); i++) {
            int count=0;
            for (int j = 0; j < input.length(); j++) {
                if (input.toCharArray() [i]==input.toCharArray()[j])
                    count++;
            }
            if (count==1)
                return input.toCharArray()[i];
        }
        return 'a';
    }
    public char fistNonRepeatingCharacter_v2(String input){

        HashMap<Character,Integer> map = new HashMap<>();
        for (Character ch : input.toCharArray()) {
          map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (char ch :input.toCharArray()) {
            if(map.get(ch)==1)
                return ch;
        }
        return Character.MIN_VALUE;
    }
    public static void main(String[] args) {
    FirstNoRepeatingCharacter f = new FirstNoRepeatingCharacter();
        List<Integer> l = new ArrayList<>();
        l.add(12);
        l.add(1_000_000_000);
        System.out.println(l);

       // System.out.println(f.fistNonRepeatingCharacter_v1("alassaneln"));
    }
}
