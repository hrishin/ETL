package com.springernature.etl.extractors;

import com.springernature.etl.domain.Document;

import java.util.Collection;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public interface Extractor {
    Collection<Document> extract();
}
