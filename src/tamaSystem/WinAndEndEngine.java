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

	//in seconds, 3600 = 1h
	private int tamaWinTimer;

	public WinAndEndEngine(GameEngine ge, TamaGUI tg, TamaGUIEnd tge,
			DepressionEngine de, HungerEngine he){
		this.ge = ge;
		this.tg = tg;
		this.tge = tge;
		this.de = de;
		this.he = he;
	}

	public WinAndEndEngine(){
	}

	private void deathAndWinChecker(){
		if (de.isDeathByDepression() == true){
			deathByDepression(ge.getTamaName());
			tg.showGUI(false);
			ge.setALL_TREADS_RUNNING(false);
		}
		else if(he.isDeathByHunger() == true){
			deathByHunger(ge.getTamaName());
			tg.showGUI(false);
			ge.setALL_TREADS_RUNNING(false);
		}
		else if (isWin() == true){
			winning(ge.getTamaName());
			tg.showGUI(false);
			ge.setALL_TREADS_RUNNING(false);
		}
	}

	//The loop, Win checker
	@Override
	public void run() {
		tamaWinTimer = 3600;
		
		int x = 0;

		while(ge.isALL_TREADS_RUNNING() == true){
			if(tamaWinTimer <= x){
				win = true;
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


	public void deathByHunger(String tamaName){
		tge.setTextEndInfo("YOUR TAMA DIED OF HUNGER \n");
		tge.setTextEndInfo("RIP " + tamaName + "\n\n");
		ge.setALL_TREADS_RUNNING(false);
		tge.tamaEndGUIStarter();
	}

	public void deathByDepression(String tamaName){
		tge.setTextEndInfo("YOUR TAMA DIED OF DEPRESSION \n");
		tge.setTextEndInfo("RIP " + tamaName +"\n\n");
		ge.setALL_TREADS_RUNNING(false);
		tge.tamaEndGUIStarter();
	}

	public void winning(String tamaName){
		tge.setTextEndInfo("YOU WIN \n");
		tge.setTextEndInfo(tamaName + " is all grown up now!\n\n");
		ge.setALL_TREADS_RUNNING(false);
		tge.tamaEndGUIStarter();
	}

	public boolean isWin() {
		return win;
	}
}
