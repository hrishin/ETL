package com.springernature.etl.loaders;

import com.springernature.etl.Setup;
import com.springernature.etl.domain.Document;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by hrishikesh_shinde on 12/4/2016.
 */
public class FileLoaderTest extends Setup {

    @Test
    public void loadDocument() throws IOException {
        Document transformedDocument = new Document("test.txt", Files.readAllLines(Paths.get(SOURCE_FILE)));

        Loader fileLoader = new FileLoader(DESTINATION_FILE_PATH);
        boolean result = fileLoader.load(transformedDocument);

        assertTrue(result);
        assertTrue(Files.readAllLines(Paths.get(DESTINATION_FILE)).contains("Hello Sir!! hello"));
    }

    @Test(expected = LoaderException.class)
    public void loadToInvalidPath() throws IOException {
        Document transformedDocument = new Document("test.txt", Files.readAllLines(Paths.get(SOURCE_FILE)));

        Loader fileLoader = new FileLoader("wrong path/");
        fileLoader.load(transformedDocument);
    }

}