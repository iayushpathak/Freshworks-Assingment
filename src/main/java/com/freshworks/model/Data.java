package com.freshworks.model;

public class Data {
    private String key;
    private String jsonObject;
    private long ttl;

    public Data(String key, String jsonObject) {
        this.key = key;
        this.jsonObject = jsonObject;
    }

    public Data(String key, String jsonObject, long ttl) {
        this.key = key;
        this.jsonObject = jsonObject;
        this.ttl = ttl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(String jsonObject) {
        this.jsonObject = jsonObject;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "Data{" +
                "key='" + key + '\'' +
                ", jsonObject='" + jsonObject + '\'' +
                ", ttl=" + ttl +
                '}';
    }
}
