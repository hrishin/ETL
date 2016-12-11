package com.springernature.etl.extractors;

import com.springernature.etl.domain.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class FileExtractor implements Extractor {

    private String filePath;

    public FileExtractor(String filePath) {
        this.filePath = !filePath.endsWith("/") ? filePath +"/" : filePath;
    }

    @Override
    public Collection<Document> extract() {
        try (Stream<Path> paths = Files.walk(Paths.get(filePath))){
            return paths
                .filter(filePath -> Files.isRegularFile(filePath))
                .map(path -> prepareDocument(path))
                .filter(d -> d != null)
                .collect(Collectors.toList());

        } catch (IOException e) {
            throw new ExtractException("Source file path issue :" + filePath , e);
        }
    }

    private Document prepareDocument(Path path) {
        try {
            return new Document(path.getFileName().toString(), Files.readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
