package com.springernature.etl.extractor;

import java.util.Collection;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public interface Extractor {
    Collection<String> extract(String fileName);
}
