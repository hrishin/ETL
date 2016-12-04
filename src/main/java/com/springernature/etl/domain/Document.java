package com.springernature.etl.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

/**
 * Created by hrishikesh_shinde on 12/4/2016.
 */
public class Document {
    private final String name;
    private final Collection<String> data;

    public Document(String name, Collection<String> data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public Collection<String> getData() {
        return data;
    }

    public boolean saveToFile(String location) {
        try {
            Files.write(Paths.get(location+name), (Iterable<String>) data.stream()::iterator,
                    CREATE, WRITE);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
