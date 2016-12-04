package com.springernature.etl.loaders;


import com.springernature.etl.domain.Document;

import java.io.IOException;

/**
 * Created by hrishikeshshinde on 04/12/16.
 */
public class FileLoader implements Loader {

    private final String filePath;

    public FileLoader(String filePath) {
        this.filePath = !filePath.endsWith("/") ? filePath + "/" : filePath;
    }

    @Override
    public boolean load(Document transformedContent) throws LoaderException {
        try {
            return transformedContent.saveToFile(filePath);
        } catch (IOException e) {
            throw new LoaderException("Target directory issue :" + filePath, e);
        }
    }
}
