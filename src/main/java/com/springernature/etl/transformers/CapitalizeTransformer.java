package com.springernature.etl.transformers;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class CapitalizeTransformer implements Transformer {

    @Override
    public Collection<String> transform(Collection<String> content) {
        return content.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

    }
}
