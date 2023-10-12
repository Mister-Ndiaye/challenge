package part2.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Test {
    public static void main(String[] args) {
        String path = "C:\\Users\\SNNDIAYEA.SRV-AD01\\Videos\\Mosh\\Design Pattern\\The Ultimate Design Patterns Part 1\\aims.txt";
        var tab =  path.split("\\\\");
        tab[tab.length-1]="cipher.txt";
        StringJoiner joiner = new StringJoiner("\\\\");
        for (String part:tab) {
            joiner.add(part);
        }

        System.out.println(joiner);
        System.out.println(Arrays.toString(tab));
    }
}
