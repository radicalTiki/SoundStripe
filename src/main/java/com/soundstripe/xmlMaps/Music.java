package com.soundstripe.xmlMaps;

import java.util.List;
import javax.xml.bind.annotation.*;

/**
 * Music Object from stripe xml
 * @author matt
 */
@XmlRootElement(name="music")
@XmlAccessorType(XmlAccessType.FIELD)
public class Music {
    @XmlElementWrapper(name="playlists")
    @XmlElement(name="playlist")
    private List<Playlist> playlists;

    @XmlElement(name="progress-map")
    private ProgressMap progressMap;
    
    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public ProgressMap getMaps() {
        return progressMap;
    }

    public void setMaps(ProgressMap progressMap) {
        this.progressMap = progressMap;
    }
}
