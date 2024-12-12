package joker3.domain;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener {
    //牌的属性
    //牌的名字
    private String name;
    //牌的正面or反面
    private boolean up;
    //是否可被点击
    private boolean canclick = false;
    //当前的状态：被点击或不被点击
    private boolean click = false;

    public Poker(String name, boolean up) {
        this.name = name;
        this.up = up;

        if (up) {
            turnFront();//显示卡牌正面
        } else {
            turnRear();//显示卡牌背面
        }
        this.setSize(71, 96);
        this.setVisible(true);
        this.addMouseListener(this);
    }

    private void turnRear() {
        this.setIcon(new ImageIcon("image/poker/rear.png"));//背面的图片统一只使用改地址的图片
        this.canclick = false;//显示背面的牌不可执行点击操作
    }

    private void turnFront() {
        this.setIcon(new ImageIcon("image/poker/"+ name +".png"));
        this.canclick = true;//显示正面的方法可执行点击操作
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.canclick) {
            int temp = 0;
            if (this.click) {
                temp = 20;//如果是从被点击到不被点击，Poker下降20
            } else {
                temp = -20;//如果是从不被点击到被点击，poker上升20
            }
            this.click = !this.click;
            Point from = this.getLocation();//获取Poker对象当前位置
            Point to = new Point(from.x, from.y + temp);//添加偏移量
            this.setLocation(to);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
