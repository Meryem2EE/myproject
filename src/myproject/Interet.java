package myproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import myproject.Acceuil;

 public class Interet extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel1, panel2;
        private JPanel panelPrincipal=new JPanel(new GridLayout(3,1));
        private JPanel panel11=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JButton calculer=new JButton("Calculer");
        private JComboBox combo=new JComboBox();
        private JLabel info=new JLabel("veuillez remplir les données :\n\n");
        private JButton hm = new JButton(new ImageIcon("images/home.png"));
	private Container c;
        
        JTextField p=new JTextField(5);
        JTextField f=new JTextField(5);
        JTextField n=new JTextField(5);
        JPanel panel3=new JPanel();
        
        JMenuBar br=new JMenuBar();
        JMenu D=new JMenu("Fichier");
        JMenu hel=new JMenu("?");
        JMenuItem nv=new JMenuItem("Sauvegarder");
        JMenuItem hlp=new JMenuItem("Aide");
        JMenuItem aprpos=new JMenuItem("A propos");
        JMenuItem Quitter=new JMenuItem("Quitter");

	public Interet() {
		super();
		setTitle("Calcul de (i/P,N,F)");
                this.setSize(500,550);
		c = getContentPane();
                hm.setPreferredSize(new Dimension(30,30));
		panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                panel1.setLayout(new GridLayout(4,1));
                panel1.setLayout( new BoxLayout(panel1,BoxLayout.Y_AXIS));
                panel1.setBorder(BorderFactory.createCompoundBorder());
                c.add(panel1);
                panelPrincipal.add(br);
                panel11.add(hm);
                hm.addActionListener(this);
                aprpos.addActionListener(this);
                Quitter.addActionListener(this);
                calculer.addActionListener(this);
                hlp.addActionListener(this);
                panelPrincipal.add(panel11);
                panelPrincipal.add(panel1);
		panel2 = new JPanel();
                panel2.setBackground(Color.PINK);
                D.add(nv);
                D.addSeparator();
                D.add(Quitter);
                hel.add(hlp);
                hel.add(aprpos);
                br.add(D);
                br.add(hel);
                c.add(panelPrincipal, BorderLayout.NORTH);
		panel1.add(info);
                panel2.setLayout(new BorderLayout());
                JPanel panelGauche=new JPanel();
                JPanel panelDroit=new JPanel();
                panelGauche.setBackground(Color.PINK);
                panelDroit.setBackground(Color.PINK);
                panelGauche.setLayout(new GridLayout(3,2));
                panelGauche.setLayout( new BoxLayout(panelGauche,BoxLayout.Y_AXIS));
                panelGauche.setBorder(BorderFactory.createCompoundBorder());
                combo.addItem("annuellement");
                combo.addItem("semestriellement");
                combo.addItem("trimestriellement");
                combo.addItem("mensuellement");
                combo.addActionListener(this);
                JPanel p1=new JPanel();
                JPanel p2=new JPanel();
                JPanel p3=new JPanel();
             //   JLabel text2=new JLabel("hjgvcuejhuhgugyythgfvhgvdgeb");text2.setForeground(Color.PINK);
                JLabel text1=new JLabel("hjgvhh");text1.setForeground(Color.PINK);
                p1.add(new JLabel("valeur du capital initial P :     "));p1.add(p);
                panelGauche.add(p1);
                p2.add(new JLabel("valeur du future montant  F :"));p2.add(f);
                panelGauche.add(p2);
                p3.add(new JLabel("Durée d'analyse N :"));p3.add(text1);p3.add(n);
                panelGauche.add(p3);
                panelDroit.setLayout(new GridLayout(8,1));
                panelDroit.setLayout( new BoxLayout(panelDroit,BoxLayout.Y_AXIS));
                panelDroit.setBorder(BorderFactory.createCompoundBorder());
                p1.setBackground(Color.PINK);
                p2.setBackground(Color.PINK);
                p3.setBackground(Color.PINK);
                panel2.add(panelGauche,BorderLayout.LINE_START);
                panel3.add(calculer);
                panel2.add(panel3,BorderLayout.SOUTH );
		c.add(panel2);
		setLocationRelativeTo(null); 
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
                     if(e.getSource() == hm) {
                    this.setVisible(false);
                    Acceuil ac=new Acceuil();ac.setVisible(true);
                       }
                     if(e.getSource()==Quitter){System.exit(0);}
        if(e.getSource()==hlp)
		{
			JOptionPane.showMessageDialog(this,"calcul du taut d'intérêt nominal \n capitalisé annuellement i \n à partir des données saisis.",
			"Aide",JOptionPane.QUESTION_MESSAGE);
		}
		if(e.getSource()==aprpos)
                { JOptionPane.showMessageDialog(this,"copyright 2014 ,Elouragini Meryem \n","",JOptionPane.INFORMATION_MESSAGE);}
               
               
                if(e.getSource()==calculer)
                {
                    if(p.getText().equals("") || f.getText().equals("") || n.getText().equals("") ){
                        JOptionPane.showMessageDialog(this,"Veuillez inserer des données svp !","",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                    int P=Integer.parseInt(p.getText());
                    int F=Integer.parseInt(f.getText());
                    int N=Integer.parseInt(n.getText());
                  //  System.out.println(P);System.out.println(F);System.out.println(N);
                    double NN=(double)1/N;
                    double o=(double)F/P;
                    double result=(Math.pow(o,NN))-1;
                    JOptionPane.showMessageDialog(this,"i = "+(result*100)+" %","Resultat",JOptionPane.INFORMATION_MESSAGE);
                }
                }
	}
	public static void main(String[] args) {
		Interet  f = new Interet ();
		f.setVisible(true);
	}
}

