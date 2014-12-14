package com.soundstripe;
 
import com.soundstripe.xmlMaps.Playlist;
import com.soundstripe.xmlMaps.ProgressMap;
import com.soundstripe.xmlMaps.Map;
import com.soundstripe.xmlMaps.Song;
import com.soundstripe.xmlMaps.Stripe;
import com.soundstripe.xmlMaps.Maps;
import com.soundstripe.xmlMaps.Book;
import com.soundstripe.xmlMaps.Music;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
 
/**
* Parse the xml to get the book (Name, Author, Soundtrack tags), the cover,
* playlists (song1.mp3, song2.mp3, song3.mp3...)
* 
* Quick static implementation of static values
* 
* @author Matt Gleason
*/
public class SoundStripeXmlReader implements ActionBean {
    private ActionBeanContext context;
    private String result;
    private String bookPerc;
    private String bookName;
    private String bookAuthor;
    private String bookImage;
    private String songs;
    private String playlistName;
 
    public ActionBeanContext getContext() { return context; }
    public void setContext(ActionBeanContext context) { this.context = context; }
 
    /*
        index.jsp getter and setters
    */
    public String getbookPerc() { return bookPerc; }
    public void setbookPerc(String bookPerc) { this.bookPerc = bookPerc; }
    
    /*
        stripe Xml getter and setters
    */
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    
    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }
    
    public String getBookAuthor() { return bookAuthor; }
    public void setBookAuthor(String bookAuthor) { this.bookAuthor = bookAuthor; }
    
    public String getBookImage() { return bookImage; }
    public void setBookImage(String bookImage) { this.bookImage = bookImage; }
    
    public String getSongs() { return songs; }
    public void setSongs(String songs) { this.songs = songs; }
    
    public String getPlaylistName() { return playlistName; }
    public void setPlayListName(String playlistName) { this.playlistName = playlistName; }
 
    @DefaultHandler
    public Resolution spotify() {
        parseXml();
        return new ForwardResolution("/WEB-INF/stripeXmlDisplay.jsp");
    }
    
    public Resolution back() {
        return new ForwardResolution("/WEB-INF/index.jsp");
    }
    
    public void parseXml() {
         try {
            File file = new File("C:\\Users\\matt\\Documents\\NetBeansProjects\\SoundStripe\\src\\main\\webapp\\WEB-INF\\Stripes\\StripeExample.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Stripe.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Stripe stripe = (Stripe) jaxbUnmarshaller.unmarshal(file);
            
            /*
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(stripe, System.out);
            */
            
            //Get Book info
            Book book = stripe.getBook();
            
            this.bookName = book.getName();
            this.bookAuthor = book.getAuthor();
            this.bookImage = book.getImage();
            
            //Get Music object
            Music music = stripe.getMusic();
            
            //Get Maps object
            ProgressMap progressMap = music.getMaps();
            Maps mapsObject = progressMap.getMaps();
            List<Map> maps = mapsObject.getMaps();
            
            int mappedPlaylistId = 0;
            
            for(Map map : maps) {
                if (map.getPercentage().getBegin() <= Integer.parseInt(this.getbookPerc()) && 
                        map.getPercentage().getEnd() >= Integer.parseInt(this.getbookPerc())) {
                    mappedPlaylistId = Integer.parseInt(map.getId());
                }
            }
            
            List<Playlist> playlists = music.getPlaylists();
            List<Song> songs = null;
            
            for(Playlist playlist : playlists) {
                if (Integer.parseInt(playlist.getId()) == mappedPlaylistId) {
                    songs = playlist.getSongs();
                    this.playlistName = playlist.getName();
                }
            }
            
            String songsString = "";
            for (Song song : songs) {
                //remove the spotify:track:
                songsString += song.getSpotifyUri().substring(14);
                if (!(songs.get(songs.size() -1).equals(song))) {
                    songsString += ",";
                }
            }
            this.songs = songsString;
                    
            
        } catch (JAXBException e) {
          e.printStackTrace();
        }
    }
}