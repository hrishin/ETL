package com.springernature.etl;

import com.springernature.etl.extractors.Extractor;
import com.springernature.etl.extractors.FileExtractor;
import com.springernature.etl.loaders.FileLoader;
import com.springernature.etl.loaders.Loader;
import com.springernature.etl.transformers.CapitalizeTransformer;
import com.springernature.etl.transformers.Transformer;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by hrishikesh_shinde on 12/4/2016.
 */
public class ETLExecutorTest {

    private String sourcePath;
    private String destinationPath;
    private Extractor extractor;
    private Transformer transformer;
    private Loader loader;
    private ETLExecutor etlWorkflow;

    @Before
    public void setup() {
        sourcePath = "./files/source/";
        destinationPath = "./files/destination/";

        extractor = new FileExtractor(sourcePath);
        transformer = new CapitalizeTransformer();
        loader = new FileLoader(destinationPath);

        etlWorkflow = new ETLExecutor(extractor, transformer, loader);
    }

    @Test
    public void executeSerially() throws Exception {
        etlWorkflow.executeSerially();
        assertEquals(Files.list(Paths.get(sourcePath)).count(), Files.list(Paths.get(destinationPath)).count());
    }

    @Test
    public void executeParallely() throws Exception {
        etlWorkflow.executeParallely();
        assertEquals(Files.list(Paths.get(sourcePath)).count(), Files.list(Paths.get(destinationPath)).count());
    }
}