package tamaGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
 
/** TAMA GUI END, just the end gui
 * This GUI is to show some statistics/information
 * 
 * 
 * 
 *
 */

public class TamaGUIEnd{
	
	//STATIC, the end text. For score and more.
	public static JTextArea textEndInfo;
	
	private JFrame frmTheEnd;
	private final JButton btnThnxButton = new JButton("EXIT GAME");

	//Show frame method.
	public void tamaEndGUIStarter(){
		frmTheEnd.setVisible(true);
	}

	public TamaGUIEnd() {
		initialize();
	}

	//the builder
	private void initialize() {
		frmTheEnd = new JFrame();
		frmTheEnd.getContentPane().setBackground(Color.WHITE);
		frmTheEnd.setTitle("The End");
		frmTheEnd.setBounds(100, 100, 450, 300);
		frmTheEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheEnd.getContentPane().setLayout(null);
		btnThnxButton.setToolTipText("Thank You For Playing Tama.v2");
		btnThnxButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThnxButton.setBounds(0, 221, 432, 32);
		frmTheEnd.getContentPane().add(btnThnxButton);

		textEndInfo = new JTextArea();
		textEndInfo.setBounds(0, 0, 432, 220);
		frmTheEnd.getContentPane().add(textEndInfo);
	}
}
