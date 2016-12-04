package com.springernature.etl.loaders;

/**
 * Created by hrishikeshshinde on 04/12/16.
 */
public interface Loader {
    boolean load(Object transformedContent);
}
