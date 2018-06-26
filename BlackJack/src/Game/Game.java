package Game;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Cards.Card;
import Cards.Deck;

public class Game extends JFrame implements ActionListener {
    private Image d1, d2, d3, d4, d5, d6;
    private Image p1, p2, p3, p4, p5, p6;
    private static Deck deck = new Deck(); 
    private static Better player = new Better();
    private static Player dealer = new Player();
    private static JLabel PStatus = new JLabel(String.valueOf(player.cardValue()));
    private static JLabel bidlabel = new JLabel("");
    private static JLabel PMoney = new JLabel("");
    private static JLabel DStatus = new JLabel("");
    private static boolean deal1 = true;
    private JButton increase = new JButton("Increase bid");
    private JButton decrease = new JButton("Decrease bid");
    private JButton deal = new JButton("Deal");
    private JButton hit = new JButton("Hit");
    private JButton stand = new JButton("Stand");
    private JButton surr = new JButton("Surrender");
    private JButton DD = new JButton("Double Down");
    private JPanel Game = new JPanel(new GridLayout(3, 1));
    private JPanel buttons = new JPanel(new GridLayout(1, 7));
    private JPanel pic = new JPanel(new GridLayout(2, 6));
    private JPanel gamescore = new JPanel(new GridLayout(1, 3));
    private JPanel score = new JPanel(new GridLayout(2, 1));
    private static boolean finish = false;
    private static int bid = 4;
    private static int g = 0;
    private static ArrayList < JLabel > Plabels = new ArrayList < JLabel > (11);
    private static ArrayList < JLabel > Dlabels = new ArrayList < JLabel > (11);
    public Game() throws InterruptedException {

        increase.addActionListener(this);
        decrease.addActionListener(this);
        hit.addActionListener(this);
        stand.addActionListener(this);
        deal.addActionListener(this);
        surr.addActionListener(this);
        DD.addActionListener(this);
        for (int i = 0; i <= 11; i++) {
            Plabels.add(new JLabel());
            Dlabels.add(new JLabel());
        }
        for (int i = 0; i <= 11; i++) {
            pic.add(Dlabels.get(i));
        }
        for (int i = 0; i <= 11; i++) {
            pic.add(Plabels.get(i));
        }
        pic.setVisible(true);
        buttons.add(increase);
        buttons.add(decrease);
        buttons.add(deal);
        buttons.add(hit);
        buttons.add(stand);
        buttons.add(surr);
        buttons.add(DD);
        buttons.setVisible(true);
        gamescore.add(bidlabel);
        gamescore.add(score);
        score.add(DStatus);
        score.add(PStatus);
        gamescore.add(PMoney);
        gamescore.setVisible(true);
        Game.add(pic);
        Game.add(buttons);
        Game.add(gamescore);
        Game.setVisible(true);
        showCard(player);
        showCard(dealer);
        add(Game);

    }


    public static void showCard(Better x) throws InterruptedException {
        int a = 0;
        for (Card i: x.getCards()) {
            Thread.sleep(200);
            Plabels.get(a).setIcon(new ImageIcon(i.getImage().getScaledInstance(83, 127, Image.SCALE_DEFAULT)));
            a++;
        }
    }



    public static void showCard(Player x) throws InterruptedException {
        int a = 0;
        for (Card i: x.getCards()) {
            Thread.sleep(200);
            Dlabels.get(a).setIcon(new ImageIcon(i.getImage().getScaledInstance(83, 127, Image.SCALE_DEFAULT)));
            a++;
        }
    }
    public static void showFCard() throws InterruptedException {
        Thread.sleep(200);
        Image image = null;
        File frames = new File("Pictures/qm.png");
        try {
            image = ImageIO.read(frames);
        } catch (IOException e) {
            e.printStackTrace();
        };
        Dlabels.get(0).setIcon(new ImageIcon(dealer.getCards().get(0).getImage().getScaledInstance(83, 127, Image.SCALE_DEFAULT)));
        Thread.sleep(200);
        Dlabels.get(1).setIcon(new ImageIcon(image.getScaledInstance(83, 127, Image.SCALE_DEFAULT)));
    }



    public static void removeCard(Better x) {
        Image image = null;
        File frames = new File("Pictures/b.png");
        try {
            image = ImageIO.read(frames);
        } catch (IOException e) {
            e.printStackTrace();
        };
        for(JLabel a : Plabels) {
            a.setIcon(new ImageIcon(image.getScaledInstance(83, 127, Image.SCALE_DEFAULT)));}
    }

