package com.springernature.etl;

import com.springernature.etl.domain.Document;
import com.springernature.etl.extractors.Extractor;
import com.springernature.etl.extractors.FileExtractor;
import com.springernature.etl.loaders.FileLoader;
import com.springernature.etl.loaders.Loader;
import com.springernature.etl.transformers.CapitalizeTransformer;
import com.springernature.etl.transformers.Transformer;
import org.junit.Assert;
import org.junit.Test;

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
        boolean result = document.saveToFile(location);

        Assert.assertTrue(result == true);

    }

    @Test
    public void basicETL() {

        String sourcePath = "./files/source/";
        String destinationPath = "./files/destination/";

        Extractor extractor = new FileExtractor(sourcePath);
        Transformer transformer = new CapitalizeTransformer();
        Loader loader = new FileLoader(destinationPath);

        ETLExecutor etlWorkflow = new ETLExecutor(extractor, transformer, loader);
        etlWorkflow.executeParallely();

    }


}