package com.soundstripe.xmlMaps;

/**
 * Stripe object to be used from stripe xml
 * @author matt
 */
import javax.xml.bind.annotation.*;

@XmlRootElement(name="stripe")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stripe {
    @XmlElement(name="book")
    private Book book;
    
    @XmlElement(name="music")
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}