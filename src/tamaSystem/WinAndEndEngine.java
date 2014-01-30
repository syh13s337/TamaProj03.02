package tamaSystem;

import tamaGUI.TamaGUIEnd;
import tamaGUI.TamaGUIStart;

/** WIN ENGINE CLASS
 * This class is for winners! 
 * The class will will start a counter and when its reached
 *	player win Tama.
 * 
 *
 */

public class WinAndEndEngine implements Runnable {

	private boolean win = false;
	private GameEngine ge;
	private	TamaGUIEnd tge;

	//in seconds
	private int tamaWinTimer;

	public WinAndEndEngine(GameEngine ge, TamaGUIEnd tge){
		this.ge = ge;
		this.tge = tge;
	}
	
	public WinAndEndEngine(){
	}
	
	//The loop, Win checker
	@Override
	public void run() {
		tamaWinTimer = 3600;

		if(ge.getGameLevel() == 3){

		}
		else if (ge.getGameLevel() <= 2){
			int x = 0;
			int z = 1;
			while(z == 1){
				if(tamaWinTimer <= x){
					win = true;
					z = 0;
				}
				else if (x != tamaWinTimer){
					try {
						x++;
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void deathByHunger(String tamaName){
		TamaGUIEnd.textEndInfo.append("YOUR TAMA DIED OF HUNGER \n");
		TamaGUIEnd.textEndInfo.append("RIP " + tamaName + "\n\n");
		TamaGUIStart.ALL_THREADS_RUNNING = false;
		tge.tamaEndGUIStarter();
	}

	public void deathByDepression(String tamaName){
		TamaGUIEnd.textEndInfo.append("YOUR TAMA DIED OF DEPRESSION \n");
		TamaGUIEnd.textEndInfo.append("RIP " + tamaName +"\n\n");
		TamaGUIStart.ALL_THREADS_RUNNING = false;
		tge.tamaEndGUIStarter();
	}

	public void winning(String tamaName){
		TamaGUIEnd.textEndInfo.append("YOU WIN \n");
		TamaGUIEnd.textEndInfo.append(tamaName + " is all grown up now!\n\n");
		TamaGUIStart.ALL_THREADS_RUNNING = false;
		tge.tamaEndGUIStarter();
	}
	
	public boolean isWin() {
		return win;
	}
}
