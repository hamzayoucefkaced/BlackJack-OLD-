import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
//Randomly generate possibility for ace, j, q, k then assign value accordingly
public class Card {

private int value;
private Image image; 

public Card(Better better){
Random now = new Random();
value = now.nextInt(12);
switch(value){
case 0 : {if(better.cardValue()<11){value=11;} if (better.cardValue()>=11){value=1;}		
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/ace.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};
break;}
case 1: {value=2;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/2.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};
break;}
case 2 : {value=3;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/3.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
}
break;}
case 3 : {value=4;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/4.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};
break;}
case 4 : {value=5;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/5.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};
break;}
case 5 : {value=6;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/6.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};
break;}
case 6 : {value=7;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/7.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
case 7 : {value=8;File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/8.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
case 8 : {value=9;File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/9.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
case 9 : {value=10;File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/q.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
case 10 : {value=10;File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/j.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
case 11 : {value=10;File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/k.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
}
}

public Card(Player x){
Random now = new Random();
value = now.nextInt(12);
switch(value){
case 0 : {if(x.cardValue()<11){value=11;} if (x.cardValue()>=11){value=1;};		
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/ace.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};
break;}
case 1: {value=2;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/2.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};
break;}
case 2 : {value=3;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/3.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
}
break;}
case 3 : {value=4;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/4.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};
break;}
case 4 : {value=5;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/5.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};
break;}
case 5 : {value=6;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/6.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};
break;}
case 6 : {value=7;
File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/7.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
case 7 : {value=8;File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/8.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
case 8 : {value=9;File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/9.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
case 9 : {value=10;File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/q.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
case 10 : {value=10;File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/j.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
case 11 : {value=10;File frames = new File("C:/Users/Hamza/Desktop/Programming shit/BlackJack/k.png");
try {
image = ImageIO.read(frames);
} catch (IOException e) {
e.printStackTrace();
};break;}
}
}

public int getValue(){
	return value;
}


public Image returnImage(){
	return image;
}




}