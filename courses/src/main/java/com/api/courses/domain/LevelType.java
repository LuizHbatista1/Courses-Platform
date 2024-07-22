package com.api.courses.domain;

public enum LevelType {

    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    private String level;

    LevelType (String level){

        this.level = level;

    }
    public String getValue(){

        return level;

    }
}
