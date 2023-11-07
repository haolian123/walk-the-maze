import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//该类用于绘制迷宫
public class MazeGenerator extends JPanel implements KeyListener {

    // 可移动块的坐标
    private int x = 1;
    private int y = 1;

    // 是否到达终点
    private boolean isEnd = false;
    // 用二维数组表示迷宫
    private static int[][] maze;

    // 偏移量
    private static int Offset = 50;

    //初始化迷宫
    private void initMaze(int difficulty){
        maze=MazeFactory.createMaze(difficulty);
    }

    private void initFrame(int difficulty){
        difficulty=Math.min(difficulty,2);
        //初始化偏移量
        Offset=50+difficulty*20;
        //设置画图的偏移量
        int width=250*Math.min(3,difficulty+1)+150;
        int height=250*Math.min(3,difficulty+1)+100;
        JFrame frame = new JFrame("走迷宫"); // 创建窗口对象
        frame.setSize(width, height); // 设置窗口大小
        frame.setLocation(500, 100); // 设置窗口位置
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭行为
        frame.add(this); // 将当前对象添加到窗口
        frame.setVisible(true); // 设置窗口可见
        frame.addKeyListener(this); // 添加键盘事件监听器
    }

    public MazeGenerator(int difficulty) {
        //初始化迷宫
        initMaze(difficulty);

        //初始化窗口
        initFrame(difficulty);

    }

    // 画图
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 调用父类的绘制方法

        int cellSize = 30; // 设置单元格大小
        g.setColor(Color.YELLOW); // 设置绘图颜色为黄色
        g.fillRect((maze[0].length - 2) * cellSize + Offset, (maze.length - 2) * cellSize + Offset, cellSize, cellSize); // 绘制终点
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 1) {
                    g.setColor(Color.BLACK); // 设置绘图颜色为黑色
                    g.fillRect(j * cellSize + Offset, i * cellSize + Offset, cellSize, cellSize); // 绘制墙壁
                }
                if (maze[i][j] == 2) {
                    g.setColor(Color.GRAY); // 设置绘图颜色为灰色
                    g.fillRect(j * cellSize + Offset, i * cellSize + Offset, cellSize, cellSize); // 绘制迷宫外部
                }
            }
        }

        g.setColor(Color.BLUE); // 设置绘图颜色为蓝色
        g.fillRect(x * cellSize + Offset, y * cellSize + Offset, cellSize, cellSize); // 绘制当前位置

        if (isEnd) {
            g.setColor(Color.BLUE); // 设置绘图颜色为蓝色
            g.fillRect((maze[0].length - 1) * cellSize, (maze.length - 1) * cellSize, cellSize, cellSize); // 绘制终点
            JOptionPane.showMessageDialog(this, "恭喜你，成功通关!"); // 显示成功消息框
            System.exit(0); // 退出程序
        }

        if (x == maze[0].length - 2 && y == maze.length - 2) {
            isEnd = true; // 标记到达终点
            g.setColor(Color.BLUE); // 设置绘图颜色为蓝色
            g.fillRect(x * cellSize + Offset, y * cellSize + Offset, cellSize, cellSize); // 绘制当前位置
            repaint(); // 重新绘制
        }
    }

    // 监听键盘
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP && y > 0 && maze[y - 1][x] < 1) {
            y--;
        }
        if (code == KeyEvent.VK_DOWN && y < maze.length - 1 && maze[y + 1][x] < 1) {
            y++;
        }
        if (code == KeyEvent.VK_LEFT && x > 0 && maze[y][x - 1] < 1) {
            x--;
        }
        if (code == KeyEvent.VK_RIGHT && x < maze[0].length - 1 && maze[y][x + 1] < 1) {
            x++;
        }
        repaint(); // 重新绘制
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}

