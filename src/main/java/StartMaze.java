import javax.swing.*;
import java.awt.*;

public class StartMaze {
    private static Font font = new Font("宋体", Font.PLAIN, 20); // Arial字体，普通风格，字体大小20
    static JFrame mainFrame=null;
    public static void main(String[] args) {
        mainFrame= new JFrame("开始");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setLocation(600,300);
        mainFrame.setLayout(null);
        mainFrame.add(new JPanel());

        // 创建 JLabel
        JLabel hostLabel = new JLabel("请选择难度：");
        hostLabel.setFont(font);
        hostLabel.setBounds(150,50,200,25);
        mainFrame.add(hostLabel);

        //创建按钮
        int difficulty=0;
        MainMenuButton Button;
        Button=new EasyButton();
        mainFrame.add(Button.getButton());
        Button=new MediumButton();
        mainFrame.add(Button.getButton());
        Button=new HardButton();
        mainFrame.add(Button.getButton());

        mainFrame.setVisible(true);
    }

    //按钮反应函数
    public static void actionFunction(int difficulty){
        mainFrame.setVisible(false);
        SwingUtilities.invokeLater(() -> new MazeGenerator(difficulty));
    }
}
