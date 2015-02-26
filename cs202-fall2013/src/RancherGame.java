import java.util.ArrayList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;

public class RancherGame extends JFrame implements BoardSettings {

	private static final long serialVersionUID = 7883610549309925809L;

	RangeCanvas drawingCanvas;
	StartTimer startTimer;
	JTextField fileNameBox;
	JTextField ns1Box;
	JTextField ns2Box;
	JTextField nwBox;
	JTextField mainText;
	int mouseX, mouseY;
	JButton pl1Button = new JButton("Player 1");
	JButton pl2Button = new JButton("Player 2");
	int counter = 0;
	private Timer timer = new Timer(1000, new TimerListener());
	ArrayList<Entity> animals = new ArrayList<Entity>();

	public RancherGame() {
		drawingCanvas = new RangeCanvas();
		startTimer = new StartTimer();

		fileNameBox = new JTextField("data.txt");
		fileNameBox.setPreferredSize(new Dimension(80, 24));

		JLabel jl1 = new JLabel("#S: ");
		jl1.setBounds(400, 50, 30, 50);
		JLabel jl2 = new JLabel("#S: ");
		jl2.setBounds(400, 150, 30, 50);
		JLabel jl3 = new JLabel("#W: ");
		jl3.setBounds(400, 250, 30, 50);
		ns1Box = new JTextField("3");
		ns1Box.setPreferredSize(new Dimension(30, 24));
		ns1Box.setBounds(450, 50, 30, 30);
		ns2Box = new JTextField("3");
		ns2Box.setBounds(450, 150, 30, 30);
		ns2Box.setPreferredSize(new Dimension(30, 24));
		nwBox = new JTextField("4");
		nwBox.setBounds(450, 250, 30, 30);
		nwBox.setPreferredSize(new Dimension(30, 24));
		
		mainText = new JTextField("Welcome to Rancher Game...");
		mainText.setFont(new Font(Font.DIALOG,Font.BOLD,25));
		mainText.setBounds(50, 500, 450, 60);
		
		drawingCanvas.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("(x,y) = ("+e.getX()+", "+e.getY()+")");
				mouseX = e.getX();
				mouseY = e.getY();
			}
				
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		
		pl1Button.setBackground(Color.blue);
		pl1Button.setBounds(400, 100, 150, 40);
		
		pl2Button.setBounds(400, 200, 150, 40);

		JButton startButton = new JButton("START");
		startButton.addActionListener(new actionEntitiesRandom());
		startButton.setBounds(350, 350, 89, 23);// (30, 11, 384, 142);(30, 11,
													// 330, 330);(167, 164, 89,
													// 23);

