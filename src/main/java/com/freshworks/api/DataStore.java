package com.freshworks.api;

import com.freshworks.exceptions.LimitsExceededException;
import com.freshworks.file.FileHandler;
import com.freshworks.model.Data;

import java.io.File;
import java.io.IOException;

public class DataStore {
    private static final String USER_HOME = System.getProperty("user.home");
    private static final String FILE_SEPARATOR = File.separator;
    private static final String DEFAULT_STORAGE_LOCATION = USER_HOME + FILE_SEPARATOR + "FreshworksDataStore";

    private static final int MAX_KEY_LENGTH = 32;
    private static final long MAX_VALUE_BYTES = 16 * 1024; // 16KB


    private String dataStoreLocation;

    public DataStore() throws IOException {
        dataStoreLocation = DEFAULT_STORAGE_LOCATION;
        verifyAndCreateStorageDirectory(dataStoreLocation);
    }

    public DataStore(String path) throws IOException {
        dataStoreLocation = path;
        verifyAndCreateStorageDirectory(dataStoreLocation);
    }

    private void verifyAndCreateStorageDirectory(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new RuntimeException("Another file with the expected directory name, already exists at the storage location, Conflicting file path : " + path);
            }
        } else {
            file.mkdirs();
        }
    }

    private String determineAbsolutePath(String key) {
        return dataStoreLocation + FILE_SEPARATOR + key + ".json";
    }

    public Data save(String key, String value) throws IOException {
            if (key.length() > MAX_KEY_LENGTH)
                throw new LimitsExceededException("Key Length Cannot be greater than 32 chars");
            if (value.getBytes().length > MAX_VALUE_BYTES)
                throw new LimitsExceededException("Value Stored cannot be more than 16KB");

        synchronized (key.intern()) {
            return FileHandler.createFile(determineAbsolutePath(key), value);
        }
    }

    public boolean delete(String key) {
        synchronized (key.intern()) {
            return FileHandler.deleteFile(determineAbsolutePath(key));
        }
    }

    public Data read(String key) {
        synchronized (key.intern()) {
            return FileHandler.readFile(determineAbsolutePath(key));
        }
    }
}
