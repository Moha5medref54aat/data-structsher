/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structsher;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author kcsstore.com
 */
public class NewClass {
    
  
    static  DataStructsher [] videoList = new  DataStructsher [8];
    static String[] videoNames = new String[8];
    
    static  DataStructsher[] playlist = new  DataStructsher [1000];
    static String [] playlistName = new String[1000];
    
    static int cnt = 0;
    static int cntPlay = 0;
    
    public NewClass() {
        videoList[0] = new DataStructsher ("C:\\Users\\kcsstore.com\\OneDrive\\Documents\\NetBeansProjects\\data structsher\\src\\video\\gool\\ (9) 3gool on world cup - YouTube", "gool");
        videoList[1] = new DataStructsher ("C:\\Users\\kcsstore.com\\OneDrive\\Documents\\NetBeansProjects\\data structsher\\src\\video\\gool\\(9) gool on world cup - YouTube", "gool");
        videoList[2] = new  DataStructsher ("C:\\Users\\kcsstore.com\\OneDrive\\Documents\\NetBeansProjects\\data structsher\\src\\video\\gool\\(9)23 gool on world cup - YouTube", "gool");
        videoList[3] = new  DataStructsher ("C:\\Users\\kcsstore.com\\OneDrive\\Documents\\NetBeansProjects\\data structsher\\src\\video\\red\\card\\(9) 1red card in world cup 2022 - YouTube", "red");
        videoList[4] = new  DataStructsher ("C:\\Users\\kcsstore.com\\OneDrive\\Documents\\NetBeansProjects\\data structsher\\src\\video\\red\\card\\(9) mred card in world cup 2022 - YouTube", "red");
        videoList[5] = new  DataStructsher ("C:\\Users\\kcsstore.com\\OneDrive\\Documents\\NetBeansProjects\\data structsher\\src\\video\\red\\card\\(9) red card in world cup 2022 - YouTube", "red");
        videoList[6] = new  DataStructsher ("C:\\Users\\kcsstore.com\\OneDrive\\Documents\\NetBeansProjects\\data structsher\\src\\video\\yellow\\card_(9) 1yellow card in world cup - YouTube", "yellow");
        videoList[7] = new  DataStructsher ("C:\\Users\\kcsstore.com\\OneDrive\\Documents\\NetBeansProjects\\data structsher\\src\\video\\yellow\\card_(9) yellow card in world cup - YouTube",  "yellow");
        //videoList[8] = new Song("E:\\Songs\\14.Ya_Hamam.mp3", "Mohamed Moneer");
       // songList[9] = new Song("E:\\Songs\\Cairokee - Kol haga Beta'ady - كايروكي -  كل حاجة بتعدى.mp3", "Kairokee");

        for (int i = 0; i < 8; i++) {
            videoNames[i] = videoList[i].fileName;
        }
    }
    
    public static int getIndex(String song){
        for(int i=0; i<8; i++){
            if(song.equals(videoNames[i])){
                return i;
            }
        }
        return 0;
    }
    
    public static void addVideo(String s ){
       
        if(cnt == 999){
            System.out.println("Playlist is Full");
            return;
        }
        
        int indx = getIndex(s);
        playlist[cnt] = videoList[indx];
        playlistName[cnt] = playlist[cnt].fileName;
        cnt++;    
    }
    
    public static int playing(){
        return cntPlay;
    }

     public static int next(){
         if(cntPlay == cnt-1){
             cntPlay =0;
             return cntPlay;
         }
        cntPlay++;
        return cntPlay;
     }
     public static int previous(){
        
         if(cntPlay == 0){
         cntPlay = cnt-1;
         return cntPlay;
         }
        cntPlay--;
        return cntPlay;
        
    }
     
     public static void deletevideo(int indx){
         
         if(cnt-1 == 0){
             playlistName[0] = null;
             playlist[0] = null;
             cnt--;
             cntPlay=0;
             return;
             
         }
         
         if(cntPlay == indx){
           JOptionPane.showMessageDialog(null, "You can't delete the plying video.");
             return;
         }
                
         for(int i=indx; i<cnt; i++){
            playlistName[i] =  playlistName[i+1];
            playlist[i] =  playlist[i+1];
                 }
         if(indx < cntPlay) cntPlay--;
         
         cnt--;
     }
     
    public static int getBeginning(){
        cntPlay = 0;
        return cntPlay;
    }
    
     public static int getEnd(){
        cntPlay = cnt-1;
        return cntPlay;
    }
     
     public static void moveUp(int mv){
         cntPlay = 0;
         if(cnt == 1) return;
         if(mv == 0) return;
         
        String temp = playlistName[mv];
        playlistName[mv] = playlistName[mv-1];
        playlistName[mv -1] = temp;
        
         DataStructsher  tempS = playlist[mv];
        playlist[mv] = playlist[mv-1];
        playlist[mv -1] = tempS;
        
     }
     
     public static void moveDown(int mv){
         cntPlay = 0;
         if(cnt == 1) return;
         if(mv == cnt-1) return;
         
        String temp = playlistName[mv];
        playlistName[mv] = playlistName[mv+1];
        playlistName[mv+1] = temp;
        
         DataStructsher  tempS = playlist[mv];
        playlist[mv] = playlist[mv+1];
        playlist[mv+1] = tempS;
     }
     
     public static String searchSongName(String text){
         
         for(int i=0; i<8; i++){
             if( text.equals(videoNames[i])){
                 addVideo(text);
                 return text+ " is added succesfully to list";
             }
         }
         
         return "Song is not Found";
     }
     public static String searchvideolink(String text){
         
         for(int i=0; i<8; i++){
             if( text.equals(videoList[i].linkName)){
                 addVideo(videoNames[i]);
                 return videoNames[i] + " by "+ text + " is added succesfully to list";
             }
         }
         
         return "Singer is not Found";
     }
     public static String searchvideogool( Object gool){
         
         for(int i=0; i<8; i++){
             if( gool.equals(videoNames[i])){
                 addVideo(videoNames[i]);
                  return videoNames[i] + " by "+ gool + " is added succesfully to list";
             }
         }
          return "Singer is not Found";
     }
     public static String searchvideoredcard(Object redcard ){
         
         for(int i=0; i<8; i++){
             if( redcard.equals(videoNames[i])){
                 addVideo(videoNames[i]);
                 return videoNames[i] + " by "+ redcard+ " is added succesfully to list";
             }
         } 
           return "Singer is not Found";
     }
     public static String searchvideoyellowcard( Object yellowcard){
         
         for(int i=0; i<8; i++){
             if( yellowcard.equals(videoNames[i])){
                 addVideo(videoNames[i]);
                   return videoNames[i] + " by "+ yellowcard + " is added succesfully to list";
             }
         }
         return "Singer is not Found";
    
         } 

}



