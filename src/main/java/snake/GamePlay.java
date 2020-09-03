package snake;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class GamePlay extends JFrame {

    final JLabel[][] labels;
    List<Point> snake;

    Timer t;

    char currMoveState;

    int LastRow, lastCol, firstCol, firstRow;
    int foRow, foCol;
    int delay;

    public GamePlay(int level) {
        setSize(300, 300);

        labels = new JLabel[15][15];

        snake = new ArrayList();

        delay = 350 / level;

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {

                if (i == 0 || j == 0 || i == 14 || j == 14) {
                    JPanel jp = new JPanel();
                    jp.setSize(20, 20);
                    jp.setBackground(Color.YELLOW);

                    add(jp);

                } else {
                    labels[i][j] = new JLabel();
                    labels[i][j].setSize(20, 20);
                    add(labels[i][j]);
                }

            }
        }

        currMoveState = 'd';

        setSnake();
        putNewFood();

        addKeyListener(new KeyAction());

        setLayout(new GridLayout(15, 15));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(java.awt.Frame.ICONIFIED);
        setVisible(true);
        setLocationRelativeTo(null);

        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currMoveState == 'w') {
                    upMove();
                } else if (currMoveState == 'd') {
                    rigMove();
                } else if (currMoveState == 'a') {
                    lefMove();
                } else if (currMoveState == 's') {
                    dnMove();
                }
            }
        });
        t.setDelay(delay);
        t.setRepeats(true);
        t.start();
    }

    private void checkLose() {
        if (snake.size() > 3) {
            for (int i = 0; i < snake.size() - 1; i++) {
                Point p = snake.get(i);
                if (firstRow == p.row && firstCol == p.col) {
                    new GameOver().setVisible(true);
                    t.stop();
                    dispose();
                    return;
                }
            }
        }
    }

    public void upMove() {
        int x = firstRow, y = firstCol;

        if (x == 1) {
            t.stop();
            new GameOver().setVisible(true);
            dispose();
            return;
        }

        labels[x][y].setIcon(null);
        labels[LastRow][lastCol].setIcon(null);

        labels[x][y].setIcon(new ImageIcon("src/Icons/green_dot.png"));
        labels[x - 1][y].setIcon(new ImageIcon("src/Icons/red_dot.png"));
        snake.add(new Point(x - 1, y));
        snake.remove(new Point(LastRow, lastCol));

        firstRow = snake.get(snake.size() - 1).row;
        lastCol = snake.get(0).col;
        LastRow = snake.get(0).row;

        checkLose();
        checkIncrease();
        repaint();
    }

    public void dnMove() {
        int x = firstRow, y = firstCol;

        if (x == 13) {
            t.stop();

            new GameOver().setVisible(true);
            dispose();
            return;
        }

        labels[x][y].setIcon(null);
        labels[LastRow][lastCol].setIcon(null);

        labels[x][y].setIcon(new ImageIcon("src/Icons/green_dot.png"));
        labels[x + 1][y].setIcon(new ImageIcon("src/Icons/red_dot.png"));
        snake.add(new Point(x + 1, y));
        snake.remove(new Point(LastRow, lastCol));

        firstRow = snake.get(snake.size() - 1).row;
        lastCol = snake.get(0).col;
        LastRow = snake.get(0).row;

        checkLose();
        checkIncrease();
        repaint();

    }

    public void lefMove() {
        int x = firstRow, y = firstCol;

        if (y == 1) {
            t.stop();

            new GameOver().setVisible(true);
            dispose();
            return;
        }

        labels[x][y].setIcon(null);
        labels[LastRow][lastCol].setIcon(null);

        labels[x][y].setIcon(new ImageIcon("src/Icons/green_dot.png"));
        labels[x][y - 1].setIcon(new ImageIcon("src/Icons/red_dot.png"));
        snake.add(new Point(x, y - 1));
        snake.remove(new Point(LastRow, lastCol));

        firstCol = snake.get(snake.size() - 1).col;
        lastCol = snake.get(0).col;
        LastRow = snake.get(0).row;

        checkLose();
        checkIncrease();

        repaint();
    }

    public void rigMove() {
        int x = firstRow, y = firstCol;

        if (y == 13) {
            t.stop();
            new GameOver().setVisible(true);
            dispose();
            return;
        }

        labels[x][y].setIcon(null);
        labels[LastRow][lastCol].setIcon(null);

        labels[x][y].setIcon(new ImageIcon("src/Icons/green_dot.png"));
        labels[x][y + 1].setIcon(new ImageIcon("src/Icons/red_dot.png"));
        snake.add(new Point(x, y + 1));
        snake.remove(new Point(LastRow, lastCol));

        firstCol = snake.get(snake.size() - 1).col;
        lastCol = snake.get(0).col;
        LastRow = snake.get(0).row;

        checkLose();
        checkIncrease();

        repaint();
    }

    private void putNewFood() {
        while (true) {
            Random ra = new Random();
            int c = ra.nextInt(9) + 1;
            int r = ra.nextInt(10) + 1;
            for (Point p : snake) {
                if (p.col != c && p.row != r) {
                    labels[r][c].setIcon(new ImageIcon("src/Icons/food.png"));
                    foRow = r;
                    foCol = c;
                    return;
                }
            }
        }

    }

    private void checkIncrease() {
        if (foRow == firstRow && foCol == firstCol) {
            new Increase().increase();
        }
    }

    private void setSnake() {
        snake.add(new Point(3, 3));
        labels[3][3].setIcon(new ImageIcon("src/Icons/green_dot.png"));
        snake.add(new Point(3, 4));
        labels[3][4].setIcon(new ImageIcon("src/Icons/green_dot.png"));
        snake.add(new Point(3, 5));
        labels[3][5].setIcon(new ImageIcon("src/Icons/red_dot.png"));

        LastRow = 3;
        lastCol = 3;

        firstRow = 3;
        firstCol = 5;
    }

    class KeyAction implements KeyListener {

        public KeyAction() {
            Runnable runnable = new Runnable() {
                public void run() {
                }
            };
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    currMoveState = 'a';
                    break;
                case KeyEvent.VK_RIGHT:
                    currMoveState = 'd';
                    break;
                case KeyEvent.VK_UP:
                    currMoveState = 'w';
                    break;
                case KeyEvent.VK_DOWN:
                    currMoveState = 's';
                    break;
            }
        }
    }

    class Increase {

        public void increase() {
            if (snake.get(0).row >= 1 && snake.get(0).row <= 12) {
                int x = snake.get(0).row + 1, y = snake.get(0).col;
                labels[x][y].setIcon(new ImageIcon("src/Icons/green_dot.png"));
                snake.add(0, new Point(x, y));
                LastRow = x;
                lastCol = y;
            } else if (snake.get(0).col >= 1 && snake.get(0).col <= 12) {
                int x = snake.get(0).col + 1, y = snake.get(0).col;
                labels[x][y].setIcon(new ImageIcon("src/Icons/green_dot.png"));
                snake.add(0, new Point(x, y));
                LastRow = x;
                lastCol = y;

            } else {
                int x = snake.get(0).col, y = snake.get(0).col - 1;
                labels[x][y].setIcon(new ImageIcon("src/Icons/green_dot.png"));
                snake.add(0, new Point(x, y));
                LastRow = x;
                lastCol = y;
            }
//            if (snake.get(0).row > snake.get(1).row) {
//                int x = snake.get(0).row + 1, y = snake.get(0).col;
//                labels[x][y].setIcon(new ImageIcon("src/Icons/green_dot.png"));
//                snake.add(0, new Point(x, y));
//                LastRow = x;
//                lastCol = y;
//            } else if (snake.get(0).row < snake.get(1).row) {
//                int x = snake.get(0).row - 1, y = snake.get(0).col;
//                labels[x][y].setIcon(new ImageIcon("src/Icons/green_dot.png"));
//                snake.add(0, new Point(x, y));
//                LastRow = x;
//                lastCol = y;
//
//            }
//            else if (snake.get(0).col > snake.get(1).col) {
//                int x = snake.get(0).row, y = snake.get(0).col + 1;
//                labels[x][y].setIcon(new ImageIcon("src/Icons/green_dot.png"));
//                snake.add(0, new Point(x, y));
//                LastRow = x;
//                lastCol = y;
//            } else if (snake.get(0).col < snake.get(1).col) {
//                int x = snake.get(0).row, y = snake.get(0).col - 1;
//                labels[x][y].setIcon(new ImageIcon("src/Icons/green_dot.png"));
//                snake.add(0, new Point(x, y));
//                LastRow = x;
//                lastCol = y;
//            }

            putNewFood();
        }

    }

    class Point {

        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            try {
                Point p = (Point) obj;
                if (p.row == row && p.col == col) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }

            return false;
        }
    }
}
