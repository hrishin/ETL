package com.springernature.etl.loaders;

import com.springernature.etl.domain.Document;

/**
 * Created by hrishikeshshinde on 04/12/16.
 */
public interface Loader {
    boolean load(Document transformedContent) throws LoaderException;
}
