package com.springernature.etl.extractors;

import com.springernature.etl.domain.Document;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Collection;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class FileExtractorTest {

    @Test
    public void extractFileContent() {
       String filePath = "./files/source/";

        Extractor fileExtractor = new FileExtractor(filePath);
        Collection<Document> extractedContent = fileExtractor.extract();

        Assert.assertEquals(1, extractedContent.size());
    }

    @Test(expected = ExtractException.class)
    public void extractInvalidFileContent() {
        String filePath = "file not exits";

        Extractor fileExtractor = new FileExtractor(filePath);
        Collection<Document> extractedContent = fileExtractor.extract();

        Assert.assertEquals(2, extractedContent.size());
    }
}