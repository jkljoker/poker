package joker2;

import javax.print.DocFlavor;
import java.util.*;

public class Poker {
    //牌库
    static ArrayList<String> list = new ArrayList<>();
    //这个包使用另外一种方法对玩家手中的牌进行排序，hm中的value用于判断大小
    static HashMap<String, Integer> hm = new HashMap<>();
    //初始化牌库
    static {
        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("小王", 16);
        hm.put("大王", 17);

        String[] arr = new String[]{"♦", "♣", "♥", "♠"};
        String[] arr2 = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String s : arr) {
            for (String string : arr2) {
                list.add(s + string);
            }
        }
        list.add(" 小王");
        list.add(" 大王");
    }

    public Poker() {
        //洗牌
        Collections.shuffle(list);
        //发牌
        //三个玩家和一个lord
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> gamer1 = new ArrayList<>();
        ArrayList<String> gamer2 = new ArrayList<>();
        ArrayList<String> gamer3 = new ArrayList<>();
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
        //对玩家的手牌进行排序
        order(lord);
        order(gamer1);
        order(gamer2);
        order(gamer3);

        //查看手牌
        lookPoker("lord", lord);
        lookPoker("gamer1", gamer1);
        lookPoker("gamer2", gamer2);
        lookPoker("gamer3", gamer3);
    }

    private void order(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //计算o1和o2的价值
                int a = checkPoker(o1.substring(1));
                int b = checkPoker(o2.substring(1));
                //获得花色
                String c = o1.substring(0, 1);
                String d = o2.substring(0, 1);
                int i = a - b;
                //若价值相同，则根据花色判断大小
                return i == 0 ? c.compareTo(d) : i;
            }
        });
    }

    private int checkPoker(String s) {//用于判断手牌对应的数字
        if (hm.containsKey(s)) {//如何hm中有这个key，则返回value
            return hm.get(s);
        } else {//如果hm没有，则说明这个字符就是数字，转换成int类型直接返回
            return Integer.parseInt(s);
        }
    }

    private void lookPoker(String name, ArrayList<String> list) {//查看手牌
        System.out.print(name + ":");
        for (String s : list) {
            System.out.print(s + ",");
        }
        System.out.println();
    }
}
