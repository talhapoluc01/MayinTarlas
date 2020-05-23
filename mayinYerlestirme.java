
package mayintarlasi;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;




public class mayinYerlestirme extends mayinTarlasiOyunu implements ActionListener{
   
 protected int boyut;
 protected int mayinSayisi; 
 JButton [][] buttons;
 int[][] mayin;
 int hak;

 
  public void actionPerformed(ActionEvent e) {
   
    
     JButton btn=(JButton)e.getSource();
     Point point=getArrayLocation(btn);
     if(mayin[point.x][point.y]<0){
        buttons[point.x][point.y].setText(" "); 
        oyunBitti();
     }
     else if(mayin[point.x][point.y]>0){
         if(buttons[point.x][point.y].getActionCommand()=="doldur"){                     
         if(mayin[point.x][point.y]==1){
         
           
           buttons[point.x][point.y].setText(""+mayin[point.x][point.y]);
           buttons[point.x][point.y].setOpaque(true);
           buttons[point.x][point.y].setBackground(Color.WHITE);
         }
         if(mayin[point.x][point.y]==2){
           buttons[point.x][point.y].setText(""+mayin[point.x][point.y]);;
           buttons[point.x][point.y].setOpaque(true);
           buttons[point.x][point.y].setBackground(Color.WHITE);
         }
         if(mayin[point.x][point.y]==3){
           buttons[point.x][point.y].setText(""+mayin[point.x][point.y]);
           buttons[point.x][point.y].setOpaque(true);
           buttons[point.x][point.y].setBackground(Color.WHITE);
         }
         if(mayin[point.x][point.y]>3) {
           buttons[point.x][point.y].setText(""+mayin[point.x][point.y]);
           buttons[point.x][point.y].setOpaque(true);
           buttons[point.x][point.y].setBackground(Color.WHITE);
         }
          hak--;
       if(hak==0)
          JOptionPane.showMessageDialog(null,"Kazandın","Sonuc", JOptionPane.INFORMATION_MESSAGE);
    
       } 
     }
     else if(mayin[point.x][point.y]==0){
        kareAcma(point.x,point.y); 
     }
     
  }
    @Override
  public void oyunBitti(){
     
      resimler rs=new resimler();
      for(int i=0;i<mayin.length;i++){
        for(int j=0;j<mayin[i].length;j++){
          if(mayin[i][j]<0){
            buttons[i][j].setText(" ");
            ImageIcon mayin=rs.mayin();
            buttons[i][j].setOpaque(true);
            buttons[i][j].setBackground(Color.WHITE);
            buttons[i][j].setIcon(mayin);
          }
          else if(mayin[i][j]==0){
            buttons[i][j].setText(" ");
            buttons[i][j].setOpaque(true);
            buttons[i][j].setBackground(Color.WHITE);
          }
          else{
            buttons[i][j].setText(""+mayin[i][j]);
            if(mayin[i][j]==1){
              buttons[i][j].setText(""+mayin[i][j]);
              buttons[i][j].setOpaque(true);
              buttons[i][j].setBackground(Color.WHITE);
           }    
           if(mayin[i][j]==2){
              buttons[i][j].setText(""+mayin[i][j]);
              buttons[i][j].setOpaque(true);
              buttons[i][j].setBackground(Color.WHITE);
           }  
           if(mayin[i][j]==3){
              buttons[i][j].setText(""+mayin[i][j]);
              buttons[i][j].setOpaque(true);
              buttons[i][j].setBackground(Color.WHITE);
           }
           if(mayin[i][j]>3){
              buttons[i][j].setText(""+mayin[i][j]);
              buttons[i][j].setOpaque(true);
              buttons[i][j].setBackground(Color.WHITE);
           }
          }
        }  
      }
      JOptionPane.showMessageDialog(null,"Kaybettiniz","Mayin",JOptionPane.INFORMATION_MESSAGE);
      Timer.stop();
      System.out.println("Oyun süresi: " + Timer.getElapsedSeconds());
  }
  
