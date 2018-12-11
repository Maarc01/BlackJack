import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BlackJackGUI extends JFrame {

  private JButton playButton;
  private JButton hitButton;
  private JButton standButton;
  private JPanel outputPanel = new JPanel();
  private JTextArea playerArea;
  private JTextArea dealerArea ;
   public BlackJackGUI ()
            {
                 
       setSize(1600,900);
        setTitle("BlackJack");
            
                    JPanel panelBlack = new JPanel ();  
                    JPanel panelBlack1 = new JPanel (); // content 
                    panelBlack1.setBackground(Color.LIGHT_GRAY);
                   panelBlack1.setLayout(null);
 
   
    panelBlack.setBounds(0, 0, 1910, 50);
                                     JPanel panelBlack2 = new JPanel (); //buttons
                                  

             playButton = new JButton("Play ");
    hitButton = new JButton("Hit");
    standButton = new JButton("Stand");
    playerArea = new JTextArea();
    dealerArea = new JTextArea();


                   playButton .setBounds(365, 669,110, 46);
                     hitButton .setBounds(544, 669, 110, 46);
	standButton .setBounds(721, 669, 110, 46);
	playerArea .setBounds(89, 76, 473, 501);	
	dealerArea .setBounds(614, 76, 473, 501);


                    
                    add(playButton );
                    add(hitButton );
                    add(standButton);
                    add(playerArea);
                    add(dealerArea);
                    add(panelBlack1);
  hitButton.setEnabled(false);
    standButton.setEnabled(false);
    playerArea.setText("  ");
    dealerArea.setText("  ");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void setPlayAction(ActionListener listener){
    playButton.addActionListener(listener);
  }

  public void setHitAction(ActionListener listener){
    hitButton.addActionListener(listener);
  }

  public void setStandAction(ActionListener listener){
    standButton.addActionListener(listener);
  }

  public void displayPlayer(Hand hand){
    playerArea.setText("Player:\n"+hand.valueOf()+"\n"+hand);
  }

  public void displayDealer(Hand hand){
    dealerArea.setText("Dealer:\n"+hand.valueOf()+"\n"+hand);
  }

  public void displayDealerCard(Card card){
    dealerArea.setText("Dealer:\n"+card);
  }

  public void displayOutcome(String outcome){
    playerArea.setText(playerArea.getText()+"\n\n"+outcome);
  }

  public void enableHitAndStandButtons(){
    playButton.setEnabled(false);
    hitButton.setEnabled(true);
    standButton.setEnabled(true);
  }

  public void enablePlayButton(){
    playButton.setEnabled(true);
    hitButton.setEnabled(false);
    standButton.setEnabled(false);
  }

  static public void main(String[] args){
    new BlackJackGUI();
  }

}