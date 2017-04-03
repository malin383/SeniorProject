package src;

import javax.swing.JOptionPane;

//jab>uppercut>block>straight&jab
//straight>jab&uppercut, 

public class Damage {
	//Variables for damage calculator initiated
	int damageGiven;
	int damageTaken;
	
	//4 methods for each player move, with 4 additional routes for enemy move
	//Variable emoveCalc is initiated in the method to find the enemy option
	public void Jab(int emoveCalc){
		if(emoveCalc == 0){
			JOptionPane.showMessageDialog(null,"Blow were traded!");
			damageGiven = 6;
			damageTaken = 6;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else if(emoveCalc == 1){
			JOptionPane.showMessageDialog(null,"Enemy blocked your attack!");
			 damageGiven = 0;
			 damageTaken = 0;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else if(emoveCalc == 2){
			JOptionPane.showMessageDialog(null,"You interrupted the enemy's uppercut!");
			 damageGiven = 6;
			 damageTaken = 0;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else{
			JOptionPane.showMessageDialog(null,"The enemy's straight broke through your jab");
			 damageGiven = 0;
			 damageTaken = 10;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
	}
	public void Block( int emoveCalc){
		if(emoveCalc == 0){
			JOptionPane.showMessageDialog(null,"You blocked the enemy's attack!");
			 damageGiven = 0;
			 damageTaken = 0;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else if(emoveCalc == 1){
			JOptionPane.showMessageDialog(null,"Stalemate!");
			 damageGiven = 0;
			 damageTaken = 0;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else if(emoveCalc == 2){
			JOptionPane.showMessageDialog(null,"The enemy broke through your block!");
			 damageGiven = 0;
			 damageTaken = 15;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else{
			JOptionPane.showMessageDialog(null,"An opening! You countered the enemy's straight!");
			 damageGiven = 16;
			 damageTaken = 0;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
	}
	public void Uppercut(int emoveCalc){
		if(emoveCalc == 0){
			JOptionPane.showMessageDialog(null,"The enemy's jab interrupted your uppercut");
			damageGiven = 0;
			damageTaken = 6;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else if(emoveCalc == 1){
			JOptionPane.showMessageDialog(null,"You broke through the enemy's block!");
			damageGiven = 15;
			damageTaken = 0;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else if(emoveCalc == 2){
			JOptionPane.showMessageDialog(null,"You traded blows with the enemy!");
			damageGiven = 8;
			damageTaken = 8;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else{
			JOptionPane.showMessageDialog(null,"The enemy interrupts you with a heavy straight! Severe damage!");
			damageGiven = 0;
			damageTaken = 20;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
	}
	public void Straight(int emoveCalc){
		if(emoveCalc == 0){
			JOptionPane.showMessageDialog(null,"Successful straight! The enemy took damage!");
			damageGiven = 16;
			damageTaken = 0;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else if(emoveCalc == 1){
			JOptionPane.showMessageDialog(null,"The enemy saw through your straight and countered!");
			damageGiven = 0;
			damageTaken = 16;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else if(emoveCalc == 2){
			JOptionPane.showMessageDialog(null,"You interrupted the enemy's uppercut and gave heavy damage!");
			damageGiven = 20;
			damageTaken = 0;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
		else{
			JOptionPane.showMessageDialog(null,"You traded blows with the enemy!");
			damageGiven = 8;
			damageTaken = 8;
			Fight.health -= damageTaken;
			Fight.ehealth -= damageGiven;
			JOptionPane.showMessageDialog(null, "You took " + damageTaken + " damage!");
			JOptionPane.showMessageDialog(null, "Enemy took " + damageGiven + " damage!");
		}
	}
}
