package com.springernature.etl.transformers;

import com.springernature.etl.domain.Document;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by hrishikesh_shinde on 12/4/2016.
 */
public class WorldCountTransformerTest {
    @Test
    public void countWords() throws Exception {
        Document sourceDocument = new Document("sample.txt", Arrays.asList("Hello World hello"));

        Transformer transformer = new WorldCountTransformer();
        Document transformedDocument = transformer.transform(sourceDocument);

        assertTrue(transformedDocument.getData().contains("hello -> 2"));
        assertTrue(transformedDocument.getData().contains("world -> 1"));
    }

}