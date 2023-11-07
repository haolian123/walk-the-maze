import javax.swing.*;
import java.awt.*;

public class Main {
    // Arial字体，普通风格，字体大小20
    private static Font font = new Font("宋体", Font.PLAIN, 20);
    // 开始窗口
    static JFrame mainFrame=null;

    public static void main(String[] args) {
        //初始化mainFrame
        initFrame();
        // 创建 JLabel
        JLabel hostLabel = new JLabel("请选择难度：");
        hostLabel.setFont(font);
        hostLabel.setBounds(150,50,200,25);
        mainFrame.add(hostLabel);
        //初始化并添加按钮
        initButton();
        //设置窗口可见
        mainFrame.setVisible(true);
    }


    private static void initFrame(){
        //设置窗口参数
        mainFrame= new JFrame("开始");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setLocation(600,300);
        mainFrame.setLayout(null);
        mainFrame.add(new JPanel());
    }
    private static void addButton(JButton button){
        mainFrame.add(button);
    }

    //初始化并添加按钮
    private static void initButton(){
        //简单按钮
        addButton(new EasyButton().getButton());
        //中等按钮
        addButton(new MediumButton().getButton());
        //困难按钮
        addButton(new HardButton().getButton());
    }


    //按钮反应函数
    public static void actionFunction(int difficulty){
        //设置开始菜单不可见
        mainFrame.setVisible(false);
        //绘制迷宫
        SwingUtilities.invokeLater(() -> new MazeGenerator(difficulty));
    }
}
