package edu.calstatela.cs202.gala.project;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class GUI {

	private JFrame mainFrame;
	private JPanel gamePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setForeground(new Color(102, 0, 0));
		mainFrame.setBackground(new Color(102, 0, 0));
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		int x = 0, newX = 0;
		int y = 0, newY = 0;
		
		gamePanel = new JPanel();
		gamePanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		gamePanel.setBounds(30, 11, 384, 142);
		int B_HEIGHT = gamePanel.getHeight();
		int B_WIDTH = gamePanel.getWidth();
		
		mainFrame.getContentPane().add(gamePanel);
		
		JButton btnNorth = new JButton(" North");
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You moved north");
			}
		});
		btnNorth.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNorth.setBounds(167, 164, 89, 23);
		mainFrame.getContentPane().add(btnNorth);
		
		JButton btnSouth = new JButton("South");
		btnSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You moved south");
			}
		});
		btnSouth.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSouth.setBounds(167, 232, 89, 23);
		mainFrame.getContentPane().add(btnSouth);
		
		JButton btnEast = new JButton("East");
		btnEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You moved east");
			}
		});
		btnEast.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEast.setBounds(268, 198, 89, 23);
		mainFrame.getContentPane().add(btnEast);
		
		JButton btnWest = new JButton("West");
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You moved west");
			}
		});
		btnWest.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnWest.setBounds(68, 198, 89, 23);
		mainFrame.getContentPane().add(btnWest);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Create an object of TestConfig
				TestConfig tc = new TestConfig();
				
				//Read the config file
				try {
					tc.read("project.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				TestBoard tb = new TestBoard();
				TestSheep sheep = new TestSheep();
				TestWolf wolf = new TestWolf();
				testGrass grass = new testGrass();
				testTree tree = new testTree();
			}
		});
		btnStart.setBounds(367, 164, 65, 23);
		mainFrame.getContentPane().add(btnStart);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(367, 198, 65, 23);
		mainFrame.getContentPane().add(btnQuit);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "In this game, you must keep the sheep alive by\n preventing starvation and predation by wolves.", "The Rules", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnHelp.setBounds(367, 232, 65, 23);
		mainFrame.getContentPane().add(btnHelp);
	}
	
	
	public void paintComponent(Graphics pen, int B_HEIGHT, int B_WIDTH)
	{
//		super.paintComponent(pen);

		int ystep = B_HEIGHT/20;
		int xstep = B_WIDTH/20;

		for (int i = 0; i < 11; i++) {
			pen.drawLine(0, i*ystep, B_WIDTH, i*ystep);
		}
		
		for (int i = 0; i < 11; i++) {
			pen.drawLine(i*xstep, 0, i*xstep, B_HEIGHT);
		}
	}
	public JPanel getGamePanel() {
		return gamePanel;
	}
}
