package com.springernature.etl.extractor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class FileExtractor implements Extractor {

    @Override
    public Collection<String> extract(String filePath) {
        try {
            return Files
                    .lines(Paths.get(filePath))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
