package myproject;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
 public class Panneau extends JPanel
{
        Graphics g;
        JButton sk=new JButton(new ImageIcon("images/hel.png"));
	public void paintComponent(Graphics g)
	{
            super.paintComponent(g);
		int fontSize = 20;
	try {
      Image img =ImageIO.read(new File("images/acceuil.png"));
      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }catch (IOException e) {
    }
    finally{
    //	g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
    	g.setColor(Color.pink);
	}
	
	}
	
	
}



	
