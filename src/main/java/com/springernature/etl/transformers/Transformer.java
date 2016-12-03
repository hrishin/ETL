package com.springernature.etl.transformers;

import java.util.Collection;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public interface Transformer {
    Collection<String> transform(Collection<String> content);
}
