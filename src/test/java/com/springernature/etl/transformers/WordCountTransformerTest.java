package com.springernature.etl.transformers;

import com.springernature.etl.Setup;
import com.springernature.etl.domain.Document;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static com.springernature.etl.transformers.WordCountTransformer.INDIRECTION_SYMBOL;
import static org.junit.Assert.*;

/**
 * Created by hrishikesh_shinde on 12/4/2016.
 */
public class WordCountTransformerTest extends Setup {
    @Test
    public void countWords() throws Exception {
        Document sourceDocument = new Document("test.txt", Files.readAllLines(Paths.get(SOURCE_FILE)));

        Transformer transformer = new WordCountTransformer();
        Document transformedDocument = transformer.transform(sourceDocument);

        assertTrue(transformedDocument.getData().contains("hello"+ INDIRECTION_SYMBOL+"2"));
        assertTrue(transformedDocument.getData().contains("sir!!"+ INDIRECTION_SYMBOL+"1"));
    }

}