/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structsher;

//import jaco.mp3.player.MP3Player;
import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author kcsstore.com
 */
public class DataStructsher {
   // worldcup videos;
   Desktop player;
  File videofile;
    String fileName;
    String linkName;
    String currentPath;
    public DataStructsher (String s,String h){
      this.videofile = new File(s); 
      this.fileName = videofile.getName();
      this.currentPath = s;
     // this.player= new Desktop();
      this.linkName = h; 
    }

 
  


    
    public String getVideoName(){
        return fileName;
        
    }
    
   public  Desktop GetVideoplayer (){
    return player;
  }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new video().setVisible(true);
    }
    
}
