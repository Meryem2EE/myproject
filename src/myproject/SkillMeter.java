package myproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

 class SkillMeterM extends JFrame implements ActionListener {
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
        JTextField i=new JTextField(5);
        JTextField n=new JTextField(5);
        JPanel panel3=new JPanel();
        JMenuBar br=new JMenuBar();
        JMenu D=new JMenu("Fichier");
        JMenu hel=new JMenu("?");
        JMenuItem nv=new JMenuItem("Sauvegarder");
        JMenuItem hlp=new JMenuItem("Aide");
        JMenuItem aprpos=new JMenuItem("A propos");
        JMenuItem Quitter=new JMenuItem("Quitter");

	public SkillMeterM() {
		super();
		setTitle("Calcul de F ");
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
                JLabel text2=new JLabel("hjgvcuejhuhgugyythgfvhgvdgeb");text2.setForeground(Color.PINK);
                JLabel text1=new JLabel("hjgvcuejhuhgugyytddgeb");text1.setForeground(Color.PINK);
                p1.add(new JLabel("valeur du capital initial P :"));p1.add(text1);p1.add(p);
                panelGauche.add(p1);
                p2.add(new JLabel("taux d'intérêt i ( % ) capitalisé"));p2.add(combo);p2.add(i);
                panelGauche.add(p2);
                p3.add(new JLabel("Durée d'analyse N :"));p3.add(text2);p3.add(n);
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
			JOptionPane.showMessageDialog(this,"calcul de la valeur dans le futur d'un montant \n à partir des données saisis.",
			"Aide",JOptionPane.QUESTION_MESSAGE);
		}
		if(e.getSource()==aprpos)
                { JOptionPane.showMessageDialog(this,"copyright 2014 , Meryem \n","",JOptionPane.INFORMATION_MESSAGE);}
               
               
                if(e.getSource()==calculer)
                {
                    if(p.getText().equals("") || i.getText().equals("") || n.getText().equals("") ){
                        JOptionPane.showMessageDialog(this,"Veuillez inserer des données svp !","",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                    int P=Integer.parseInt(p.getText());
                    double I=Double.parseDouble(i.getText());
                    I=(double)I/100;
                    int N=Integer.parseInt(n.getText());
                    if (combo.getSelectedItem().equals("semestriellement")){
                            I=I/2;
                            N=N*2;
                        }else if (combo.getSelectedItem().equals("trimestriellement")){
                            I=I/4;
                            N=N*4;
                        }else if (combo.getSelectedItem().equals("mensuellement")){
                            I=I/12;
                            N=N*12;
                        }
                    double dd=P*Math.pow(I+1,N); 
                    JOptionPane.showMessageDialog(this,"F = "+dd+" $","Resultat",JOptionPane.INFORMATION_MESSAGE);
                }
                }
                
	}
	public static void main(String[] args) {
		SkillMeterM  f = new SkillMeterM ();
		f.setVisible(true);
	}
}

