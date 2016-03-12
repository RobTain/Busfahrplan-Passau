package com.robtain.busfahrplan_passau;

import java.util.LinkedList;

/**
 * a busline object contains several BusStations
 */
public class BusLine {
    private Tools tools;
    private LinkedList list = new LinkedList();
    public LinkedList getBusLine(String keyword) {
        tools = new Tools();
        list = tools.findBusLine(keyword);
        return list;
    }
}

