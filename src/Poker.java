import java.util.*;

public class Poker {
    //初始化牌
    //花色："♦", "♣", "♥", "♠"
    //牌面大小："3" "4" "5" "6" "7" "8" "9" "10" "J" "Q" "K" "A" "2" "小王" "大王"
    //用于比较大小的牌库，因为不用排序所以使用HashMap
    static HashMap<Integer, String> deck = new HashMap<>();
    //用于打乱的牌库,根据索引来从deck中获取牌
    static ArrayList<Integer> list = new ArrayList<>();
    static {
        String[] arr = new String[]{"♦", "♣", "♥", "♠"};
        String[] arr2 = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int number = 0;
        for (String s : arr2) {
            for (String string : arr) {
                String temp = s + string;
                list.add(number);
                deck.put(number, temp);
                number++;
            }
        }
        list.add(number);
        deck.put(number, "小王");
        number++;
        list.add(number);
        deck.put(number, "大王");
    }

    public Poker() {
        //洗牌,打乱牌序
        Collections.shuffle(list);
        //发牌
        //三个玩家和一个lord
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> gamer1 = new TreeSet<>();
        TreeSet<Integer> gamer2 = new TreeSet<>();
        TreeSet<Integer> gamer3 = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (i <= 2) {
                lord.add(list.get(i));
            } else if (i % 3 == 0) {
                gamer1.add(list.get(i));
            } else if (i % 3 == 1) {
                gamer2.add(list.get(i));
            } else {
                gamer3.add(list.get(i));
            }
        }
        //看牌
        lookPoker("lord", lord);
        lookPoker("gamer1", gamer1);
        lookPoker("gamer2", gamer2);
        lookPoker("gamer3", gamer3);
    }
    private void lookPoker(String name, TreeSet<Integer> list) {
        System.out.print(name + ":");
        for (int i : list) {
            System.out.print(deck.get(i));
        }
        System.out.println();
    }
}
