package com.robtain.busfahrplan_passau;

import java.io.Serializable;

/**
 * a BusStation is a displayable bus schedule
 */
public class BusStation implements Serializable {
    String title;
    String line;
    String id;


    public String getTitle() {
        return title;
    }
    public String getId() {
        return id;
    }

    public String getLine() {
        return line;
    }

    public BusStation(String title, String line, String id) {
        this.title = title;
        this.line = line;
        this.id = id;
    }
}

