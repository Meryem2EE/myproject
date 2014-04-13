package myproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

 public class Painture  extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel1, panel2;
        private JPanel panelPrincipal=new JPanel(new GridLayout(3,1));
        private JPanel panel11=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JButton calculer=new JButton("Calculer");
        private JComboBox combo=new JComboBox();
        private JComboBox combo2=new JComboBox();
        private JLabel info=new JLabel("veuillez remplir les données :\n\n");
        private JButton hm = new JButton(new ImageIcon("images/home.png"));
	private Container c;
        
        JTextField i=new JTextField(5);
        JPanel panel3=new JPanel();
        
        JMenuBar br=new JMenuBar();
        JMenu D=new JMenu("Fichier");
        JMenu hel=new JMenu("?");
        JMenuItem nv=new JMenuItem("Sauvegarder");
        JMenuItem hlp=new JMenuItem("Aide");
        JMenuItem aprpos=new JMenuItem("A propos");
        JMenuItem Quitter=new JMenuItem("Quitter");

	public Painture () {
		super();
		setTitle("Calcul de i ");
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
                combo2.addItem("annuellement");
                combo2.addItem("semestriellement");
                combo2.addItem("trimestriellement");
                combo2.addItem("mensuellement");
                combo2.addActionListener(this);
                JPanel p1=new JPanel();
                JPanel p2=new JPanel();
                JPanel p3=new JPanel();
               // JLabel text2=new JLabel("hjgvcuejhuhgugyythgfvhgvdgeb");text2.setForeground(Color.PINK);
             //   JLabel text1=new JLabel("hjgvcuhhjejhuhgugyytddgeb");text1.setForeground(Color.PINK);
           //     p1.add(new JLabel("valeur du capital final F :"));p1.add(text1);p1.add(p);
          //      panelGauche.add(p1);
                p2.add(new JLabel("Quel est le taux d'intérêt"));p2.add(combo);
                p2.add(new JLabel("équivalent aux taux d'intérêt nominal annuel de "));p2.add(i);
                p2.add(new JLabel("% capitalisé"));p2.add(combo2);
                panelGauche.add(p2);
           //     p3.add(new JLabel("Durée d'analyse N :"));p3.add(text2);p3.add(n);
         //       panelGauche.add(p3);
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
			JOptionPane.showMessageDialog(this,"calcul du taux d'intérêt i \n à partir des données saisis.",
			"Aide",JOptionPane.QUESTION_MESSAGE);
		}
		if(e.getSource()==aprpos)
                { JOptionPane.showMessageDialog(this,"copyright 2014 ,Elouragini Meryem \n","",JOptionPane.INFORMATION_MESSAGE);}
               
               
                if(e.getSource()==calculer)
                { 
                    double result=0.0;
                    if(i.getText().equals("")){
                        JOptionPane.showMessageDialog(this,"Veuillez inserer des données svp !","",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                    double I=Double.parseDouble(i.getText());
                    I=(double)I/100;
                      if (combo.getSelectedItem().equals("semestriellement") && combo2.getSelectedItem().equals("trimestriellement")){
                            I=I/4+1;
                            result=Math.pow(I,2)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else if (combo.getSelectedItem().equals("semestriellement") && combo2.getSelectedItem().equals("mensuellement")){
                            I=I/12+1;
                            result=Math.pow(I,6)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else if (combo.getSelectedItem().equals("semestriellement") && combo2.getSelectedItem().equals("annuellement")){
                            I=I+1;
                            result=Math.pow(I,0.5)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else if (combo.getSelectedItem().equals("trimestriellement") && combo2.getSelectedItem().equals("semestriellement")){
                            I=I/2+1;
                            result=Math.pow(I,0.5)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else if (combo.getSelectedItem().equals("trimestriellement") && combo2.getSelectedItem().equals("mensuellement")){
                            I=I/12+1;
                            result=Math.pow(I,3)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else if (combo.getSelectedItem().equals("trimestriellement") && combo2.getSelectedItem().equals("annuellement")){
                            I=I+1;
                            result=Math.pow(I,0.25)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else if (combo.getSelectedItem().equals("mensuellement") && combo2.getSelectedItem().equals("semestriellement")){
                            I=I/2+1;
                            result=Math.pow(I,0.1666)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else if (combo.getSelectedItem().equals("mensuellement") && combo2.getSelectedItem().equals("trimestriellement")){
                            I=I/4+1;
                            result=Math.pow(I,0.3333)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else if (combo.getSelectedItem().equals("mensuellement") && combo2.getSelectedItem().equals("annuellement")){
                            I=I+1;
                            result=Math.pow(I,0.0833)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else if (combo.getSelectedItem().equals("annuellement") && combo2.getSelectedItem().equals("semestriellement")){
                            I=I/2+1;
                            result=Math.pow(I,2)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else if (combo.getSelectedItem().equals("annuellement") && combo2.getSelectedItem().equals("trimestriellement")){
                            I=I/4+1;
                            result=Math.pow(I,4)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else if (combo.getSelectedItem().equals("annuellement") && combo2.getSelectedItem().equals("mensuellement")){
                            I=I/12+1;
                            result=Math.pow(I,12)-1;
                            JOptionPane.showMessageDialog(this,"i = "+result*100+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(this,"i = "+I+" %","",JOptionPane.INFORMATION_MESSAGE);
                        }
                }
                }
	}
	public static void main(String[] args) {
		Painture  f = new Painture ();
                f.pack();
                f.setVisible(true);
	}
}

