package com.jumia.jpay.model;

public enum Country {

    CAMEROON("(237)", "\\(237\\)\\ ?[2368]\\d{7,8}$"),
    ETHIOPIA("(251)", "\\(251\\)\\ ?[1-59]\\d{8}$"),
    MOROCCO("(212)", "\\(212\\)\\ ?[5-9]\\d{8}$"),
    MOZAMBIQUE("(258)", "\\(258\\)\\ ?[28]\\d{7,8}$"),
    UGANDA("(256)", "\\(256\\)\\ ?\\d{9}$");

    public final String countryCode;
    public final String regex;

    Country(String countryCode, String regex){
        this.countryCode = countryCode;
        this.regex = regex;
    }
}
