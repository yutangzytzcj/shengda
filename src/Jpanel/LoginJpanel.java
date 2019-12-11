/**
 * ±³¾°Ãæ°å
 */
package Jpanel;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class LoginJpanel extends JPanel{
	public void paintComponent(Graphics g) {
		try {
			URL url=getClass().getResource("/res/login.jpg");
			ImageIcon image=new ImageIcon(url);
			g.drawImage(image.getImage(), 0,0,this);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
