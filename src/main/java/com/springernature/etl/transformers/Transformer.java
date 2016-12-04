package com.springernature.etl.transformers;

import com.springernature.etl.domain.Document;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public interface Transformer {
    Document transform(Document content);
}
