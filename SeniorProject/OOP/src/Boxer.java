package src;

public class Boxer {
	private String playerType;
	private String playerMove;
	Damage dCalc = new Damage();
	
	Boxer(String pType, String pMove){
		playerType = pType;
		playerMove = pMove;
	}
	
	//Original method 
	void  Move(String playerMove, int enemyMove){
		if(playerMove.equals("jab")){
			dCalc.Jab(enemyMove);
		}
		else if(playerMove.equals("block")){
			dCalc.Block(enemyMove);
		}
		else if(playerMove.equals("uppercut")){
			dCalc.Uppercut(enemyMove);
		}
		else{
			dCalc.Straight(enemyMove);
		}
	}

	//Set and Get Type of player i.e. HMN, CPU
	public void setplayerType(String playerType){
		this.playerType = playerType;
	}
	public String getplayerType(){
		return playerType;
	}
	//Set and get of the user's move
	public void setplayerMove(String playerMove){
		this.playerMove = playerMove;
	}
	public String getplayerMove(){
		return playerMove;
	}
}
