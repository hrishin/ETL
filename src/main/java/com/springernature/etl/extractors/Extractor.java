package com.springernature.etl.extractors;

import java.util.Collection;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public interface Extractor {
    Collection<String> extract();
}