		JButton btnWest = new JButton("West");
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You moved west");
				if(counter % 2 == 0)
				{
					drawingCanvas.moveSheepWest(0, mouseX, mouseY);
					pl2Button.setBackground(Color.pink);
					pl1Button.setBackground(null);
					if(drawingCanvas.CheckForDeadSheep() != 2)
						counter++;
					else
					{
						mainText.setText("End of Player2...");
						counter+= 2;
					}
					drawingCanvas.repaint();
				}
				else
				{
					drawingCanvas.moveSheepWest(1, mouseX, mouseY);
					pl1Button.setBackground(Color.blue);
					pl2Button.setBackground(null);
					if(drawingCanvas.CheckForDeadSheep() != 1)
						counter++;
					else
					{
						counter+=2;
						mainText.setText("End of Player1...");
					}
					drawingCanvas.repaint();
				}
			}
		});
		btnWest.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnWest.setBounds(68, 400, 89, 23);

		JButton btnEast = new JButton("East");
		btnEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You moved East");
				if(counter % 2 == 0)
				{
					drawingCanvas.moveSheepEast(0, mouseX, mouseY);
					pl2Button.setBackground(Color.pink);
					pl1Button.setBackground(null);
					if(drawingCanvas.CheckForDeadSheep() != 2)
						counter++;
					else
					{
						counter+= 2;
						mainText.setText("End of Player2...");
					}
					drawingCanvas.repaint();
				}
				else
				{
					drawingCanvas.moveSheepEast(1, mouseX, mouseY);
					pl1Button.setBackground(Color.blue);
					pl2Button.setBackground(null);
					if(drawingCanvas.CheckForDeadSheep() != 1)
						counter++;
					else
					{
						mainText.setText("End of Player1...");
						counter+=2;
					}
					drawingCanvas.repaint();
				}
			}
		});
		btnEast.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEast.setBounds(268, 400, 89, 23);

		JButton btnSouth = new JButton("South");
		btnSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You moved South");
				if(counter % 2 == 0)
				{
					drawingCanvas.moveSheepSouth(0, mouseX, mouseY);
					pl2Button.setBackground(Color.pink);
					pl1Button.setBackground(null);
					if(drawingCanvas.CheckForDeadSheep() != 2)
						counter++;
					else
					{
						counter+= 2;
						mainText.setText("End of Player2...");
					}
					drawingCanvas.repaint();
				}
				else
				{
					drawingCanvas.moveSheepSouth(1, mouseX, mouseY);
					pl1Button.setBackground(Color.blue);
					pl2Button.setBackground(null);
					if(drawingCanvas.CheckForDeadSheep() != 1)
						counter++;
					else
					{
						counter+=2;
						mainText.setText("End of Player1...");
					}
					drawingCanvas.repaint();
				}
			}
		});
		btnSouth.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSouth.setBounds(167, 450, 89, 23);

		JButton btnNorth = new JButton("North");
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You moved North");
				if(counter % 2 == 0)
				{
					drawingCanvas.moveSheepNorth(0, mouseX, mouseY);
					pl2Button.setBackground(Color.pink);
					pl1Button.setBackground(null);
					if(drawingCanvas.CheckForDeadSheep() != 2)
						counter++;
					else
					{
						counter+= 2;
						mainText.setText("End of Player2...");
					}
					drawingCanvas.repaint();
				}
				else
				{
					drawingCanvas.moveSheepNorth(1, mouseX, mouseY);
					pl1Button.setBackground(Color.blue);
					pl2Button.setBackground(null);
					if(drawingCanvas.CheckForDeadSheep() != 1)
						counter++;
					else
					{
						counter+=2;
						mainText.setText("End of Player1...");
					}
					drawingCanvas.repaint();
				}
			}
		});
		btnNorth.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNorth.setBounds(167, 350, 89, 23);

		JPanel top = new JPanel();
		top.setLayout(new FlowLayout());
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 1));

		// top.add( new JLabel("Filename ") );
		// top.add(fileNameBox);
		// top.add(readButton);

		bottom.add(drawingCanvas);
		//bottom.add(randomButton);

		drawingCanvas.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(
				0, 0, 0)));
		drawingCanvas.setBounds(30, 11, 330, 330);
		
		if(counter % 2 == 0)
		{
			
		}
		else
		{
			
		}

		// this.add(top);
		this.setLayout(null);
		this.add(jl1);
		this.add(jl2);
		this.add(jl3);
		this.add(ns1Box);
		this.add(ns2Box);
		this.add(nwBox);
		this.add(drawingCanvas);
		this.add(pl1Button);
		this.add(pl2Button);
		this.add(mainText);
		this.getContentPane().add(startButton);
		this.getContentPane().add(btnWest);
		this.getContentPane().add(btnEast);
		this.getContentPane().add(btnNorth);
		this.getContentPane().add(btnSouth);
		// this.pack();
	}

	class actionEntitiesRandom implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// update so that you get the correct values from text field
			// -- begin update --
			int NS = Integer.valueOf(ns1Box.getText());
			int NS2 = Integer.valueOf(ns2Box.getText());
			int WS = Integer.valueOf(nwBox.getText());

			// -- end update --
			drawingCanvas.CreateAnimalsWithRandomLocations(NS, WS);
			drawingCanvas.addSecondPlayer(NS2);
			drawingCanvas.repaint();
			mainText.setText("Change #S, press Start to start again");
			//timer.start();
			//animals = nanimals;
			// drawingCanvas.startTimer(animals, NS, WS);
		}
	}

	public static void main(String args[]) {
		RancherGame c = new RancherGame();
		// c.setLayout(new GridLayout(2, 1));
		c.setSize(B_WIDTH, B_HEIGHT);
		c.setVisible(true);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!drawingCanvas.startTimer(animals))
				timer.stop();
			drawingCanvas.repaint();
		}
	}
}
