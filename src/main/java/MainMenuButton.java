

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//主功能页面按钮
abstract public class MainMenuButton{
    //困难选项
    public static int difficulty=0;
    //迷宫
    public static int [][]maze=null;
    // 设置按钮的首选大小
    Dimension dimension = new Dimension(100, 50);
    Font font = new Font("楷体", Font.PLAIN, 20); // Arial字体，普通风格，字体大小20
    JPanel panel = new JPanel();

    //给按钮绑定监听事件
    abstract public JButton getButton();


}

//增加数据按钮
class EasyButton extends MainMenuButton{
    @Override
    public JButton getButton(){
        // 创建"增加数据"按钮
        JButton Button = new JButton("简 单");
        Button.setPreferredSize(dimension); // 100像素宽，50像素高
        Button.setFont(font);
        Button.setBounds(150, 120, 150, 50);
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMaze.actionFunction(0);
            }
        });
        return Button;
    }


}

//修改数据按钮
class MediumButton extends MainMenuButton{
    @Override
    public JButton getButton(){
        // 创建"修改数据"按钮
        JButton Button = new JButton("中 等");
        Button.setPreferredSize(dimension); // 100像素宽，50像素高
        Button.setFont(font);
        Button.setBounds(150, 180, 150, 50);
        panel.add(Button);


        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMaze.actionFunction(1);
            }
        });
        return Button;
    }
}

//删除数据按钮
class HardButton extends MainMenuButton{
    @Override
    public JButton getButton(){
        JButton Button = new JButton("困 难");
        Button.setPreferredSize(dimension); // 100像素宽，50像素高
        Button.setFont(font);
        Button.setBounds(150, 240, 150, 50);
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMaze.actionFunction(2);
            }
        });
        return Button;
    }

}

