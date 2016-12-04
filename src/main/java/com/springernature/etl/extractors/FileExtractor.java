package com.springernature.etl.extractors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class FileExtractor implements Extractor {

    private String filePath;

    public FileExtractor(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Collection<String> extract() {
        try {
            return Files
                    .lines(Paths.get(filePath))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new ExtractException("file not found", e);
        }
    }
}
