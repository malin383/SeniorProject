package src;

import java.util.Random;
import javax.swing.JOptionPane;

public class Fight {
	// initialize public variables
	public static int health = 100;
	public static int ehealth = 100;
	public static Random rn = new Random();
	
	public static void main(String[] args) {
		// initialize method variables
		Boxer fighter = new Boxer("HMN", null);
		Boxer enemy = new Boxer("CPU", null);
		JOptionPane.showMessageDialog(null, "Time to FIGHT!");

		while (health > 0 && ehealth > 0) {
			// Enemy option generator
			int emove = rn.nextInt(3);
			@SuppressWarnings("unused")
			String eoption = null;
			if (emove == 0) {
				enemy.setplayerMove("Jab");
				eoption = " jab ";
			} else if (emove == 1) {
				enemy.setplayerMove("Block");
				eoption = " block ";
			} else if (emove == 2) {
				enemy.setplayerMove("Uppercut");
				eoption = " uppercut ";
			} else {
				enemy.setplayerMove("Straight");
				eoption = " straight ";
			}
			for(int i = 0; i != 1;){
				// User Input
				String move = JOptionPane.showInputDialog(null,
						"Player HP: " + health + "" + "\nEnemy: " + ehealth +
								/* empty line */"" + "\n" + "\nWhat will you do?" + "\n(A) Jab" + "\n(B) Block"
								+ "\n(C) UpperCut" + "\n(D) Straight",
						"FIGHT!", JOptionPane.INFORMATION_MESSAGE);
				// Fight Sequence
				i++;
				if (move.equals("a") || move.equals("A")) {
					fighter.setplayerMove("jab");
				} else if (move.equals("b") || move.equals("B")) {
					fighter.setplayerMove("block");
				} else if (move.equals("c") || move.equals("C")) {
					fighter.setplayerMove("uppercut");
				} else if (move.equals("d") || move.equals("D")) {
					fighter.setplayerMove("straight");
				} else {
					JOptionPane.showMessageDialog(null, "Please choose viable option", "FIGHT!", JOptionPane.ERROR_MESSAGE);
					i--;
				}
			}
			//Player and Enemy Move, followed by access to the damage calculator
			JOptionPane.showMessageDialog(null, "You used a " + fighter.getplayerMove() + 
												"! Enemy used " + enemy.getplayerMove() + "!", "FIGHT!", 2);
			fighter.Move(fighter.getplayerMove(), emove);
			
		}
		//End results, code break
		if(health < ehealth){
			JOptionPane.showMessageDialog(null, "You lose!", "LOSER!!", JOptionPane.PLAIN_MESSAGE);
		}
		else{
			JOptionPane.showMessageDialog(null, "You win!", "WINNER!!", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