    public static void removeCard(Player x) {
        Image image = null;
        File frames = new File("Pictures/b.png");
        try {
            image = ImageIO.read(frames);
        } catch (IOException e) {
            e.printStackTrace();
        };
        for(JLabel a : Dlabels) {
            a.setIcon(new ImageIcon(image.getScaledInstance(83, 127, Image.SCALE_DEFAULT)));}
        }
    

    public static void compare(Player x, Better z) throws InterruptedException {
        if (x.cardValue() > 21) {
            PStatus.setText("You won");
            z.addMoney(bid);
            Thread.sleep(1000);
        } else if (x.cardValue() == z.cardValue()) {
            PStatus.setText("Draw");
            DStatus.setText("Draw");
            Thread.sleep(1000);
        } else if (x.cardValue() < z.cardValue()) {
            PStatus.setText("You won");
            z.addMoney(bid);
            Thread.sleep(1000);
        } else if (x.cardValue() > z.cardValue()) {
            z.removeMoney(bid);
            DStatus.setText("Dealer won");
            Thread.sleep(1000);
        }
        player.removeCards();
        dealer.removeCards();
        PStatus.setText(String.valueOf(player.cardValue()));
        DStatus.setText(String.valueOf(dealer.cardValue()));
        PMoney.setText(String.valueOf(player.getMoney()));
    }




