package com.springernature.etl.extractors;

import com.springernature.etl.Setup;
import com.springernature.etl.domain.Document;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class FileExtractorTest extends Setup {

    @Test
    public void extractFiles() throws IOException {

        Extractor fileExtractor = new FileExtractor(sourceFilePath);
        Collection<Document> extractedContent = fileExtractor.extract();

        long actualFileCount = extractedContent.size();
        long expectedFileCount = Files.list(Paths.get(sourceFilePath)).count();

        assertEquals(expectedFileCount, actualFileCount);
    }

    @Test(expected = ExtractException.class)
    public void extractInvalidFileContent() {
        String filePath = "file path not exits";

        Extractor fileExtractor = new FileExtractor(filePath);
        fileExtractor.extract();
    }
}