package com.springernature.etl;

import com.springernature.etl.extractors.Extractor;
import com.springernature.etl.extractors.FileExtractor;
import com.springernature.etl.loaders.FileLoader;
import com.springernature.etl.loaders.Loader;
import com.springernature.etl.transformers.CapitalizeTransformer;
import com.springernature.etl.transformers.Transformer;
import com.springernature.etl.transformers.WordCountTransformer;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static com.springernature.etl.transformers.WordCountTransformer.INDIRECTION_SYMBOL;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.*;

/**
 * Created by hrishikesh_shinde on 12/4/2016.
 */
public class ETLExecutorTest extends Setup {

    private Extractor extractor;
    private Transformer capitalizeTransformer, wordCountTransformer;
    private Loader loader;
    private ETLExecutor etlWorkflow;

    @Before
    public void setup() {
        extractor = new FileExtractor(SOURCE_FILE_PATH);
        loader = new FileLoader(DESTINATION_FILE_PATH);
    }

    @Test
    public void executeCapitalizationSerially() throws Exception {
        capitalizeTransformer = new CapitalizeTransformer();
        etlWorkflow = new ETLExecutor(extractor, capitalizeTransformer, loader);

        etlWorkflow.executeSerially();
        assertEquals(Files.list(Paths.get(SOURCE_FILE_PATH)).count(), Files.list(Paths.get(DESTINATION_FILE_PATH)).count());
        assertTrue(Files.readAllLines(Paths.get(DESTINATION_FILE)).contains("HELLO SIR!! HELLO"));
    }

    @Test
    public void executeCapitalizationParallely() throws Exception {
        capitalizeTransformer = new CapitalizeTransformer();
        etlWorkflow = new ETLExecutor(extractor, capitalizeTransformer, loader);

        etlWorkflow.executeParallely();
        assertEquals(Files.list(Paths.get(SOURCE_FILE_PATH)).count(), Files.list(Paths.get(DESTINATION_FILE_PATH)).count());
        assertTrue(Files.readAllLines(Paths.get(DESTINATION_FILE)).contains("HELLO SIR!! HELLO"));
    }

    @Test
    public void executeWordCountSerially() throws Exception {
        wordCountTransformer = new WordCountTransformer();
        etlWorkflow = new ETLExecutor(extractor, wordCountTransformer, loader);

        etlWorkflow.executeSerially();
        assertEquals(Files.list(Paths.get(SOURCE_FILE_PATH)).count(), Files.list(Paths.get(DESTINATION_FILE_PATH)).count());
        assertTrue(Files.readAllLines(Paths.get(DESTINATION_FILE)).contains("hello"+ INDIRECTION_SYMBOL+"2"));
        assertTrue(Files.readAllLines(Paths.get(DESTINATION_FILE)).contains("sir!!"+ INDIRECTION_SYMBOL+"1"));
    }

    @Test
    public void executeWordCountParalally() throws Exception {
        wordCountTransformer = new WordCountTransformer();
        etlWorkflow = new ETLExecutor(extractor, wordCountTransformer, loader);

        etlWorkflow.executeParallely();
        assertEquals(Files.list(Paths.get(SOURCE_FILE_PATH)).count(), Files.list(Paths.get(DESTINATION_FILE_PATH)).count());
        assertTrue(Files.readAllLines(Paths.get(DESTINATION_FILE)).contains("hello"+ INDIRECTION_SYMBOL+"2"));
        assertTrue(Files.readAllLines(Paths.get(DESTINATION_FILE)).contains("sir!!"+ INDIRECTION_SYMBOL+"1"));
    }
}