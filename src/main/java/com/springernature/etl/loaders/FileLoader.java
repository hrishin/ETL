package com.springernature.etl.loaders;


import com.springernature.etl.domain.Document;

/**
 * Created by hrishikeshshinde on 04/12/16.
 */
public class FileLoader implements Loader {

    private final String filePath;

    public FileLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean load(Document transformedContent) {
        return transformedContent.saveToFile(filePath);
    }
}
