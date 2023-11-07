

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//主功能页面按钮
abstract public class DifficultyButton{
    //困难选项
    public static int difficulty=0;
    //迷宫
    public static int [][]maze=null;
    // 设置按钮的首选大小
    Dimension dimension = new Dimension(100, 50);

    Font font = new Font("楷体", Font.PLAIN, 20); // Arial字体，普通风格，字体大小20

    JPanel panel = new JPanel();
    //获取按钮对象并给按钮绑定监听事件
    abstract public JButton getButton();
}

//简单难度
class EasyButton extends DifficultyButton{
    @Override
    public JButton getButton(){
        JButton Button = new JButton("简 单");
        Button.setPreferredSize(dimension); // 100像素宽，50像素高
        Button.setFont(font);
        Button.setBounds(150, 120, 150, 50);
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actionFunction(0);
            }
        });
        return Button;
    }


}

//中等难度
class MediumButton extends DifficultyButton{
    @Override
    public JButton getButton(){
        JButton Button = new JButton("中 等");
        Button.setPreferredSize(dimension);
        Button.setFont(font);
        Button.setBounds(150, 180, 150, 50);
        panel.add(Button);


        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actionFunction(1);
            }
        });
        return Button;
    }
}

//困难难度
class HardButton extends DifficultyButton{
    @Override
    public JButton getButton(){
        JButton Button = new JButton("困 难");
        Button.setPreferredSize(dimension); // 100像素宽，50像素高
        Button.setFont(font);
        Button.setBounds(150, 240, 150, 50);
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actionFunction(2);
            }
        });
        return Button;
    }

}

