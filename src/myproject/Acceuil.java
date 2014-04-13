
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
//import myproject.Interet;

 public class Acceuil extends JFrame implements ActionListener,MenuListener{
        JMenuBar br=new JMenuBar();
        JMenu D=new JMenu("Fichier");
        JMenu hel=new JMenu("?");
	Panneau p;
	Container C=new Container();
        JMenuItem help=new JMenuItem("Aide");
        JMenuItem apropos=new JMenuItem("A propos");
        JMenuItem Quitter=new JMenuItem("Quitter");
        JButton skill=new JButton("Calcul de (F/P,i,N)");
        JButton demin=new JButton("Calcul de (P/F,i,N)");
        JButton dessin=new JButton("Calcul de i");
        JButton interet=new JButton("Calcul de (i/P,N,F)");
        JButton capitalisationAnnuite=new JButton("Calcul du Facteur De Capitalisation d'une Annuité (F/A,i,N)");
        JButton actualisationAnnuite=new JButton("Calcul du Facteur D'Actualisation d'une Annuité (P/A,i,N)");
        JButton annuite=new JButton("Calcul d'Annuité (A/F,i,N)");
        JButton annuite2=new JButton("Calcul d'Annuité (A/P,i,N)");
        
        JPanel pan1=new JPanel();
        
        
        
	public Acceuil()
	{
    this.setTitle("Calcul Financier");        
    this.setSize(500, 700);
    skill.setPreferredSize(new Dimension(40,70));
    demin.setPreferredSize(new Dimension(60,70));
    dessin.setPreferredSize(new Dimension(60,70));
    interet.setPreferredSize(new Dimension(60,70));
    p=new Panneau(); 
    //D.addSeparator();
    D.add(Quitter);
    Quitter.addActionListener(this);
    help.addActionListener(this);
    skill.addActionListener(this);
    
    hel.add(help);
   
    apropos.addActionListener(this);
    dessin.addActionListener(this);
    demin.addActionListener(this);
    interet.addActionListener(this);
    capitalisationAnnuite.addActionListener(this);
    actualisationAnnuite.addActionListener(this);
    annuite.addActionListener(this);
    annuite2.addActionListener(this);
    hel.add(apropos);
    
    
    br.add(D);
    br.add(hel);
    this.setJMenuBar(br);
    C=this.getContentPane();
    pan1.setLayout(new GridLayout(4,1));
    pan1.setLayout( new BoxLayout(pan1,BoxLayout.Y_AXIS));
    pan1.setBorder(BorderFactory.createCompoundBorder());
    pan1.add(new JLabel("<html><body><center><font size=10 >Gestion de Projet</font></center><br><br></body></html>"));
    pan1.add(skill);
    pan1.add(new JLabel("<html><body><br><br></body></html>"));
    pan1.add(demin);
    pan1.add(new JLabel("<html><body><br><br></body></html>"));
    pan1.add(dessin);
    pan1.add(new JLabel("<html><body><br><br></body></html>"));
    pan1.add(interet);
    pan1.add(new JLabel("<html><body><br><br></body></html>"));
    pan1.add(capitalisationAnnuite);
    pan1.add(new JLabel("<html><body><br><br></body></html>"));
    pan1.add(actualisationAnnuite);
    pan1.add(new JLabel("<html><body><br><br></body></html>"));
    pan1.add(annuite);
    pan1.add(new JLabel("<html><body><br><br></body></html>"));
    pan1.add(annuite2);
    p.add(pan1);
    C.add(p);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    }
     @Override
        public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==Quitter){System.exit(0);}
        if(e.getSource()==help)
		{
			JOptionPane.showMessageDialog(this,"Cette application vous permet des calculs\n"
                                + "financiers mathématiques tous dépondant de vos données . \nBienvenue !",
			"Aide",JOptionPane.QUESTION_MESSAGE);
		}
		if(e.getSource()==apropos)
                { JOptionPane.showMessageDialog(this,"copyright 2014 ,Elouragini Meryem.\n","",JOptionPane.INFORMATION_MESSAGE);}
                if(e.getSource()==skill){
                    this.setVisible(false);
                    SkillMeterM s=new SkillMeterM();
                }
               else if(e.getSource()==demin){
                    this.setVisible(false);
                    Demineur d=new Demineur();
                }
               else if(e.getSource()==dessin){
                    this.setVisible(false);
                    Painture pt=new Painture();
                    pt.pack();
                    pt.setLocationRelativeTo(null);
                }
                else if(e.getSource()==interet){
                    this.setVisible(false);
                        Interet i=new Interet();
                   // pt.pack();
                    i.setLocationRelativeTo(null);
                }else if(e.getSource()==capitalisationAnnuite){
                    this.setVisible(false);
                        CapitalisationAnnuite q=new CapitalisationAnnuite();
                   // pt.pack();
                    q.setLocationRelativeTo(null);
                }else if(e.getSource()==actualisationAnnuite){
                    this.setVisible(false);
                        ActualisationAnnuite v=new ActualisationAnnuite();
                   // pt.pack();
                    v.setLocationRelativeTo(null);
                }
                else if(e.getSource()==annuite){
                    this.setVisible(false);
                        Annuite a=new Annuite();
                   // pt.pack();
                    a.setLocationRelativeTo(null);
                }
                else if(e.getSource()==annuite2){
                    this.setVisible(false);
                        Annuite2 a=new Annuite2();
                   // pt.pack();
                    a.setLocationRelativeTo(null);
                }
                
	}
   
	public static void main(String []args)
	{
		Acceuil f=new Acceuil();
	}
        
    @Override
    public void menuSelected(MenuEvent e) {
      
    }


    @Override
    public void menuDeselected(MenuEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
class Window extends JFrame {
    JPanel pHelp;
    Container cH=new Container();
    Window(){
        pHelp=new PanneauH();
        this.setTitle("Help");
        this.setVisible(true);
        this.setSize(200, 350);
        cH=this.getContentPane();
        cH.add(pHelp);
        this.setLocationRelativeTo(null);               
      // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
class PanneauH extends JPanel{
        public void paintComponent(Graphics s){
		super.paintComponent(s);
	try {
      Image img =ImageIO.read(new File("images/help.png"));
      s.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }catch (IOException e) {
    }
    finally{
    	s.setColor(Color.black);
    /*	s.drawString("Cette application englobe trois différents jeux la premiere est Skillmeter,"
                + "la deuxiéme est Démineur et la troisiéme est Paint. Amusez vous ! ",300,200);*/
	}
	}
}