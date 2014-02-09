package tamaSystem;

import tamaGUI.TamaGUI;
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
	private TamaGUI tg;
	private DepressionEngine de;
	private HungerEngine he;

	//in seconds
	private int tamaWinTimer;

	public WinAndEndEngine(GameEngine ge, TamaGUIEnd tge,
			DepressionEngine de, HungerEngine he){
		this.ge = ge;
		this.tge = tge;
		this.de = de;
		this.he = he;
	}
	
	public WinAndEndEngine(TamaGUI tg){
		this.tg=tg;
	}
	
	private void deathAndWinChecker(){
		if (de.isDeathByDepression() == true){
			deathByDepression(ge.getTamaName());
			tg.showGUI(false);
		}
		else if(he.isDeathByHunger() == true){
			deathByHunger(ge.getTamaName());
			tg.showGUI(false);
		}
		else if (isWin() == true){
			winning(ge.getTamaName());
			tg.showGUI(false);
		}
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
						deathAndWinChecker();
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
