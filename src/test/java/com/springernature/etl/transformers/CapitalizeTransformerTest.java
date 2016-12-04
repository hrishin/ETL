package com.springernature.etl.transformers;

import com.springernature.etl.domain.Document;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class CapitalizeTransformerTest {

    @Test
    public void capitalizeString() throws IOException {
        Collection<String> content = new LinkedHashSet<>();
        content.add("hello");
        Document inputDocument = new Document("sample.txt",content);

        Transformer transformer = new CapitalizeTransformer();
        Document transformedDocument = transformer.transform(inputDocument);

        assertEquals(inputDocument.getData().size(), inputDocument.getData().size());
        transformedDocument.getData()
                .stream()
                .forEach(c -> {
                    assertTrue(StringUtils.isAllUpperCase(c));
                });
    }

}