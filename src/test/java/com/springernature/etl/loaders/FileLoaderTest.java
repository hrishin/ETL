package com.springernature.etl.loaders;

import com.springernature.etl.Setup;
import com.springernature.etl.domain.Document;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by hrishikesh_shinde on 12/4/2016.
 */
public class FileLoaderTest extends Setup {

    @Test
    public void loadDocument() throws IOException {
        Document transformedDocument = new Document("test.txt", Files.readAllLines(Paths.get(sourceFile)));

        Loader fileLoader = new FileLoader(destinationFilePath);
        boolean result = fileLoader.load(transformedDocument);

        assertTrue(result);
        assertTrue(Files.readAllLines(Paths.get(destinationFile)).contains("Hello Sir!! hello"));
    }

    @Test(expected = LoaderException.class)
    public void loadToInvalidPath() throws IOException {
        Document transformedDocument = new Document("test.txt", Files.readAllLines(Paths.get(sourceFile)));

        Loader fileLoader = new FileLoader("wrong path/");
        fileLoader.load(transformedDocument);
    }

}