package com.soundstripe.xmlMaps;

import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author matt
 */
@XmlRootElement(name="maps")
@XmlAccessorType(XmlAccessType.FIELD)
public class Maps {
    
    @XmlElement(name="map")
    private List<Map> maps;

    public List<Map> getMaps() {
        return maps;
    }

    public void setMaps(List<Map> maps) {
        this.maps = maps;
    }
}