    public static void main(String[] args) throws InterruptedException {
        Game playerPlayer = new Game();
        playerPlayer.setTitle("BlackJack");
        playerPlayer.setSize(2000, 1000);
        playerPlayer.setVisible(true);
        removeCard(player);
        removeCard(dealer);
        playerPlayer.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        bidlabel.setText(String.valueOf(bid));
        PMoney.setText(String.valueOf(player.getMoney()));
        PStatus.setText(String.valueOf(player.cardValue()));
        deck.shuffle();
        while (!finish) {
            if (player.getMoney() <= 0) {
                PStatus.setText("Game over!");
                DStatus.setText("Game over!");
                finish = true; }
                //the main mechanic for the game; g represents what decision the player has made in regard to his deck and allows the game to proceed based on it
                switch (g) {
                    case 1:
                        {
                            if (player.cardValue() < 21) {
                                deck.deal(player);
                                showCard(player);
                                if (player.cardValue() > 21) {
                                	boolean containsace = false;
                                	for(Card i : player.cards) {
                                		if(i.getCardType().equals(Card.CardType.ACE)) {
                                			if(player.cardValue()>21) {}
                                		}
                                	}
                                    player.removeMoney(bid);
                                    DStatus.setText("Dealer won");
                                    Thread.sleep(1000);
                                    player.removeCards();
                                    dealer.removeCards();
                                    DStatus.setText(String.valueOf(dealer.cardValue()));
                                    removeCard(player);
                                    removeCard(dealer);
                                    removeCard(dealer);
                                    PStatus.setText(String.valueOf(player.cardValue()));
                                    bidlabel.setText(String.valueOf(bid));
                                    PMoney.setText(String.valueOf(player.getMoney()));
                                    deal1 = true;
                                } else
                                	if (player.cardValue() == 21) {
                                    player.addMoney(bid);
                                    PStatus.setText("BlackJack!");
                                    Thread.sleep(1000);
                                    player.removeCards();
                                    dealer.removeCards();
                                    removeCard(player);
                                    removeCard(dealer);
                                    bidlabel.setText(String.valueOf(bid));
                                    PStatus.setText(String.valueOf(player.cardValue()));
                                    PMoney.setText(String.valueOf(player.getMoney()));
                                    player.removeCards();
                                    deal1 = true;
                                } else {
                                    PStatus.setText(String.valueOf(player.cardValue()));
                                    Thread.sleep(1000);
                                    PStatus.setText(String.valueOf(player.cardValue()));
                                    bidlabel.setText(String.valueOf(bid));
                                }
                            }
                            g = 0;
                            break;
                        }
                    case 2:
                        {
                            {
                                while ((dealer.cardValue() + 3) < 21) {
                                    deck.deal(dealer);
                                }
                                if (player.cardValue() > dealer.cardValue()) {
                                    deck.deal(dealer);
                                }
                                showCard(dealer);
                                DStatus.setText(String.valueOf(dealer.cardValue()));
                                compare(dealer, player);
                                removeCard(player);
                                removeCard(dealer);
                                player.removeCards();
                                dealer.removeCards();
                                deal1 = true;
                            }
                            g = 0;
                            break;
                        }

                    case 3:
                        {
                            deck.deal(dealer);
                            deck.deal(dealer);
                            deck.deal(player);
                            deck.deal(player);
                            showFCard();
                            showCard(player);
                            PStatus.setText(String.valueOf(player.cardValue()));
                            DStatus.setText(String.valueOf(dealer.getCards().get(0).getValue()));
                            if (player.cardValue() == 21) {
                                player.addMoney(bid);
                                PStatus.setText("BlackJack!");
                                Thread.sleep(1000);
                                player.removeCards();
                                dealer.removeCards();
                                removeCard(player);
                                removeCard(dealer);
                                bidlabel.setText(String.valueOf(bid));
                                PStatus.setText(String.valueOf(player.cardValue()));
                                PMoney.setText(String.valueOf(player.getMoney()));
                                player.removeCards();
                                DStatus.setText(String.valueOf(dealer.cardValue()));
                                deal1 = true;
                            } else {
                                deal1 = false;
                            }
                            g = 0;
                            break;
                        }

                    case 4:
                        {   if(dealer.getCards().get(0).getValue()==10 || dealer.getCards().get(0).getCardType()==Card.CardType.ACE) {
                            player.removeMoney(bid);
                            DStatus.setText("Dealer won");
                            Thread.sleep(1000);
                            player.removeCards();
                            dealer.removeCards();
                            DStatus.setText(String.valueOf(dealer.cardValue()));
                            removeCard(player);
                            removeCard(dealer);
                            removeCard(dealer);
                            PStatus.setText(String.valueOf(player.cardValue()));
                            bidlabel.setText(String.valueOf(bid));
                            PMoney.setText(String.valueOf(player.getMoney()));deal1 = true;g = 0;}
                            break;
                        }

                    case 5:
                        {
                            deck.deal(player);
                            bid *= 2;
                            showCard(player);
                            if (player.cardValue() == 21) {
                                player.addMoney(bid);
                                PStatus.setText("BlackJack!");
                                Thread.sleep(1000);
                                player.removeCards();
                                dealer.removeCards();
                                removeCard(player);
                                removeCard(dealer);
                                bid /= 2;
                                bidlabel.setText(String.valueOf(bid));
                                PStatus.setText(String.valueOf(player.cardValue()));
                                PMoney.setText(String.valueOf(player.getMoney()));
                                player.removeCards();
                                deal1 = true;
                                g = 0;
                                break;
                            }

                            if (player.cardValue() > 21) {
                                player.removeMoney(bid);
                                DStatus.setText("Dealer won");
                                Thread.sleep(1000);
                                player.removeCards();
                                dealer.removeCards();
                                DStatus.setText(String.valueOf(dealer.cardValue()));
                                removeCard(player);
                                removeCard(dealer);
                                removeCard(dealer);
                                PStatus.setText(String.valueOf(player.cardValue()));
                                bid /= 2;
                                bidlabel.setText(String.valueOf(bid));
                                PMoney.setText(String.valueOf(player.getMoney()));
                                bid /= 2;
                                deal1 = true;
                                g = 0;
                                break;
                            }

                            {
                                while ((dealer.cardValue() + 3) < 21) {
                                    deck.deal(dealer);
                                }
                                if (player.cardValue() > dealer.cardValue()) {
                                    deck.deal(dealer);
                                }
                                showCard(dealer);
                                DStatus.setText(String.valueOf(dealer.cardValue()));
                            }
                            compare(dealer, player);
                            showCard(dealer);
                            removeCard(player);
                            removeCard(dealer);
                            player.removeCards();
                            dealer.removeCards();
                            deal1 = true;
                            g = 0;
                            break;
                        }
                }
            }}
        


        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (finish == false) {
                if (arg0.getSource() == increase) {
                    if (bid < player.getMoney())
                        bid += 4;
                    bidlabel.setText(String.valueOf(bid));
                }
                if (arg0.getSource() == decrease) {
                    if (bid > 4) {
                        bid -= 4;
                        bidlabel.setText(String.valueOf(bid));
                    }

                }
                if (arg0.getSource() == hit) {
                    if (!deal1) {
                        g = 1;
                    }
                }

                if (arg0.getSource() == stand) {
                    if (!deal1) {
                        g = 2;
                    }
                }

                if (arg0.getSource() == deal) {
                    if (deal1) {
                        g = 3;
                    }
                }
                if (arg0.getSource() == surr) {
                    if (!deal1) {
                        g = 4;
                    }
                }
                if (arg0.getSource() == DD) {
                    if (!deal1) {
                        g = 5;
                    }
                }


            }
        }
    }
