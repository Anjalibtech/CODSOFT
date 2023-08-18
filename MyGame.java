import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MyGame implements ActionListener{
	Frame f1= new Frame("Welcome");
	Frame f2=new Frame("Game");
	Label l1 = new Label ("Welcome to the \"NUMBER GAME\"");
	int attempts = 10;
	Label l2 = new Label ("\"You have 10 attempts to guess a number between 1 and 100.\"");
	Label l3 = new Label("Enter your guess:");
	Label l4 = new Label("Score: ");
	int sc=0;
	Label l5 = new Label(String.valueOf(sc));
	Label l6=new Label(": Play Again");
	Button b3=new Button("()");
	Label l7=new Label();
	TextField t1= new TextField();
	Button b1 = new Button("Play");
	Button b2=new Button("Did I guess it right?");
	int act_num,guess;
	int min = 1;
	int max = 100;
	Dialog dialog = new Dialog(f2, "Thinking of giving up...");
	Label GiveUp = new Label("Do you want to give up?");
	Button giveUP = new Button("YES");
	Button close=new Button("NO");
	Dialog dialog1 = new Dialog(f2, "Congratulations :-)");
	Label PlayMore = new Label("Do you want to play more?");
	Button playMore = new Button("YES");
	Button Close=new Button("NO");
	Dialog dialog2 = new Dialog(f2, "No Worries! You can play once again/");
	Label PlayAgain = new Label("Do you want to play again?");
	Button playAgain = new Button("YES");
	Button ClosE=new Button("NO");
	MyGame(){
		l1.setBounds(400, 250, 500, 30);
		l1.setFont(new Font("Arial", Font.PLAIN, 30));
		l1.setForeground(Color.green.darker());
		f1.add(l1);

		b1.setBounds(588,300,100,50);
		b1.setFont(new Font("Arial", Font.PLAIN, 30));
		b1.setForeground(Color.white);
		b1.setBackground(Color.green.darker());
		b1.addActionListener(this);
		f1.add(b1);

		f1.setSize(1500,1000);
		f1.setLayout(null);
		f1.setVisible(true);
		//f2.setVisible(true);

		l4.setBounds(130, 50, 100, 40);
		l4.setFont(new Font("Arial", Font.PLAIN, 30));
		l4.setForeground(Color.green.darker());
		f2.add(l4);

		l5.setBounds(230, 50, 200, 40);
		l5.setFont(new Font("Arial", Font.PLAIN, 30));
		l5.setForeground(Color.darkGray);
		f2.add(l5);


		l6.setBounds(940, 50, 160, 40);
		l6.setFont(new Font("Arial", Font.PLAIN, 30));
		l6.setForeground(Color.green.darker());
		f2.add(l6);

		b3.setBounds(890, 50, 40, 40);
		b3.setFont(new Font("Arial", Font.PLAIN, 30));
		b3.setForeground(Color.white);
		b3.setBackground(Color.green.darker());
		b3.addActionListener(this);
		f2.add(b3);

		l2.setBounds(230, 100, 850, 40);
		l2.setFont(new Font("Arial", Font.PLAIN, 30));
		l2.setForeground(Color.red);
		f2.add(l2);

		l3.setBounds(330, 180, 300, 40);
		l3.setFont(new Font("Arial", Font.PLAIN, 30));
		l3.setForeground(Color.green.darker());
		f2.add(l3);

		t1.setBounds(700, 180, 185, 40);
		t1.setFont(new Font("Arial", Font.PLAIN, 30));
		t1.setForeground(Color.gray);
		t1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					guess = Integer.parseInt(t1.getText());
					t1.setText("");
					dialog.setVisible(false);
					if (guess == act_num) {
						sc++;
						l7.setText("Congratulation! Your guess is right.");
						l5.setText("" + sc);
						l3.setEnabled(false);
						t1.setEnabled(false);
						b2.setEnabled(false);
						dialog.setVisible(false);
						dialog1.setVisible(true);
					}
					else if (guess > act_num) {
						attempts--;
						l7.setText("Oops! "+guess + " is too high.");
						if(attempts<=4)
							dialog.setVisible(true);
					}
					else {
						attempts--;
						l7.setText("Oops! "+guess + " is too low.");
						if(attempts<=4)
							dialog.setVisible(true);
					}
					l2.setText("\"You have "+ attempts+" attempts to guess a number between 1 and 100.\"");
					if (attempts == 0) {
						l7.setText("You ran out of attempts. The number was " + act_num + ".");
						b2.setEnabled(false);
						l3.setEnabled(false);
						t1.setEnabled(false);
						dialog.setVisible(false);
						dialog2.setVisible(true);
					}
				}
			}
		});
		f2.add(t1);

		b2.setBounds(320,260,620,50);
		b2.setFont(new Font("Arial", Font.PLAIN, 30));
		b2.setForeground(Color.white);
		b2.setBackground(Color.green.darker());
		b2.addActionListener(this);
		f2.add(b2);

		l7.setBounds(400,340,620,50);
		l7.setFont(new Font("Arial", Font.PLAIN, 30));
		l7.setForeground(Color.green.darker());
		f2.add(l7);

		dialog.setLayout(new FlowLayout());
		dialog.setLocation(510,0);
		dialog.setSize(300, 150);
		giveUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l7.setText("You gave up. The number was " + act_num + ".");
				l3.setEnabled(false);
				t1.setEnabled(false);
				b3.setEnabled(true);
				b2.setEnabled(false);
				sc=0;
				dialog.setVisible(false);
			}
		});
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});
		GiveUp.setFont(new Font("Arial", Font.PLAIN, 20));
		giveUP.setFont(new Font("Arial", Font.PLAIN, 20));
		close.setFont(new Font("Arial", Font.PLAIN, 20));
		dialog.add(GiveUp);
		dialog.add(giveUP);
		dialog.add(close);

		dialog1.setLayout(new FlowLayout());
		dialog1.setLocation(510,0);
		dialog1.setSize(300, 150);
		playMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog1.setVisible(false);
				dialog.setVisible(false);
				//tt.setText("Great! Let's play once more time.");
				l3.setEnabled(true);
				t1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
				t1.setText("");
				l7.setText("");
				attempts = 10;
				act_num = (int) (Math.random() * (max - min + 1)) + min;
				l2.setText("\"You have "+ attempts+" attempts to guess a number between 1 and 100.\"");
				//tt.setText("");
			}
		});
		Close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dialog1.setVisible(false);
				dialog.setVisible(false);
				attempts=10;
				b3.setEnabled(true);
				f2.setVisible(false);
				f1.setVisible(true);
			}
		});
		PlayMore.setFont(new Font("Arial", Font.PLAIN, 20));
		playMore.setFont(new Font("Arial", Font.PLAIN, 20));
		Close.setFont(new Font("Arial", Font.PLAIN, 20));
		dialog1.add(PlayMore);
		dialog1.add(playMore);
		dialog1.add(Close);

		dialog2.setLayout(new FlowLayout());
		dialog2.setLocation(510,0);
		dialog2.setSize(300, 150);
		playAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog2.setVisible(false);
				l3.setEnabled(true);
				t1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
				dialog.setVisible(false);
				attempts = 10;
				act_num = (int) (Math.random() * (max - min + 1)) + min;
				sc = 0;
				t1.setText("");
				l7.setText("");
				l5.setText("" + sc);
				/*if(attempts<=4){
					l2.setForeground(Color.red);
				}*/
				l2.setText("\"You have "+ attempts+" attempts to guess a number between 1 and 100.\"");
			}
		});
		ClosE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dialog2.setVisible(false);
				dialog.setVisible(false);
				f2.setVisible(false);
				f1.setVisible(true);
				b3.setEnabled(true);
			}
		});
		PlayAgain.setFont(new Font("Arial", Font.PLAIN, 20));
		playAgain.setFont(new Font("Arial", Font.PLAIN, 20));
		ClosE.setFont(new Font("Arial", Font.PLAIN, 20));
		dialog2.add(PlayAgain);
		dialog2.add(playAgain);
		dialog2.add(ClosE);

		Random rand = new Random();
		act_num = rand.nextInt(max - min + 1) + min;

		f2.setSize(1500,1000);
		f2.setLayout(null);
	}
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == b1) {
				f1.setVisible(false);

				f2.setVisible(true);

				t1.setText("");
				l7.setText("");
				attempts=10;
				sc=0;
				l5.setText(""+sc);
				l2.setText("\"You have "+ attempts+" attempts to guess a number between 1 and 100.\"");
				l3.setEnabled(true);
				t1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
			}
			else if (e.getSource() == b2) {
				guess = Integer.parseInt(t1.getText());
				t1.setText("");
				dialog.setVisible(false);
				if (guess == act_num) {
					sc++;
					l7.setText("Congratulation! Your guess is right.");
					l5.setText("" + sc);
					l3.setEnabled(false);
					t1.setEnabled(false);
					b2.setEnabled(false);
					dialog.setVisible(false);
					dialog1.setVisible(true);
				}
				else if (guess > act_num) {
					attempts--;
					l7.setText("Oops! "+guess + " is too high.");
					if(attempts<=4)
					dialog.setVisible(true);
				}
				else {
					attempts--;
					l7.setText("Oops! "+guess + " is too low.");
					if(attempts<=4)
					dialog.setVisible(true);
				}
				l2.setText("\"You have "+ attempts+" attempts to guess a number between 1 and 100.\"");
				if (attempts == 0) {
					l7.setText("You ran out of attempts. The number was " + act_num + ".");
					b2.setEnabled(false);
					l3.setEnabled(false);
					t1.setEnabled(false);
					dialog.setVisible(false);
					dialog2.setVisible(true);
				}
			}
			else if (e.getSource() == b3) {
				attempts = 10;
				act_num = (int) (Math.random() * (max - min + 1)) + min;
				sc = 0;
				l3.setEnabled(true);
				t1.setEnabled(true);
				b2.setEnabled(true);
				l5.setText("" + sc);
				t1.setText("");
				l2.setText("\"You have "+ attempts+" attempts to guess a number between 1 and 100.\"");
			}
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public static void main(String[] args) {
		MyGame m=new MyGame();
	}
}
