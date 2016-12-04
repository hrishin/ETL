package com.springernature.etl.loaders;

import com.springernature.etl.domain.Document;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by hrishikesh_shinde on 12/4/2016.
 */
public class FileLoaderTest {

    @Test
    public void load() throws IOException {

        String filePath = "./files/destination/";
        Collection<String> data = Arrays.asList("HELLO WORLD!");
        Document transformedDocument = new Document("sample.text", data);


        Loader fileLoader = new FileLoader(filePath);
        boolean result = fileLoader.load(transformedDocument);

        Assert.assertTrue(result);
    }

}