package snake;

import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class NewClass1 extends JFrame {

    final JFrame frame = new JFrame("S N A K E   G A M E");
    final JPanel[][] panels = new JPanel[12][12];

    List<Point> snake;

    Timer t;

    char currOp;

    int firCol, firRow, LasRow, lasCol;
    int foRow, foCol;
    int snakeLength = 0;

    public NewClass1(int level) {
        snake = new ArrayList<>();
        int delay = 350 / level;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {

                panels[i][j] = new JPanel();
                panels[i][j].setBackground(Color.WHITE);

                if (i == 0 || i == 11 || j == 0 || j == 11) {
                    panels[i][j].setBackground(Color.GRAY);
                }

                frame.getContentPane().add(panels[i][j]);
            }
        }

        currOp = 'd';

        firCol = lasCol = 10;
        firRow = LasRow = 5;
        snake.add(new Point(firRow, firCol));

        putNewFood();

        panels[firRow][firCol].setBackground(Color.BLACK);
        panels[firRow][firCol].addKeyListener(new KeyAction());
        panels[firRow][firCol].setFocusable(true);

        snakeLength++;

        frame.setLayout(new GridLayout(12, 12));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currOp == 'w') {
                    upMove();
                } else if (currOp == 'd') {
                    rigMove();
                } else if (currOp == 'a') {
                    lefMove();
                } else if (currOp == 's') {
                    dnMove();
                }
            }
        });
        t.setDelay(delay);
        t.setRepeats(true);
        t.start();
    }

    private void checkLose() {
        if (snake.size() > 1) {
            if (firRow == LasRow && lasCol == firCol) {
                new GameOver().setVisible(true);
            }
        }
    }

    public void upMove() {
        panels[LasRow][lasCol].setBackground(Color.white);

        if (firRow <= 1) {
            panels[10][firCol].setBackground(Color.BLACK);
            firRow = 10;
            if (LasRow <= 1) {
                LasRow = 10;
            } else {
                LasRow -= 1;
            }
        } else {
            panels[firRow - 1][firCol].setBackground(Color.BLACK);
            firRow -= 1;
            LasRow -= 1;
        }
        checkLose();
        checkIncrease();
    }

    public void dnMove() {
        panels[LasRow][lasCol].setBackground(Color.white);

        if (firRow >= 10) {
            panels[1][firCol].setBackground(Color.BLACK);
            firRow = 1;
            if (LasRow >= 10) {
                LasRow = 1;
            } else {
                LasRow += 1;
            }
        } else {
            panels[firRow + 1][firCol].setBackground(Color.BLACK);
            firRow += 1;
            LasRow += 1;
        }
        checkLose();
        checkIncrease();
    }

    public void lefMove() {
        panels[LasRow][lasCol].setBackground(Color.white);

        if (firCol <= 1) {
            panels[firRow][10].setBackground(Color.BLACK);
            firCol = 10;
            if (lasCol <= 1) {
                lasCol = 10;
            } else {
                lasCol -= 1;
            }
        } else {
            panels[firRow][firCol - 1].setBackground(Color.BLACK);
            firCol -= 1;
            lasCol -= 1;
        }
        checkLose();
        checkIncrease();
    }

    public void rigMove() {
        panels[LasRow][lasCol].setBackground(Color.white);

        if (firCol >= 10) {
            panels[firRow][1].setBackground(Color.BLACK);
            firCol = 1;
            if (lasCol >= 10) {
                lasCol = 1;
            } else {
                lasCol += 1;
            }
        } else {
            panels[firRow][firCol + 1].setBackground(Color.BLACK);
            firCol += 1;
            lasCol += 1;
        }
        checkLose();
        checkIncrease();
    }

    private void putNewFood() {
        Random ra = new Random();
        int c = ra.nextInt(9) + 1;
        int r = ra.nextInt(10) + 1;
        Point food = new Point(r, c);
        for (Point p : snake) {
            if (!p.equals(food)) {
                panels[r][c].setBackground(Color.red);
                foRow = r;
                foCol = c;
                return;
            }
        }
        putNewFood();
    }

    private void checkIncrease() {
        Point p1 = new Point(foRow, foCol);
        Point p2 = new Point(firRow, firCol);
        if (p1.equals(p2)) {
            new Increase().increase();
        }
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
                    currOp = 'a';
                    break;
                case KeyEvent.VK_RIGHT:
                    currOp = 'd';
                    break;
                case KeyEvent.VK_UP:
                    currOp = 'w';
                    break;
                case KeyEvent.VK_DOWN:
                    currOp = 's';
                    break;
            }
        }
    }

    class Increase {

        public Increase() {
            putNewFood();
        }

        void increase() {
            if (currOp == 'w') {
                upIncrease();
            } else if (currOp == 'd') {
                rigMove();
            } else if (currOp == 'a') {
                lefIncrease();
            } else if (currOp == 's') {
                rigIncrease();
            }
        }

        private void upIncrease() {

            if (LasRow >= 10) {
//                panels[1][lasCol].setBackground(Color.BLACK);
                LasRow = 1;
            } else {
//                panels[LasRow + 1][lasCol].setBackground(Color.BLACK);
                LasRow += 1;
            }
            snake.add(new Point(LasRow, lasCol));
//            checkLose();
        }

        public void dnIncrease() {

            if (LasRow >= 1) {
//                panels[10][lasCol].setBackground(Color.BLACK);
                LasRow = 10;
            } else {
//                panels[LasRow - 1][lasCol].setBackground(Color.BLACK);
                LasRow -= 1;
            }
            snake.add(new Point(LasRow, lasCol));
//            checkLose();
        }

        public void lefIncrease() {

            if (lasCol <= 1) {
//                panels[LasRow][10].setBackground(Color.BLACK);
                lasCol = 10;
            } else {
//                panels[LasRow][lasCol + 1].setBackground(Color.BLACK);
                lasCol += 1;
            }
            snake.add(new Point(LasRow, lasCol));
//            checkLose();
        }

        public void rigIncrease() {

            if (lasCol >= 10) {
//                panels[LasRow][1].setBackground(Color.BLACK);
                lasCol = 1;
            } else {
//                panels[LasRow][lasCol - 1].setBackground(Color.BLACK);
                lasCol -= 1;
            }
            snake.add(new Point(LasRow, lasCol));
//            checkLose();
        }

    }

    class Point {

        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Boolean equals(Point p) {
            if (p.row == row && p.col == col) {
                return true;
            }
            return false;
        }
    }
}
