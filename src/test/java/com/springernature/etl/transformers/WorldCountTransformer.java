package com.springernature.etl.transformers;

import com.springernature.etl.domain.Document;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by hrishikesh_shinde on 12/4/2016.
 */
public class WorldCountTransformer implements Transformer {
    @Override
    public Document transform(Document document) {
        return new Document(document.getName(), getWordCountAsList(document.getData()));
    }

    private Collection<String> getWordCountAsList(Collection<String> data) {
        return CountWords(data.stream()
                .flatMap(Pattern.compile(" ")::splitAsStream)
                .map(String::toLowerCase)
                .collect(Collectors.toList()));

    }

    private Collection<String> CountWords(List<String> words) {
            return fromMapToCollection(words
                                    .stream()
                                    .collect(groupingBy(s -> s, Collectors.counting())));
    }

    private Collection<String> fromMapToCollection(Map<String, Long> wordCountData) {
        return wordCountData.entrySet()
                .stream()
                .map(e -> {return e.getKey()+" -> "+e.getValue();})
                .collect(Collectors.toList());
    }
}
