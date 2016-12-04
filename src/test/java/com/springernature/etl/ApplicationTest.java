package com.springernature.etl;

import com.springernature.etl.loaders.FileLoader;
import com.springernature.etl.loaders.Loader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */

public class ApplicationTest {

    @Test
    public void load() throws IOException {
        File file = File.createTempFile( "sample", "text");
        String filePath = file.getAbsolutePath();
        Object transformedContent = "TEST TEST";

        Loader fileLoader = new FileLoader(filePath);
        boolean result = fileLoader.load(transformedContent);

        Assert.assertTrue(result);
    }


}