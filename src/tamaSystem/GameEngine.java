package tamaSystem;

import tamaDB.MySQLEngine;
import tamaDB.TamaGUILogIn;
import tamaDB.UserEngine;
import tamaDialogs.DialogEngine;
import tamaDialogs.TalkingToTamaEngine;
import tamaGUI.TamaGUI;
import tamaGUI.TamaGUIEnd;
import tamaGUI.TamaGUIFace;
import tamaGUI.TamaGUIStart;

/**THE GAME ENGINE
 * 
 * Here is where the game loop and updater is.
 * 
 * 
 *
 */

public class GameEngine {

	//GAME VERSION STATIC!
	public static String TAMA_VERSION = "TamaProj 03.3";

	private WinAndEndEngine we;
	private DepressionEngine de;
	private HungerEngine he;
	private MoneyEngine mo;
	private DialogEngine di;
	private TalkingToTamaEngine tt;
	private ScoreEngine se;
	private GameEngine ge;
	public GameEngine getGe() {
		return ge;
	}
	public void setGe(GameEngine ge) {
		this.ge = ge;
	}

	private UserEngine ue;

	private TamaGUILogIn tgli;
	private TamaGUIEnd tge = new TamaGUIEnd();
	private TamaGUIStart tgs;
	private TamaGUI tg;
	private TamaGUIFace tgf;

	private MySQLEngine mysql;

	protected String tamaName = "";
	public String getTamaName() {
		return tamaName;
	}
	public void setTamaName(String tamaName) {
		this.tamaName = tamaName;
	}

	private int gameLevel;
	public int getGameLevel() {
		return gameLevel;
	}
	public void setGameLevel(int gameLevel) {
		this.gameLevel = gameLevel;
	}

	private void initiater(){
		this.tg = new TamaGUI();

		this.we = new WinAndEndEngine(tg);
		this.de = new DepressionEngine(tg);
		this.he = new HungerEngine(tg);
		this.mo = new MoneyEngine(tg);
		
		this.di = new DialogEngine();
		this.tt = new TalkingToTamaEngine();
		this.se = new ScoreEngine();

	}

	public GameEngine(){
		initiater();
	}

	private void threadStarter(){
		Thread depEngine = new Thread(de, "DepressionThread");
		Thread winEngine = new Thread(we, "WinThread");
		Thread hunEngine = new Thread(he, "FoodThread");
		Thread monEngine = new Thread(mo, "MoneyThead");
		Thread diaEngine = new Thread(di, "DialogThread");
		Thread scoEngine = new Thread(se, "ScoreThread");
		Thread tgfEngine = new Thread(tgf, "TgfThread");

		diaEngine.start();
		scoEngine.start();
		depEngine.start();
		winEngine.start();
		hunEngine.start();
		monEngine.start();
		tgfEngine.start();
	}


	//	protected void deathAndWinChecker(String tamanName){
	//		if (de.isDeathByDepression() == true){
	//			we.deathByDepression(tamanName);
	//			tg.GUIFrame.setVisible(false);
	//		}
	//		else if(he.isDeathByHunger() == true){
	//			we.deathByHunger(tamaName);
	//			tg.GUIFrame.setVisible(false);
	//		}
	//		else if (we.isWin() == true){
	//			we.winning(tamaName);
	//			tg.GUIFrame.setVisible(false);
	//		}
	//	}

	//	protected void barUpdate(){
	//		//for bars in TamaGUI
	//		tg.setDepressionBar();	
	//		tg.setMoneyBar();
	//		tg.setHungerBar();
	//	}

	//	protected void mouseEventUpdater(){
	//		for (int i = 0; i < tg.getMoneyMouseCounter(); i++) {
	//			mo.moneyGain1();
	//		}
	//		tg.setMoneyMouseCounter(0);
	//
	//		for (int i = 0; i < tg.getMouseHappinessSinker(); i++) {
	//			de.mouseHappinessSinker();
	//		}
	//		tg.setMouseHappinessSinker(0);
	//
	//		for (int i = 0; i < tg.getMouseGainHappiness(); i++) {
	//			de.mouseHappiness();
	//		}
	//		tg.setMouseGainHappiness(0);
	//	}

	public void StartLogIn(){
		this.tgli = new TamaGUILogIn();
		this.ue = new UserEngine(tgli);
		this.mysql = new MySQLEngine(ge, tgli);


		this.tgli.loginStarter(ge, tgli, ue, mysql);
	}



	//The start luncher after log in.
	public void GameGuiStart(){
		tgs = new TamaGUIStart();
		tgs.TamaStartGUIStarter(ge);


	}

	//The game main Game Gui.
	public void GameGUI(int gameLevel, String frameTitle, String tamaName){
		this.tamaName = tamaName;
		this.gameLevel = gameLevel;

//		this.tg = new TamaGUI(gameLevel, frameTitle, tamaName, he, mo, di, tt, de);		

		tg.TamaGUI(gameLevel, frameTitle, tamaName, he, mo, di, tt, de);
		this.tgf = new TamaGUIFace(tg, gameLevel, de, he);
		this.we = new WinAndEndEngine(ge, tge, de, he);
		
		de.setGameLevel(gameLevel);
		he.setGameLevel(gameLevel);
		mo.setGameLevel(gameLevel);

		threadStarter();

		tg.showGUI(true);
	}
}



