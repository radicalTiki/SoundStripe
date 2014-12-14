package com.soundstripe.xmlMaps;

/**
 * Map object for progress mapping of playlists
 * @author matt
 */
import javax.xml.bind.annotation.*;

@XmlRootElement(name="map")
@XmlAccessorType(XmlAccessType.FIELD)
public class Map {
    @XmlElement(name="playlist-id")
    private String id;

    @XmlElement(name="percentage")
    private Percentage percentage;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Percentage getPercentage() {
        return percentage;
    }

    public void setPercentage(Percentage percentage) {
        this.percentage = percentage;
    }
}
