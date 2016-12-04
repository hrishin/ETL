package com.springernature.etl.transformers;

import com.springernature.etl.domain.Document;
import org.junit.Test;

import java.util.Arrays;

import static com.springernature.etl.transformers.WordCountTransformer.INDIRECTION_SYMBOL;
import static org.junit.Assert.*;

/**
 * Created by hrishikesh_shinde on 12/4/2016.
 */
public class WordCountTransformerTest {
    @Test
    public void countWords() throws Exception {
        Document sourceDocument = new Document("sample.txt", Arrays.asList("Hello World hello"));

        Transformer transformer = new WordCountTransformer();
        Document transformedDocument = transformer.transform(sourceDocument);

        assertTrue(transformedDocument.getData().contains("hello"+ INDIRECTION_SYMBOL+"2"));
        assertTrue(transformedDocument.getData().contains("world"+ INDIRECTION_SYMBOL+"1"));
    }

}