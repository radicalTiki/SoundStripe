package com.soundstripe.xmlMaps;

/**
 * Class for song object for stripes
 * @author matt
 */

import javax.xml.bind.annotation.*;

@XmlRootElement(name="song")
@XmlAccessorType(XmlAccessType.FIELD)
public class Song {

    @XmlElement(name="http-link")
    private String httpLink;

    @XmlElement(name="spotify-uri")
    private String spotifyUri;

    @XmlElement(name="embed-code")
    private String embedCode;
    
    
    public String getHttpLink() {
        return httpLink;
    }

    public void setHttpLink(String httpLink) {
        this.httpLink = httpLink;
    }

    public String getSpotifyUri() {
        return spotifyUri;
    }

    public void setSpotifyUri(String spotifyUri) {
        this.spotifyUri = spotifyUri;
    }

    public String getEmbedCode() {
        return embedCode;
    }

    public void setEmbedCode(String embedCode) {
        this.embedCode = embedCode;
    }
}