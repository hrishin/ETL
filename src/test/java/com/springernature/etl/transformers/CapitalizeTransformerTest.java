package com.springernature.etl.transformers;

import com.springernature.etl.Setup;
import com.springernature.etl.domain.Document;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class CapitalizeTransformerTest extends Setup {

    @Test
    public void capitalizeString() throws IOException {
        Document inputDocument = new Document("test.txt", Files.readAllLines(Paths.get(SOURCE_FILE)));

        Transformer transformer = new CapitalizeTransformer();
        Document transformedDocument = transformer.transform(inputDocument);

        assertEquals(inputDocument.getData().size(), transformedDocument.getData().size());
        assertTrue(transformedDocument.getData().contains("HELLO SIR!! HELLO"));
    }

}