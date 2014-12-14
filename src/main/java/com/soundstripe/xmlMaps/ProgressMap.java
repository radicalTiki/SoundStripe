/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soundstripe.xmlMaps;

import javax.xml.bind.annotation.*;

/**
 *
 * @author matt
 */
@XmlRootElement(name="progress-map")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProgressMap {
    
    @XmlElement(name="maps")
    private Maps maps;

    public Maps getMaps() {
        return maps;
    }

    public void setMaps(Maps maps) {
        this.maps = maps;
    }
}
