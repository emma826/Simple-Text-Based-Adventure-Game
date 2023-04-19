import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StartGame {
    static ArrayList<Game> gameArrayList;
    static int gameIndex =0;
    public StartGame(){
        JFrame startGameFrame = new JFrame("Start Game");
        startGameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


         gameArrayList = new ArrayList<>();
        gameArrayList.add(new Game("You find yourself stranded on a deserted island with no idea how you got there. Your goal is to find a way off the island and back to civilization. You start by exploring the area around you. You are standing on a sandy beach with dense jungle on either side of you. In front of you is a small stream. What will you do", new Option(1, "go into the jungle", true), new Option(2, "Give up on the mission", false)));
        gameArrayList.add(new Game("You venture into the jungle, and after a few steps, you come across a large tree with a branch hanging low enough for you to climb up, what will you do", new Option(1, "climb the tree", true), new Option(2, "Rest and give up on the game", false)));
        gameArrayList.add(new Game("You climb the tree and discover a small cave nestled in the branches. Inside the cave, you find a map and a compass. The map shows a path to a nearby village where you can find help. You must now navigate your way through the jungle using the map and compass. what will you do", new Option(1, "Rest and give up on the game", false), new Option(2, "follow the map", true)));
        gameArrayList.add(new Game("You follow the map through the dense jungle, and after a few hours of hiking, you arrive at the village. The villagers welcome you and offer to help you get off the island. However, they need you to complete a task for them first. They want you to retrieve a rare flower that only grows on the other side of the island.", new Option(1, "Don't agree to retrieve the flower", false), new Option(2, "agree to retrieve the flower", true)));
        gameArrayList.add(new Game("You agree to retrieve the flower and set off on your journey. On your way, you come across a river with a broken bridge. You need to find a way to cross the river to continue your journey. ", new Option(1, "look for a way to cross the river", true), new Option(2, "Go back to the villagers", false)));
        gameArrayList.add(new Game("You find a boat near the riverbank and use it to cross the river. Once on the other side, you find the rare flower and bring it back to the village. The villagers keep their promise and help you leave the island. Congratulations, you have completed the game and escaped the island!", new Option(1, "Accept", true), new Option(2, "Decline", false)));


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5,0,0,0));
        mainPanel.setBackground(Color.black);

        JLabel story = new JLabel(gameArrayList.get(0).getStory());
        story.setForeground(Color.green);
        story.setSize(500, 500);



        JLabel op1 = new JLabel("1. " +gameArrayList.get(gameIndex).op1.getOptionText());
        op1.setForeground(Color.white);
        JLabel op2 = new JLabel("2. " +gameArrayList.get(gameIndex).op2.getOptionText());
        op2.setForeground(Color.white);

        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(new GridLayout(0,2,10,0));


        JTextArea textArea = new JTextArea();

        textArea.setFont(new Font("MV Boli", Font.BOLD, 20));
        JButton goBtn = new JButton("GO");
        goBtn.setFocusable(false);
        goBtn.setForeground(Color.white);
        goBtn.setBackground(Color.green);

        goBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane jOptionPane = new JOptionPane();
                try{
                    int input = Integer.parseInt(textArea.getText());
                    if (input >2){
                        jOptionPane.setMessage("Option is not valid");
                        JDialog dialog = jOptionPane.createDialog(startGameFrame, "Error");
                        dialog.setVisible(true);
                    }
                    else{
                        if (gameIndex == gameArrayList.size()){
                            //this means that the person has completed the game
                            int result = JOptionPane.showConfirmDialog(startGameFrame, "Congratulations, you have completed the game", "Game complete", JOptionPane.PLAIN_MESSAGE);
                            if (result == JOptionPane.OK_OPTION || result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION){
                                System.exit(0);
                            }

                        }
                        else{
                            Game game = gameArrayList.get(gameIndex);
                            if (input == game.getOp1().getOptionId() && game.getOp1().isCorrectOption()){
                                System.out.println("op1 and is correct");
                                gameIndex ++;
                                setPrompts(story, op1, op2, textArea);

                            }
                            else{
                                //it is not option one, it might be option two
                                if (input == game.getOp2().getOptionId() && game.getOp2().isCorrectOption()){
                                    //user is correct
                                    System.out.println("op2 and is correct");
                                    gameIndex ++;
                                    setPrompts(story, op1, op2, textArea);
                                }
                                else{
                                    //user is not correct
                                    System.out.println("op2 and is not corrct");
                                    int result = JOptionPane.showConfirmDialog(startGameFrame, "Wrong option!!, you hava failed the game", "Game Exit", JOptionPane.PLAIN_MESSAGE);
                                    if (result == JOptionPane.OK_OPTION || result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION){
                                        System.exit(0);
                                    }
                                }
                            }



                        }

                    }

                }
                catch (Exception exception){
                    jOptionPane.setMessage(exception.getMessage());
                    JDialog dialog = jOptionPane.createDialog(startGameFrame, "Error");
                    dialog.setVisible(true);
                    System.out.println(exception.getMessage());
                }


            }
        });
        panel.add(textArea);
        panel.add(goBtn);


        mainPanel.add(story);
        mainPanel.add(op1);
        mainPanel.add(op2);
        mainPanel.add(panel);

        startGameFrame.setSize(600, 600);
        startGameFrame.setLayout(new GridBagLayout());
        startGameFrame.getContentPane().setBackground(Color.black);
        startGameFrame.add(mainPanel);


        startGameFrame.setVisible(true);
        startGameFrame.setLocationRelativeTo(null);
    }

    public static void endGame(Frame frame){

    }

   public static  void setPrompts(JLabel story, JLabel op1, JLabel op2, JTextArea textArea ){
        if (gameIndex > gameArrayList.size() -1){

        }
        else{
            story.setText(gameArrayList.get(gameIndex).getStory());
            op1.setText("1. " +gameArrayList.get(gameIndex).op1.getOptionText());
            op2.setText("2. " +gameArrayList.get(gameIndex).op2.getOptionText());
            textArea.setText("");
        }


   }
}
