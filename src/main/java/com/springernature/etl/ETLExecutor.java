package com.springernature.etl;

import com.springernature.etl.extractors.Extractor;
import com.springernature.etl.loaders.Loader;
import com.springernature.etl.transformers.Transformer;

/**
 * Created by hrishikesh_shinde on 12/4/2016.
 */
public class ETLExecutor {
    private final Extractor extractor;
    private final Transformer transformer;
    private final Loader loader;

    public ETLExecutor(Extractor extractor, Transformer transformer, Loader loader) {
        this.extractor = extractor;
        this.transformer = transformer;
        this.loader = loader;
    }

    public void executeSerially() {
        extractor.extract()
                .stream()
                .map(d -> {return transformer.transform(d);})
                .forEach(d -> loader.load(d));
    }

    public void executeParallely() {
        extractor.extract()
                .parallelStream()
                .map(d -> {return transformer.transform(d);})
                .forEach(d -> loader.load(d));

    }
}
