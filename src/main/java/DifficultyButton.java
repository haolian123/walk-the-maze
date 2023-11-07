

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DifficultyConfig{
    public final static int EASY=0;
    public final static int MEDIUM=1;
    public final static int HARD=2;
}

//主功能页面按钮
abstract public class DifficultyButton{
    //按钮位置
    protected final static int BUTTON_LOCATION_X =150;
    protected final static int BUTTON_LOCATION_Y =60;
    //按钮的长宽
    protected final static int BUTTON_WIDTH=150;
    protected final static int BUTTON_HEIGHT =50;
    //字体
    Font font = new Font("楷体", Font.PLAIN, 20); // Arial字体，普通风格，字体大小20
    //画板
    JPanel panel = new JPanel();
    //获取按钮对象并给按钮绑定监听事件
    protected void initButton(JButton button,int difficulty){
        button.setFont(font);
        button.setBounds(BUTTON_LOCATION_X, BUTTON_LOCATION_Y *(difficulty+2), BUTTON_WIDTH, BUTTON_HEIGHT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actionFunction(difficulty);
            }
        });
    }
    abstract public JButton getButton();
}

//简单难度
class EasyButton extends DifficultyButton{
    @Override
    public JButton getButton(){
        JButton Button = new JButton("简 单");
        initButton(Button,DifficultyConfig.EASY);
        return Button;
    }
}

//中等难度
class MediumButton extends DifficultyButton{
    @Override
    public JButton getButton(){
        JButton Button = new JButton("中 等");
        initButton(Button,DifficultyConfig.MEDIUM);
        return Button;
    }
}

//困难难度
class HardButton extends DifficultyButton{
    @Override
    public JButton getButton(){
        JButton Button = new JButton("困 难");
        initButton(Button,DifficultyConfig.HARD);
        return Button;
    }
}

