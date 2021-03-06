package tamaGUI;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tamaSystem.DepressionEngine;
import tamaSystem.HungerEngine;


/** TAMA GUI FACE CLASS, is not real GUI. 
 * This Class gives a animation to player. 
 * Depending on the Level it gives different faces.
 * 
 * 
 * Image made by Arild in Paint!
 * Try sue me now!
 * 
 * 
 *
 */

public class TamaGUIFace implements Runnable {

	private static final long serialVersionUID = 1L;

	private JLabel label;
	private ArrayList <ImageIcon> faces;
	private TamaGUI tg;
	private int gameLevel;
	private DepressionEngine de;
	private HungerEngine he;
	private ImageIcon tmp;
	private int x = 0;
	private int y = 7;


	public TamaGUIFace(TamaGUI tg, int gameLevel, DepressionEngine de, HungerEngine he){
		this.tg = tg;
		this.gameLevel = gameLevel;
		this.de = de;
		this.he = he;
	}

	private void animationUpdater(){
		if (x >= 7 || y >= 9){
			x = 0;
			y = 7;
		}
		if (de.getTamaCurrentDepression() <= 3000 || he.getTamaCurrentHunger() <= 3000 ){
			tmp = faces.get(y);
			y++;
		}else{
			tmp = faces.get(x);
			x++;
		}
		tg.labelUpdater(tmp);
	}

	//load pics, depending on game level
	private void loadpics(){
		faces = new ArrayList <ImageIcon>();

		if (gameLevel == 1) {
			faces.add(new ImageIcon("image/Baby/b2.png"));
			faces.add(new ImageIcon("image/Baby/b3.png"));
			faces.add(new ImageIcon("image/Baby/b4.png"));
			faces.add(new ImageIcon("image/Baby/b3.png"));
			faces.add(new ImageIcon("image/Baby/bo1.png"));
			faces.add(new ImageIcon("image/Baby/bo2.png"));
			faces.add(new ImageIcon("image/Baby/bo3.png"));
			faces.add(new ImageIcon("image/Baby/bs1.png"));
			faces.add(new ImageIcon("image/Baby/bs2.png"));
			faces.add(new ImageIcon("image/Baby/bs3.png"));
		}
		else if (gameLevel == 2) {
			faces.add(new ImageIcon("image/Kid/b2.png"));
			faces.add(new ImageIcon("image/Kid/b3.png"));
			faces.add(new ImageIcon("image/Kid/b4.png"));
			faces.add(new ImageIcon("image/Kid/b3.png"));
			faces.add(new ImageIcon("image/Kid/bo1.png"));
			faces.add(new ImageIcon("image/Kid/bo2.png"));
			faces.add(new ImageIcon("image/Kid/bo3.png"));
			faces.add(new ImageIcon("image/Kid/bs1.png"));
			faces.add(new ImageIcon("image/Kid/bs2.png"));
			faces.add(new ImageIcon("image/Kid/bs3.png"));
		}
		else if (gameLevel == 3) {
			faces.add(new ImageIcon("image/YA/b2.png"));
			faces.add(new ImageIcon("image/YA/b3.png"));
			faces.add(new ImageIcon("image/YA/b4.png"));
			faces.add(new ImageIcon("image/YA/b3.png"));
			faces.add(new ImageIcon("image/YA/bo1.png"));
			faces.add(new ImageIcon("image/YA/bo2.png"));
			faces.add(new ImageIcon("image/YA/bo3.png"));
			faces.add(new ImageIcon("image/YA/bs1.png"));
			faces.add(new ImageIcon("image/YA/bs2.png"));
			faces.add(new ImageIcon("image/YA/bs3.png"));
		}
	}

	@Override
	public void run() {
		loadpics();

		while(TamaGUIStart.ALL_THREADS_RUNNING == true){
			try {
				animationUpdater();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

