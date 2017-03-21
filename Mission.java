package com.example.regev.selfchat;

import java.util.ArrayList;

/**
 * Created by Regev on 3/21/2017.
 */

public class Mission {
    private String text;

    public Mission(String description) {
        text = description;
    }

    public String getDescription() {
        return text;
    }

    private static int lastMissionID = 0;

    public static ArrayList<Mission> createMissionList(int numMissions) {
        ArrayList<Mission> missions = new ArrayList<Mission>();

        for (int i = 1; i <= numMissions; i++) {
            missions.add(new Mission("Mission " + ++lastMissionID));
        }

        return missions;
    }
}