

import java.io.File;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RancherGame extends JFrame implements BoardSettings {

	private static final long serialVersionUID = 7883610549309925809L;

	RangeCanvas drawingCanvas;
	JTextField fileNameBox;
	JTextField nsBox;
	JTextField nwBox;
	
	public RancherGame() {
		drawingCanvas = new RangeCanvas();

		fileNameBox = new JTextField("data.txt");
		fileNameBox.setPreferredSize( new Dimension( 80, 24 ) );
		
		JButton readButton = new JButton("READ");
		readButton.addActionListener( new actionEntitiesReadFromFile() );

		nsBox = new JTextField("1");
		nsBox.setPreferredSize( new Dimension( 30, 24 ) );
		nwBox = new JTextField("4");
		nwBox.setPreferredSize( new Dimension( 30, 24 ) );

		JButton randomButton = new JButton("RANDOM");
		randomButton.addActionListener( new actionEntitiesRandom() );
		
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout());
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 1));

		top.add( new JLabel("Filename ") );
		top.add(fileNameBox);
		top.add(readButton);
		
		top.add( new JLabel(" #S ") );
		top.add(nsBox);
		top.add( new JLabel(" #W ") );
		top.add(nwBox);
		top.add(randomButton);
		
		bottom.add(drawingCanvas);

		this.add(top);
		this.add(bottom);
		// this.pack();
	}
	
	class actionEntitiesReadFromFile implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// update this so that it grabs the correct value from text field
			// -- begin update --
			String fileName = "data.txt";
			// -- end update --
			
			drawingCanvas.ReadFromFile(new File(fileName));
			drawingCanvas.repaint();
		}
	}
	
	class actionEntitiesRandom implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// update so that you get the correct values from text field
			// -- begin update --
			int NS = 2;
			int WS = 2;
			// -- end update --
			drawingCanvas.CreateAnimalsWithRandomLocations(NS, WS);
			drawingCanvas.repaint();
		}
	}
	
	public static void main(String args[]) {
		RancherGame c = new RancherGame();
		c.setLayout(new GridLayout(2, 1));
		c.setSize(B_WIDTH, B_HEIGHT);
		c.setVisible(true);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
