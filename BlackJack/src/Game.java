import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame implements ActionListener{
private Image d1,d2,d3,d4,d5,d6;
private Image p1,p2,p3,p4,p5,p6;
private static final Better hamza = new Better();
private static final Player dealer = new Player();
private static JLabel PStatus = new JLabel(String.valueOf(hamza.cardValue())); 
private static JLabel bidlabel = new JLabel("");
private static JLabel PMoney = new JLabel("");
private static JLabel DStatus = new JLabel("");
private static boolean deal1 = true;
private JLabel a1 = new JLabel("p card 1"); 
private JLabel a2 = new JLabel("p card 2"); 
private JLabel a3 = new JLabel("p card 3"); 
private JLabel a4 = new JLabel("p card 4"); 
private JLabel a5 = new JLabel("p card 5"); 
private JLabel a6 = new JLabel("p card 6"); 
private JLabel a7 = new JLabel("p card 7");
private JLabel a8 = new JLabel("p card 8");
private JLabel a9 = new JLabel("p card 9");
private JLabel a10 = new JLabel("p card 10");
private JLabel a11 = new JLabel("p card 11");
private JLabel b1 = new JLabel("d card 1"); 
private JLabel b2 = new JLabel("d card 2"); 
private JLabel b3 = new JLabel("d card 3"); 
private JLabel b4 = new JLabel("d card 4"); 
private JLabel b5 = new JLabel("d card 5");
private JLabel b6 = new JLabel("d card 6");
private JLabel b7 = new JLabel("d card 7");
private JLabel b8 = new JLabel("d card 8");
private JLabel b9 = new JLabel("d card 9");
private JLabel b10 = new JLabel("d card 10");
private JLabel b11 = new JLabel("d card 11");
private JButton increase = new JButton("Increase bid");
private JButton decrease = new JButton("Decrease bid");
private JButton deal = new JButton("Deal");
private JButton hit = new JButton("Hit");
private JButton stand = new JButton("Stand");
private JButton surr = new JButton("Surrender");
private JButton DD = new JButton("Double Down");
private JPanel Game = new JPanel(new GridLayout(3,1));
private JPanel but = new JPanel(new GridLayout(1,7));
private JPanel pic = new JPanel(new GridLayout(2,6));
private JPanel gg = new JPanel(new GridLayout(1,3));
private JPanel score = new JPanel(new GridLayout(2,1));
private static boolean finish = false;
private static int bid = 4;
private static int g = 0;
private static JLabel[] Plabels = new JLabel[11];{
Plabels[0] = a1; Plabels[1] = a2;Plabels[2] = a3;Plabels[3] = a4;Plabels[4] = a5;Plabels[5] = a6;Plabels[6] = a7;Plabels[7] = a8; Plabels[8] = a9; Plabels[9] = a10;Plabels[10] = a11;    }
private static JLabel[] Dlabels = new JLabel[11];{
	Dlabels[0] = b1; Dlabels[1] = b2;Dlabels[2] = b3;Dlabels[3] = b4;Dlabels[4] = b5;Dlabels[5] = b6;Dlabels[6] = b7;Dlabels[7] = b8;Dlabels[8] = b9;Dlabels[9] = b10;Dlabels[10] = b11; }
public Game() throws InterruptedException{
increase.addActionListener(this);
decrease.addActionListener(this);
hit.addActionListener(this);
stand.addActionListener(this);
deal.addActionListener(this);
surr.addActionListener(this);
DD.addActionListener(this);
pic.add(a1);
pic.add(a2);
pic.add(a3);
pic.add(a4);
pic.add(a5);
pic.add(a6);
pic.add(a7);
pic.add(a8);
pic.add(a9);
pic.add(a10);
pic.add(a11);
pic.add(b1);
pic.add(b2);
pic.add(b3);
pic.add(b4);
pic.add(b5);
pic.add(b6);
pic.add(b7);
pic.add(b8);
pic.add(b9);
pic.add(b10);
pic.add(b11);
pic.setVisible(true);
Game.add(pic);
but.add(increase);
but.add(decrease);
but.add(deal);
but.add(hit);
but.add(stand);
but.add(surr);
but.add(DD);
but.setVisible(true);
gg.add(bidlabel);
gg.add(score);
score.add(PStatus);
score.add(DStatus);
gg.add(PMoney);
gg.setVisible(true);
Game.add(but);
Game.add(gg);
Game.setVisible(true);
PshowCard(hamza);
DshowCard(dealer);
add(Game);

} 


public static void PshowCard(Better x) throws InterruptedException{
int a = 0;
while(x.cards[a]!=null){
Thread.sleep(200);
Plabels[a].setIcon(new ImageIcon(x.cards[a].returnImage()));
a++;
if (a==12){a=0;}
}
}

public static void DshowCard(Player x) throws InterruptedException{
int a = 0;
while(x.cards[a]!=null){
Thread.sleep(500);
Dlabels[a].setIcon(new ImageIcon(x.cards[a].returnImage()));
a++;
if (a==12){a=0;}
}
}
public static void DshowFCard() throws InterruptedException{
	Thread.sleep(200);
	Image image = null;
	File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/qm.png");
	try {
	image = ImageIO.read(frames);
	} catch (IOException e) {
	e.printStackTrace();
	};
	Dlabels[0].setIcon(new ImageIcon(dealer.cards[0].returnImage()));
	Thread.sleep(200);
	Dlabels[1].setIcon(new ImageIcon(image));
}

public static void PremoveCard(Player x){
	int a = 0;
	Image image = null;
	File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/b.png");
	try {
	image = ImageIO.read(frames);
	} catch (IOException e) {
	e.printStackTrace();
	};
	while(a<11){
		Plabels[a].setIcon(new ImageIcon(image));
		a++;
	}
}

public static void PremoveCard(Better x){
	int a = 0;
	Image image = null;
	File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/b.png");
	try {
	image = ImageIO.read(frames);
	} catch (IOException e) {
	e.printStackTrace();
	};
	while(a<11){
		Plabels[a].setIcon(new ImageIcon(image));
		a++;
	}
}

public static void DremoveCard(Player x){
	int a = 0;
	Image image = null;
	File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/b.png");
	try {
	image = ImageIO.read(frames);
	} catch (IOException e) {
	e.printStackTrace();
	};
	while(a<11){
		Dlabels[a].setIcon(new ImageIcon(image));
		a++;
	}
}

public static void compare (Player x, Better z) throws InterruptedException{
	if(x.cardValue()>21){PStatus.setText("You won");z.addMoney(bid);Thread.sleep(1000);}
	else if (x.cardValue()==z.cardValue()){PStatus.setText("Draw"); DStatus.setText("Draw");Thread.sleep(1000);}
	else if (x.cardValue()<z.cardValue()){PStatus.setText("You won");z.addMoney(bid);Thread.sleep(1000);}
	else if (x.cardValue()>z.cardValue()) {z.removeMoney(bid); DStatus.setText("Dealer won"); Thread.sleep(1000);}
	hamza.removeCards();
	dealer.removeCards();
	PStatus.setText(String.valueOf(hamza.cardValue()));
	DStatus.setText(String.valueOf(dealer.cardValue()));
	PMoney.setText(String.valueOf(hamza.returnMoney()));
}




public static void main(String[] args) throws InterruptedException{
	Game hamzaPlayer = new Game();
	hamzaPlayer.setTitle("BlackJack");
	hamzaPlayer.setSize(2000,1000);
	hamzaPlayer.setVisible(true);
	PremoveCard(hamza); DremoveCard(dealer);
	hamzaPlayer.addWindowListener(new WindowAdapter()
	{ public void windowClosing (WindowEvent e){		
	System.exit(0); }
	});
	bidlabel.setText(String.valueOf(bid));
	PMoney.setText(String.valueOf(hamza.returnMoney()));
	PStatus.setText(String.valueOf(hamza.cardValue()));
	while(!finish){
	if (hamza.returnMoney()<=0){PStatus.setText("Game over!"); DStatus.setText("Game over!"); finish = true;}
	switch (g){
	case 1: {if(hamza.cardValue()<21){hamza.addCard();
	PshowCard(hamza);
	if(hamza.cardValue()>21){hamza.removeMoney(bid); DStatus.setText("Dealer won"); Thread.sleep(1000); hamza.removeCards(); dealer.removeCards(); 
	DStatus.setText(String.valueOf(dealer.cardValue()));PremoveCard(hamza); DremoveCard(dealer);DremoveCard(dealer); PStatus.setText(String.valueOf(hamza.cardValue())); bidlabel.setText(String.valueOf(bid)); 
	PMoney.setText(String.valueOf(hamza.returnMoney())); deal1=true;} 
	else 
	if(hamza.cardValue()==21){hamza.addMoney(bid);PStatus.setText("BlackJack!");Thread.sleep(1000); hamza.removeCards(); dealer.removeCards();PremoveCard(hamza); DremoveCard(dealer);
	bidlabel.setText(String.valueOf(bid)); PStatus.setText(String.valueOf(hamza.cardValue())); PMoney.setText(String.valueOf(hamza.returnMoney())); hamza.removeCards(); deal1=true;} 
	else {PStatus.setText(String.valueOf(hamza.cardValue())); Thread.sleep(1000);PStatus.setText(String.valueOf(hamza.cardValue()));	bidlabel.setText(String.valueOf(bid));}}
		g = 0; break;}
	case 2: {{while((dealer.cardValue()+3)<21){dealer.addCard();}
	if (hamza.cardValue()>dealer.cardValue()){dealer.addCard();}
	DshowCard(dealer);
	DStatus.setText(String.valueOf(dealer.cardValue()));
	compare(dealer, hamza);
	PremoveCard(hamza);	DremoveCard(dealer);
	hamza.removeCards();
	dealer.removeCards();
	deal1 = true;}
	g=0;break;}
	
	case 3:{
dealer.addCard(); dealer.addCard(); hamza.addCard(); hamza.addCard(); DshowFCard(); PshowCard(hamza); PStatus.setText(String.valueOf(hamza.cardValue()));
DStatus.setText(String.valueOf(dealer.cards[0].getValue()));if(hamza.cardValue()==21){hamza.addMoney(bid);PStatus.setText("BlackJack!");Thread.sleep(1000); hamza.removeCards(); dealer.removeCards();PremoveCard(hamza); DremoveCard(dealer);
bidlabel.setText(String.valueOf(bid)); PStatus.setText(String.valueOf(hamza.cardValue())); PMoney.setText(String.valueOf(hamza.returnMoney())); hamza.removeCards(); DStatus.setText(String.valueOf(dealer.cardValue()));deal1=true;} else {deal1 = false;} g=0; break;}
	
	case 4:{hamza.removeMoney(bid); DStatus.setText("Dealer won"); Thread.sleep(1000); hamza.removeCards(); dealer.removeCards(); 
	DStatus.setText(String.valueOf(dealer.cardValue()));PremoveCard(hamza); DremoveCard(dealer);DremoveCard(dealer); PStatus.setText(String.valueOf(hamza.cardValue())); bidlabel.setText(String.valueOf(bid)); 
	PMoney.setText(String.valueOf(hamza.returnMoney())); deal1=true; g=0; break;}
	
	case 5:{hamza.addCard(); bid*=2; 	PshowCard(hamza); if(hamza.cardValue()==21){hamza.addMoney(bid);PStatus.setText("BlackJack!");
	Thread.sleep(1000); hamza.removeCards(); dealer.removeCards();PremoveCard(hamza); DremoveCard(dealer);
	bid/=2; bidlabel.setText(String.valueOf(bid)); PStatus.setText(String.valueOf(hamza.cardValue())); 
	PMoney.setText(String.valueOf(hamza.returnMoney())); hamza.removeCards(); deal1=true; g=0; break;} 
	
	if(hamza.cardValue()>21)
	{hamza.removeMoney(bid); 
	DStatus.setText("Dealer won"); 
	Thread.sleep(1000); 
	hamza.removeCards(); 
	dealer.removeCards(); 
	DStatus.setText(String.valueOf(dealer.cardValue()));
	PremoveCard(hamza); 
	DremoveCard(dealer);
	DremoveCard(dealer); 
	PStatus.setText(String.valueOf(hamza.cardValue())); 
	bid/=2; 
	bidlabel.setText(String.valueOf(bid)); 
	PMoney.setText(String.valueOf(hamza.returnMoney())); 
	bid/=2;
	deal1=true; 
	g=0; 
	break;}
	
	{while((dealer.cardValue()+3)<21)
	{dealer.addCard();}
	if (hamza.cardValue()>dealer.cardValue())
	{dealer.addCard();}
	DshowCard(dealer);
	DStatus.setText(String.valueOf(dealer.cardValue()));
	}	
	compare(dealer, hamza);
	DshowCard(dealer);
	PremoveCard(hamza);
	DremoveCard(dealer);
	hamza.removeCards();
	dealer.removeCards();
	deal1 = true;
	g=0;break;}}
	}
	}


@Override
public void actionPerformed(ActionEvent arg0) {
	if (finish==false)
	{if (arg0.getSource()==increase){
	if (bid<hamza.returnMoney())
	bid+=4;
	bidlabel.setText(String.valueOf(bid));
} 
	if (arg0.getSource()==decrease){
	if(bid>4){bid-=4;
	bidlabel.setText(String.valueOf(bid));}
	
}
	if (arg0.getSource()==hit){
	if(!deal1){g = 1;}
	}
	
	if (arg0.getSource()==stand){
    if(!deal1){g = 2;}
	}
	
	if(arg0.getSource()==deal){
	if (deal1){g = 3;}	
	}
	if(arg0.getSource()==surr){
	if (!deal1){g = 4;}	
	}
	if(arg0.getSource()==DD){
	if (!deal1){g = 5;}	
	}
	
	
}}}
