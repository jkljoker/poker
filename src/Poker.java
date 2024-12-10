import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker {
    //初始化牌
    //"3" "4" "5" "6" "7" "8" "9" "10" "J" "Q" "K" "A" "2"
    static List<String> list = new ArrayList<>();
    static {
        String[] arr = new String[]{"♠", "♥", "♦", "♣"};
        String[] arr2 = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                list.add(arr[i] + arr2[j]);
            }
        }
        list.add("大王");
        list.add("小王");
    }

    public Poker() {
        //洗牌
        Collections.shuffle(list);

        //发牌
        List<String> lord = new ArrayList<>();
        List<String> gamer1 = new ArrayList<>();
        List<String> gamer2 = new ArrayList<>();
        List<String> gamer3 = new ArrayList<>();

        int count = list.size();
        for (int i = 0; i < count; i++) {
            if (i <= 2) {
                lord.add(list.get(i));
            } else if ((i + 1) % 3 == 1) {
                gamer1.add(list.get(i));
            } else if ((i + 1) % 3 == 2) {
                gamer2.add(list.get(i));
            } else if ((i + 1) % 3 == 0) {
                gamer3.add(list.get(i));
            }
        }

        //看牌
        System.out.println("lord:" + loojPoker(lord));
        System.out.println("gamer1:" + loojPoker(gamer1));
        System.out.println("gamer2:" + loojPoker(gamer2));
        System.out.println("gamer3:" + loojPoker(gamer3));
    }

    private String loojPoker(List<String> gamer) {
        StringBuilder sb = new StringBuilder();
        for (String s : gamer) {
            sb.append(s);
        }
        return sb.toString();
    }
}
