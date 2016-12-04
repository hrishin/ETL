package com.springernature.etl.transformers;

import com.springernature.etl.domain.Document;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class CapitalizeTransformer implements Transformer {

    @Override
    public Document transform(Document document) {
        return new Document(document.getName(), capitalizeContent(document.getData()));
    }

    private Collection<String> capitalizeContent(Collection<String> data) {
        return data
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
