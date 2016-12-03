package com.springernature.etl.transformers;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;

import static org.junit.Assert.*;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class CapitalizeTransformerTest {

    @Test
    public void capitalizeString() throws IOException {
        Collection<String> content = new LinkedHashSet<>();
        content.add("hello");

        Transformer transformer = new CapitalizeTransformer();
        Collection<String> capitalizedContents = transformer.transform(content);

        assertEquals(content.size(), capitalizedContents.size());
        capitalizedContents
                .stream()
                .forEach(c -> {
                    assertTrue(StringUtils.isAllUpperCase(c));
                });
    }

}