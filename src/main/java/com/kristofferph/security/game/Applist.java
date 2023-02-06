package com.kristofferph.security.game;

import com.google.gson.JsonArray;

import java.util.List;

public class Applist {

    public List<App> apps;

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }
}