    @Override
  public void kareAcma(int x,int y){
    if(x<0 || y<0 || x>buttons.length-1 ||y>buttons.length-1)
       return;
     if(buttons[x][y].getText()=="  "){
        
       if(mayin[x][y]>0){
         if(mayin[x][y]==1){
           buttons[x][y].setText(""+mayin[x][y]);
           buttons[x][y].setOpaque(true);
           buttons[x][y].setBackground(Color.WHITE);
         }
         if(mayin[x][y]==2){
           buttons[x][y].setText(""+mayin[x][y]);
           buttons[x][y].setOpaque(true);
           buttons[x][y].setBackground(Color.WHITE);
         }
         if(mayin[x][y]==3){
           buttons[x][y].setText(""+mayin[x][y]);
           buttons[x][y].setOpaque(true);
           buttons[x][y].setBackground(Color.WHITE);
         }
         if(mayin[x][y]>3){
           buttons[x][y].setText(""+mayin[x][y]);
           buttons[x][y].setOpaque(true);
           buttons[x][y].setBackground(Color.WHITE);
         }
         hak--;
         if(hak==0)
           JOptionPane.showMessageDialog(null,"Kazandın", "Sonuc", JOptionPane.INFORMATION_MESSAGE);
         
       }
       
       if(mayin[x][y]==0){
           buttons[x][y].setText(" ");
           buttons[x][y].setOpaque(true);
           buttons[x][y].setBackground(Color.WHITE);
           hak--;
         if(hak==0)
           JOptionPane.showMessageDialog(null,"Kazandın", "Sonuc", JOptionPane.INFORMATION_MESSAGE);
         
        
         kareAcma(x-1, y-1); kareAcma(x-1, y+1); kareAcma(x+1, y); kareAcma(x+1, y-1);
         kareAcma(x-1, y); kareAcma(x, y+1); kareAcma(x, y-1); kareAcma(x+1, y+1);
       }
       
     }     
  }
 
  public Point getArrayLocation(JButton btn){
     Point pt=new Point(-1, -1);
     for(int j=0;j<buttons.length;j++){
       for(int k=0;k<buttons[j].length;k++){
         if(buttons[j][k]==btn){
           pt.setLocation(j, k);
           return pt;
         }
       }
     }
     return pt; 
  }
   
  
  public JPanel getContent(){
        
        JPanel panel  = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        for(int j = 0; j < buttons.length; j++) {
            for(int k = 0; k < buttons[j].length; k++) {
                buttons[j][k] = new JButton("  ");
                buttons[j][k].addActionListener(this);
                buttons[j][k].setActionCommand("doldur");
                gbc.gridwidth = (k < buttons[j].length-1) ? 1 :GridBagConstraints.REMAINDER;
                panel.add(buttons[j][k], gbc);
            }
        }
        return panel;
  }
  
  public mayinYerlestirme(int boyut, int mayinSayisi){
     this.boyut=boyut;
     this.mayinSayisi=mayinSayisi;
     
     if (anaEkran.ozelOyunDurum){
         buttons = new JButton[anaEkran.ozelOyunX][anaEkran.ozelOyunY];
         hak=anaEkran.ozelOyunX * anaEkran.ozelOyunY - anaEkran.ozelOyunMayinSayisi;
         mayin=new int[anaEkran.ozelOyunX][anaEkran.ozelOyunY];
     }
     else{
         if (anaEkran.boyutDegisimi){
         buttons = new JButton[boyut][30];
         hak=this.boyut*30-this.mayinSayisi;
         mayin=new int[boyut][30]; 
         
     }
     else{
         buttons=new JButton[boyut][boyut];
         hak=this.boyut*this.boyut-this.mayinSayisi;
         mayin=new int[boyut][boyut]; 
     }
     }
     
     
     Random rnd=new Random();
     int x,y = 0;
     for(int i=0;i<mayin.length;i++){
       for(int j=0;j<mayin[i].length;j++){
          mayin[i][j]=0;
       }
     }
     
     for(int j=0;j<mayinSayisi;j++){
         
         if (anaEkran.ozelOyunDurum){
             x = rnd.nextInt(anaEkran.ozelOyunX);
             y = rnd.nextInt(anaEkran.ozelOyunY);
         }
         else{
             x=rnd.nextInt(boyut);
       
       if (anaEkran.boyutDegisimi){
           y=rnd.nextInt(30);
       }
       else{
           y=rnd.nextInt(boyut);
       }
         }
         
       
       
       
       if(mayin[x][y]<0){
         j--;
         continue;
       }
       mayin[x][y]=-100;
       try{mayin[x-1][y]++;}catch(Exception e){}
       try{mayin[x+1][y]++;}catch(Exception e){}
       try{mayin[x][y-1]++;}catch(Exception e){}
       try{mayin[x][y+1]++;}catch(Exception e){}
       try{mayin[x-1][y-1]++;}catch(Exception e){}
       try{mayin[x-1][y+1]++;}catch(Exception e){}
       try{mayin[x+1][y-1]++;}catch(Exception e){}
       try{mayin[x+1][y+1]++;}catch(Exception e){}
     }  
     anaEkran.boyutDegisimi = false;
  }

  
}