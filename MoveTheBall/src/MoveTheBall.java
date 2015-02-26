import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
public class MoveTheBall extends JFrame {
  private JButton jbtLeft = new JButton("Left");
  private JButton jbtRight = new JButton("Right");
  private JButton jbtUp = new JButton("Up");
  private JButton jbtDown = new JButton("Down");
  private CirclePanel canvas = new CirclePanel();
    
  public MoveTheBall() {
    JPanel panel = new JPanel(); // Use the panel to group buttons
    panel.add(jbtLeft);
    panel.add(jbtRight);
    panel.add(jbtUp);
    panel.add(jbtDown);
      
    this.add(canvas, BorderLayout.CENTER); // Add canvas to center
    this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame 
      
    jbtLeft.addActionListener(new BallListener());
    jbtRight.addActionListener(new BallListener());
    jbtUp.addActionListener(new BallListener());
    jbtDown.addActionListener(new BallListener());
  }
    
  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new MoveTheBall();
    frame.setTitle("ControlCircle");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setVisible(true);
  }
   
  class BallListener implements ActionListener { // Inner class
     @Override
     public void actionPerformed(ActionEvent e) {
    	 if(e.getSource() == jbtLeft)
    		 canvas.left();
    	 if(e.getSource() == jbtRight)
    		 canvas.right();
    	 if(e.getSource() == jbtUp)
    		 canvas.up();
    	 if(e.getSource() == jbtDown)
    		 canvas.down();
     }
  }
    
  class CirclePanel extends JPanel 
  { // Inner class
    private int radius = 5; // Default circle radius
        int x = 100, y = 100;
    /** Enlarge the circle */
    public void left() 
    {
    	x = x - 100;
      repaint();
    }
    public void right() 
    {
    	x = x + 100;
        
        repaint();
    }
    public void up() 
    {
        y = y - 100;
        repaint();
    }
    public void down() 
    {
    	
        y = y + 100;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      g.drawOval(x,y,2 * radius, 2 * radius);
    }
  }   
}  