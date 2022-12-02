package com.bootcamp.java.client.DTO;

public enum ClientTypeEnum {
    PERSONNEL("PERSONNEL"), BUSINESS("BUSINESS");
    private String value;
    ClientTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
