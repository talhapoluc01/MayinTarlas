package mayintarlasi;

import java.awt.Color;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import sun.awt.RepaintArea;


public class anaEkran extends mayinTarlasiOyunu{
    protected int kareSayisi=9;
    protected int mayin=10;
    public static Label l;
    
    public static int ozelOyunX, ozelOyunY, ozelOyunMayinSayisi = 0;
    public static boolean ozelOyunDurum = false;
    public static JFrame frm=new JFrame("Oyun");
    public static boolean boyutDegisimi = false;
    public static void main(String [] args){
              
                 

        anaEkran al=new anaEkran();
        al.ilkFrame();        
        
   }
   public void ilkFrame(){
    
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frm.getContentPane().add(new mayinYerlestirme(9,10).getContent());
      frm.setSize(550,450);
      
      frm.setLocation(300,100);
      
      frm.setVisible(true);
      
      JMenuBar menuBar=new JMenuBar();
      
      menuBar.setSize(550,100);
      
      oyunMenubar(menuBar);
      
      frm.setJMenuBar(menuBar);
      
      frm.repaint();
      
      frm.revalidate();
   }
   

  public void oyunMenubar(JMenuBar menuBar){
   
        JMenu dosya=new JMenu("Oyun");
        menuBar.add(dosya);
        JMenuItem yeniOyun=new JMenuItem("Yeni oyun");
        dosya.add(yeniOyun);
        JMenuItem baslangic=new JMenuItem("Baslangic");
        dosya.add(baslangic);
        JMenuItem orta=new JMenuItem("Orta");
        dosya.add(orta);
        JMenuItem zor=new JMenuItem("Zor");
        dosya.add(zor);
        JMenuItem ozel =new JMenuItem("Özel Oyun");
        dosya.add(ozel);
        JMenuItem cikis=new JMenuItem("Cıkıs");
        dosya.add(cikis);
        
        cikis.addActionListener(new ActionListener() {
          
            @Override
             public void actionPerformed(ActionEvent e) {
               System.exit(0);                      
                  }
            }); 
        
        yeniOyun.addActionListener(new ActionListener() {
            
            @Override
             public void actionPerformed(ActionEvent e) {
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(false);
                 
                anaEkran al=new anaEkran();
                JFrame frm=new JFrame("Oyun");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.getContentPane().add(new mayinYerlestirme(9,9).getContent());
                frm.setSize(550,450);
                frm.setLocation(300,100); 
                frm.setVisible(true);
                JMenuBar menuBar=new JMenuBar();
                frm.setJMenuBar(menuBar);
                al.oyunMenubar(menuBar);
                al.frm=frm;
                  }
            }); 
            
        
        baslangic.addActionListener(new ActionListener() {
           
            @Override
             public void actionPerformed(ActionEvent e) {
                         Timer.start();

                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(false);
                anaEkran al=new anaEkran();
                JFrame frm=new JFrame("Oyun");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.getContentPane().add(new mayinYerlestirme(9,15).getContent());
                frm.setSize(550,450);
                frm.setLocation(300,100);
                frm.setVisible(true);
                JMenuBar menuBar=new JMenuBar();
                frm.setJMenuBar(menuBar);
                al.oyunMenubar(menuBar); 
                al.frm=frm;
                  }
            }); 
        
        orta.addActionListener(new ActionListener() {
           
            @Override
             public void actionPerformed(ActionEvent e) {
                         Timer.start();

                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(false);
                anaEkran al=new anaEkran();
                JFrame frm=new JFrame("Oyun");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.getContentPane().add(new mayinYerlestirme(16,40).getContent());
                frm.setSize(900,700);
                frm.setLocation(300,50);
                frm.setVisible(true);  
                JMenuBar menuBar=new JMenuBar();
                frm.setJMenuBar(menuBar);
                al.oyunMenubar(menuBar);  
                al.frm=frm;
                  }
            }); 
        
        zor.addActionListener(new ActionListener() {
           
            @Override
             public void actionPerformed(ActionEvent e) {
                         Timer.start();

                boyutDegisimi = true;
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(false);
                anaEkran al=new anaEkran();
                JFrame frm=new JFrame("Oyun");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.getContentPane().add(new mayinYerlestirme(16,99).getContent());
                frm.setSize(1400,1000);
                frm.setLocation(200,30);
                frm.setVisible(true);  
                JMenuBar menuBar=new JMenuBar();
                frm.setJMenuBar(menuBar);
                al.oyunMenubar(menuBar);   
                al.frm=frm;
                  }
            }); 
        
        ozel.addActionListener(new ActionListener() {
           
            @Override
             public void actionPerformed(ActionEvent e) {
                         Timer.start();

                ozelOyunDurum = true;
                
                Scanner x = new Scanner(System.in);
                System.out.print("Özel Oyun X:");
                ozelOyunX = Integer.parseInt(x.next());
                
                Scanner y = new Scanner(System.in);
                System.out.print("Özel Oyun Y:");
                ozelOyunY = Integer.parseInt(y.next());
                
                Scanner z = new Scanner(System.in);
                System.out.print("Özel Oyun Mayın Sayısı:");
                ozelOyunMayinSayisi = Integer.parseInt(z.next());
                
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(false);
                anaEkran al=new anaEkran();
                
                JFrame frm=new JFrame("Oyun");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.getContentPane().add(new mayinYerlestirme(0,ozelOyunMayinSayisi).getContent());
                frm.setSize(1400,1000);
                frm.setLocation(200,30);
                frm.setVisible(true);  
                JMenuBar menuBar=new JMenuBar();
                frm.setJMenuBar(menuBar);
                al.oyunMenubar(menuBar);   
                al.frm=frm;
                  }
            }); 
        
        
  }
  
  
    
  
  
}