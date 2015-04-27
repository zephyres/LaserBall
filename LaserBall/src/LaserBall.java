import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class LaserBall extends StateBasedGame {
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new LaserBall("LaserBall"));
		
		app.setAlwaysRender(true);
		app.setShowFPS(false);
		app.setTargetFrameRate(60);
		app.setDisplayMode(1280, 720, false);
	}
	
	public LaserBall(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		
	}
}