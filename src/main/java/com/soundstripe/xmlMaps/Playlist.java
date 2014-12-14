package com.soundstripe.xmlMaps;

/**
 * Class for playlist object for stripes
 * @author matt
 */
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="playlist")
@XmlAccessorType(XmlAccessType.FIELD)
public class Playlist {

    @XmlElement(name="id")
    private String id;

    @XmlElement(name="name")
    private String name;

    @XmlElementWrapper(name="songs")
    @XmlElement(name="song")
    private List<Song> songs;
    
    /*
        Getters and Setters
    */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

}