package com.freshworks.file;

import com.freshworks.exceptions.DuplicateKeyException;
import com.freshworks.exceptions.KeyNonExistentException;
import com.freshworks.model.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

    public static Data readFile(String path) {
        StringBuilder contents = new StringBuilder();
        try {
            File dataFile = new File(path);
            Scanner scanner = new Scanner(dataFile);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                contents.append(data).append("\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new KeyNonExistentException("The specified key does not exist!", e);
        }
        return new Data(path, contents.toString());
    }

    public static Data createFile(String path, String contents) throws IOException {
        File dataFile = new File(path);
        if (dataFile.exists())
            throw new DuplicateKeyException("The given key already exists");

        dataFile.createNewFile();
        FileWriter fileWriter = new FileWriter(dataFile);
        fileWriter.write(contents);
        fileWriter.close();
        return new Data(path, contents);
    }

    public static boolean deleteFile(String path) {
        File dataFile = new File(path);
        if (!dataFile.exists())
            throw new KeyNonExistentException("The specified key does not exist!");

        return dataFile.delete();
    }

    public static Data updateFile(String path) {
        throw new AbstractMethodError("Method Call not Expected!");
    }
}
