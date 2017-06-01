import java.awt.Image;
import java.util.ArrayList;

public class Animation {//Animation class handles animation
	
	private ArrayList scenes;//All images needed for animation
	private int sceneIndex;//Access list
	private long movieTime;//Running time of animation
	private long totalTime;//Total time of animation
	private long sceneTime;
	
	//Constructor
	public Animation(){
		scenes = new ArrayList();//list of each image for animation
		totalTime = 0;//total running time
		start();//start
	}
	
	//Add scene to Array List and set the time for each scene
	public synchronized void addScene(Image i, long t){//Image and time for each scene
		totalTime += t;
		scenes.add(new OneScene(i, totalTime));//Each picture is one scene
	}
	
	//start animation from beginning; called every time it restarts
	public synchronized void start(){
		movieTime = 0;//current time to contrast against total time
		sceneIndex = 0;//Start at first scene; beginning of animation
	}
	
	//change scenes
	public synchronized void update(int count,long timePassed /*time passed from last update*/){
		if (scenes.size()>1){
			movieTime += timePassed;
			sceneTime += timePassed;
			
			if(count > scenes.size()){//time of animation does not exceed limit so it can restart animation; doesn't get stuck on last frame
				System.out.println("reset");
				movieTime = 0;
				sceneIndex = 0;
			}
			while(sceneTime > getScene(sceneIndex).endTime){
				System.out.println(sceneIndex);
				sceneIndex++;
				System.out.println(sceneIndex);
				sceneTime = 0;
				System.out.println("animated" + scenes.size());
				count++;
				System.out.println("Count:" + count);
				timePassed = 0;
			}
		}
	}
	//get animations current scene (aka image)
	public synchronized Image getImage(){
		if(scenes.size()== 0){
			return null;
		}
		else{
			return getScene(sceneIndex).pic;
		}
	}
	//get Scene
	private OneScene getScene(int x){
		return (OneScene)scenes.get(x);
	}
	//Private Inner Class
	private class OneScene{
		Image pic;
		long endTime;
		
		public OneScene(Image pic, long endTime){
			this.pic = pic;
			this.endTime = endTime;
		}
	}

}
