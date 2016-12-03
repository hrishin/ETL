package com.springernature.etl.extractor;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class FileExtractorTest {

    @Test
    public void extractFileContent() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("sample.txt").getFile());
        String filePath = file.getAbsolutePath();

        Extractor fileExtractor = new FileExtractor(filePath);
        Collection<String> extractedContent = fileExtractor.extract();

        Assert.assertEquals(2, extractedContent.size());
    }

    @Test(expected = ExtractException.class)
    public void extractInvalidFileContent() {
        String filePath = "file not exits";

        Extractor fileExtractor = new FileExtractor(filePath);
        Collection<String> extractedContent = fileExtractor.extract();

        Assert.assertEquals(2, extractedContent.size());
    }
}