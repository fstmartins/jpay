package com.jumia.jpay.model;

public enum Country {

    CAMEROON("\\(237\\)\\ ?[2368]\\d{7,8}$"),
    ETHIOPIA("\\(251\\)\\ ?[1-59]\\d{8}$"),
    MOROCCO("\\(212\\)\\ ?[5-9]\\d{8}$"),
    MOZAMBIQUE("\\(258\\)\\ ?[28]\\d{7,8}$"),
    UGANDA("\\(256\\)\\ ?\\d{9}$");

    public final String prefix;

    Country(String prefix){
        this.prefix = prefix;
    }
}
