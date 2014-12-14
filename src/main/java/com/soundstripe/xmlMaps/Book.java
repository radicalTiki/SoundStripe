package com.soundstripe.xmlMaps;

/**
 * Class for book object for stripes.
 * @author matt
 */

import javax.xml.bind.annotation.*;

@XmlRootElement(name="book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    @XmlElement(name="name")
    private String name;

    @XmlElement(name="author")
    private String author;

    @XmlElement(name="image")
    private String image;

    /*
        Getters and setters
    */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}