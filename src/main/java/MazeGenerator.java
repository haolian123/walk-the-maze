import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MazeGenerator extends JPanel implements KeyListener {
    private final int Offset=50;
    private int x = 1;
    private int y = 1;
    private boolean isEnd=false;

    private int[][] maze = {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2},
            {2, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2},
            {2, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 2},
            {2, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 2},
            {2, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 2},
            {2, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 2},
            {2, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 2},
            {2, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
    };

    public MazeGenerator() {
        JFrame frame = new JFrame("走迷宫");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
        frame.addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 30;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 1) {
                    g.setColor(Color.BLACK);
                    g.fillRect(j * cellSize+Offset, i * cellSize+Offset, cellSize, cellSize);
                }
                if(maze[i][j]==2){
                    g.setColor(Color.GRAY);
                    g.fillRect(j * cellSize+Offset, i * cellSize+Offset, cellSize, cellSize);

                }

            }
        }

        g.setColor(Color.BLUE);
        g.fillRect(x * cellSize+Offset, y * cellSize+Offset, cellSize, cellSize);

        g.setColor(Color.YELLOW);
        g.fillRect((maze.length - 2) * cellSize+Offset, (maze[0].length-2) * cellSize+Offset, cellSize, cellSize);

        if (isEnd) {
            g.setColor(Color.BLUE);
            g.fillRect((maze.length - 1) * cellSize, (maze[0].length - 1) * cellSize, cellSize, cellSize);
            JOptionPane.showMessageDialog(this, "Success!");
            System.exit(0);
        }
        if (x == maze.length - 2 && y == maze[0].length - 2) {
            isEnd=true;
            g.setColor(Color.BLUE);
            g.fillRect(x * cellSize+Offset, y * cellSize+Offset, cellSize, cellSize);
//            System.out.println("YES");
            repaint();
//            JOptionPane.showMessageDialog(this, "Success!");
//            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP && y > 0 && maze[y-1][x] != 1) {
            y--;
        }
        if (code == KeyEvent.VK_DOWN && y < maze.length - 1 && maze[y+1][x] != 1) {
            y++;
        }
        if (code == KeyEvent.VK_LEFT && x > 0 && maze[y][x-1] != 1) {
            x--;
        }
        if (code == KeyEvent.VK_RIGHT && x < maze[0].length - 1 && maze[y][x+1] != 1) {
            x++;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MazeGenerator());
    }
}
