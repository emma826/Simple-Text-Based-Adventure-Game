import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    JFrame frame;
    public Main(){
        frame = new JFrame("Simple Text Adventure Game");
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(2,1,4,3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setResizable(false);


        label();
        startGame();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon("src\\pictures\\1.png");
        frame.setIconImage(imageIcon.getImage());


    }

    private void label() {

        JLabel label = new JLabel("Simple Text Adventure Game");
        label.setForeground(Color.GREEN);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setFont(new Font("MV Boli", Font.BOLD, 35));
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);


        frame.add(label);
    }

    private void startGame() {
        JPanel startGamePanel = new JPanel();
        startGamePanel.setOpaque(true);
        startGamePanel.setBackground(Color.black);

        JButton startGame = new JButton("Start Game");
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartGame();
                frame.dispose();
            }
        });

        startGamePanel.add(startGame);
        frame.add(startGamePanel);

    }

    public static void main(String [] args){
        new Main();
    }
}