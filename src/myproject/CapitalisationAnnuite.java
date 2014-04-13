/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package myproject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import myproject.Acceuil;

 public class CapitalisationAnnuite extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel1, panel2;
        private JPanel panelPrincipal=new JPanel(new GridLayout(3,1));
        private JPanel panel11=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JButton calculer=new JButton("Calculer");
        private JComboBox combo=new JComboBox();
        private JComboBox combo2=new JComboBox();
        private JComboBox combo3=new JComboBox();
        private JLabel info=new JLabel("veuillez remplir les données :\n\n");
        private JButton hm = new JButton(new ImageIcon("images/home.png"));
	private Container c;
        JTextField a=new JTextField(5);
        JTextField i=new JTextField(3);
        JTextField n=new JTextField(3);
        JPanel panel3=new JPanel();
        JMenuBar br=new JMenuBar();
        JMenu D=new JMenu("Fichier");
        JMenu hel=new JMenu("?");
        JMenuItem nv=new JMenuItem("Sauvegarder");
        JMenuItem hlp=new JMenuItem("Aide");
        JMenuItem aprpos=new JMenuItem("A propos");
        JMenuItem Quitter=new JMenuItem("Quitter");

	public CapitalisationAnnuite() {
		super();
		setTitle("Calcul du Facteur Capitalisation d'Annuite (F/A,i,N)");
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
                combo.addItem("année");
                combo.addItem("semestre");
                combo.addItem("trimestre");
                combo.addItem("mois");
                combo.addActionListener(this);
                combo2.addItem("annuel");
                combo2.addItem("semestriel");
                combo2.addItem("trimestriel");
                combo2.addItem("mensuel");
                combo2.addActionListener(this);
                combo3.addItem("annuellement");
                combo3.addItem("semestriellement");
                combo3.addItem("trimestriellement");
                combo3.addItem("mensuellement");
                combo3.addActionListener(this);
                JPanel p1=new JPanel();
                JPanel p2=new JPanel();
                JPanel p3=new JPanel();
                p1.add(new JLabel("Montant à investir A :"));p1.add(a);
                p1.add(new JLabel("$ à la fin de chaque :"));p1.add(combo);
                p2.add(new JLabel("pendant "));p2.add(n);p2.add(new JLabel("ans"));
                p2.add(new JLabel(" avec un taux d'intérêt nominal "));p2.add(combo2);
                p3.add(new JLabel("i ( % ) capitalisé"));p3.add(combo3);p3.add(i);p3.add(new JLabel("%"));
              //  panelGauche.add(p2);
                panelGauche.add(p1);
                panelGauche.add(p2);
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
			JOptionPane.showMessageDialog(this,"calcul du montant Final F \n à partir des données saisis.",
			"Aide",JOptionPane.QUESTION_MESSAGE);
		}
		if(e.getSource()==aprpos)
                { JOptionPane.showMessageDialog(this,"copyright 2014 ,Elouragini Meryem \n","",JOptionPane.INFORMATION_MESSAGE);}
                    if(e.getSource()==calculer)
                          {
                        double I=Double.parseDouble(i.getText());
                        I=(double)I/100;
                        double iResult=(double)calculI(I);
                        System.out.println(iResult);
                        int A=Integer.parseInt(a.getText());
                        int N=Integer.parseInt(n.getText());
                       if (combo.getSelectedItem().equals("semestre")){
                      //      I=I/2;
                            N=N*2;
                        }else if (combo.getSelectedItem().equals("trimestre")){
                            N=N*4;
                        }else if (combo.getSelectedItem().equals("mensuellement")){
                            N=N*12;
                        }
                    double dd=A*(((Math.pow(iResult+1,N))-1)/iResult); 
                    JOptionPane.showMessageDialog(this,"F = "+dd+" $","Resultat",JOptionPane.INFORMATION_MESSAGE);
                }
             }
         double calculI(double ii){
            double resultI=0.0;
                       if (combo3.getSelectedItem().equals("semestriellement") && combo2.getSelectedItem().equals("trimestriel")){
                            ii=ii/4+1;
                            resultI=Math.pow(ii,2)-1;
                        }else if (combo3.getSelectedItem().equals("semestriellement") && combo2.getSelectedItem().equals("mensuel")){
                            ii=ii/12+1;
                            resultI=Math.pow(ii,6)-1;
                        }else if (combo3.getSelectedItem().equals("semestriellement") && combo2.getSelectedItem().equals("annuel")){
                            ii=ii+1;
                            resultI=Math.pow(ii,0.5)-1;
                        }else if (combo3.getSelectedItem().equals("trimestriellement") && combo2.getSelectedItem().equals("semestriel")){
                            ii=ii/2+1;
                            resultI=Math.pow(ii,0.5)-1;
                        }else if (combo3.getSelectedItem().equals("trimestriellement") && combo2.getSelectedItem().equals("mensuel")){
                            ii=ii/12+1;
                            resultI=Math.pow(ii,3)-1;
                        }else if (combo3.getSelectedItem().equals("trimestriellement") && combo2.getSelectedItem().equals("annuel")){
                            ii=ii+1;
                            resultI=Math.pow(ii,0.25)-1;
                        }else if (combo3.getSelectedItem().equals("mensuellement") && combo2.getSelectedItem().equals("semestriel")){
                            ii=ii/2+1;
                            resultI=Math.pow(ii,0.1666)-1;
                        }else if (combo3.getSelectedItem().equals("mensuellement") && combo2.getSelectedItem().equals("trimestriel")){
                            ii=ii/4+1;
                            resultI=Math.pow(ii,0.3333)-1;
                        }else if (combo3.getSelectedItem().equals("mensuellement") && combo2.getSelectedItem().equals("annuel")){
                            ii=ii+1;
                            resultI=Math.pow(ii,0.0833)-1;
                        }else if (combo3.getSelectedItem().equals("annuellement") && combo2.getSelectedItem().equals("semestriel")){
                            ii=ii/2+1;
                            resultI=Math.pow(ii,2)-1;
                        }else if (combo3.getSelectedItem().equals("annuellement") && combo2.getSelectedItem().equals("trimestriel")){
                            ii=ii/4+1;
                            resultI=Math.pow(ii,4)-1;
                        }else if (combo3.getSelectedItem().equals("annuellement") && combo2.getSelectedItem().equals("mensuel")){
                            ii=ii/12+1;
                           resultI=(double)Math.pow(ii,12)-1;
                        }else {
                            resultI=ii;
                        }
                    return resultI;
                }
        
        
	public static void main(String[] args) {
		CapitalisationAnnuite  f = new CapitalisationAnnuite ();
		f.setVisible(true);
           //     f.pack();
	}
}

