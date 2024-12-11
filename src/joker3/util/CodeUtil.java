package joker3.util;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {

    public static String getCode(){
        //获得验证码
        StringBuilder sb = new StringBuilder();
        char[] c = new char[5];
        Random r = new Random();
        int count = 0;
        c[count++] = (char) ('a' + r.nextInt(26));
        c[count++] = (char) ('a' + r.nextInt(26));
        c[count++] = (char) ('0' + r.nextInt(10));
        c[count++] = (char) ('A' + r.nextInt(26));
        c[count] = (char) ('A' + r.nextInt(26));
        for (int i = 0; i < c.length; i++) {
            int tmp = r.nextInt(5);
            char temp = c[tmp];
            c[tmp] = c[i];
            c[i] = temp;
        }
        for (char c1 : c) {
            sb.append(c1);
        }
        return sb.toString();
    }
}