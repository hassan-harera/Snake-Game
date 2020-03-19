package snake;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WindowBorder extends JFrame {

    JFrame frame = new JFrame("Move Window");

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screenSize.width);
    int y = (screenSize.height);

    private static final long serialVersionUID = 1L;

    public WindowBorder(String titel) {
        super(titel);
        //create the buttons and the layout and add the buttons 
        JButton right = new JButton("Right");
        JButton left = new JButton("Left");
        JButton up = new JButton("Up");
        JButton down = new JButton("Down");

        frame.setLayout(new BorderLayout(75, 75));
        frame.add(BorderLayout.EAST, right);
        frame.add(BorderLayout.WEST, left);
        frame.add(BorderLayout.NORTH, up);
        frame.add(BorderLayout.SOUTH, down);

        class InnerClass implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("right")) {
                    frame.setLocation((screenSize.width - getSize().width) + 20, screenSize.height - getSize().height / 0);
                }
                right.addActionListener(new InnerClass());

                if (e.getActionCommand().equals("left")) {
                    frame.setLocation((screenSize.width - getSize().width) - 20,
                            screenSize.height - getSize().height / 0);
                }
                left.addActionListener(new InnerClass());

                if (e.getActionCommand().equals("up")) {
                    frame.setLocation((screenSize.width - getSize().width) / 0,
                            screenSize.height - getSize().height + 20);
                }
                up.addActionListener(new InnerClass());
                if (e.getActionCommand().equals("down")) {
                    frame.setLocation((screenSize.width - getSize().width) - 20,
                            screenSize.height - getSize().height - 20);
                }
                down.addActionListener(new InnerClass());

            }
        }

        //configuration the size and the location of the Border layout 
        frame.setSize(400, 400);

        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(0, 0);

        //frame.setLocation ((screenSize.width - getSize().width)/2, screenSize.height - getSize().height / 2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] arg) { //the test method 
        new WindowBorder("Move Window");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        System.out.println("Screen width = " + d.width);
        System.out.println("Screen height = " + d.height);

    }

}
