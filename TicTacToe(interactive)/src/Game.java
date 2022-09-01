import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame implements ActionListener{
	JButton butoni1 = new JButton(" ");	
	JButton butoni2 = new JButton(" ");
	JButton butoni3 = new JButton(" ");
	JButton butoni4 = new JButton(" ");	
	JButton butoni5 = new JButton(" ");
	JButton butoni6 = new JButton(" ");
	JButton butoni7 = new JButton(" ");	
	JButton butoni8 = new JButton(" ");
	JButton butoni9 = new JButton(" ");
	JButton retry = new JButton("Play again");
	int m = 0;
	static String p1;
	static String p2;
	JLabel label1= new JLabel("It's "+p1+"'s turn.");
	JButton[] buttons = {butoni1,butoni2,butoni3,butoni4,butoni5,butoni6,butoni7,butoni8,butoni9};
	String[] value = {"X","O","X","O","X","O","X","O","X"};
	String[] turn= {"It's "+p2+"'s turn.","It's "+p1+"'s turn.","It's "+p2+"'s turn.","It's "+p1+"'s turn.","It's "+p2+"'s turn.","It's "+p1+"'s turn.","It's "+p2+"'s turn.","It's "+p1+"'s turn.","Game over! It's a draw."};

	public static void Players() {
		String input1 = JOptionPane.showInputDialog("Enter the name of the first player:");
		String player1 = input1;
		String input2 = JOptionPane.showInputDialog("Enter the name of the second player:");
		String player2 = input2;
		p1=player1;
		p2=player2;
	}
	public Game() {
		super("TicTacToe Game");
		setSize(800,900);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=this.getContentPane();
		c.setBackground(Color.white);
		c.setLayout(new FlowLayout());
		label1.setPreferredSize(new Dimension(600, 100));
		label1.setVerticalAlignment(JLabel.CENTER);
	    label1.setFont(new Font("Verdana", Font.PLAIN, 25));
		
	    retry.setPreferredSize(new Dimension(200,70));
	    for (int i=0;i<buttons.length;i++) {
	    	buttons[i].setPreferredSize(new Dimension(200, 200));
	    }
	    
		retry.setFont(new Font("Verdana", Font.PLAIN, 25) );
	    for (int i=0;i<buttons.length;i++) {
	    	buttons[i].setFont(new Font("Verdana", Font.BOLD, 150));
	    }
		
		retry.addActionListener(this);
		for (int i=0;i<buttons.length;i++) {
	    	buttons[i].addActionListener(this);
	    }
		
		c.add(label1);
		for (int i=0;i<buttons.length;i++) {
	    	c.add(buttons[i]);
	    }
		c.add(retry);
		setContentPane(c);
		
		retry.setVisible(false);
	}
	
	public static void main(String[] args) {
		Game.Players();
		Game loje = new Game();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0;i<buttons.length;i++) {
			if (e.getSource()==buttons[i]) {
				if (buttons[i].getText()==" "){
					buttons[i].setText(value[m]);
					label1.setText(turn[m]);
					m++;}
			}
		}
		if (m==9) {
			retry.setVisible(true);
			}
		if (e.getSource()==retry) {
			label1.setText("It's "+p1+"'s turn.");
			m=0;
			for (int i=0;i<buttons.length;i++) {
		    	buttons[i].setText(" ");
		    }
			for (int i=0;i<buttons.length;i++) {
		    	buttons[i].setEnabled(true);
		    }
			retry.setVisible(false);
		}
		if ((butoni1.getText()=="X"&&butoni1.getText()==butoni4.getText()&&butoni4.getText()==butoni7.getText())||(butoni2.getText()=="X"&&butoni2.getText()==butoni5.getText()&&butoni5.getText()==butoni8.getText())||(butoni3.getText()=="X"&&butoni3.getText()==butoni6.getText()&&butoni6.getText()==butoni9.getText())||
			(butoni1.getText()=="X"&&butoni1.getText()==butoni2.getText()&&butoni2.getText()==butoni3.getText())||(butoni4.getText()=="X"&&butoni4.getText()==butoni5.getText()&&butoni5.getText()==butoni6.getText())||(butoni7.getText()=="X"&&butoni7.getText()==butoni8.getText()&&butoni8.getText()==butoni9.getText())||
			(butoni1.getText()=="X"&&butoni1.getText()==butoni5.getText()&&butoni5.getText()==butoni9.getText())||(butoni3.getText()=="X"&&butoni3.getText()==butoni5.getText()&&butoni5.getText()==butoni7.getText())) {
			label1.setText(p1+" is the winner!");
			retry.setVisible(true);
			for (int i=0;i<buttons.length;i++) {
		    	buttons[i].setEnabled(false);
		    }
		}
		if ((butoni1.getText()=="O"&&butoni1.getText()==butoni4.getText()&&butoni4.getText()==butoni7.getText())||(butoni2.getText()=="O"&&butoni2.getText()==butoni5.getText()&&butoni5.getText()==butoni8.getText())||(butoni3.getText()=="O"&&butoni3.getText()==butoni6.getText()&&butoni6.getText()==butoni9.getText())||
			(butoni1.getText()=="O"&&butoni1.getText()==butoni2.getText()&&butoni2.getText()==butoni3.getText())||(butoni4.getText()=="O"&&butoni4.getText()==butoni5.getText()&&butoni5.getText()==butoni6.getText())||(butoni7.getText()=="O"&&butoni7.getText()==butoni8.getText()&&butoni8.getText()==butoni9.getText())||
			(butoni1.getText()=="O"&&butoni1.getText()==butoni5.getText()&&butoni5.getText()==butoni9.getText())||(butoni3.getText()=="O"&&butoni3.getText()==butoni5.getText()&&butoni5.getText()==butoni7.getText())) {
				label1.setText(p2+" is the winner!");
				retry.setVisible(true);
				for (int i=0;i<buttons.length;i++) {
			    	buttons[i].setEnabled(false);
			    }
		}
	}
}
