
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

 public class MyProject extends JFrame implements ActionListener{
        JMenuBar br=new JMenuBar();
        JMenu D=new JMenu("Fichier");
        JMenu hel=new JMenu("?");
	Panneau p;
	Container C=new Container();
        JMenuItem help=new JMenuItem("Aide");
        JMenuItem apropos=new JMenuItem("A propos");
        JMenuItem Quitter=new JMenuItem("Quitter");
        JButton skill=new JButton(new ImageIcon("images/skill.png"));
        JButton demin=new JButton(new ImageIcon("images/demin.png"));
        JButton dessin=new JButton(new ImageIcon("images/paint.png"));
        JPanel pan1=new JPanel();
        
        
        
	public MyProject()
	{
    this.setTitle("Meryem Games");        
    this.setSize(500, 550);
    skill.setPreferredSize(new Dimension(40,70));
    demin.setPreferredSize(new Dimension(60,70));
    dessin.setPreferredSize(new Dimension(60,70));
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
    hel.add(apropos);
    br.add(D);
    br.add(hel);
    this.setJMenuBar(br);
    C=this.getContentPane();
    pan1.setLayout(new GridLayout(1,4));
    pan1.setLayout( new BoxLayout(pan1,BoxLayout.Y_AXIS));
    pan1.setBorder(BorderFactory.createCompoundBorder());
    pan1.add(new JLabel("<html><body><center><font size=10 color='pink'>     Bienvenue</font></center><br><br></body></html>"));
    pan1.add(skill);
    pan1.add(new JLabel("<html><body><br><br></body></html>"));
    pan1.add(demin);
    pan1.add(new JLabel("<html><body><br><br></body></html>"));
    pan1.add(dessin);
    p.add(pan1);
    C.add(p);
    //C.setLayout(new BorderLayout());
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
			JOptionPane.showMessageDialog(this,"Cette application englobe trois différents jeux à la fois \nla premiere est Skillmeter,"
                + "\nla deuxiéme est Démineur et la troisiéme est Paint.\nVeuiller choisir un jeu ! \nAmusez-vous !",
			"Aide",JOptionPane.QUESTION_MESSAGE);
		}
		if(e.getSource()==apropos)
                { JOptionPane.showMessageDialog(this,"copyright 2013 , Meryem Games.\n","Démineur",JOptionPane.INFORMATION_MESSAGE);}
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
                }
	}
   
	public static void main(String []args)
	{
		MyProject f=new MyProject();
	}
}
