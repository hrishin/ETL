package com.springernature.etl;

import com.springernature.etl.domain.Document;
import com.springernature.etl.loaders.FileLoader;
import com.springernature.etl.loaders.Loader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */

public class ApplicationTest {

    @Test
    public void document() {
        String name = "test.text";
        Collection<String> data = Arrays.asList("Hello", "Hi", "Namaste");
        String location = "./files/destination/";

        Document document = new Document(name, data);
        boolean result = document.save(location);

        Assert.assertTrue(result == true);

    }


}