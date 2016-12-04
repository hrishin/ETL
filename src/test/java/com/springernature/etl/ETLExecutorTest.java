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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
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

    @Test
    public void lambdaTest() {
        Collection<String> data = Arrays.asList("Hello world hello", "Hello");
        data.stream()
            .flatMap(Pattern.compile(" ")::splitAsStream)
            .map(String::toLowerCase)
            .collect(Collectors.toList())
                .stream()
                .collect(groupingBy(s -> s, Collectors.counting()))
        .entrySet()
                .stream()
                .map(entry ->  {return entry.getKey() + "->" + entry.getValue();})
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }
}