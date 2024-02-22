
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Calcul {
    JFrame f;
    TextField text;
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b00;
    JButton plus,Darb,moin,egal,ne9ta,kisma;
    JButton on,off,sahm,clear;
    JButton x2,x3,sqrt;
    JButton vider;
    JPanel p;
    JPanel Pw;
    JButton tabButton[]=new JButton[10];
    JButton Operation[]=new JButton[6];
    int x,y;
    int result;
    StringBuffer s;
    char option;
    String str;
    public Calcul() {


        b0=new JButton("0");
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");

        tabButton[0]=b0;
        tabButton[1]=b1;
        tabButton[2]=b2;
        tabButton[3]=b3;
        tabButton[4]=b4;
        tabButton[5]=b5;
        tabButton[6]=b6;
        tabButton[7]=b7;
        tabButton[8]=b8;
        tabButton[9]=b9;
        for(int i=0;i<tabButton.length;i++) {
            tabButton[i].setFont(new Font("",Font.ITALIC,20));
            //tabButton[i].setBorder(BorderFactory.createLineBorder(Color.CYAN));
        }

//		b0.addActionListener(new ecote());
//		b1.addActionListener(new ecote());
//		b2.addActionListener(new ecote());
//		b3.addActionListener(new ecote());
//		b4.addActionListener(new ecote());
//		b5.addActionListener(new ecote());
//		b6.addActionListener(new ecote());
//		b7.addActionListener(new ecote());
//		b8.addActionListener(new ecote());
//		b9.addActionListener(new ecote());

        for(int i=0;i<tabButton.length;i++) {
            tabButton[i].addActionListener(new ecote());
        }

        ne9ta=new JButton("|x|");
        plus=new JButton("+");
        Darb=new JButton("*");
        moin=new JButton("-");
        egal=new JButton("=");
        kisma=new JButton("/");

        Operation[0]=ne9ta;
        Operation[1]=plus;
        Operation[2]=Darb;
        Operation[3]=moin;
        Operation[4]=egal;
        Operation[5]=kisma;

        for(int i=0;i<Operation.length;i++) {
            Operation[i].setFont(new Font("",Font.ITALIC,20));
            //Operation[i].setBorder(BorderFactory.createLineBorder(Color.CYAN));
        }

//		ne9ta.addActionListener(new ecote());
//		plus.addActionListener(new ecote());
//		Darb.addActionListener(new ecote());
//		moin.addActionListener(new ecote());
//		egal.addActionListener(new ecote());
//		kisma.addActionListener(new ecote());

        for(int i=0;i<Operation.length;i++) {
            Operation[i].addActionListener(new ecote());
        }
        b00=new JButton("00");
        x2=new JButton("X²");
        x3=new JButton("X3");
        sqrt=new JButton("sqrt");

        b00.setFont(new Font("",Font.ITALIC,20));
        x2.setFont(new Font("",Font.ITALIC,20));
        x3.setFont(new Font("",Font.ITALIC,20));
        sqrt.setFont(new Font("",Font.ITALIC,20));
        vider=new JButton("x");
        vider.setBounds(185, 25, 50, 20);
        vider.setBackground(Color.BLACK);
        vider.setForeground(Color.WHITE);

        b00.addActionListener(new ecote());
        x2.addActionListener(new ecote());
        x3.addActionListener(new ecote());
        sqrt.addActionListener(new ecote());
        vider.addActionListener(new ecote());

        clear=new JButton();
        clear.setBounds(20, 150, 500, 10);
        clear.setBackground(Color.CYAN);
        clear.addActionListener(new ecote());
        p=new JPanel();
        p.setLayout(new GridLayout(5,4));
        p.setBounds(20, 160,500, 120);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(plus);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(moin);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(Darb);
        p.add(b0);
        p.add(ne9ta);
        p.add(b00);
        p.add(kisma);
        p.add(x2);
        p.add(x3);
        p.add(sqrt);
        p.add(egal);

        f=new JFrame();
        text=new TextField();
        text.setFont(new Font("",Font.BOLD,30));
        text.setBounds(20,50,500,100);
        text.setBackground(Color.DARK_GRAY);
        text.setForeground(Color.GREEN);
        text.setEditable(false);
        on=new JButton("on");
        off=new JButton("off");
        sahm=new JButton("<--");

        on.addActionListener(new ecote());
        off.addActionListener(new ecote());
        sahm.addActionListener(new ecote());
        on.setBackground(Color.GREEN);
        off.setBackground(Color.red);
        on.setBounds(20, 25, 50, 20);
        off.setBounds(75, 25, 50, 20);
        sahm.setBounds(130, 25, 50, 20);
        sahm.setBackground(Color.YELLOW);
        f.setLayout(null);
        f.add(on);
        f.add(off);
        f.add(sahm);
        f.add(vider);
        f.add(text);
        f.add(clear);
        f.add(p);
        f.setSize(600, 500);
        f.setVisible(true);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class ecote implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            s=new StringBuffer(text.getText());
            if(e.getSource()==b0) {
                s.append("0");
                text.setText(s.toString());
                str+="0";
            }
            if(e.getSource()==b1) {
                s.append("1");
                text.setText(s.toString());
                str+="1";
            }
            if(e.getSource()==b2) {
                s.append("2");
                text.setText(s.toString());
                str+="2";
            }
            if(e.getSource()==b3) {
                s.append("3");
                text.setText(s.toString());
                str+="3";
            }
            if(e.getSource()==b4) {
                s.append("4");
                text.setText(s.toString());
                str+="4";
            }
            if(e.getSource()==b5) {
                s.append("5");
                text.setText(s.toString());
                str+="5";
            }
            if(e.getSource()==b6) {
                s.append("6");
                text.setText(s.toString());
                str+="6";
            }
            if(e.getSource()==b7) {
                s.append("7");
                text.setText(s.toString());
                str+="7";
            }
            if(e.getSource()==b8) {
                s.append("8");
                text.setText(s.toString());
                str+="8";
            }
            if(e.getSource()==b9) {
                s.append("9");
                text.setText(s.toString());
                str+="9";
            }

            if(e.getSource()==plus) {
                option='+';
                x=(int) Double.parseDouble(text.getText());
                s.append("+");
                text.setText(s.toString());
                str="";
            }
            if(e.getSource()==Darb) {
                option='*';
                x=(int) Double.parseDouble(text.getText());
                s.append("*");
                text.setText(s.toString());
                str="";
            }
            if(e.getSource()==egal) {
                y=(int) Double.parseDouble(str);
                s.append("=");
                text.setText(s.toString());
                switch(option) {
                    case '+': result=x+y; text.setText(x+"+"+y+"="+result);
                        break;
                    case '-': result=x-y; text.setText(x+"-"+y+"="+result);
                        break;
                    case '*': result=x*y; text.setText(x+"*"+y+"="+result);
                        break;
                    case '/': result=x/y; text.setText(x+"/"+y+"="+result);
                        break;
                }
            }
            if(e.getSource()==moin) {
                option='-';
                x=(int) Double.parseDouble(text.getText());
                s.append("-");
                text.setText(s.toString());
                str="";
            }
            if(e.getSource()==ne9ta) {
                int nbr=Integer.parseInt(text.getText());
                nbr*=-1;
                text.setText("");
                text.setText(String.valueOf(nbr));
            }
            if(e.getSource()==kisma) {
                option='/';
                x=(int) Double.parseDouble(text.getText());
                s.append("/");
                text.setText(s.toString());
                str="";
            }
            if(e.getSource()==on) {
                text.setBackground(Color.DARK_GRAY);
                text.setForeground(Color.GREEN);
                clear.setBackground(Color.CYAN);
                for(int i=0;i<tabButton.length;i++) {
                    tabButton[i].setEnabled(true);
                }
                for(int i=0;i<Operation.length;i++) {
                    Operation[i].setEnabled(true);
                }
                b00.setEnabled(true);
                sqrt.setEnabled(true);
                x2.setEnabled(true);
                x3.setEnabled(true);
            }
            if(e.getSource()==off) {
                clear.setBackground(Color.BLACK);
                text.setText("");
                text.setBackground(Color.WHITE);
                for(int i=0;i<tabButton.length;i++) {
                    tabButton[i].setEnabled(false);
                }
                for(int i=0;i<Operation.length;i++) {
                    Operation[i].setEnabled(false);
                }
                b00.setEnabled(false);
                sqrt.setEnabled(false);
                x2.setEnabled(false);
                x3.setEnabled(false);

            }

            if(e.getSource()==clear) {
                text.setText("");
            }


            if(e.getSource()==vider) {
                text.setText("");
            }
            if(e.getSource()==sahm) {
                String o=text.getText();
                text.setText("");
                for(int i=0;i<o.length()-1;i++) {
                    text.setText(text.getText()+o.charAt(i));
                }
            }
            if(e.getSource()==b00) {
                s.append("00");
                str+="00";
                text.setText(s.toString());
            }
            if(e.getSource()==x2) {
                int nbr=Integer.parseInt(text.getText());
                int res=(int) Math.pow(nbr, 2);
                text.setText(String.valueOf(res));
            }
            if(e.getSource()==x3) {
                int nbr=Integer.parseInt(text.getText());
                int res=(int) Math.pow(nbr, 3);
                text.setText(String.valueOf(res));
            }
            if(e.getSource()==sqrt) {
                Double nbr=Double.parseDouble(text.getText());
                Double res=Math.sqrt(nbr);
                text.setText(String.valueOf(res));
            }


        }

    }

    public static void main(String[] args) {
        new Calcul();
    }
}
