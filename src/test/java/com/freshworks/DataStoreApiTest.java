package com.freshworks;

import com.freshworks.api.DataStore;

import java.io.IOException;

public class DataStoreApiTest {
    public static void main(String[] args) throws IOException {
        DataStore dataStore = new DataStore();
        System.out.println(dataStore.save("hello", "{\"name\":\"Ayush\"}"));
        System.out.println(dataStore.save("hello", "{\"name\":\"Ayush\"}"));
        System.out.println(dataStore.read("hello"));
        System.out.println(dataStore.delete("hello"));
    }
}
