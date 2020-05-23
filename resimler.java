
package mayintarlasi;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class resimler extends mayinTarlasiOyunu{
    
    
    
  public ImageIcon mayin(){
   java.net.URL dosyaYolu = getClass().getResource("mayin.jpg");
   ImageIcon resim = new ImageIcon(dosyaYolu);
   return resim;
 }   
}
