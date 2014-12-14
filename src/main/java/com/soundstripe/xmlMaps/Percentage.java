package com.soundstripe.xmlMaps;

/**
 * Percentage class for stripes
 * @author matt
 */
import javax.xml.bind.annotation.*;

@XmlRootElement(name="percentage")
@XmlAccessorType(XmlAccessType.FIELD)
public class Percentage {
    @XmlElement(name="begin")
    private int begin;

    @XmlElement(name="end")
    private int end;
    
    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
